package com.api.anime.anime_library_api.application.usecase;

import com.api.anime.anime_library_api.domain.entity.Anime;
import com.api.anime.anime_library_api.infrastructure.repository.AnimeJPARepository;
import org.springframework.stereotype.Service;

@Service
public class DetalharAnimeUseCase {

    private final AnimeJPARepository animeJPARepository;

    public DetalharAnimeUseCase(AnimeJPARepository animeJPARepository) {
        this.animeJPARepository = animeJPARepository;
    }

    public Anime detalhar(Long id) {
        return animeJPARepository.getReferenceById(id);
    }
}
