package com.sebaainf.acteNaissFr.common;

import com.jenkov.db.PersistenceManager;
import com.jenkov.db.itf.IDaos;
import com.jenkov.db.itf.PersistenceException;
import com.jenkov.db.jdbc.SimpleDataSource;


import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Created by admin on 10/01/2015.
 */
public class MyDaos {

    /**
     * ses infos sont ici pour developelent
     * dans la phase de production (apres depoloyment de laplication)
     * ses infos serons dans un fichier de configuration caché
     */

    static String driver = "org.h2.Driver";
    static String database = "db_acte_naiss_fr";
    static String user = "admin";
    static String password = "";
    //    String url = "jdbc:mysql"://127.0.0.1/dbfichfamil";
    static String url = "jdbc:h2:~/" + database;

    protected final static DataSource datasource = new SimpleDataSource(driver, url, user, password);

    public static final PersistenceManager persistenceManager = new PersistenceManager(datasource);


    public static int ism_lastGeneratedId(String tableName, String id) {

        IDaos daos = null;
        int i = -1;
        try {
            daos = MyDaos.persistenceManager.createDaos();

            Statement st = daos.getConnection().createStatement();

            ResultSet rs = st.executeQuery("select MAX("+ id + ") as "
                    + id + " from "+ tableName);
            if (rs.next()) {
                i = rs.getInt(id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return i;
        }
    }

    /**
     * @param nom
     * @param prenom
     * @param inFrench
     * @return
     * @throws PersistenceException
     * @should return list of attest that match nom, prenom parameters
     */
    public static List<Acte> getListAttest(String nom, String prenom, boolean inFrench) throws PersistenceException {

        List<Acte> list = new ArrayList<Acte>();

        try {
            if (!nom.equals("") && !prenom.equals("")) {

                String sql = "";
                if (inFrench) {
                    sql = "select * from attest where nomFR_cit like '"
                            + nom + "%' and prenomFR_cit like '" + prenom + "%'";
                } else {
                    sql = "select * from attest where nom_cit like '"
                            + nom + "%' and prenom_cit like '" + prenom + "%'";
                }
                IDaos daos = MyDaos.persistenceManager.createDaos();
                list = daos.getObjectDao().readList(Acte.class, sql);
            }

        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            return list;
        }

    }
}
