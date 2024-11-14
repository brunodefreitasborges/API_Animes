package com.api.anime.anime_library_api.application.usecase;

import com.api.anime.anime_library_api.application.dto.AtualizacaoAnimeDTO;
import com.api.anime.anime_library_api.domain.entity.Anime;
import com.api.anime.anime_library_api.domain.entity.Genero;
import com.api.anime.anime_library_api.infrastructure.repository.AnimeJPARepository;
import com.api.anime.anime_library_api.infrastructure.repository.GeneroJPARepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtualizarAnimeUseCase {

    private final AnimeJPARepository animeJPARepository;
    private final GeneroJPARepository generoJPARepository;

    public AtualizarAnimeUseCase(AnimeJPARepository animeJPARepository, GeneroJPARepository generoJPARepository) {
        this.animeJPARepository = animeJPARepository;
        this.generoJPARepository = generoJPARepository;
    }

    public Anime atualizar(AtualizacaoAnimeDTO dados, Long id) {
        Anime anime = animeJPARepository.getReferenceById(id);
        anime.atualizarInformacoes(dados);

        // Criando uma lista de gêneros a partir dos nomes fornecidos
        List<Genero> generos = new ArrayList<>();

        dados.generos().forEach(nomeGenero -> {
            // Verifica se o gênero já existe, caso contrário cria um novo
            generos.add(generoJPARepository.findByNome(String.valueOf(nomeGenero))
                    .orElseGet(() -> generoJPARepository.save(new Genero(null, nomeGenero.toString()))));
        });

        anime.setGeneros(generos);  // Definindo a lista de gêneros no anime

        return anime;
    }
}
