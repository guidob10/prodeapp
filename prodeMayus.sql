/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.27 : Database - prode
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`prode` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `apuestas` */

DROP TABLE IF EXISTS `apuestas`;

CREATE TABLE `apuestas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `idPartido` bigint(20) NOT NULL,
  `idUsuario` bigint(20) NOT NULL,
  `ganador` tinyint(1) NOT NULL COMMENT '1 local',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `apuestas` */

insert  into `apuestas`(`id`,`idPartido`,`idUsuario`,`ganador`) values (1,2,1,1),(2,3,1,0),(3,4,1,0),(4,5,1,0),(5,6,1,0),(11,1,1,1);

/*Table structure for table `banners` */

DROP TABLE IF EXISTS `banners`;

CREATE TABLE `banners` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(250) NOT NULL,
  `fecha` date NOT NULL,
  `archivo` varchar(250) NOT NULL,
  `estatus` enum('Activo','Inactivo') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `banners` */

insert  into `banners`(`id`,`titulo`,`fecha`,`archivo`,`estatus`) values (1,'Estreno - Kong La Isla Calavera','2017-07-27','slide1.jpg','Activo'),(2,'Proximo Mes - La bella y la bestia','2017-07-27','slide2.jpg','Activo'),(3,'Ya esta aquí - Spider Man, de regreso a casa','2017-07-28','slide3.jpg','Inactivo'),(4,'Por fin ha llegado el día - Cars 3 ','2017-07-29','slide4.jpg','Inactivo'),(5,'Star Wars: Episodio VIII - Los ultimos Jedi.','2017-11-17','slide5.jpg','Inactivo');

/*Table structure for table `clubes` */

DROP TABLE IF EXISTS `clubes`;

CREATE TABLE `clubes` (
  `id` bigint(20) NOT NULL,
  `nombreClub` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `clubes` */

insert  into `clubes`(`id`,`nombreClub`) values (1,'Boca'),(2,'Hispano'),(3,'Obras'),(4,'Quilmes'),(5,'Peñarol'),(6,'Comunicaciones'),(7,'Ferro'),(8,'San Lorenzo'),(9,'Bahia Basket'),(10,'Gimnasia Comodoro');

/*Table structure for table `detalles` */

DROP TABLE IF EXISTS `detalles`;

CREATE TABLE `detalles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `director` varchar(100) DEFAULT NULL,
  `actores` varchar(255) DEFAULT NULL,
  `sinopsis` text,
  `trailer` varchar(255) DEFAULT NULL COMMENT 'URL del video en Youtube\n',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `detalles` */

insert  into `detalles`(`id`,`director`,`actores`,`sinopsis`,`trailer`) values (1,'Jordan Vogt-Roberts','Samuel L. Jackson,Tom Hiddleston,Brie Larson,Toby Kebbell','Kong: La Isla Calavera reimagina el origen del mítico Kong en una irresistible aventura original del director Jordan Vogt-Roberts. En la película, un diverso equipo de exploradores es reunido para aventurarse en el interior de una isla del Pacífico —tan bella como traicionera— que no aparece en los mapas, sin saber que están invadiendo los dominios del mítico Kong.','https://www.youtube.com/embed/86jhW2gPc84'),(2,'Daniel Espinosa','Jake Gyllenhaal, Ryan Reynolds, Rebecca Ferguson','Seis miembros de la tripulación de la Estación Espacial Internacional que están a punto de lograr uno de los descubrimientos más importantes en la historia humana: la primera evidencia de vida extraterrestre en Marte. A medida que el equipo comienza a investigar y sus métodos tienen consecuencias inesperadas, la forma viviente demostrará ser más inteligente de lo que cualquiera esperaba.','https://www.youtube.com/embed/_cq1XIVXdjU'),(3,'Bill Condon','Dan Stevens,Emma Watson,Luke Evans','LA BELLA Y LA BESTIA, de Disney, es una adaptación de acción real de la película animada, que revive a los queridos personajes del clásico cuento de Disney para una audiencia contemporánea, manteniendo la música original e incorporando varias nuevas canciones.','https://www.youtube.com/embed/4D8N06nx9rs'),(4,'Oriol Paulo','Mario Casas, Bárbara Lennie, José Coronado, Ana Wagener','Adrián Doria, un joven y exitoso empresario, despierta en la habitación de un hotel junto al cadáver de su amante. Acusado de asesinato, decide contratar los servicios de Virginia Goodman, la mejor preparadora de testigos del país. En el transcurso de una noche, asesora y cliente trabajarán para encontrar una duda razonable que le libre de la cárcel.','https://www.youtube.com/embed/sOxy2gtPY7A'),(5,'Dean Israelite','Bryan Cranston, Elizabeth Banks, Becky G, Dacre Montgomery','Cinco adolescentes deben convertirse en algo extraordinario al enterarse que su pueblo, Angel Grove, y el mundo están a punto de ser aniquilados por una amenaza extraterrestre. Escogidos por el destino, nuestros héroes pronto descubren que son los únicos que pueden salvar el planeta…pero para hacerlo, deberán superar sus problemas de la vida real y, antes que sea demasiado tarde, unirse como los PowerRangers.','https://www.youtube.com/embed/gemUEi0XMTg'),(6,'F. Gary Gray','Dwayne Johnson,Michelle Rodriguez,Charlize Theron,Jason Statham,Vin Diesel','Justo cuando Dom y Letty celebran su luna de miel, Brian y Mia se han retirado del juego y el resto del equipo se ha desintegrado en busca de una vida comun y corriente; una misteriosa mujer intentara seducir a Dom para convencerlo de regresar a la vida criminal que tanto lo acecha, traicionando a quienes lo rodean y enfrentandose a retos nunca antes vistos.','https://www.youtube.com/embed/3KuazYQ1JuE'),(7,'James Gunn','Dave Bautista,Bradley Cooper,Zoe Saldana,Vin Diesel,Chris Pratt','Ambientada en el nuevo contexto sonoro de \"Awesome Mixtape #2\", GUARDIANES DE LA GALAXIA VOL. 2, de Marvel, continua las aventuras del equipo en su travesia por los confines del cosmos. Los Guardianes deberan luchar para mantener unida a su nueva familia mientras intentan resolver el misterio del verdadero linaje de Peter Quill. Viejos rivales se convertiran en nuevos aliados y los personajes favoritos de los comics clasicos acudiran en ayuda de nuestros heroes a medida que el Universo Cinematografico de Marvel continua expandiendose.','https://www.youtube.com/embed/bBTtlcJwjSo');

/*Table structure for table `horarios` */

DROP TABLE IF EXISTS `horarios`;

CREATE TABLE `horarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `sala` varchar(100) NOT NULL,
  `precio` double NOT NULL DEFAULT '0',
  `idPelicula` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Horarios_Peliculas1_idx` (`idPelicula`),
  CONSTRAINT `fk_Horarios_Peliculas1` FOREIGN KEY (`idPelicula`) REFERENCES `peliculas` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

/*Data for the table `horarios` */

insert  into `horarios`(`id`,`fecha`,`hora`,`sala`,`precio`,`idPelicula`) values (1,'2018-01-12','18:00:00','Premium',55,1),(2,'2018-01-12','18:00:00','Premium',55,3),(3,'2018-01-12','21:00:00','Premium',55,3),(4,'2018-01-12','18:00:00','Premium',65,4),(5,'2018-01-12','21:00:00','Premium',65,4),(6,'2018-01-12','20:00:00','Premium',55,5),(7,'2018-01-12','16:30:00','Premium',60,7),(8,'2018-01-12','15:45:00','Premium',55,8),(9,'2018-01-12','14:00:00','Sala 1',55,1),(10,'2018-01-12','16:00:00','Sala 1',55,1),(11,'2018-01-12','14:00:00','Sala 1',60,2),(12,'2018-01-12','16:00:00','Sala 1',60,2),(13,'2018-01-12','14:00:00','Sala 1',55,3),(14,'2018-01-12','16:00:00','Sala 1',55,3),(15,'2018-01-12','14:00:00','Sala 1',65,4),(16,'2018-01-12','16:00:00','Sala 1',65,4),(17,'2018-01-12','17:00:00','Sala 1',55,5),(18,'2018-01-12','19:00:00','Sala 1',55,5),(19,'2018-01-12','21:00:00','Sala 1',55,5),(20,'2018-01-12','18:45:00','Sala 1',55,8),(21,'2018-01-12','21:45:00','Sala 1',55,8),(22,'2018-01-12','17:00:00','Sala 2',55,3),(23,'2018-01-12','17:00:00','Sala 2',65,4),(24,'2018-01-12','16:00:00','Sala 2',55,5),(25,'2018-01-12','18:30:00','Sala 2',60,7),(26,'2018-01-12','16:00:00','Sala 3',55,3),(27,'2018-01-12','16:00:00','Sala 3',65,4),(28,'2018-01-12','22:00:00','Sala 3',55,5),(29,'2018-01-12','20:45:00','Sala 3',60,7),(30,'2018-01-12','22:20:00','Sala 3',55,8),(31,'2018-01-13','18:00:00','Premium',55,1),(32,'2018-01-13','18:00:00','Premium',55,3),(33,'2018-01-13','21:00:00','Premium',55,3),(34,'2018-01-13','18:00:00','Premium',65,4),(35,'2018-01-13','21:00:00','Premium',65,4),(36,'2018-01-13','14:30:00','Premium',55,8),(37,'2018-01-13','17:00:00','Premium',55,8),(38,'2018-01-13','14:00:00','Sala 1',55,1),(39,'2018-01-13','16:00:00','Sala 1',55,1),(40,'2018-01-13','14:00:00','Sala 1',60,2),(41,'2018-01-13','16:00:00','Sala 1',60,2),(42,'2018-01-13','14:00:00','Sala 1',55,3),(43,'2018-01-13','16:00:00','Sala 1',55,3),(44,'2018-01-13','14:00:00','Sala 1',65,4),(45,'2018-01-13','16:00:00','Sala 1',65,4),(46,'2018-01-13','17:50:00','Sala 1',55,8),(47,'2018-01-13','17:00:00','Sala 2',55,3),(48,'2018-01-13','17:00:00','Sala 2',65,4),(49,'2018-01-13','17:00:00','Sala 2',55,8),(50,'2018-01-13','16:00:00','Sala 3',55,3),(51,'2018-01-13','16:00:00','Sala 3',65,4),(52,'2018-01-13','22:10:00','Sala 3',55,8),(53,'2018-01-14','18:00:00','Premium',55,5),(54,'2018-01-14','21:00:00','Premium',55,5),(55,'2018-01-14','20:00:00','Premium',60,2),(56,'2018-01-14','15:30:00','Premium',55,8),(57,'2018-01-14','14:00:00','Sala 1',55,5),(58,'2018-01-14','16:00:00','Sala 1',55,5),(59,'2018-01-14','17:00:00','Sala 1',60,2),(60,'2018-01-14','19:00:00','Sala 1',60,2),(61,'2018-01-14','21:00:00','Sala 1',60,2),(62,'2018-01-14','20:30:00','Sala 1',55,8),(63,'2018-01-14','13:30:00','Sala 1',60,7),(64,'2018-01-14','17:00:00','Sala 2',55,5),(65,'2018-01-14','16:00:00','Sala 2',60,2),(66,'2018-01-14','17:15:00','Sala 2',55,8),(67,'2018-01-14','13:30:00','Sala 2',60,7),(68,'2018-01-14','18:00:00','Sala 2',60,7),(69,'2018-01-14','21:30:00','Sala 2',60,7),(70,'2018-01-14','16:00:00','Sala 3',55,5),(71,'2018-01-14','22:00:00','Sala 3',60,2),(72,'2018-01-14','17:15:00','Sala 3',55,8),(73,'2018-01-14','14:00:00','Sala 3',60,7),(74,'2018-01-14','22:00:00','Sala 3',60,7),(75,'2018-01-15','22:15:00','Premium',55,5),(76,'2018-01-15','14:30:00','Premium',60,7),(77,'2018-01-15','17:00:00','Premium',60,7),(78,'2018-01-15','11:00:00','Premium',55,8),(79,'2018-01-15','14:30:00','Sala 1',60,7),(80,'2018-01-15','21:30:00','Sala 1',60,7),(81,'2018-01-15','15:30:00','Sala 1',55,8),(82,'2018-01-15','15:30:00','Sala 2',55,5),(83,'2018-01-15','21:30:00','Sala 2',60,7),(84,'2018-01-15','11:00:00','Sala 2',55,8),(85,'2018-01-15','17:55:00','Sala 2',55,8),(86,'2018-01-15','16:40:00','Sala 3',55,5),(87,'2018-01-15','14:30:00','Sala 3',60,7),(88,'2018-01-15','17:00:00','Sala 3',60,7),(89,'2018-01-15','21:30:00','Sala 3',60,7),(90,'2018-01-15','11:00:00','Sala 3',55,8),(91,'2018-01-15','22:10:00','Sala 3',55,8),(92,'2018-01-16','13:30:00','Premium',55,8),(93,'2018-01-16','15:30:00','Premium',55,8),(94,'2018-01-16','17:30:00','Premium',55,8),(95,'2018-01-16','21:00:00','Premium',55,8),(96,'2018-01-16','17:00:00','Premium',60,7),(97,'2018-01-16','20:45:00','Premium',60,7),(98,'2018-01-16','16:15:00','Sala 1',55,8),(99,'2018-01-16','18:30:00','Sala 1',55,8),(100,'2018-01-16','21:30:00','Sala 1',55,8),(101,'2018-01-16','16:15:00','Sala 2',60,7),(102,'2018-01-16','20:15:00','Sala 2',60,7),(103,'2018-01-16','22:50:00','Sala 2',60,7),(104,'2018-01-16','14:40:00','Sala 3',55,8),(105,'2018-01-16','20:10:00','Sala 3',55,8);

/*Table structure for table `jornadas` */

DROP TABLE IF EXISTS `jornadas`;

CREATE TABLE `jornadas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  `numeroJornada` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `jornadas` */

insert  into `jornadas`(`id`,`fechaInicio`,`fechaFin`,`numeroJornada`) values (1,'2018-02-13','2018-02-17',1),(2,'2018-03-10','2018-06-15',2);

/*Table structure for table `noticias` */

DROP TABLE IF EXISTS `noticias`;

CREATE TABLE `noticias` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(250) NOT NULL,
  `fecha` date NOT NULL,
  `detalle` text NOT NULL,
  `estatus` enum('Activa','Inactiva') NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `noticias` */

insert  into `noticias`(`id`,`titulo`,`fecha`,`detalle`,`estatus`) values (1,'Prode LNB','2018-02-21','<p><strong><span style=\"color: #ff0000;\">A la luz el nuevo Prode de la Liga Nacional de Basquet. </span></strong></p>\r\n<p><strong>&iexcl;San Lorenzo, Boca y todos! Todo sobre la nueva temporada.<br /></strong></p>\r\n<p>Arriesga, juga, y adivina quien es el mejor equipo de la liga &iquest;Quien sabe mas de basquet?</p>\r\n<p>Ya lo veremos!!</p>','Activa'),(2,'Julia Roberts protagonizara. The Bookseller','2018-01-10','<p>La novela de Cynthia Swanson <span style=\"color: #0000ff;\"><strong>The Bookseller</strong></span> ser&aacute; llevada al cine con <span style=\"color: #0000ff;\">Julia Roberts (Los Pitufos: La aldea Escondida)</span> como protagonista.<br /><br />La historia est&aacute; ambientada en los sesenta y su protagonista es una mujer soltera, Kitty Miller, que lleva una librer&iacute;a. Sue&ntilde;a con una vida alternativa en la que ha encontrado el amor y est&aacute; casada y con hijos, pero la l&iacute;nea que separa realidad y ficci&oacute;n comienza a estar demasiado dispersa para que la distinga.<br /><br />Seg&uacute;n informa <span style=\"color: #ff0000;\"><strong>Moviehole</strong></span> Roberts tambi&eacute;n producir&aacute; la pel&iacute;cula junto a Lisa Gillan y Marisa Yeres Hill.</p>','Inactiva'),(3,'Rosamund Pike sera Marie Curie','2017-05-17','<p><strong>Rosamund Pike</strong> (<span style=\"color: #008000;\">Un Reino Unido</span>) dar&aacute; vida a la famosa cient&iacute;fica Marie Curie en la pel&iacute;cula de Studiocanal <strong>Radioactiv</strong>. Se trata de una adaptaci&oacute;n de la biograf&iacute;a escrita por Lauren Redniss, que se centra en el romance entre Marie y Pierre Curie y en el descubrimiento de la radiactividad.<br /><br />Seg&uacute;n informa <span style=\"color: #008000;\"><strong>Premiere</strong></span> el proceso de casting para los papeles de Pierre y de Paul Langevin, su joven amante, ya ha comenzado.<br /><br />Marjane Satrapi dirigir&aacute; a partir de un gui&oacute;n de Jack Thorne. Tim Bevan, Eric Fellner y Paul Webster producir&aacute;n la pel&iacute;cula.</p>','Inactiva'),(4,'Julianne Moore sera Gloria','2018-01-12','<p><strong><span style=\"color: #0000ff;\">Julianne Moore</span></strong> <span style=\"color: #808080;\">(Kingsman: El C&iacute;rculo de Oro)</span> protagonizar&aacute; el remake de FilmNation de la pel&iacute;cula chilena <em><strong>Gloria</strong></em>.<br /><br />Sebastian Lelio, director de la pel&iacute;cula original, escribir&aacute; el gui&oacute;n del remake, que todav&iacute;a no tiene t&iacute;tulo.<br /><br />Moore ser&aacute; Gloria, una mujer de 58 a&ntilde;os que est&aacute; sola en la vida. Para compensar el vac&iacute;o, llena sus d&iacute;as de actividades y por las noches busca el amor en el mundo de las fiestas para solteros adultos, donde solo consigue perderse en una serie de aventuras sin sentido. Esta fr&aacute;gil felicidad en la que vive se altera cuando conoce a Rodolfo, un hombre de 65 a&ntilde;os, recientemente separado, que se obsesiona con ella. Gloria comienza un romance, pero &eacute;ste se complica por la enfermiza dependencia de Rodolfo hacia sus hijos y su ex mujer. Esta relaci&oacute;n, a la que Gloria se entrega porque intuye que podr&iacute;a ser la &uacute;ltima, acabar&aacute; por hacerla estrellarse contra la cruel realidad del mundo. Gloria deber&aacute; reconstruirse para enfrentar con nuevas fuerzas su definitiva entrada a la vejez.<br /><br />Seg&uacute;n <span style=\"color: #008000;\"><strong>The Hollywood Reporter</strong> </span>Juan de Dios Larrain y Pablo Larrain producir&aacute;n la cinta, que comenzar&aacute; a rodarse a finales de mes.</p>','Inactiva');

/*Table structure for table `parametros` */

DROP TABLE IF EXISTS `parametros`;

CREATE TABLE `parametros` (
  `id` bigint(20) NOT NULL,
  `codigo` varchar(20) NOT NULL,
  `valor` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `parametros` */

insert  into `parametros`(`id`,`codigo`,`valor`) values (1,'ambiente','desarrollo');

/*Table structure for table `partidos` */

DROP TABLE IF EXISTS `partidos`;

CREATE TABLE `partidos` (
  `id` bigint(20) NOT NULL,
  `idlocal` bigint(20) NOT NULL,
  `idvisita` bigint(20) NOT NULL,
  `puntosLocal` int(11) DEFAULT NULL,
  `puntosVisita` int(11) DEFAULT NULL,
  `idJornada` bigint(20) NOT NULL,
  `fechaPartido` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `partido_jornada` (`idJornada`),
  KEY `partido_club` (`idlocal`),
  KEY `partido_clubvisita` (`idvisita`),
  CONSTRAINT `partido_club` FOREIGN KEY (`idlocal`) REFERENCES `clubes` (`id`),
  CONSTRAINT `partido_clubvisita` FOREIGN KEY (`idvisita`) REFERENCES `clubes` (`id`),
  CONSTRAINT `partido_jornada` FOREIGN KEY (`idJornada`) REFERENCES `jornadas` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `partidos` */

insert  into `partidos`(`id`,`idlocal`,`idvisita`,`puntosLocal`,`puntosVisita`,`idJornada`,`fechaPartido`) values (1,1,2,100,101,1,'2018-02-14'),(2,2,1,102,120,2,'2018-02-20'),(3,3,4,120,102,2,'2018-02-17'),(4,5,6,88,99,2,'2018-02-15'),(5,7,8,66,77,2,'2018-02-15'),(6,9,10,55,83,2,'2018-02-16');

/*Table structure for table `peliculas` */

DROP TABLE IF EXISTS `peliculas`;

CREATE TABLE `peliculas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(150) NOT NULL,
  `duracion` int(11) NOT NULL,
  `clasificacion` enum('A','B','C') NOT NULL,
  `genero` varchar(45) NOT NULL,
  `imagen` varchar(200) DEFAULT NULL,
  `fechaEstreno` date NOT NULL,
  `estatus` enum('Activa','Inactiva') NOT NULL DEFAULT 'Activa',
  `idDetalle` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Peliculas_Detalles1_idx` (`idDetalle`),
  CONSTRAINT `fk_Peliculas_Detalles1` FOREIGN KEY (`idDetalle`) REFERENCES `detalles` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `peliculas` */

insert  into `peliculas`(`id`,`titulo`,`duracion`,`clasificacion`,`genero`,`imagen`,`fechaEstreno`,`estatus`,`idDetalle`) values (1,'Kong La Isla Calavera',118,'B','Accion y Aventura','kong.png','2018-01-07','Activa',1),(2,'Life: Vida Inteligente',104,'B','Drama','life.png','2018-01-07','Activa',2),(3,'La Bella y La Bestia',132,'A','Infantil','bella.png','2018-01-07','Activa',3),(4,'Contratiempo',106,'B','Thriller','contratiempo.png','2018-01-09','Activa',4),(5,'Power Rangers',120,'B','Aventura','power-rangers.png','2018-01-09','Activa',5),(7,'Rapidos y Furiosos 8',136,'B','Accion','rapidos-furiosos.png','2018-01-11','Activa',6),(8,'Guardianes de la Galaxia Vol 2',136,'B','Accion','guardianes-galaxia.png','2018-01-11','Activa',7);

/*Table structure for table `usuarioperfil` */

DROP TABLE IF EXISTS `usuarioperfil`;

CREATE TABLE `usuarioperfil` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `perfil` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Usuarios_Perfil1` (`username`),
  CONSTRAINT `fk_Usuarios_Perfil1` FOREIGN KEY (`username`) REFERENCES `usuarios` (`username`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `usuarioperfil` */

insert  into `usuarioperfil`(`id`,`username`,`perfil`) values (1,'luis','editor'),(4,'guido','jugador');

/*Table structure for table `usuarios` */

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) NOT NULL,
  `email` varchar(50) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `usuarios` */

insert  into `usuarios`(`id`,`nombre`,`email`,`username`,`password`) values (1,'Luis (Editor de My CineSite)','editor@cinesite.com','luis','e6ba4060d7bc5a577715be0c5352a6f1'),(3,'Marisol','a@a.com','marisol','c21b6a13d68b58cd46df1f0c60d157fa'),(4,'guido','g@asd.com','guido','c21b6a13d68b58cd46df1f0c60d157fa');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
