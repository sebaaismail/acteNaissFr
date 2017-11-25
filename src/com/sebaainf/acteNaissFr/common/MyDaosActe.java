package com.sebaainf.acteNaissFr.common;

import com.jenkov.db.itf.IDaos;
import com.jenkov.db.itf.PersistenceException;
import com.sebaainf.acteNaissFr.common.MyDaos;
import com.sebaainf.ismUtils.IsmPrintStream;
import com.sebaainf.acteNaissFr.common.Acte;

import java.util.*;

//import com.sebaainf.fichfamil.common.Deces;

/**
 * Created by admin on 18/05/2017.
 * Class to create new, update or delete Attests
 */
public class MyDaosActe {




    /**
     * @param id_acte
     * @return
     * @throws com.jenkov.db.itf.PersistenceException
     * @should return Attest with id_acte
     */
    public static Acte getActe(int id_acte) throws PersistenceException {

    	Acte acte = null;


        try {

            String sql = "select * from actes where id_acte=?";
            IDaos daos = MyDaos.persistenceManager.createDaos();
            acte = daos.getObjectDao().read(Acte.class, sql, id_acte);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            return acte;
        }
    }


    /**
     * @param nom_cit
     * @param prenom_cit
     * @return
     * @should return list Acte with nom prenom
     */
    public static TreeSet<Acte> getListActes(String nom_cit, String prenom_cit) {


        List<Acte> listObjs;
        TreeSet<Acte> setObjs = new TreeSet<Acte>();
        try {
            String sql = "select * from actes where nom_cit='" + nom_cit +
                    "' and prenom_cit='" + prenom_cit;
            IDaos daos = MyDaos.persistenceManager.createDaos();
            listObjs = daos.getObjectDao().readList(Acte.class, sql);
            if (listObjs != null) {
            	setObjs = new TreeSet<Acte>(listObjs);
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            return setObjs;
        }

    }

    /**
     * method to add new Acte
     *
     * @param acte
     * @return
     * @should insert Acte attest into Data base
     */
    public static Acte insertActe(Acte acte) throws PersistenceException{

            IDaos daos = MyDaos.persistenceManager.createDaos();
            int i = daos.getObjectDao().insert(acte);
        System.out.println(" id_new acte = " + i);
        return acte;
    }


    /**
     * method to update
     *
     * @param acte
     * @return
     * @should update Acte acte
     */
    public static Acte updateActe(Acte acte) throws PersistenceException {


            IDaos daos = MyDaos.persistenceManager.createDaos();
            daos.getObjectDao().update(acte);

        return acte;

    }

    /**
     * method to delete Acte acte
     *
     * @param acte
     * @return
     * @should delete Acte acte
     */
    public static boolean deleteActe(Acte acte) {

        boolean flag = false;

        try {
            IDaos daos = MyDaos.persistenceManager.createDaos();
            daos.getObjectDao().delete(acte);
            flag = true;
            IsmPrintStream.logging("Acte is deleted");

        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            IsmPrintStream.logging("flag :" + flag);
            return flag;
        }


    }

    /**
     * method to delete Acte acte
     *
     * @param id_acte
     * @return
     * @should delete Acte acte by id_acte
     */
    public static boolean deleteActe(int id_acte) {

        boolean flag = false;
        try {
            if (getActe(id_acte) != null) {

                IDaos daos = MyDaos.persistenceManager.createDaos();
                daos.getObjectDao().delete(Acte.class, id_acte);
                flag = true;
                IsmPrintStream.logging("Acte deleted");
            } else {
                IsmPrintStream.logging("Acte not found in data base !!");
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            IsmPrintStream.logging("flag :" + flag);
            return flag;
        }

    }

    public static Collection<Acte> getActes() throws PersistenceException {

        //createBeanCollection

        Vector vector = new Vector();
        Acte acte = null;

        try {

            String sql = "select * from actes where id_acte>0";
            IDaos daos = MyDaos.persistenceManager.createDaos();
            vector = (Vector) daos.getObjectDao().readList(Acte.class, sql);

        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            return vector;
        }
    }

}
