
-- Creación de la tabla 'autor'
CREATE TABLE autor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL,
    nacionalidad VARCHAR(255),
    fecha_nacimiento DATE
);

-- Creación de la tabla 'editorial'
CREATE TABLE editorial (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(100),
    telefono VARCHAR(50),
    correo VARCHAR(100)
);

-- Creación de la tabla 'libro'
CREATE TABLE libro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor_id BIGINT NOT NULL,
    editorial_id BIGINT NOT NULL,
    anio_publicacion INT,
    genero VARCHAR(50) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES autor(id) ON DELETE CASCADE,
    FOREIGN KEY (editorial_id) REFERENCES editorial(id) ON DELETE CASCADE
);