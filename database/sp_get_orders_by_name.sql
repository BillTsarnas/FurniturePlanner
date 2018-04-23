use furnitureplanner;

DROP PROCEDURE IF EXISTS sp_get_orders_by_name;

DELIMITER $$;

CREATE PROCEDURE sp_get_orders_by_name(IN cadena VARCHAR(255))
BEGIN
 
DECLARE id                  INT;
DECLARE abuscar              VARCHAR(510);

CREATE TEMPORARY TABLE TMPLIST 
(
ID 				INTEGER      NOT NULL AUTO_INCREMENT PRIMARY KEY,
CADENA          VARCHAR(510)
);

CREATE TEMPORARY TABLE TEMP_ORDERS_IDS 
(
 orderId            INTEGER
);

call sp_util_string_split(cadena, " ");

SELECT MIN(tl.id) INTO id FROM TMPLIST tl;
 
WHILE id is not null  DO

	select UPPER(tl.cadena) into abuscar from TMPLIST tl where tl.id = id;
	 
    INSERT INTO  TEMP_ORDERS_IDS
    select o.orderId from ORDERS o where upper(o.name) like CONCAT('%', abuscar, '%');
 
SELECT MIN(tl.id) into id from TMPLIST tl where tl.id > id;

END WHILE;

select 	o.orderid,
		o.clientid,
        o.name,
        o.totalcost,
        o.status
from ORDERS o, (select distinct orderId orderId from TEMP_ORDERS_IDS) toi
where o.orderId = toi.orderId;


drop table if exists TMPLIST;
drop table if exists TEMP_CLIENTS_IDS; 
 
END;
