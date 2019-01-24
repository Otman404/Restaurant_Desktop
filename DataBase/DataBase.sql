CREATE TABLE `Restaurant`.`Serveur` ( `IDSer` INT NOT NULL , `NomSer` VARCHAR(20) NOT NULL , `PreNomSer` VARCHAR(20) NOT NULL , `login` VARCHAR(20) NOT NULL , `password` VARCHAR(20) NOT NULL , `actif` VARCHAR(1) NOT NULL , `nbrRes` INT NOT NULL , PRIMARY KEY (`IDSer`)) ENGINE = InnoDB;
ALTER TABLE Serveur
ADD CHECK (actif = '+' or actif = '-');



CREATE TABLE `Restaurant`.`Tables` ( `NumTable` INT NOT NULL , `NbrPlaceTable` INT NOT NULL , PRIMARY KEY (`NumTable`)) ENGINE = InnoDB;


CREATE TABLE `Restaurant`.`Reservation` ( `CodeRes` INT NOT NULL AUTO_INCREMENT , `DateRes` DATETIME NOT NULL , `NumTable` INT NOT NULL , `IDSer` INT NOT NULL , PRIMARY KEY (`CodeRes`),FOREIGN KEY (IDSer) REFERENCES Serveur(IDSer)) ENGINE = InnoDB;
ALTER TABLE Reservation
ADD FOREIGN KEY (NumTable) REFERENCES Tables(NumTable);


CREATE TABLE `Restaurant`.`Categorie` ( `CodeCat` VARCHAR(2) NOT NULL , `LibelleCat` VARCHAR(20) NOT NULL , PRIMARY KEY (`CodeCat`)) ENGINE = InnoDB;


CREATE TABLE `Restaurant`.`Plate` ( `CodePlat` INT NOT NULL , `NomPlate` VARCHAR(20) NOT NULL , `PrixPlate` DECIMAL NOT NULL , `CodeCat` VARCHAR(2) NOT NULL , PRIMARY KEY (`CodePlat`),FOREIGN KEY (CodeCat) REFERENCES Categorie(CodeCat)) ENGINE = InnoDB;


CREATE TABLE `Restaurant`.`QteReservee` ( `CodeRes` INT NOT NULL , `CodePlat` INT NOT NULL , `Qte` INT NOT NULL, FOREIGN KEY (CodeRes) REFERENCES Reservation(CodeRes), FOREIGN KEY (CodePlat) references Plate(CodePlat) ) ENGINE = InnoDB;


CREATE TABLE `Restaurant`.`login` ( `username` VARCHAR(20) NOT NULL , `password` VARCHAR(20) NOT NULL , PRIMARY KEY (`username`)) ENGINE = InnoDB;
