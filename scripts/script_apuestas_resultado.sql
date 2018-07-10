ALTER TABLE `apuestas` ADD COLUMN `resultadoApuesta` TINYINT(1) NULL COMMENT '1 gano' AFTER `ganador`, ADD COLUMN `fechaProceso` DATE NULL COMMENT 'fecha proceso' AFTER `resultadoApuesta`; 

DELIMITER $$

ALTER DEFINER=`root`@`localhost` EVENT `ev_resultados` ON SCHEDULE EVERY 1 DAY STARTS '2018-06-06 03:00:00' ON COMPLETION NOT PRESERVE ENABLE DO BEGIN
	   -- SELECT id,puntosLocal,puntosVisita FROM partidos WHERE fechaPartido = DATE_ADD(CURDATE(), INTERVAL -1 DAY); -- recupero ids con fecha -1
	    DROP TABLE IF EXISTS apuestasganadores;
	    CREATE TEMPORARY TABLE apuestasganadores
	    SELECT a.id  FROM apuestas a
		JOIN partidos p ON a.idpartido = p.id 
		WHERE p.fechapartido = DATE_ADD(CURDATE(), INTERVAL -1 DAY)
		AND (p.puntosLocal < p.puntosVisita AND a.ganador = 0) OR
		(p.puntosLocal > p.puntosVisita AND a.ganador = 1);
		
	    
	    DROP TABLE IF EXISTS apuestasperdedores;
	    CREATE TEMPORARY TABLE apuestasperdedores
	    SELECT a.id  FROM apuestas a
		JOIN partidos p ON a.idpartido = p.id 
		WHERE p.fechapartido = DATE_ADD(CURDATE(), INTERVAL -1 DAY)
		AND (p.puntosLocal < p.puntosVisita AND a.ganador = 1) OR
		(p.puntosLocal > p.puntosVisita AND a.ganador = 0);		
		 	
	    UPDATE apuestas a 
	    SET a.resultadoApuesta = 1, a.fechaProceso = CURDATE()
	    WHERE a.id IN (SELECT id FROM apuestasganadores);
	    
	    UPDATE apuestas a 
	    SET a.resultadoApuesta = 0, a.fechaProceso = CURDATE()
	    WHERE a.id IN (SELECT id FROM apuestasperdedores);	    
	    -- recupero apuestas de usuarios con in de partidos, este select puede ir en el where
		-- guardo en tabla temporal idpartido / idapuesta / ganadorapuesta / ganadorpartido (si local o visitante 0,1)
	        --  insert from (recorro tabla temporal if ganadorapuesta = ganadorpartido) en nuevo tabla de puntos +1 usuariopuntosjornada
		
		
	    
	END$$

DELIMITER ;

-- creo tabla ranking
CREATE TABLE `rankings`( `id` BIGINT NOT NULL, `idUsuario` BIGINT NOT NULL, `idJornada` BIGINT NOT NULL, `puntos` BIGINT NOT NULL DEFAULT 0, PRIMARY KEY (`id`) ); 

Alter table `rankings`   
  change `id` `id` bigint(20) NOT NULL Auto_increment;
 ALTER TABLE `rankings` CHANGE `puntos` `puntos` BIGINT(20) DEFAULT 0 NULL;


DELIMITER $$

ALTER DEFINER=`root`@`localhost` EVENT `ev_ranking` ON SCHEDULE EVERY 1 DAY STARTS '2018-06-06 04:00:00' ON COMPLETION NOT PRESERVE ENABLE DO BEGIN
	   -- SELECT id,puntosLocal,puntosVisita FROM partidos WHERE fechaPartido = DATE_ADD(CURDATE(), INTERVAL -1 DAY); -- recupero ids con fecha -1

	TRUNCATE TABLE rankings;
	INSERT INTO rankings (idUsuario, idJornada, puntos)
	SELECT a.idusuario, p.idjornada, SUM(resultadoApuesta)   FROM apuestas a JOIN partidos p ON a.idpartido = p.id  GROUP BY a.idusuario, p.idjornada;

	    
	END$$

DELIMITER ; 
