package com.example.textgenerator.controllers;

import com.example.textgenerator.dtos.PhraseRequest;
import com.example.textgenerator.dtos.PhraseResponse;
import com.example.textgenerator.models.Phrase;
import com.example.textgenerator.services.PhraseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.events.Event;

import java.util.List;

@RestController
public class PhraseController {
    private final PhraseService phraseService;

    public PhraseController(PhraseService phraseService) {
        this.phraseService = phraseService;
    }

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return new ResponseEntity<>("Bienvenidx a la API de generación de frases. Usa /phrases para obtener un listado de todas las frases", HttpStatus.OK);
    }

    @GetMapping("/phrases")
    public ResponseEntity<List<PhraseResponse>> getAllPhrases() {
        return new ResponseEntity<>(phraseService.getAllPhrases(), HttpStatus.OK);
    }

    @PostMapping("/phrases")
    public ResponseEntity<PhraseResponse> addPhrase(@Valid @RequestBody PhraseRequest phraseRequest) {
        return new ResponseEntity<>(phraseService.addPhrase(phraseRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/phrases/{id}")
    public ResponseEntity<Phrase> deletePhrase(@PathVariable Long id) {
        Phrase deletedPhrase = phraseService.deletePhrase(id);
        return new ResponseEntity<Phrase>(deletedPhrase, HttpStatus.OK);
    }

    @GetMapping("/phrases/{id}")
    public ResponseEntity<Phrase> getPhraseById(@PathVariable Long id) {
        Phrase phrase = phraseService.getPhraseById(id);
        return new ResponseEntity<Phrase>(phrase, HttpStatus.OK);
    }

    @PutMapping("/phrases/{id}")
    public ResponseEntity<Phrase> updatePhrase(@PathVariable Long id, @RequestBody Phrase updatedPhrase) {
        Phrase phrase = phraseService.updatePhrase(id, updatedPhrase);
        return new ResponseEntity<Phrase>(phrase, HttpStatus.OK);
    }
}
