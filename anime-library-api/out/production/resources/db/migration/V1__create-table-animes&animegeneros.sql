CREATE TABLE IF NOT EXISTS animes (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    nota DOUBLE DEFAULT 0.0,
    quantidade_avaliacoes INT DEFAULT 0,
    sinopse TEXT NOT NULL,
    generos JSON
);



