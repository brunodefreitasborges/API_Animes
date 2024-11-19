package com.api.anime.anime_library_api.domain.animes;

import com.api.anime.anime_library_api.infrastructure.entity.Genero;
import com.api.anime.anime_library_api.infrastructure.repository.GeneroJPARepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class GenderService {

    private final GeneroJPARepository generoJPARepository;

    public Genero findByNome(String nomeGenero) {
        return generoJPARepository.findByNome(nomeGenero)
                .orElse(generoJPARepository.save(new Genero(null, nomeGenero)));
    }
}