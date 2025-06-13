package com.example.textgenerator.dtos;

import com.example.textgenerator.models.Phrase;

public class PhraseMapper {
    public static Phrase dtoToEntity (PhraseRequest dto){
        return new Phrase(dto.name(), dto.author());
    }
    public static PhraseResponse entityToDto (Phrase phrase){
        return new PhraseResponse(phrase.getText(), phrase.getAuthor());
    }
}
