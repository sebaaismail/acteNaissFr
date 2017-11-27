package com.sebaainf.acteNaissFr.common;
import java.text.SimpleDateFormat;
import java.util.Collection;

import java.util.Date;
import java.util.Vector;

import com.jenkov.db.itf.mapping.AGetterMapping;
import com.jgoodies.common.bean.Bean;
import com.sebaainf.ismUtils.IsmPrintStream;
import com.sebaainf.acteNaissFr.common.MyApp;

/**
* Created by ISMAIL on 26/04/2017.
* for butterfly mapping
* 1- we have follow the naming conditions of class and properties
* just match the table and their columns in data base
* 2- we have initialise all properties in class with defaults values
* 3- put GETTER anotations just before their getter methods
*/

public class Acte extends Bean{
	
	public static final String PROPERTY_ID_ACTE = "id_acte";
	public static final String PROPERTY_NUM_ACTE = "num_acte";
	
	public static final String PROPERTY_WILAYA = "wilaya";
	public static final String PROPERTY_DAIRA = "daira";
	public static final String PROPERTY_COMMUNE = "commune";
	
	public static final String PROPERTY_NOM_CIT = "nom_cit";
	public static final String PROPERTY_PRENOM_CIT = "prenom_cit";
	
	public static final String PROPERTY_DATE_NAISS_CIT = "date_naiss_cit";
	public static final String PROPERTY_HEURE_NAISS_CIT = "heure_naiss_cit";
	public static final String PROPERTY_LIEU_NAISS_CIT = "lieu_naiss_cit";

	public static final String PROPERTY_IS_f = "is_f";
	public static final String PROPERTY_FULLNAME_PERE = "fullname_pere";
	public static final String PROPERTY_FULLNAME_MERE = "fullname_mere";
	
	public static final String PROPERTY_ADRESSE = "adresse";
	
	public static final String PROPERTY_DATE_DRESSE = "date_dresse";
	public static final String PROPERTY_HEURE_DRESSE = "heure_dresse";
	
	public static final String PROPERTY_DECLARANT = "declarant"; // longue texte 05 lignes
	public static final String PROPERTY_DATE_COPIE = "date_copie";
	
	public static final String PROPERTY_MAR_LE = "mar_le"; // sur la marge 02 lignes de text
	public static final String PROPERTY_FULLNAME_CONJ = "fullname_conj";
	public static final String PROPERTY_FAIT_LE = "fait_le";
	
	private int id_acte;
	private int num_acte;
	
	private String wilaya ="Oran";
	private String daira ="Oued Tlelat";
	private String commune ="Boufatis";

	private String nom_cit = "";
	private String prenom_cit = "";
	
	private java.util.Date date_naiss_cit = MyApp.defaultDate;
	private String heure_naiss_cit = "";
	private String lieu_naiss_cit = "";

	private boolean is_f = false;
	private String fullname_pere = "";
	private String fullname_mere = "";
	
	private String adresse = "";
	
	private java.util.Date date_dresse = MyApp.defaultDate;
	private String heure_dresse = "";
	
	private String declarant = ""; // longue texte 05 lignes
	private java.util.Date date_copie = new Date();

	private java.util.Date mar_le = MyApp.defaultDate; // sur la marge 02 lignes de text
	private String fullname_conj = "";
	private java.util.Date fait_le = MyApp.defaultDate;



	private SimpleDateFormat simpleDateFormat;

	//******************************************************
	@AGetterMapping(databaseGenerated = true)
	
	public int getID_acte() {
		return id_acte;
	}
	public int getNum_acte() {
		return num_acte;
	}
	public String getWilaya() {
		return wilaya;
	}
	public String getDaira() {
		return daira;
	}
	public String getCommune() {
		return commune;
	}
	public String getNom_cit() {
		return nom_cit;
	}
	public String getPrenom_cit() {
		return prenom_cit;
	}
	public java.util.Date getDate_naiss_cit() {
		return date_naiss_cit;
	}
	public String getHeure_naiss_cit() {
		return heure_naiss_cit;
	}
	public String getLieu_naiss_cit() {
		return lieu_naiss_cit;
	}
	public boolean isIs_f() {
		return is_f;
	}
	public String getFullname_pere() {
		return fullname_pere;
	}
	public String getFullname_mere() {
		return fullname_mere;
	}
	public String getAdresse() {
		return adresse;
	}
	public java.util.Date getDate_dresse() {
		return date_dresse;
	}
	public String getHeure_dresse() {
		return heure_dresse;
	}
	public String getDeclarant() {
		return declarant;
	}
	public java.util.Date getDate_copie() {
		return date_copie;
	}
	public java.util.Date getMar_le() {
		return mar_le;
	}
	public String getFullname_conj() {
		return fullname_conj;
	}
	public java.util.Date getFait_le() {
		return fait_le;
	}
	public SimpleDateFormat getSimpleDateFormat() {
		return simpleDateFormat;
	}

	public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {
		this.simpleDateFormat = simpleDateFormat;
	}

	public void setId_acte(int newValue) {
	
		int oldValue = this.id_acte;
		this.id_acte = newValue;
		if (oldValue != newValue) {
			firePropertyChange(Acte.PROPERTY_ID_ACTE, oldValue, newValue);
		}
	}
	public void setNum_acte(int newValue) {
		
		int oldValue = this.num_acte;
		this.num_acte = newValue;
		if (oldValue != newValue) {
			firePropertyChange(Acte.PROPERTY_NUM_ACTE, oldValue, newValue);
		}
	}
	public void setWilaya(String newValue) {
	
		String oldValue = this.wilaya;
		this.wilaya = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Acte.PROPERTY_WILAYA, oldValue, newValue);
		}
	}
	public void setDaira(String newValue) {
	
		String oldValue = this.daira;
		this.daira = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Acte.PROPERTY_DAIRA, oldValue, newValue);
		}
	}
	public void setCommune(String newValue) {
	
		String oldValue = this.commune;
		this.commune = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Acte.PROPERTY_COMMUNE, oldValue, newValue);
		}
	}
	public void setNom_cit(String newValue) {
	
		String oldValue = this.nom_cit;
		this.nom_cit = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Acte.PROPERTY_NOM_CIT, oldValue, newValue);
		}
	}
	public void setPrenom_cit(String newValue) {
	
		String oldValue = this.prenom_cit;
		this.prenom_cit = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Acte.PROPERTY_PRENOM_CIT, oldValue, newValue);
		}
	}
	public void setDate_naiss_cit(java.util.Date newValue) {
	
		Date oldValue = this.date_naiss_cit;
		this.date_naiss_cit = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Acte.PROPERTY_DATE_NAISS_CIT, oldValue, newValue);
		}
	}
	public void setHeure_naiss_cit(String newValue) {
	
		String oldValue = this.heure_naiss_cit;
		this.heure_naiss_cit = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Acte.PROPERTY_HEURE_NAISS_CIT, oldValue, newValue);
		}
	}
	public void setLieu_naiss_cit(String newValue) {
	
		String oldValue = this.lieu_naiss_cit;
		this.lieu_naiss_cit = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Acte.PROPERTY_LIEU_NAISS_CIT, oldValue, newValue);
		}
	}
	public void setIs_f(boolean newValue) {
	
		boolean oldValue = this.is_f;
		this.is_f = newValue;
		if (oldValue != newValue) {
			firePropertyChange(Acte.PROPERTY_IS_f, oldValue, newValue);
		}
	}
	public void setFullname_pere(String newValue) {
	
		String oldValue = this.fullname_pere;
		this.fullname_pere = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Acte.PROPERTY_FULLNAME_PERE, oldValue, newValue);
		}
	}
	public void setFullname_mere(String newValue) {
	
		String oldValue = this.fullname_mere;
		this.fullname_mere = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Acte.PROPERTY_FULLNAME_MERE, oldValue, newValue);
		}
	}
	public void setAdresse(String newValue) {
	
		String oldValue = this.adresse;
		this.adresse = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Acte.PROPERTY_ADRESSE, oldValue, newValue);
		}
	}
	public void setDate_dresse(java.util.Date newValue) {
	
		Date oldValue = this.date_dresse;
		this.date_dresse = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Acte.PROPERTY_DATE_DRESSE, oldValue, newValue);
		}
	}
	public void setHeure_dresse(String newValue) {
	
		String oldValue = this.heure_dresse;
		this.heure_dresse = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Acte.PROPERTY_HEURE_DRESSE, oldValue, newValue);
		}
	}
	public void setDeclarant(String newValue) {
	
		String oldValue = this.declarant;
		this.declarant = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Acte.PROPERTY_DECLARANT, oldValue, newValue);
		}
	}
	public void setDate_copie(java.util.Date newValue) {
	
		Date oldValue = this.date_copie;
		this.date_copie = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Acte.PROPERTY_DATE_COPIE, oldValue, newValue);
		}
	}
	public void setMar_le(java.util.Date newValue) {

		Date oldValue = this.mar_le;
		this.mar_le = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Acte.PROPERTY_MAR_LE, oldValue, newValue);
		}
	}
	public void setFullname_conj(String newValue) {
	
		String oldValue = this.fullname_conj;
		this.fullname_conj = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Acte.PROPERTY_FULLNAME_CONJ, oldValue, newValue);
		}
	}
	public void setFait_le(java.util.Date newValue) {

		Date oldValue = this.fait_le;
		this.fait_le = newValue;
		if (!oldValue.equals(newValue)) {
			firePropertyChange(Acte.PROPERTY_FAIT_LE, oldValue, newValue);
		}
	}	
}