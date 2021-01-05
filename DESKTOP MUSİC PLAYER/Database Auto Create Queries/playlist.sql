/*
-- Query: SELECT * FROM sekotify.playlist
LIMIT 0, 1000

-- Date: 2020-05-25 03:18
*/
CREATE TABLE `playlist` (
  `username` varchar(45) DEFAULT NULL,
  `songName` varchar(45) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO `` (`username`,`songName`,`id`) VALUES ('lifeguard','RammsteinRosenrot.wav',27);
INSERT INTO `` (`username`,`songName`,`id`) VALUES ('lifeguard','Barracuda.wav',44);
INSERT INTO `` (`username`,`songName`,`id`) VALUES ('lifeguard','Stranger Things-Theme Song.wav',45);
INSERT INTO `` (`username`,`songName`,`id`) VALUES ('lifeguard','Y2K bbno$ - Lalala.wav',47);
INSERT INTO `` (`username`,`songName`,`id`) VALUES ('lifeguard','Kungs-This Girl.wav',48);
INSERT INTO `` (`username`,`songName`,`id`) VALUES ('lifeguard','RammsteinRosenrot.wav',50);
INSERT INTO `` (`username`,`songName`,`id`) VALUES ('lifeguard','Dark Trap.wav',53);
INSERT INTO `` (`username`,`songName`,`id`) VALUES ('lifeguard','Eminem-Without me.wav',55);
INSERT INTO `` (`username`,`songName`,`id`) VALUES ('lifeguard','Saint JHN - Roses.wav',58);
INSERT INTO `` (`username`,`songName`,`id`) VALUES ('serkan6','Annenmaykantereit-Toms Diner.wav',59);
INSERT INTO `` (`username`,`songName`,`id`) VALUES ('serkan6','Imagine Dragons-Thunder.wav',60);
INSERT INTO `` (`username`,`songName`,`id`) VALUES ('serkan6','Bass House.wav',61);
