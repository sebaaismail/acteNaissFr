
package com.sebaainf.acteNaissFr.common;

import java.util.Date;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.value.ValueModel;

/**
 * Created by SEBAA Ismail
 * in 08/05/2017
 */

public final class ActeEditorModel extends PresentationModel<Acte>{

	private ValueModel id_acte;
	private ValueModel num_acte;
	
	private ValueModel wilaya;
	private ValueModel daira;
	private ValueModel commune;

	private ValueModel nom_cit;
	private ValueModel prenom_cit;
	
	private ValueModel date_naiss_cit;
	private ValueModel heure_naiss_cit;
	private ValueModel lieu_naiss_cit;
    
	// maybe delete this ???
    private Acte acte;
    
	private ValueModel is_f;
	private ValueModel fullname_pere;
	private ValueModel fullname_mere;
	
	private ValueModel adresse;
	
	private ValueModel date_dresse;
	private ValueModel heure_dresse;
	
	private ValueModel declarant; // longue texte 05 lignes
	private ValueModel date_copie;
	
	private ValueModel mar_le; // sur la marge 02 lignes de text
	private ValueModel fullname_conj;
	private ValueModel fait_le; 
  
   
    
    /**
     * @param Acte
     */
    public ActeEditorModel(Acte Acte) {


        super(Acte);
        //this.setTriggerChannel(new Trigger());
        this.acte = Acte;
        initComponents();
    }


    /**
     *
     */
    private void initComponents() {

    	id_acte = this.getBufferedModel(Acte.PROPERTY_ID_ACTE);
    	adresse = this.getBufferedModel(Acte.PROPERTY_ADRESSE);
    	commune = this.getBufferedModel(Acte.PROPERTY_COMMUNE);
    	daira = this.getBufferedModel(Acte.PROPERTY_DAIRA);
    	date_copie = this.getBufferedModel(Acte.PROPERTY_DATE_COPIE);
    	
    	//

    	date_dresse = this.getBufferedModel(Acte.PROPERTY_DATE_DRESSE);
    	date_naiss_cit = this.getBufferedModel(Acte.PROPERTY_DATE_NAISS_CIT);
    	declarant = this.getBufferedModel(Acte.PROPERTY_DECLARANT);
    	fait_le = this.getBufferedModel(Acte.PROPERTY_FAIT_LE);
    	fullname_conj = this.getBufferedModel(Acte.PROPERTY_FULLNAME_CONJ);
    	
    	fullname_mere = this.getBufferedModel(Acte.PROPERTY_FULLNAME_MERE);
    	fullname_pere = this.getBufferedModel(Acte.PROPERTY_FULLNAME_PERE);
    	heure_dresse = this.getBufferedModel(Acte.PROPERTY_HEURE_DRESSE);
    	heure_naiss_cit = this.getBufferedModel(Acte.PROPERTY_HEURE_NAISS_CIT);
    	is_f = this.getBufferedModel(Acte.PROPERTY_IS_f);

    	lieu_naiss_cit = this.getBufferedModel(Acte.PROPERTY_LIEU_NAISS_CIT);
    	mar_le = this.getBufferedModel(Acte.PROPERTY_MAR_LE);
    	nom_cit = this.getBufferedModel(Acte.PROPERTY_NOM_CIT);
    	num_acte = this.getBufferedModel(Acte.PROPERTY_NUM_ACTE);   	
    	prenom_cit = this.getBufferedModel(Acte.PROPERTY_PRENOM_CIT);
       	wilaya = this.getBufferedModel(Acte.PROPERTY_WILAYA);
   
    }


	public ValueModel getId_acte() {
		return id_acte;
	}


	public ValueModel getNum_acte() {
		return num_acte;
	}


	public ValueModel getWilaya() {
		return wilaya;
	}


	public ValueModel getDaira() {
		return daira;
	}


	public ValueModel getCommune() {
		return commune;
	}


	public ValueModel getNom_cit() {
		return nom_cit;
	}


	public ValueModel getPrenom_cit() {
		return prenom_cit;
	}


	public ValueModel getDate_naiss_cit() {
		return date_naiss_cit;
	}


	public ValueModel getHeure_naiss_cit() {
		return heure_naiss_cit;
	}


	public ValueModel getLieu_naiss_cit() {
		return lieu_naiss_cit;
	}


	public Acte getActe() {
		return acte;
	}


	public ValueModel getIs_f() {
		return is_f;
	}


	public ValueModel getFullname_pere() {
		return fullname_pere;
	}


	public ValueModel getFullname_mere() {
		return fullname_mere;
	}


	public ValueModel getAdresse() {
		return adresse;
	}


	public ValueModel getDate_dresse() {
		return date_dresse;
	}


	public ValueModel getHeure_dresse() {
		return heure_dresse;
	}


	public ValueModel getDeclarant() {
		return declarant;
	}


	public ValueModel getDate_copie() {
		return date_copie;
	}


	public ValueModel getMar_le() {
		return mar_le;
	}


	public ValueModel getFullname_conj() {
		return fullname_conj;
	}


	public ValueModel getFait_le() {
		return fait_le;
	}

    

}
