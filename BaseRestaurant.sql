
CREATE TABLE Categorie(
id serial not null PRIMARY KEY,
nom varchar(50)
);
INSERT INTO Categorie(nom) VALUES('Entree');
INSERT INTO Categorie(nom) VALUES('Resistance');
INSERT INTO Categorie(nom) VALUES('Gouter');
INSERT INTO Categorie(nom) VALUES('Dessert');

CREATE TABLE Plat(
 id serial not null PRIMARY KEY,
 nom varchar(50) not null,
 prix int not null,
 idCategorie int references Categorie(id) on delete cascade,
 autre varchar(50)
);
INSERT INTO Plat(nom,prix,idCategorie) VALUES('henakisoa sy ravitoto',4000,2);
INSERT INTO Plat(nom,prix,idCategorie) VALUES('henakisoa ritra',5000,2);
INSERT INTO Plat(nom,prix,idCategorie) VALUES('Misao',2000,1);
INSERT INTO Plat(nom,prix,idCategorie) VALUES('Pizza',14000,3);
INSERT INTO Plat(nom,prix,idCategorie) VALUES('Soupe',5000,1);
INSERT INTO Plat(nom,prix,idCategorie) VALUES('Salade de Fruit',5000,4);



CREATE TABLE Ingredient(
id serial not null PRIMARY KEY,
nomIngredient varchar(50) not null,
prix int not null
);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Henakisoa',2000);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Ravitoto',1000);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Riz',800);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Farine',1000);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Carrote',500);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Oeuf',1000);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Fromage',500);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Mortadelle',1500);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('HaricotVert',1000);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Carry',1500);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Mangue',1000);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Banane',1000);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Ananas',1000);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Papaye',1000);

CREATE TABLE Composition(
	id serial not null PRIMARY KEY,
	nom varchar(50)
);
INSERT INTO Composition(nom) VALUES('Henakisoa');
INSERT INTO Composition(nom) VALUES('Pattes');
INSERT INTO Composition(nom) VALUES('PattesPizza');
INSERT INTO Composition(nom) VALUES('Riz');
INSERT INTO Composition(nom) VALUES('FangaronyMisao');
INSERT INTO Composition(nom) VALUES('Fangaronalasopy');
INSERT INTO Composition(nom) VALUES('Ravitoto');
INSERT INTO Composition(nom) VALUES('Fangaronapizza');
INSERT INTO Composition(nom) VALUES('Fruit');
CREATE TABLE Creation(
	id serial not null PRIMARY KEY,
	idComposition int references Composition(id) on delete cascade,
	idIngredient int references Ingredient(id) on delete cascade,
	fatrany int
);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(1,1,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(2,4,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(3,4,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(4,3,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(5,5,2);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(5,6,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(5,7,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(5,8,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(6,5,2);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(6,6,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(9,11,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(9,12,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(9,13,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(9,14,1);

CREATE TABLE Assemblage(
    id serial not null PRIMARY KEY,
    idPlat int references Plat(id) on delete cascade,
    idCreation int references Composition(id) on delete cascade,
    quantite int
);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(1,1,1);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(1,7,1);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(1,4,1);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(2,1,1);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(2,4,1);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(3,2,1);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(3,5,1);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(4,3,1);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(4,8,1);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(5,6,1);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(6,9,1);
CREATE TABLE PrixRevient(
	id serial not null PRIMARY KEY,
	idPlat int references Plat(id) on delete cascade,
	prixrevient int
);
CREATE TABLE Stock(
	id serial not null PRIMARY KEY,
	idIngredient references Ingredient(id) on delete cascade,
	quantite int
);
CREATE TABLE Serveur(
	id serial not null PRIMARY KEY,
	nomServeur varchar(50)
);
INSERT INTO Serveur (nomServeur) VALUES('Jean');
INSERT INTO Serveur (nomServeur) VALUES('Bozy');
INSERT INTO Serveur (nomServeur) VALUES('Baba');
INSERT INTO Serveur (nomServeur) VALUES('Zo');

CREATE TABLE Commande(
	id serial not null PRIMARY KEY,
	idServeur int references Serveur(id) on delete cascade,
	dateCommande Date,
	numerotable int,
	etat varchar(50),
	somme int,
	reste int
);
INSERT INTO Commande (idServeur,dateCommande,numerotable,etat) VALUES(1,'28-04-2022',1,'false');
INSERT INTO Commande (idServeur,dateCommande,numerotable,etat) VALUES(1,'05-04-2022',2,'false');

CREATE TABLE DetailCommande(
    id serial not null PRIMARY KEY,
	idPlat int references Plat(id) on delete cascade,
	quantite int,
    idCommande int references Commande(id) on delete cascade
);
INSERT INTO DetailCommande (idPlat,quantite,idCommande) VALUES(1,1,1);
INSERT INTO DetailCommande (idPlat,quantite,idCommande) VALUES(2,1,1);
INSERT INTO DetailCommande (idPlat,quantite,idCommande) VALUES(3,1,1);
INSERT INTO DetailCommande (idPlat,quantite,idCommande) VALUES(4,1,1);

INSERT INTO DetailCommande (idPlat,quantite,idCommande) VALUES(1,1,2);
INSERT INTO DetailCommande (idPlat,quantite,idCommande) VALUES(2,1,2);
CREATE TABLE Parametre(
	id serial not null PRIMARY KEY,
	label varchar(50),
	valeur double precision
);
CREATE TABLE Type(
	id serial not null PRIMARY KEY,
	nom varchar(50)
);
INSERT INTO Type(nom) VALUES('Espece');
INSERT INTO Type(nom) VALUES('Cheque');
CREATE TABLE Facture(
	id serial not null PRIMARY KEY,
	idType int references Type(id) on delete cascade,
	idCommande int references Commande(id) on delete cascade,
	montant int,
	dateFacture Date
);
INSERT INTO Facture(idType,idCommande,montant,dateFacture) VALUES(2,2,4000,'05-04-2022');
INSERT INTO Facture(idType,idCommande,montant,dateFacture) VALUES(1,1,5000,'28-04-2022');
INSERT INTO Facture(idType,idCommande,montant,dateFacture) VALUES(2,1,14000,'05-04-2022');
INSERT INTO Facture(idType,idCommande,montant,dateFacture) VALUES(1,1,16000,'28-04-2022');
INSERT INTO Facture(idType,idCommande,montant,dateFacture) VALUES(1,1,5000,'28-04-2022');

create view charge as select a.idPlat,a.idCreation,c.id,c.idIngredient,i.prix,a.quantite
 from Assemblage a JOIN Creation c ON a.idCreation=c.id JOIN Ingredient i ON c.idIngredient=i.id;

CREATE TABLE Categorie(
id serial not null PRIMARY KEY,
nom varchar(50)
);
INSERT INTO Categorie(nom) VALUES('Entree');
INSERT INTO Categorie(nom) VALUES('Resistance');
INSERT INTO Categorie(nom) VALUES('Gouter');
INSERT INTO Categorie(nom) VALUES('Dessert');

CREATE TABLE Plat(
 id serial not null PRIMARY KEY,
 nom varchar(50) not null,
 prix int not null,
 idCategorie int references Categorie(id) on delete cascade,
 autre varchar(50)
);
INSERT INTO Plat(nom,prix,idCategorie) VALUES('henakisoa sy ravitoto',4000,2);
INSERT INTO Plat(nom,prix,idCategorie) VALUES('henakisoa ritra',5000,2);
INSERT INTO Plat(nom,prix,idCategorie) VALUES('Misao',2000,1);
INSERT INTO Plat(nom,prix,idCategorie) VALUES('Pizza',14000,3);
INSERT INTO Plat(nom,prix,idCategorie) VALUES('Soupe',5000,1);
INSERT INTO Plat(nom,prix,idCategorie) VALUES('Salade de Fruit',5000,4);



CREATE TABLE Ingredient(
id serial not null PRIMARY KEY,
nomIngredient varchar(50) not null,
prix int not null
);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Henakisoa',2000);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Ravitoto',1000);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Riz',800);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Farine',1000);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Carrote',500);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Oeuf',1000);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Fromage',500);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Mortadelle',1500);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('HaricotVert',1000);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Carry',1500);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Mangue',1000);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Banane',1000);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Ananas',1000);
INSERT INTO Ingredient(nomIngredient,prix) VALUES('Papaye',1000);

CREATE TABLE Composition(
	id serial not null PRIMARY KEY,
	nom varchar(50)
);
INSERT INTO Composition(nom) VALUES('Henakisoa');
INSERT INTO Composition(nom) VALUES('Pattes');
INSERT INTO Composition(nom) VALUES('PattesPizza');
INSERT INTO Composition(nom) VALUES('Riz');
INSERT INTO Composition(nom) VALUES('FangaronyMisao');
INSERT INTO Composition(nom) VALUES('Fangaronalasopy');
INSERT INTO Composition(nom) VALUES('Ravitoto');
INSERT INTO Composition(nom) VALUES('Fangaronapizza');
INSERT INTO Composition(nom) VALUES('Fruit');
CREATE TABLE Creation(
	id serial not null PRIMARY KEY,
	idComposition int references Composition(id) on delete cascade,
	idIngredient int references Ingredient(id) on delete cascade,
	fatrany int
);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(1,1,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(2,4,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(3,4,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(4,3,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(5,5,2);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(5,6,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(5,7,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(5,8,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(6,5,2);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(6,6,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(9,11,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(9,12,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(9,13,1);
INSERT INTO Creation(idComposition,idIngredient,fatrany) VALUES(9,14,1);

CREATE TABLE Assemblage(
    id serial not null PRIMARY KEY,
    idPlat int references Plat(id) on delete cascade,
    idCreation int references Composition(id) on delete cascade,
    quantite int
);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(1,1,1);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(1,7,1);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(1,4,1);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(2,1,1);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(2,4,1);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(3,2,1);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(3,5,1);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(4,3,1);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(4,8,1);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(5,6,1);
INSERT INTO Assemblage (idPlat,idCreation,quantite) VALUES(6,9,1);
CREATE TABLE PrixRevient(
	id serial not null PRIMARY KEY,
	idPlat int references Plat(id) on delete cascade,
	prixrevient int
);
CREATE TABLE Stock(
	id serial not null PRIMARY KEY,
	idIngredient references Ingredient(id) on delete cascade,
	quantite int
);
CREATE TABLE Serveur(
	id serial not null PRIMARY KEY,
	nomServeur varchar(50)
);
INSERT INTO Serveur (nomServeur) VALUES('Jean');
INSERT INTO Serveur (nomServeur) VALUES('Bozy');
INSERT INTO Serveur (nomServeur) VALUES('Baba');
INSERT INTO Serveur (nomServeur) VALUES('Zo');

CREATE TABLE Commande(
	id serial not null PRIMARY KEY,
	idServeur int references Serveur(id) on delete cascade,
	dateCommande Date,
	numerotable int,
	etat varchar(50),
	somme int,
	reste int
);
INSERT INTO Commande (idServeur,dateCommande,numerotable,etat) VALUES(1,'28-04-2022',1,'false');
INSERT INTO Commande (idServeur,dateCommande,numerotable,etat) VALUES(1,'05-04-2022',2,'false');

CREATE TABLE DetailCommande(
    id serial not null PRIMARY KEY,
	idPlat int references Plat(id) on delete cascade,
	quantite int,
    idCommande int references Commande(id) on delete cascade
);
INSERT INTO DetailCommande (idPlat,quantite,idCommande) VALUES(1,1,1);
INSERT INTO DetailCommande (idPlat,quantite,idCommande) VALUES(2,1,1);
INSERT INTO DetailCommande (idPlat,quantite,idCommande) VALUES(3,1,1);
INSERT INTO DetailCommande (idPlat,quantite,idCommande) VALUES(4,1,1);

INSERT INTO DetailCommande (idPlat,quantite,idCommande) VALUES(1,1,2);
INSERT INTO DetailCommande (idPlat,quantite,idCommande) VALUES(2,1,2);
CREATE TABLE Parametre(
	id serial not null PRIMARY KEY,
	label varchar(50),
	valeur double precision
);
CREATE TABLE Type(
	id serial not null PRIMARY KEY,
	nom varchar(50)
);
INSERT INTO Type(nom) VALUES('Espece');
INSERT INTO Type(nom) VALUES('Cheque');
CREATE TABLE Facture(
	id serial not null PRIMARY KEY,
	idType int references Type(id) on delete cascade,
	idCommande int references Commande(id) on delete cascade,
	montant int,
	dateFacture Date
);
INSERT INTO Facture(idType,idCommande,montant,dateFacture) VALUES(2,2,4000,'05-04-2022');
INSERT INTO Facture(idType,idCommande,montant,dateFacture) VALUES(1,1,5000,'28-04-2022');
INSERT INTO Facture(idType,idCommande,montant,dateFacture) VALUES(2,1,14000,'05-04-2022');
INSERT INTO Facture(idType,idCommande,montant,dateFacture) VALUES(1,1,16000,'28-04-2022');
INSERT INTO Facture(idType,idCommande,montant,dateFacture) VALUES(1,1,5000,'28-04-2022');

create view charge as select a.idPlat,a.idCreation,c.id,c.idIngredient,i.prix,a.quantite
 from Assemblage a JOIN Creation c ON a.idCreation=c.id JOIN Ingredient i ON c.idIngredient=i.id;
