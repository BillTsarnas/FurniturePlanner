use furnitureplanner;

DROP PROCEDURE IF EXISTS sp_get_clients_by_name;

DELIMITER $$;

CREATE PROCEDURE sp_get_clients_by_name(IN cadena VARCHAR(255))
BEGIN
 
DECLARE id                  INT;
DECLARE abuscar              VARCHAR(510);

CREATE TEMPORARY TABLE TMPLIST 
(
ID 				INTEGER      NOT NULL AUTO_INCREMENT PRIMARY KEY,
CADENA          VARCHAR(510)
);

CREATE TEMPORARY TABLE TEMP_CLIENTS 
(
 id                  INTEGER      NOT NULL AUTO_INCREMENT PRIMARY KEY,
 clientId            INTEGER,
 nombre				 varchar(510)
);

CREATE TEMPORARY TABLE TEMP_CLIENTS_IDS 
(
 clientId            INTEGER
);

INSERT INTO TEMP_CLIENTS (clientId,nombre)
SELECT  clientId,
        CONCAT(name," ",surname)
FROM    CLIENTS;



call sp_util_string_split(cadena, " ");

SELECT MIN(tl.id) INTO id FROM TMPLIST tl;
 
WHILE id is not null  DO

	select UPPER(tl.cadena) into abuscar from TMPLIST tl where tl.id = id;
	
    -- select abuscar;
	 
    INSERT INTO  TEMP_CLIENTS_IDS
    select c.clientId from CLIENTS c where upper(CONCAT(c.name," ",c.surname)) like CONCAT('%', abuscar, '%');
 
SELECT MIN(tl.id) into id from TMPLIST tl where tl.id > id;

END WHILE;

select 	c.clientId,
		c.name,
        c.surname,
        c.mphone,
        c.hphone,
        c.email,
        c.address
from CLIENTS c, (select distinct clientId clientId from TEMP_CLIENTS_IDS) tci
where c.clientId = tci.clientId;


drop table if exists TMPLIST;
drop table if exists TEMP_CLIENTS; 
drop table if exists TEMP_CLIENTS_IDS; 
 
END;