package com.api.anime.anime_library_api.application.usecase;

import com.api.anime.anime_library_api.domain.dto.ListarGenerosDTO;
import com.api.anime.anime_library_api.infrastructure.repository.GeneroJPARepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ListarGenerosUseCase {

    private final GeneroJPARepository generoJPARepository;

    public ListarGenerosUseCase(GeneroJPARepository generoJPARepository) {
        this.generoJPARepository = generoJPARepository;
    }

    public Page<ListarGenerosDTO> listar(Pageable pageable) {
        return generoJPARepository.findAll(pageable).map(ListarGenerosDTO::new);
    }
}
