package com.api.anime.anime_library_api.application.usecase;

import com.api.anime.anime_library_api.domain.entity.Anime;
import com.api.anime.anime_library_api.infrastructure.repository.AnimeJPARepository;
import org.springframework.stereotype.Service;

@Service
public class DesativarAnimeUseCase {

    private final AnimeJPARepository animeJPARepository;

    public DesativarAnimeUseCase(AnimeJPARepository animeJPARepository) {
        this.animeJPARepository = animeJPARepository;
    }

    public Anime desativar(Long id) {
        Anime anime = animeJPARepository.getReferenceById(id);
        anime.desativar();
        return anime;
    }
}
