
--Insertar autores
INSERT INTO autor (nombre, apellido, nacionalidad, fecha_nacimiento) VALUES
('Gabriel', 'García Márquez', 'Colombiano', '1927-03-06'),
('Isaac', 'Asimov', 'Estadounidense', '1920-01-02'),
('George', 'Orwell', 'Británico', '1903-06-25'),
('J.K.', 'Rowling', 'Británica', '1965-07-31'),
('Jane', 'Austen', 'Británica', '1775-12-16');


Insertar editoriales
INSERT INTO editorial (nombre, direccion, telefono, email) VALUES
('Editorial Sudamericana', 'Avenida Principal 123', '1134567890', 'contacto@sudamericana.com'),
('Editorial Planeta', 'Avenida del Sol 321', '551234567', 'editorial@planeta.com'),
('Penguin Random House', 'Calle Ficticia 1', '1220333', 'contacto@penguinrandomhouse.com'),
('HarperCollins', 'Avenida Ficción 2', '4446666', 'info@harpercollins.com'),
('Macmillan', 'Avenida Literatura 4', '2223444', 'contacto@macmillan.com'),
('Editorial Anagrama', 'Calle Crítica 6', '8890800', 'editorial@anagrama.com'),
('Alfaguara', 'Calle Inventada 8', '456654567', 'info@alfaguara.com');

Insertar libros
INSERT INTO libro (titulo, autor_id, editorial_id, publicacion, genero, precio) VALUES
('Don Quijote de la Mancha', 1, 1, 1605, 'NOVELA', 20000),
('1984', 3, 2, 1949, 'CIENCIA_FICCION', 23000),
('El Gran Gatsby', 4, 3, 1925, 'DRAMA', 30000),
('Matar a un Ruiseñor', 5, 4, 1960, 'DRAMA', 28000),
('Orgullo y Prejuicio', 6, 5, 1813, 'ROMANCE', 32000),
('El Retrato de Dorian Gray', 7, 6, 1890, 'TERROR', 25000),
('Fahrenheit 451', 2, 7, 1953, 'CIENCIA_FICCION', 27000);
