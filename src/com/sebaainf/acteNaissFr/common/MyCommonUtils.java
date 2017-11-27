package com.sebaainf.acteNaissFr.common;

import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ArrayList;

/**
 * Class contain common functions
 * Created by admin on 04/02/2015.
 */
public class MyCommonUtils {


    public ActionListener actionDeces = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
        
    };

    public static void setListComponentsEnabled(ArrayList<JComponent> listComponents, boolean b) {

        for (JComponent comp : listComponents) {

            if (comp.getClass().getSimpleName().equals("JTextField"))
                ((JTextField) comp).setEditable(b);
            else if (comp.getClass().getSimpleName().equals("JCheckBox"))
                ((JCheckBox) comp).setEnabled(b);
            else if (comp.getClass().getSimpleName().equals("JComboBox"))
                ((JComboBox) comp).setEnabled(b);
            else if (comp.getClass().getSimpleName().equals("JRadioButton"))
                ((JRadioButton) comp).setEnabled(b);
            else if (comp.getClass().getSimpleName().equals("JDatePickerImpl")) {
                ((JDatePickerImpl) comp).setTextEditable(b);
                // set the button disabled
                ((JDatePickerImpl) comp).getComponent(1).setEnabled(b);
            }

        }

    }

    public static SimpleDateFormat getMyFrDateFormat() {
        DateFormatSymbols dfs = new DateFormatSymbols(new Locale("fr"));
        dfs.setMonths(new String[]{
                "janvier",
                "fevrier",
                "mars",
                "Avril",
                "mai",
                "juin",
                "juillet",
                "août",
                "septembre",
                "octobre",
                "novebre",
                "décembre",

        });
        return new SimpleDateFormat("dd MMMM yyyy", dfs);
    }
    public static SimpleDateFormat getMyFrDateFormat2() {
        DateFormatSymbols dfs = new DateFormatSymbols(new Locale("fr"));
        dfs.setMonths(new String[]{
                "janvier",
                "fevrier",
                "mars",
                "Avril",
                "mai",
                "juin",
                "juillet",
                "août",
                "septembre",
                "octobre",
                "novebre",
                "décembre",

        });
        String[] jours = new String[31];
        jours[0]= "premier";
        jours[1]= "deux";
        jours[2]= "trois";
        jours[3]= "quatre";
        jours[4]= "cinq";
        jours[5]= "six";
        jours[6]= "sept";
        jours[7]= "huit";
        jours[8]= "neuf";
        jours[9]= "dix";
        jours[10]= "onze";
        jours[11]= "douze";
        jours[12]= "treize";
        jours[13]= "quatorze";
        jours[14]= "quinze";
        jours[15]= "seize";
        jours[16]= "dix-sept";
        jours[17]= "dix-huit";
        jours[18]= "dix-neuf";
        jours[19]= "vingt";
        jours[20]= "vingt et un";
        jours[29]= "trente";
        jours[30]= "trente et un";
        for(int i=21; i<29; i++) {
            jours[i] = "vingt " + "et " + jours[i-20];
        }
        //TODO finish the algo
        return new SimpleDateFormat("dd MMMM yyyy", dfs);
    }

    public static SimpleDateFormat getMyArDateFormat() {
        DateFormatSymbols dfs = new DateFormatSymbols(new Locale("ar"));
        dfs.setMonths(new String[]{
                "جانفي",
                "فيفري",
                "مارس",
                "أفريل",
                "ماي",
                "جوان",
                "جويلية",
                "أوت",
                "سبتمبر",
                "أكتوبر",
                "نوفمبر",
                "ديسمبر",

        });
        return new SimpleDateFormat("dd MMMM yyyy", dfs);
    }


}