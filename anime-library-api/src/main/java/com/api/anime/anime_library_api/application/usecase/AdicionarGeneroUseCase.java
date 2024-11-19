package com.api.anime.anime_library_api.application.usecase;

import com.api.anime.anime_library_api.infrastructure.entity.Anime;
import com.api.anime.anime_library_api.infrastructure.entity.Genero;
import com.api.anime.anime_library_api.infrastructure.repository.AnimeJPARepository;
import com.api.anime.anime_library_api.infrastructure.repository.GeneroJPARepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdicionarGeneroUseCase {

    private final AnimeJPARepository animeJPARepository;
    private final GeneroJPARepository generoJPARepository;

    public AdicionarGeneroUseCase(AnimeJPARepository animeJPARepository, GeneroJPARepository generoJPARepository) {
        this.animeJPARepository = animeJPARepository;
        this.generoJPARepository = generoJPARepository;
    }

    public void adicionarGenero(Long id, String nomeGenero) {
        Optional<Genero> generoExistenteOptional = generoJPARepository.findByNome(nomeGenero);

        if (generoExistenteOptional.isEmpty()) {
            Genero genero = new Genero(null, nomeGenero);
            generoJPARepository.save(genero);
            generoExistenteOptional = Optional.of(genero);
        }

        Anime anime = animeJPARepository.getReferenceById(id);
        Genero generoExistente = generoExistenteOptional.get();
        anime.getGeneros().add(generoExistente);
    }
}
