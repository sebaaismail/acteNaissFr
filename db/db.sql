create database db_acte_naiss_fr;
use db_acte_naiss_fr;

DROP TABLE IF EXISTS actes;
CREATE TABLE actes
(
	id_acte INT UNSIGNED PRIMARY KEY NOT NULL AUTO_INCREMENT,
	adresse VARCHAR(100) NULL,
	commune VARCHAR(60) NULL,
	wilaya VARCHAR(60) NULL,
	daira VARCHAR(60) NULL,
	date_copie DATE NULL,
	date_dresse DATE NULL,
	date_naiss_cit DATE NULL,
	declarant VARCHAR(80) NULL,
	fait_le VARCHAR(80) NULL,
	fullname_conj VARCHAR(80) NULL,
	fullname_mere VARCHAR(80) NULL,
	fullname_pere VARCHAR(80) NULL,
	heure_dresse VARCHAR(80) NULL,
	heure_naiss_cit VARCHAR(80) NULL,	
	is_f BOOLEAN DEFAULT FALSE,
	lieu_naiss_cit VARCHAR(60)NULL,
	mar_le VARCHAR(60) NULL,
	nom_cit VARCHAR(40) NOT NULL,
	prenom_cit VARCHAR(40) NOT NULL,
	num_acte LONG UNSIGNED,

	UNIQUE INDEX unique_index (nom_cit, prenom_cit, date_naiss_cit, lieu_naiss_cit)

);