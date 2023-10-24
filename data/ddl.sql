CREATE TABLE IF NOT EXISTS newsletter (
    id UUID PRIMARY KEY,
    titulo VARCHAR(255),
    conteudo VARCHAR(500)
);

-- Inserção 1
INSERT INTO newsletter (id, titulo, conteudo)
VALUES ('6ba7b810-9dad-11d1-80b4-00c04fd430c8', 'Novidades da Semana', 'Confira as últimas novidades da semana em nossa newsletter.');

-- Inserção 2
INSERT INTO newsletter (id, titulo, conteudo)
VALUES ('6ba7b811-9dad-11d1-80b4-00c04fd430c9', 'Dicas de Saúde', 'Descubra dicas úteis para manter uma vida saudável em nossa newsletter de saúde.');

-- Inserção 3
INSERT INTO newsletter (id, titulo, conteudo)
VALUES ('6ba7b812-9dad-11d1-80b4-00c04fd430d0', 'Receitas Deliciosas', 'Explore receitas deliciosas e fáceis de preparar em nossa newsletter culinária.');
