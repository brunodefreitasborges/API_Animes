package com.api.anime.anime_library_api.application.usecase;

import com.api.anime.anime_library_api.infrastructure.repository.AnimeJPARepository;
import com.api.anime.anime_library_api.infrastructure.repository.GeneroJPARepository;
import org.springframework.stereotype.Service;

@Service
public class AtualizarAnimeUseCase {

    private final AnimeJPARepository animeJPARepository;
    private final GeneroJPARepository generoJPARepository;

    public AtualizarAnimeUseCase(AnimeJPARepository animeJPARepository, GeneroJPARepository generoJPARepository) {
        this.animeJPARepository = animeJPARepository;
        this.generoJPARepository = generoJPARepository;
    }


}
