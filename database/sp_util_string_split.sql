use furnitureplanner;

DROP PROCEDURE IF EXISTS sp_util_string_split;

CREATE TEMPORARY TABLE TMPLIST 
(
ID 				INTEGER      NOT NULL AUTO_INCREMENT PRIMARY KEY,
CADENA          VARCHAR(510)
);

DELIMITER $$;

CREATE PROCEDURE sp_util_string_split
(
  vString VARCHAR(8000),
  vSeparator VARCHAR(5)
)
BEGIN
 
DECLARE vDone tinyint(1) DEFAULT 1;
DECLARE vIndex INT DEFAULT 1;
DECLARE vSubString VARCHAR(255);
 
WHILE vDone > 0 DO
  SET vSubString = SUBSTRING(vString, vIndex,
                    IF(LOCATE(vSeparator, vString, vIndex) > 0,
                      LOCATE(vSeparator, vString, vIndex) - vIndex,
                      LENGTH(vString)
                    ));
  IF LENGTH(vSubString) > 0 THEN
      SET vIndex = vIndex + LENGTH(vSubString) + 1;
      INSERT INTO TMPLIST(CADENA)VALUES (vSubString);
  ELSE
      SET vDone = 0;
  END IF;
END WHILE;
 
END;



DROP TABLE IF EXISTS TMPLIST;

