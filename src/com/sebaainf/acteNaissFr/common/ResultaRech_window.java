package com.sebaainf.acteNaissFr.common;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.common.collect.ArrayListModel;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.factories.Paddings;

import com.sebaainf.ismUtils.IsmAbstractJFrame;
import com.sebaainf.ismUtils.IsmPrintStream;
import com.sebaainf.ismUtils.IsmTableAdapter;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;

public class ResultaRech_window extends JFrame {


    public static Dimension dimWin;
    public static Dimension dimPannel;
    private static ResultaRech_window uniqueFrame;
    private List listObj;

    private ResultaRech_window(List listObj) {

        UIManager.put("Table.background", new ColorUIResource(MyApp.tableBackColor));
        UIManager.put("Table.alternateRowColor", MyApp.alternateRowColor);

        this.listObj = listObj;
        dimWin = new Dimension(6 * (int) IsmAbstractJFrame.screenSize.getWidth() / 10, 4 * (int) IsmAbstractJFrame.screenSize.getHeight() / 10);
        dimPannel = new Dimension(5 * (int) IsmAbstractJFrame.screenSize.getWidth() / 10, 3 * (int) IsmAbstractJFrame.screenSize.getHeight() / 10);

        this.setTitle("Resultat de recherche !");
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(this.createPanel());

        this.pack();

        this.setSize(dimWin);

        this.setLocationRelativeTo(null); //to center the frame in the middle of screen
    }

    public static ResultaRech_window getInstance(List listObj) {

        if (uniqueFrame == null) {
            uniqueFrame = new ResultaRech_window(listObj);
        } else {
            //becarfull with using singleton
            // for exple : without this else part it was an disaster
            uniqueFrame.dispose();
            uniqueFrame = new ResultaRech_window(listObj);
        }
        return uniqueFrame;

    }

    // Singleton

    public JComponent createPanel() {


        //final List listCitoyens = new ArrayListModel(this.listCit);

        //final SelectionInList selectionInList = new SelectionInList(listCit);
        IsmTableAdapter tableAdapter = new IsmTableAdapter(
                listObj, new String[]{Acte.PROPERTY_NUM_ACTE, Acte.PROPERTY_NOM_CIT, Acte.PROPERTY_PRENOM_CIT,
                Acte.PROPERTY_DATE_NAISS_CIT, Acte.PROPERTY_FULLNAME_PERE, Acte.PROPERTY_FULLNAME_MERE}
                , new String[]{"N° acte", "Nom", "Prenom", "Date naissance",
        "Père", "Mère"});
        JTable table = new JTable(tableAdapter);

        tableAdapter.settingTable(table);

        // on double Click Action  ******************

        table.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {

                JTable table = (JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    // your valueChanged overridden method

                    Acte selectedObj = (Acte) new ArrayListModel(listObj).getElementAt(table.getSelectedRow());
                    //to update commune if changed
                    selectedObj.setCommune(MyApp.commune);
                    selectedObj.setDaira(MyApp.daira);
                    selectedObj.setWilaya(MyApp.wilaya);


                    ActeEditorModel objModel = new ActeEditorModel(selectedObj);

                    Editor_window view = new Editor_window(objModel, false);
                    view.setVisible(true);
                }
            }

        });

        //*********************************


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(dimPannel);


        return FormBuilder.create()
                .columns("p:g")
                .rows("p:g")
                .padding(Paddings.DIALOG)
                .add(scrollPane).xy(1, 1)
                .build();

    }

    class ObjectTableAdapter extends AbstractTableAdapter {

        public ObjectTableAdapter(ListModel listModel, String[] columnNames) {

            super(listModel, columnNames);
        }

        /**
         * Returns the value for the cell at <code>columnIndex</code> and
         * <code>rowIndex</code>.
         *
         * @param rowIndex    the row whose value is to be queried
         * @param columnIndex the column whose value is to be queried
         * @return the value Object at the specified cell
         */
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {


            Acte obj = (Acte) getRow(rowIndex);
            if (columnIndex == 0) {
                return obj.getNom_cit();
            } else if (columnIndex == 1) {
                return obj.getID_acte();
            }else if (columnIndex == 2) {
                return obj.getPrenom_cit();
            } else if (columnIndex == 3) {
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                String str = formatter.format(obj.getDate_naiss_cit());
                IsmPrintStream.logging("ha la daaate = " + str);

                return str;
            }  else if (columnIndex == 4) {
                return obj.getNom_cit();
            } else {
                return obj.getPrenom_cit();
            }
        }
    }


}
