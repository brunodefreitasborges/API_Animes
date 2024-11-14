package com.api.anime.anime_library_api.application.usecase;

import com.api.anime.anime_library_api.application.dto.AvaliarDTO;
import com.api.anime.anime_library_api.domain.entity.Anime;
import com.api.anime.anime_library_api.infrastructure.repository.AnimeJPARepository;
import org.springframework.stereotype.Service;

@Service
public class AvaliarAnimeUseCase {

    private final AnimeJPARepository animeJPARepository;

    public AvaliarAnimeUseCase(AnimeJPARepository animeJPARepository) {
        this.animeJPARepository = animeJPARepository;
    }

    public void avaliar(Long id, AvaliarDTO novaNota) {
        Anime anime = animeJPARepository.getReferenceById(id);
        anime.adicionarNota(novaNota.nota());
        animeJPARepository.save(anime);
    }
}
