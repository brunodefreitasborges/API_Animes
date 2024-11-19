package com.api.anime.anime_library_api.application.usecase;

import com.api.anime.anime_library_api.infrastructure.entity.Anime;
import com.api.anime.anime_library_api.infrastructure.repository.AnimeJPARepository;
import org.springframework.stereotype.Service;

@Service
public class AtivarAnimeUseCase {

    private final AnimeJPARepository animeJPARepository;

    public AtivarAnimeUseCase(AnimeJPARepository animeJPARepository) {
        this.animeJPARepository = animeJPARepository;
    }

    public Anime ativar(Long id) {
        Anime anime = animeJPARepository.getReferenceById(id);
        anime.ativar();
        return anime;
    }
}
