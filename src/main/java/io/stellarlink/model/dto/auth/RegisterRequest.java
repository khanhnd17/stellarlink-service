package io.stellarlink.model.dto.auth;

import io.stellarlink.model.enums.EncryptionAlgorithm;
import jakarta.validation.constraints.NotBlank;

public record RegisterRequest(
    @NotBlank String username,
    @NotBlank String password,
    EncryptionAlgorithm algorithm
) {}