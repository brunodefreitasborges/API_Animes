package com.api.anime.anime_library_api.domain.entity;

import com.api.anime.anime_library_api.domain.anime.DadosRegistroAnime;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "animes")
@Entity(name = "Anime")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String autor;

    private Double nota = 0.0;

    @Column(name = "quantidade_avaliacoes", nullable = false, columnDefinition = "INT DEFAULT 0")
    private int quantidadeAvaliacoes = 0;

    private String sinopse;

    @ManyToMany
    @JoinTable(
            name = "anime_generos",
            joinColumns = @JoinColumn(name = "anime_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id")
    )
    private List<Genero> generos;

    public Anime(DadosRegistroAnime dados, List<Genero> generos) {
        this.titulo = dados.titulo();
        this.autor = dados.autor();
        this.sinopse = dados.sinopse();
        this.generos = generos;
    }

    public void adicionarNota(Double novaNota) {
        this.nota = ((this.nota * this.quantidadeAvaliacoes) + novaNota) / (this.quantidadeAvaliacoes + 1);
        this.quantidadeAvaliacoes++;
    }
}
