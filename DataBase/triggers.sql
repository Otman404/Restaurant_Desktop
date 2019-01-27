DELIMITER $$

CREATE TRIGGER suppr_table
BEFORE DELETE
ON Tables
FOR EACH ROW
BEGIN
delete from Reservation where Reservation.NumTable = OLD.NumTable;
END
$$

DELIMITER ;

------------------------------

CREATE TRIGGER suppr_serv
BEFORE DELETE
ON Serveur
FOR EACH ROW
BEGIN

IF OLD.nbrRes > 0 THEN 
	CALL cannot_delete_error; 
END IF

END
$$

DELIMITER ;

------------------------------

DELIMITER $$

CREATE TRIGGER suppr_cat
BEFORE DELETE
ON Categorie
FOR EACH ROW
BEGIN


delete from Plate where Plate.CodeCat = OLD.CodeCat;


END
$$

DELIMITER ;

------------------------------


DELIMITER $$

CREATE TRIGGER suppr_plat
BEFORE DELETE
ON Plate
FOR EACH ROW
BEGIN

delete from QteReservee where QteReservee.CodePlat = OLD.CodePlat;

END
$$

DELIMITER ;


--------------------------

