package com.sebaainf.acteNaissFr.common;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;

/**
 * Created by ${sebaainf.com} on 22/09/2017.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 */

@XmlRootElement
public class Commune {

    private String wil ="";
    private String da ="";
    private String com ="";

/*    public Commune (String wil, String da, String com) {
        this.setWil(wil);
        this.setDa(da);
        this.setCom(com);
    }*/
    public static void initilize(){
        //Commune commune = new Commune("ORAN", "OUED-TLELAT", "BOUFATIS");
        Commune commune = new Commune();
        commune.setWil("ORAN");
        commune.setDa("OUED-TLELAT");
        commune.setCom("BOUFATIS");
        File file = new File("files/commune.xml");
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Commune.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(commune, file);
            jaxbMarshaller.marshal(commune, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public static void changeCommune(){
        //Commune commune = new Commune("?????", "???? ??????", "???????");
        Commune commune = new Commune();
        commune.setWil("?????");
        commune.setDa("???? ??????");
        commune.setCom("??????? ???????");
        File file = new File("files/commune.xml");
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Commune.class);

            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(commune, file);
            jaxbMarshaller.marshal(commune, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }

    public static void readCommune(){
        File file = new File("files/commune.xml");
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Commune.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Commune commune = (Commune) jaxbUnmarshaller.unmarshal(file);
        System.out.println("La commune : " + commune.getCom());
            MyApp.wilaya = commune.getWil();
            MyApp.daira = commune.getDa();
            MyApp.commune = commune.getCom();

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public String getWil() {

        return wil;
    }
    @XmlElement
    public void setWil(String wil) {

        this.wil = wil;
    }

    public String getDa() {

        return da;
    }
    @XmlElement
    public void setDa(String da) {

        this.da = da;
    }

    public String getCom() {

        return com;
    }
    @XmlElement
    public void setCom(String com) {

        this.com = com;
    }
}
