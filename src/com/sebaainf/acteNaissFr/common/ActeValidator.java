package com.sebaainf.acteNaissFr.common;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.value.ValueModel;
import com.jgoodies.validation.ValidationResult;
import com.jgoodies.validation.Validator;

import com.sebaainf.ismUtils.IsmPrintStream;
import com.sebaainf.ismUtils.IsmValidator;

/**
 * Created by SEBAA Ismail on 18/05/2017.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 */
public class ActeValidator extends IsmValidator implements Validator<Object> {


    public ActeValidator(PresentationModel preModel) {

        this.preModel = preModel;

    }

    @Override
    public ValidationResult validate(Object attest) {

   	    IsmPrintStream.logging("validating attestation ...");
        addBlankError(Acte.PROPERTY_WILAYA, "wilaya sur fichier xml");
        addBlankError(Acte.PROPERTY_DAIRA, "daira sur fichier xml");
        addBlankError(Acte.PROPERTY_COMMUNE, "commune sur fichier xml");
        addBlankError(Acte.PROPERTY_NOM_CIT, "nom_cit");
        addBlankError(Acte.PROPERTY_PRENOM_CIT, "prenom_cit");
        
        addBlankError(Acte.PROPERTY_LIEU_NAISS_CIT, "lieu_naiss_cit");
        
        addBlankError(Acte.PROPERTY_DECLARANT, "declarant");
        addBlankError(Acte.PROPERTY_FAIT_LE, "fait_le");
        addBlankError(Acte.PROPERTY_FULLNAME_CONJ, "fullname_conj");
        addBlankError(Acte.PROPERTY_FULLNAME_MERE, "fullname_mere");
        addBlankError(Acte.PROPERTY_FULLNAME_PERE, "fullname_pere");
        addBlankError(Acte.PROPERTY_HEURE_DRESSE, "heure_adresse");        
        addBlankError(Acte.PROPERTY_HEURE_NAISS_CIT, "heure_naiss_cit");     
        
        addBlankError(Acte.PROPERTY_MAR_LE, "mar_le");
        addBlankError(Acte.PROPERTY_NUM_ACTE, "num_acte");

        return validationResult;
    }

    @Override
    public ValidationResult validateForSearch(Object o) {
        IsmPrintStream.logging("validating search acte object...");
        addBlankError(Acte.PROPERTY_NOM_CIT, "nom_cit");
        addBlankError(Acte.PROPERTY_PRENOM_CIT, "prenom_cit");


        return validationResult;
    }

}
