
INSERT INTO autor (nombre, apellido, nacionalidad, fecha_nacimiento) VALUES
('George', 'Orwell', 'Británico', '1903-06-25'),
('F.Scott', 'Fitzgerald', 'Estadounidense', '1925-04-10'),
('Isaac', 'Asimov', 'Estadounidense', '1919-12-20'),
('Harper', 'Lee', 'Estadounidense', '1926-04-28'),
('J.K.', 'Rowling', 'Británica', '1965-07-31'),
('Oscar', 'Wilde', 'Irlandés', '1854-10-16'),
('Ray', 'Bradbury', 'Estadounidense', '1953-10-19'),
('Jane', 'Austen', 'Británica', '1775-12-16');



INSERT INTO editorial (nombre, direccion, telefono, email) VALUES
('Editorial Sudamericana', 'Avenida Principal 123', '1134567890', 'contacto@sudamericana.com'),
('Editorial Planeta', 'Avenida del Sol 321', '551234567', 'editorial@planeta.com'),
('Penguin Random House', 'Calle Ficticia 1', '1220333', 'contacto@penguinrandomhouse.com'),
('HarperCollins', 'Avenida Ficción 2', '4446666', 'info@harpercollins.com'),
('Macmillan', 'Avenida Literatura 4', '2223444', 'contacto@macmillan.com'),
('Editorial Anagrama', 'Calle Crítica 6', '8890800', 'editorial@anagrama.com'),
('Alfaguara', 'Calle Inventada 8', '456654567', 'info@alfaguara.com');


INSERT INTO libro (titulo, autor_id, editorial_id, publicacion, genero, precio) VALUES
('1984', 1, 2, 1949, 'CIENCIA_FICCION', 23000),
('El Gran Gatsby', 2, 3, 1925, 'DRAMA', 30000),
('Yo, robot', 3, 3, 1950, 'CIENCIA_FICCION', 30000),
('Matar a un Ruiseñor', 4 , 4, 1960, 'DRAMA', 28000),
('Orgullo y Prejuicio', 8, 5, 1813, 'ROMANCE', 32000),
('El Retrato de Dorian Gray', 6, 6, 1890, 'TERROR', 25000),
('Fahrenheit 451', 7, 7, 1953, 'CIENCIA_FICCION', 27000);
