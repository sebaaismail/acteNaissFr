package com.sebaainf.ismUtils;

import org.jdatepicker.impl.JDatePickerImpl;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.image.BufferedImage;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.ArrayList;

import static com.sun.javafx.iio.common.ImageTools.readFully;

/**
 * Class contain common functions
 * Created by admin on 04/02/2015.
 */
public class IsmCommonUtils {


    public ActionListener actionDeces = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
        
    };

    public static void encryptDES(String pathInputFile,String pathOutputFile, String key){
        FileInputStream  file = null;
        try {
            file = new FileInputStream(pathInputFile);

        FileOutputStream output = new FileOutputStream(pathOutputFile);
        byte j[]=key.getBytes();
        SecretKeySpec kye = new SecretKeySpec(j,"DES");
        System.out.println(kye);
        Cipher enc = Cipher.getInstance("DES");
        enc.init(Cipher.ENCRYPT_MODE,kye);
        CipherOutputStream cos = new CipherOutputStream(output, enc);
        byte[] buf = new byte[1024];
        int read;
        while((read=file.read(buf))!=-1){
            cos.write(buf,0,read);
        }
        file.close();
        output.flush();
        cos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage decryptDES_picture(String pathInputFile,String key){
        FileInputStream  file = null;
        BufferedImage image = null;
        try {
            file = new FileInputStream(pathInputFile);
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte j[]=key.getBytes();
            SecretKeySpec kye = new SecretKeySpec(j,"DES");
            System.out.println(kye);
            Cipher enc = Cipher.getInstance("DES");
            enc.init(Cipher.DECRYPT_MODE,kye);
            CipherOutputStream cos = new CipherOutputStream(output, enc);
            byte[] buf = new byte[1024];
            int read;
            while((read=file.read(buf))!=-1){
                cos.write(buf,0,read);
            }
            file.close();
            output.flush();
            cos.close();

            byte[] data = output.toByteArray();
            ByteArrayInputStream input = new ByteArrayInputStream(data);
            image = ImageIO.read(input);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public static FileOutputStream decryptDES(String pathInputFile,String key){
        FileInputStream  file = null;
        FileOutputStream output = null;
        try {
            file = new FileInputStream(pathInputFile);
            output = new FileOutputStream("");

        byte j[]=key.getBytes();
        SecretKeySpec kye = new SecretKeySpec(j,"DES");
        System.out.println(kye);
        Cipher enc = Cipher.getInstance("DES");
        enc.init(Cipher.DECRYPT_MODE,kye);
        CipherOutputStream cos = new CipherOutputStream(output, enc);
        byte[] buf = new byte[1024];
        int read;
        while((read=file.read(buf))!=-1){
            cos.write(buf,0,read);
        }
        file.close();
        output.flush();
        cos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return output;
    }

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