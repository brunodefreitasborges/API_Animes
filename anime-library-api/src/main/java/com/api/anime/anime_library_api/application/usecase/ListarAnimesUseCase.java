package com.api.anime.anime_library_api.application.usecase;

import com.api.anime.anime_library_api.application.dto.ListarAnimeDTO;
import com.api.anime.anime_library_api.domain.repository.AnimeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarAnimesUseCase {

    private final AnimeRepository animeRepository;

    public ListarAnimesUseCase(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public Page<ListarAnimeDTO> listar(Pageable pageable) {
        return animeRepository.findAllByAtivoTrue(pageable).map(ListarAnimeDTO::new);
    }
}
