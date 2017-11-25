package com.sebaainf.acteNaissFr.common;

//import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.*;
import com.jgoodies.looks.plastic.theme.DesertBlue;
import com.sebaainf.ismThemes.BlackTheme;
import com.sebaainf.ismThemes.MyTheme;
import com.sebaainf.ismUtils.IsmAbstractJFrame;
import com.sebaainf.ismUtils.IsmPrintStream;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by admin on 24/01/2015.
 */
public class MyApp {

    public static int default_id_c = 3114; //todo maybe get from general variable or file config
    public static MyTheme theme = new BlackTheme();
    public static Color tableBackColor = Color.white;
    public static Color alternateRowColor = Color.lightGray;
    public static Date defaultDate;


    //public static Color tableBackgColor = Color.decode("#D7EAF5");

    //public static MyTheme theme = new GreyTheme(); // put in config
    public static void setUIFont(javax.swing.plaf.FontUIResource f) {

        java.util.Enumeration keys = UIManager.getDefaults().keys();

        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value != null && value instanceof javax.swing.plaf.FontUIResource)
                UIManager.put(key, f);
        }
    }

    public static void main(String[] args) {

        /**
         * set jgoodies Look And Feel
         */

        try {
            defaultDate =new SimpleDateFormat("yyyy/MM/dd").parse("1900/01/01");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        IsmPrintStream.prepareLogFile();
        IsmPrintStream.logging("Welcome to Acte en français app ");

        EventQueue.invokeLater(new Runnable() {
            public void run() {



                try {
                    UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                    UIManager.put("TextField.inactiveBackground", new ColorUIResource(Color.blue));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        setUIFont(new javax.swing.plaf.FontUIResource("Times New Roman", Font.PLAIN, 18));

        //*****************************************************



        Toolkit toolkit = Toolkit.getDefaultToolkit();
        IsmAbstractJFrame.screenSize = toolkit.getScreenSize();

        //TODO
        //JFrame frame = new SearchCit_window();
        /*
         JFrame frame = new SearchAttestEditor();
         frame.setVisible(true);
        //*/
        
        
        
        //AttestEditorModel attestModel = new AttestEditorModel(getObj());
        ActeEditorModel attestModel = new ActeEditorModel(new Acte());
        Editor_window view = new Editor_window(attestModel);
        view.setVisible(true);
    }
    public static Acte getObj(){
    	Acte obj = new Acte();
        obj.setWilaya("Oran");
        obj.setDaira("Oued Tlelat");
        obj.setCommune("Boufatis");
        

        
        obj.setNom_cit("BEN ZOUBIR");
        obj.setPrenom_cit("Jaddi");
        obj.setDate_naiss_cit(new Date());
        obj.setLieu_naiss_cit("Boufatis");
        obj.setAdresse("29 ,Ecole Boufatis");
        obj.setDate_copie(new Date());
        obj.setDate_dresse(new Date());
        obj.setFait_le(new Date());
        obj.setMar_le(new Date());
        obj.setDeclarant("hafid belhassane");
        obj.setFullname_conj("conjoint");
        obj.setFullname_pere("kadda");
        obj.setFullname_mere("manna massouda");
        obj.setHeure_dresse("14:00");
        obj.setHeure_naiss_cit("06:00");
        obj.setNum_acte(38);
        obj.setIs_f(false);



        return obj;
    }

}
