CREATE TABLE `detail` (
  `id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `path` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ;

/*
-- Query: SELECT * FROM ımgdata.detail
LIMIT 0, 1000

-- Date: 2020-04-18 01:07
*/

INSERT INTO `detail` (`id`,`name`,`path`) VALUES (0,'Image Name','Path Name');
INSERT INTO `detail` (`id`,`name`,`path`) VALUES (1,'mrbean','mrbean.png');
INSERT INTO `detail` (`id`,`name`,`path`) VALUES (2,'spongebob','spongebob.png');
INSERT INTO `detail` (`id`,`name`,`path`) VALUES (3,'hello','hello.png');
INSERT INTO`detail` (`id`,`name`,`path`) VALUES (4,'easy','easy.jpg');
INSERT INTO `detail` (`id`,`name`,`path`) VALUES (5,'MaskedCat','MaskedCat.jpg');
