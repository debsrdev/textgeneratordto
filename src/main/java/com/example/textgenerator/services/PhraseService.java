package com.example.textgenerator.services;

import com.example.textgenerator.dtos.PhraseMapper;
import com.example.textgenerator.dtos.PhraseRequest;
import com.example.textgenerator.dtos.PhraseResponse;
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

    public List<PhraseResponse> getAllPhrases() {
        List<Phrase> phrases = phraseRepository.findAll();
        return phrases.stream().map(phrase -> PhraseMapper.entityToDto(phrase)).toList();
    }

    public PhraseResponse addPhrase(PhraseRequest phraseRequest) {
        Phrase newPhrase = PhraseMapper.dtoToEntity(phraseRequest);
        Phrase savedPhrase = phraseRepository.save(newPhrase);
        return PhraseMapper.entityToDto(savedPhrase);
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

    public Phrase updatePhrase(Long id, Phrase updatedPhrase) {
        Optional<Phrase> optionalPhrase = phraseRepository.findById(id);
        if (optionalPhrase.isPresent()) {
            Phrase phraseToUpdate = optionalPhrase.get();
            phraseToUpdate.setAuthor(updatedPhrase.getAuthor());
            phraseToUpdate.setText(updatedPhrase.getText());
            return phraseRepository.save(phraseToUpdate);
        } else {
            throw new RuntimeException("Frase con id " + id + " no encontrada");
        }
    }
}
