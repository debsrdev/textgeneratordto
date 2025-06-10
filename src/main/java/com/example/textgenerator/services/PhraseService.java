package com.example.textgenerator.services;

import com.example.textgenerator.models.Phrase;
import com.example.textgenerator.repositories.PhraseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Phrase deletePhrase(Long id) {
        Optional<Phrase> optionalPhrase = phraseRepository.findById(id);
        if (optionalPhrase.isPresent()) {
            // extrae la info para devolverla porque findById no devuelve nada
            Phrase phraseToDelete = optionalPhrase.get();
            phraseRepository.deleteById(id);
            return phraseToDelete;
        } else {
            throw new RuntimeException("Frase con id " + id + " no encontrada");
        }
    }

    public Phrase getPhraseById(Long id) {
        Optional<Phrase> optionalPhrase = phraseRepository.findById(id);
        if (optionalPhrase.isPresent()) {
            return optionalPhrase.get();
        } else {
            throw new RuntimeException("Frase con id " + id + " no encontrada");
        }
    }
}
