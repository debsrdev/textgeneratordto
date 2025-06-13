package com.example.textgenerator.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PhraseRequest(
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 50, message = "Name must contain between 2 and 50 characters")
        String name,
        @NotBlank(message = "Description is required")
        String author
) {
}
