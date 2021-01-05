/*
-- Query: SELECT * FROM sekotify.customer
LIMIT 0, 1000

-- Date: 2020-05-25 03:18
*/
CREATE TABLE `customer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `` (`id`,`userName`,`password`,`name`,`surname`) VALUES (149,'lifeguard','1234','Serkan','Koçoğlu');
INSERT INTO `` (`id`,`userName`,`password`,`name`,`surname`) VALUES (150,'serkan6','Serkan_35','Serkan','Koçoğlu');
INSERT INTO `` (`id`,`userName`,`password`,`name`,`surname`) VALUES (151,'Username','Password123','Name','Surname');
