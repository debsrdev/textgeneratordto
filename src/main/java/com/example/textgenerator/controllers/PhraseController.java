package com.example.textgenerator.controllers;

import com.example.textgenerator.models.Phrase;
import com.example.textgenerator.services.PhraseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.events.Event;

import java.util.List;

@RestController
public class PhraseController {
    private final PhraseService phraseService;

    public PhraseController(PhraseService phraseService) {
        this.phraseService = phraseService;
    }

    @GetMapping("/phrases")
    public List<Phrase> getAllPhrases() {
        return phraseService.getAllPhrases();
    }

    @PostMapping("/patata")
    public void addPhrase(@RequestBody Phrase newPhrase) {
        phraseService.addPhrase(newPhrase);
    }
}
