package com.example.textgenerator.repositories;

import com.example.textgenerator.models.Phrase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhraseRepository extends JpaRepository<Phrase, Long> {
}
