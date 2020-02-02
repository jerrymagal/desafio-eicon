CREATE TABLE IF NOT EXISTS `pedido` (
 
    `numero` int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `data_cadastro` date,
    `id_cliente` int,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);