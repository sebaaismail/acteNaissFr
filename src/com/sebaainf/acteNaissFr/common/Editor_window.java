package com.sebaainf.acteNaissFr.common;

import com.jgoodies.binding.beans.PropertyConnector;
import com.jgoodies.binding.value.Trigger;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.factories.Paddings;
import com.jgoodies.forms.layout.LayoutMap;
import com.jgoodies.validation.ValidationResultModel;
import com.jgoodies.validation.util.DefaultValidationResultModel;
import com.jgoodies.validation.view.ValidationResultViewFactory;

import com.sebaainf.ismUtils.IsmAbstractJFrame;
import com.sebaainf.ismUtils.IsmButtonBarBuilder;
import com.sebaainf.ismUtils.IsmButtonStackBuilder;
import com.sebaainf.ismUtils.IsmComponentFactory;
import com.sebaainf.ismUtils.IsmPrintStream;

import org.jdatepicker.impl.JDatePickerImpl;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EventObject;

/**
 * Created by ${sebaainf.com} on 18/05/2017.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 */
public class Editor_window extends IsmAbstractJFrame {

    private static Editor_window uniqueInstance;
    private boolean add_mode = false;


    private ValidationResultModel validationResultModel = new DefaultValidationResultModel();
    private JComponent messageLabel = ValidationResultViewFactory.createReportList(validationResultModel);

    private ActeEditorModel 	acteModel;


    public JLabel commune = new JLabel();
    private JLabel daira = new JLabel();
    private JLabel wilaya= new JLabel();
        

	private JTextField num_acte;

	private JTextField nom_cit;
	private JTextField prenom_cit;
	
	private JDatePickerImpl date_naiss_cit;
	private JTextField heure_naiss_cit;
	private JTextField lieu_naiss_cit;

    private javax.swing.JRadioButton is_f; //TODO
	private JTextField fullname_pere;
	private JTextField fullname_mere;
	
	private JTextField adresse;
	
	private JDatePickerImpl date_dresse;
	private JTextField heure_dresse;
	
	private JTextField declarant; // longue texte 05 lignes
	private JDatePickerImpl date_copie;
	
	private JDatePickerImpl mar_le; // sur la marge 02 lignes de text
	private JTextField fullname_conj;
	private JDatePickerImpl fait_le;
    
//*******************************

    protected JButton validerAddButton;
    protected JButton annulerButton;
    protected JButton imprimerButton;
    protected JButton annulerModifButton;

    //***************************************************************
    public Editor_window(ActeEditorModel acteModel) {
        this(acteModel, true);
    }

    public Editor_window(ActeEditorModel acteModel, boolean add_mode) {

        this.add_mode = add_mode;
        int idact = ((Acte)(acteModel.getBean())).getID_acte();

        // check if mode is add new object
      //TODO not verified pour sprint1
        //maybe set add_mod false for sprint1
        if ((idact <= 0)) {
            this.add_mode = true;
        }
        //TODO after search engine must handle the add_mode
        //this.add_mode = true; // for offline without db

        this.acteModel = acteModel;
        initComponents();
        configContent();
    }


    protected void initComponents() {

        // initializer les buttons

        validerAddButton = new JButton();
        annulerButton = new JButton("Annuler");
        imprimerButton = new JButton("Imprimer");
        annulerModifButton = new JButton("Annuler Modif");
        //labelType = new JLabel("بتاريخ :");
        
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setGroupingSeparator(' ');
        
        DecimalFormat format = new DecimalFormat();
        format.setDecimalFormatSymbols(dfs);

        if (this.add_mode) {
            validerAddButton.setText("Ajouter");
            annulerButton.setVisible(false);
            imprimerButton.setEnabled(false);
            annulerModifButton.setVisible(false);

        } else {
            validerAddButton.setText("Valider");
            //TODO handle this when add database
            imprimerButton.setEnabled(false);
            annulerModifButton.setVisible(false);
        }

        this.setTitle("Application ACTE DE NAIISANCE (en Francais)                        " +
                "                                                           " +
                "                                               Boufatis©2017");
        commune.setText(MyApp.commune);
        daira.setText(MyApp.daira);
        wilaya.setText(MyApp.wilaya);
        //commune.setEnabled(false);
        //daira.setEnabled(false);
        //wilaya.setEnabled(false);
        
        adresse = IsmComponentFactory.createTextField(acteModel.getAdresse());
        nom_cit = IsmComponentFactory.createTextField(acteModel.getNom_cit());
        prenom_cit = IsmComponentFactory.createTextField(acteModel.getPrenom_cit());
        num_acte = IsmComponentFactory.createIntegerField(acteModel.getNum_acte(), format);  
     // Binding jdatepicker with date_copie
        date_copie = IsmComponentFactory.createDatePickerImpl(acteModel,
                Acte.PROPERTY_DATE_COPIE, "dd/MM/yyyy");
        date_naiss_cit = IsmComponentFactory.createDatePickerImpl(acteModel,
                Acte.PROPERTY_DATE_NAISS_CIT, "dd/MM/yyyy");
        date_dresse = IsmComponentFactory.createDatePickerImpl(acteModel,
                Acte.PROPERTY_DATE_DRESSE, "dd/MM/yyyy");
        fait_le = IsmComponentFactory.createDatePickerImpl(acteModel,
                Acte.PROPERTY_FAIT_LE, "dd/MM/yyyy");
        mar_le = IsmComponentFactory.createDatePickerImpl(acteModel,
                Acte.PROPERTY_MAR_LE, "dd/MM/yyyy");

        declarant = IsmComponentFactory.createTextField(acteModel.getDeclarant());
        fullname_conj = IsmComponentFactory.createTextField(acteModel.getFullname_conj());
        fullname_mere = IsmComponentFactory.createTextField(acteModel.getFullname_mere());
        fullname_pere = IsmComponentFactory.createTextField(acteModel.getFullname_pere());
        
        heure_dresse = IsmComponentFactory.createTextField(acteModel.getHeure_dresse());
        heure_naiss_cit = IsmComponentFactory.createTextField(acteModel.getHeure_naiss_cit());
        
        lieu_naiss_cit = IsmComponentFactory.createTextField(acteModel.getLieu_naiss_cit());

        //TODO is_f
        
        ((JScrollBar) messageLabel.getComponent(1))
                .setAlignmentY(JScrollBar.RIGHT_ALIGNMENT);

    }

    protected JComponent buildContent() {

        nom_cit.setPreferredSize(date_naiss_cit.getPreferredSize());
        prenom_cit.setPreferredSize(date_naiss_cit.getPreferredSize());

        num_acte.setColumns(8);
        //num_acte.setHorizontalAlignment(JTextField.RIGHT);

        declarant.setColumns(20);
        
        num_acte.addPropertyChangeListener(new PropertyChangeListener(){

			@Override
			public void propertyChange(PropertyChangeEvent arg0) {

				if (num_acte.getText().length() <= 0) {
					num_acte.setText("0");		
				}
				
			}
        	
        });


        //setting border
        for(JComponent comp:getListComponents()) {
            if (!comp.getClass().getSimpleName().equals("JDatePickerImpl"))
            comp.setBorder(BorderFactory.createEtchedBorder());
        }

        LayoutMap.getRoot().columnPut("label_ar", "left:pref");
        LayoutMap.getRoot().columnPut("label_fr", "right:pref");

        //MyCommonUtils.setListComponentsEnabled(getListComponents(), true);

        JPanel mainPanel = new JPanel();

        mainPanel.setLayout(new BorderLayout());
        
        mainPanel.add(editorNorthPanel(), BorderLayout.NORTH);
        mainPanel.add(editorCenterPanel(), BorderLayout.CENTER);
        mainPanel.add(southButtonsPanel(), BorderLayout.SOUTH);

        //checkTypeAttestComponents();

        ActionListener listenerRadio = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //checkTypeAttestComponents();
            }
        };


        MyCommonUtils.setListComponentsEnabled(getListComponents(),true);

        return mainPanel;
    }

    private JComponent editorNorthPanel() {
        JPanel northPan = new JPanel();
        northPan.setLayout(new GridBagLayout());
        northPan.setBackground(Color.white);

        
    	BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(new File("files/northPanel.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        	
    	
    	JPanel pan =  FormBuilder.create()
        		.columns("pref")
        		.rows("p")
        		.add(picLabel).xy(1, 1)
        		.build();
    	northPan.add(pan);
        return northPan;
        		
    }
    
    private JComponent editorCenterPanel() {

        JScrollPane fullPanel = new JScrollPane(citEditorPanel());


        // thi code just for centring the JScrollPane in BorderLayout.Center
        // we will use GridBagLayout for the parent of the component inside it

        JViewport viewport = fullPanel.getViewport();
        ((JPanel)viewport.getView()).getParent().setLayout(new GridBagLayout());

        return fullPanel;

    }

    private JComponent citEditorPanel() {
    	int x = 1, y = 7;


        wilaya.setText("<html><font color='#77b300'>Wilaya : "
                + wilaya.getText() + "</font></html>");
        daira.setText("<html><font color='#77b300'>Daira : "
                + daira.getText() + "</font></html>");
        commune.setText("<html><font color='#77b300'>Commune : "
                + commune.getText() + "</font></html>");
        // Building citEditorPanel()


        return FormBuilder.create()
                //.debug(true)
                .columns("$label_fr, $lcgap, pref, $ugap ,$label_fr, $lcgap, pref, $ugap , $label_fr,"
                        + " $lcgap, pref, $lcgap, pref, $lcgap, pref, $lcgap, pref")
                .rows("p, $lgap, p, $lgap, p, $lgap, p, $lgap, p ,$lgap , p, $lgap,"       // for Citoyen Zone
                        + "p, $lgap, p, 6dlu, p, $lgap, p, $lgap, p, $lgap, p, $lgap, p, $pgap, p, $lgap, p")//for mention Zone
                //.columnGroups(new int[][]{{1, 5}})
                .padding(Paddings.DLU9)

                        //.add("Wilaya :").xy(1, 1)
                .add(wilaya).xy(3, 1)
                .add(daira).xy(3, 3)
                .add(commune).xy(3, 5)

                .add("Nom :").xy(1, y)
                .add(nom_cit).xy(3, y)
                .add(" Prenom :").xy(5, y)
                .add(prenom_cit).xy(7, y)

                .add("Date de naissance :").xy(1, y+2)
                .add(date_naiss_cit).xy(3, y+2)
                .add("Heure :").xy(5, y+2) //l'heure
                .add(heure_naiss_cit).xy(7, y+2)
                .add("Lieu de naissance :").xy(9, y+2)
                .add(lieu_naiss_cit).xy(11, y + 2)

                        //TODO sex is_f
                
                .add("fil de :").xy(1, y+4)
                .add(fullname_pere).xy(3, y+4)
                .add("et de :").xy(5, y+4)
                .add(fullname_mere).xy(7, y+4)

                .add("domicillés à :").xy(1, y+6)
                .add(adresse).xy(3, y+6)

                .add("Dressé le :").xy(1, y+8)
                .add(date_dresse).xy(3, y+8)
                .add("Heure :").xy(5, y + 8)
                .add(heure_dresse).xy(7, y+8)
                .add("sur declaration faite :").xy(9, y+8)
                .add(declarant).xy(11, y+8)

                .add("Num d'acte :").xy(1, y + 10)
                .add(num_acte).xy(3, y+10)

                .add("marié le :").xy(1, y+12)
                .add(mar_le).xy(3, y+12)
                .add("avec :").xy(5, y + 12)
                .add(fullname_conj).xy(7, y+12)

                .add("Fait le :").xy(1, y + 14)
                .add(fait_le).xy(3, y + 14)


                .build();

    }
/*
    private void checkTypeAttestComponents(){
    	if (nmar_dec2.isSelected()) {
    		labelType.setText("المتوفي بتاريخ :");
    	} else {
    		labelType.setText(" بتاريخ :");
    	}
        
    }
//*/
    private JComponent southButtonsPanel() {


        JPanel southPan = new JPanel();
        southPan.setBackground(Color.gray);

        imprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                ReportedBean bean = new ReportedBean(acteModel.getBean());
                //ReportedBean bean = new ReportedBean(MyApp.getObj()); //TODO delete this test line or comment it and uncomment the previous line

                ReportView.report(bean.getActe());
            }
        });

        final Trigger triggerAttest = (Trigger) acteModel.getTriggerChannel();

        validerAddButton.setEnabled(false);
        annulerModifButton.setEnabled(false);

        // now to enable buttonValider when citModel or mentModel change
        PropertyConnector.connect(acteModel, "buffering", validerAddButton, "enabled");
        //PropertyConnector.connect(attestModel, "buffering", imprimerButton, "disabled");

        //PropertyConnector.connect(date_naiss.getJFormattedTextField(), "value", buttonValider, "enabled");

        //PropertyConnector.connect(citModel, Citoyen.PROPERTY_DATE_NAISS, date_naiss, "formattedTextField");

        annulerModifButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                triggerAttest.triggerFlush();
           }
        });


        validerAddButton.addActionListener(new CommitActionListener
                (acteModel, this, add_mode));
        validerAddButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (num_acte.getText().length() <= 0) {
					num_acte.setText("0");		
				}
				
			}
        	
        });

        JPanel pan = IsmButtonBarBuilder.create(screenSize)
                //.addGlue()
                .addButton(validerAddButton)
                .addRelatedGap()
                .addButton(imprimerButton)
                .addUnrelatedGap()
                .addUnrelatedGap()
                .addUnrelatedGap()
                .addButton(annulerModifButton)
                //.padding(Paddings.DLU9)


                .build();

        southPan.add(pan);

        return southPan;

    }

    public JComponent showDialog(EventObject e) {

        return buildContent();

    }

    @Override
    public ArrayList<JComponent> getListComponents() {

        ArrayList<JComponent> list = new ArrayList<JComponent>();
        list.add(adresse);
        list.add(commune);
        list.add(daira);
        list.add(wilaya);
        list.add(date_copie);
        list.add(date_dresse);
        list.add(date_naiss_cit);
        //list.add(date_type_attest);
        list.add(declarant);
        list.add(fait_le);

        list.add(mar_le);
        list.add(fullname_conj);
        list.add(fullname_mere);
        list.add(fullname_pere);
        list.add(heure_dresse);
        list.add(heure_naiss_cit);
        
        
        list.add(lieu_naiss_cit);
        list.add(nom_cit);
        list.add(num_acte);
        list.add(prenom_cit);

        return list;

    }

}
