CREATE TABLE IF NOT EXISTS `cliente` (
 
    `id` int NOT NULL PRIMARY KEY,
    `nome` varchar(20),
    `email` varchar(50),
    `data_nascimento` date
);