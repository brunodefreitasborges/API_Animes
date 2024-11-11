package com.api.anime.anime_library_api.domain.anime;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

public record DadosRegistroAnime(
        @NotBlank String titulo,
        @NotBlank String autor,
        String sinopse,
        List<String> generos // Agora é uma lista de strings, representando os nomes dos gêneros.
) {}
