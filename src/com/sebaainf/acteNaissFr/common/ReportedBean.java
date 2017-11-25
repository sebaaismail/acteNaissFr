package com.sebaainf.acteNaissFr.common;

import com.jenkov.db.itf.PersistenceException;
import com.sebaainf.ismUtils.IsmPrintStream;

import java.util.Collection;
import java.util.Vector;

/**
 * Created by ${sebaainf.com} on 01/11/2015.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 */
public class ReportedBean {

    private Acte acte;

	private String barre1 = "/  /  /";
    private String barre2 = "/  /  /";
    
    
    //later TODO *encapsulate temoins data in Temoin[] Object
    //private Temoin ment;

    //private String marge = "زواج";



	//later TODO *
    //public ReportedBean(Citoyen cit, Mention ment) {
    public ReportedBean(Acte acte) {
        this.acte = acte;
        //this.temoins = temoins;
        //"ndiv_mar1" non div depuis mar
		//"nmar_dec2" non mar depuis dec
		//"nmar_div3" non mar depuis div

    }




    public Acte getActe() {
		return acte;
	}




	public void setActe(Acte acte) {
		this.acte = acte;
	}




	public String getBarre1() {
		return barre1;
	}

	public String getBarre2() {
		return barre2;
	}

	public void setBarre1(String barre1) {

		this.barre1 = barre1;
		
	}

	public void setBarre2(String barre2) {
		this.barre2 = barre2;
			}

    
/* TODO
    public Temoin[] getTemoins() {

        return temoins;
    }

    public void setMent(Mention ment) {

        this.ment = ment;
    }

    public String getMarge() {

        return marge;
    }

    public void setMarge(String marge) {

        this.marge = marge;
    }
//*/



}
