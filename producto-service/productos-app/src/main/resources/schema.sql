DROP TABLE IF EXISTS productos;

CREATE TABLE productos
(
    id BIGSERIAL PRIMARY KEY NOT NULL,
    nombre VARCHAR(255),
    codigo VARCHAR(255)
);