insert into Categorie values ('A', 'Tajine') ,
                             ('B', 'Brochette') ,
				             ('C', 'Cousous'),
					   	     ('D', 'Dessert'),
						     ('E', 'Entree')
						     ('F', 'Omelette');

insert into Plate values (1,'Tajine de Poulet accompagné d’olives et de citrons confits',275,'A'),
                         (2,'Tajine de Kefta (boulettes de bœuf, œuf)',275,'A'),
						 (3,'Tajine d’Agneau pruneaux et amandes',285,'A'),
						 (4,'Tajine d’Agneau tomates et oignons confits',285,'A'),
						 (5,'Tajine de poisson, dos de Cabillaud (poisson du jour) accompagné de tomates, poivrons et semoule verte',310,'A'),
						 (6,'Brochette d’agneau accompagnée de semoule verte',249.50,'B'),
						 (7,'Brochette de poulet accompagnée de semoule verte',329.50,'B'),
						 (8,'Couscous Mechoui(épaule d’agneau grillé)',790,'C'),
						 (9,'Couscous Agneau mijoté',280,'C'),
						 (10,'Couscous Merguez',270,'C'),
						 (11,'Couscous Boulettes',270,'C'),
						 (12,'Couscous Brochettes de poulet',290,'C'),
						 (13,'Couscous Brochettes d’agneau',300,'C'),
						 (14,'Couscous Royal, agneau, boulette, merguez',310,'C'),
						 (15,'Couscous Légumes ',220,'C'),
						 (16,'Couscous Végétarien (sans graisse d’agneau)',220,'C'),
						 (17,'Orange à la cannelle',85,'D'),
						 (18,'Pâtisseries marocaines maison(cornes de gazelle, cigare...)',110,'D'),
						 (19,'Pastilla au lait et aux amandes',240,'D'),
						 (20,'Fondant au chocolat et boule de glace vanille',110,'D'),
						 (21,'Coupe Colonel (sorbet citron vert, vodka)',110,'D'),
						 (22,'Coupe de glace vanille',90,'D'),
						 (23,'Salade Mechouia(poivrons grillés à l’huile d’olive)',100,'E'),
						 (24,'Salade Zaalouk(salade d’aubergines grillées)',100,'E'),
						 (25,'Salade de lentilles',100,'E'),
						 (26,'Briouat de poulet(feuilleté marocain)',115,'E'),
						 (27,'Assortiment d’entrées : salades, briouats, pastillas...',280,'E'),
						 (2	,'Pastilla',450,'E');

insert into Tables values (1,5),(2,10),(3,8),(4,15),(5,10),(6,8),(7,15),(8,5),(9,10),(10,15),(11,10),(12,15),(13,10),(14,8),(15,15),
                          (16,5),(17,10),(18,8),(19,15),(20,10),(21,8),(22,15),(23,5),(24,10),(25,15),(26,10),(27,15),(28,10),(29,8),(30,15),
						  (31,5),(32,10),(33,8),(34,15),(35,10),(36,8),(37,15),(38,8),(39,15),(40,10),(41,8),(42,10),(43,15),(44,8),(45,15);

insert into Serveur values (1,'El Othmani','Mouhamed','Restaurant1','Maroc','+',0),
                           (2,'BenAissa','Said','Restaurant2','Maroc','+',0),
						   (3,'Zerouq','Nihal','Restaurant3','Maroc','+',0),
						   (4,'Ait Bourah','Ibrahim','Restaurant4','Maroc','+',0),
						   (5,'El Bendir','Amine','Restaurant5','Maroc','+',0),
						   (6,'Soulami','Mouhamed','Restaurant6','Maroc','+',0),
						   (7,'BenAddi','Ilham','Restaurant7','Maroc','+',0),
						   (8,'Ait El Arrif','Souhaila','Restaurant8','Maroc','+',0),
						   (9,'Doulmi','Ahmed','Restaurant9','Maroc','+',0),
						   (10,'Farahat','Firdaous','Restaurant10','Maroc','+',0);
Select * From Serveur

insert into login values('1','1'),('admin','admin')