package com.example.textgenerator.controllers;

import com.example.textgenerator.models.Phrase;
import com.example.textgenerator.services.PhraseService;
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

    @GetMapping("/phrases")
    public ResponseEntity<List<Phrase>> getAllPhrases() {
        List<Phrase> phrases = phraseService.getAllPhrases();
        return new ResponseEntity<List<Phrase>>(phrases, HttpStatus.OK);
    }

    @PostMapping("/phrases")
    public ResponseEntity<Phrase> addPhrase(@RequestBody Phrase newPhrase) {
        Phrase createdPhrase = phraseService.addPhrase(newPhrase);
        return new ResponseEntity<Phrase>(createdPhrase, HttpStatus.CREATED);
    }

    @DeleteMapping("/phrases/phrase/{id}")
    public ResponseEntity<Phrase> deletePhrase(@PathVariable Long id) {
        Phrase deletedPhrase = phraseService.deletePhrase(id);
        return new ResponseEntity<Phrase>(deletedPhrase, HttpStatus.OK);
    }

    @GetMapping("phrases/phrase/{id}")
    public ResponseEntity<Phrase> getPhraseById(@PathVariable Long id) {
        Phrase phrase = phraseService.getPhraseById(id);
        return new ResponseEntity<Phrase>(phrase, HttpStatus.OK);
    }

    @PutMapping("phrases/phrase/{id}")
    public ResponseEntity<Phrase> updatePhrase(@PathVariable Long id, @RequestBody Phrase updatedPhrase) {
        Phrase phrase = phraseService.updatePhrase(id, updatedPhrase);
        return new ResponseEntity<Phrase>(phrase, HttpStatus.OK);
    }
}
