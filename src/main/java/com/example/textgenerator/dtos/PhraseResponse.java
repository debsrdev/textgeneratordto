package com.example.textgenerator.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PhraseResponse(
        String name,
        String author
) {
}
