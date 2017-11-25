package com.sebaainf.acteNaissFr.common;

import com.jenkov.db.itf.PersistenceException;
import com.jgoodies.binding.value.Trigger;
import com.jgoodies.validation.ValidationResult;
import com.sebaainf.ismUtils.IsmAbstractJFrame;
import com.sebaainf.ismUtils.IsmPrintStream;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ${sebaainf.com} on 18/05/2017.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 *
 * cette class pour valider les entrees de user dans form EditorWindow
 * est appelé quand on click sur le bouton Valider
 * pour changer un acte et aussi pour ajouter un nouveau acte
 */
public class CommitActionListener implements ActionListener {


    private ActeEditorModel actModel;
 
    //private JToggleButton divorceRadioButton;
    private boolean add_mode;
    private Trigger actTrigger;
    Editor_window wind;

    //private JComponent[] listComp = new JComponent[0];

    /**
     * constructeur mené par le model acte
     * @param actModel
     * @param add_mode
     */
    public CommitActionListener(ActeEditorModel actModel,
    		Editor_window wind, boolean add_mode){

    	this.wind = wind;
        this.actModel = actModel;
        //TODO this.divorceRadioButton = divorceRadioButton;
        this.add_mode = add_mode;
        this.actTrigger = (Trigger) actModel.getTriggerChannel();
        //this.listComp = listComp;

    }

    /**
     * Invoked when an action occurs.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String textMode = "updated"; // default
        String message = "";
        boolean correct = true;
        
        //Integer nummar = actModel.getBean().getNum_mar();
        //if (nummar.equals(null)) attestModel.getBean().setNum_mar(0);

        actTrigger.triggerCommit();

        if (actModel.isChanged()) {

            IsmPrintStream.logging("attestModel.isChanged");
            ActeValidator acteValidator = new ActeValidator(actModel);
            ValidationResult resultAttest =
            		acteValidator.validate(actModel.getBean());
            if (resultAttest.hasErrors()) {
                correct = false;
                if (resultAttest.getMessages().size() > 2) {
                    message = "أدخل بيانات المواطن"  + "\n";
                } else {
                    message += resultAttest.getMessagesText();
                }

            } else {
            	wind.imprimerButton.setEnabled(true);

                if (add_mode) {
					/* TODO
				    textMode = "added";
				    MyDaosCitoyen.insertCitoyen((Citoyen) citModel.getBean());
				    int i = MyDaos.ism_lastGeneratedId("citoyen", "id_cit");
				            ((Mention) mentModel.getBean()).setId_cit(i);
				           //*/ 
                	//* Offline mode
                	Acte acte = actModel.getBean();
                	
                	//*/
				} else {
				    // we are in update mode
				    //TODO MyDaosCitoyen.updateCitoyen((Citoyen) citModel.getBean());
				}
				IsmPrintStream.logging("acte " + textMode + " !");
				

            }
        }




        if (!correct) {
            JOptionPane.showMessageDialog(null, message);
        }
        IsmPrintStream.logging(message);
    }
}
