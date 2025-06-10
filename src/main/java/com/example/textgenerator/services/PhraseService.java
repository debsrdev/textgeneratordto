package com.example.textgenerator.services;

import com.example.textgenerator.models.Phrase;
import com.example.textgenerator.repositories.PhraseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhraseService {
    private final PhraseRepository phraseRepository;

    public PhraseService(PhraseRepository phraseRepository) {
        this.phraseRepository = phraseRepository;
    }

    public List<Phrase> getAllPhrases() {
        return phraseRepository.findAll();
    }

    public Phrase addPhrase(Phrase newPhrase) {
        return phraseRepository.save(newPhrase);
    }
}
