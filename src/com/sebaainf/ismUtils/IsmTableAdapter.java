package com.sebaainf.ismUtils;

import com.jgoodies.binding.adapter.AbstractTableAdapter;
import com.jgoodies.common.collect.ArrayListModel;
import org.apache.commons.beanutils.PropertyUtils;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.List;

/**
 * Created by ${sebaainf.com} on 21/10/2015.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 * a ِClass that take a model list of objects as parameter
 * and prepare a lot of configurations of a JTable
 * it set the columns from object properties
 * and can also customize also there text in table header
 * can customize the appearance of the JTable : font, size, color etc ...
 */
public class IsmTableAdapter extends AbstractTableAdapter {

    private Color backgroundColor = Color.darkGray;
    private Color foregroundColor = Color.white;

    private String[] columnNames;


    private String[] columnsHeaderText;

    /**
     * constructor without columnsHeaderText
     *
     * @param list
     * @param columnNames
     */
    public IsmTableAdapter(java.util.List list, String[] columnNames) {

        super(new ArrayListModel((Collection) list), columnNames);
        this.columnNames = columnNames;
    }

    /**
     * constructor with columnsHeaderText
     *
     * @param list
     * @param columnNames
     * @param columnsHeaderText
     */

    public IsmTableAdapter(List list, String[] columnNames
            , String[] columnsHeaderText) {

        this(list, columnNames);
        this.columnsHeaderText = columnsHeaderText;
    }

    public void settingTable(JTable table) {

        JTableHeader header = table.getTableHeader();
        header.setBackground(this.backgroundColor);
        header.setForeground(this.foregroundColor);

        FontMetrics metrics = table.getFontMetrics(table.getFont());
        int fontHeight = metrics.getHeight();
        table.setRowHeight(fontHeight + 4);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(rightRenderer);
        }

        if (columnsHeaderText != null) {
            this.setHeaders(table, this.columnsHeaderText);
        }

    }

    public void settingTable(JTable table, Color backgroundColor, Color foregroundColor) {

        this.backgroundColor = backgroundColor;
        this.foregroundColor = foregroundColor;
        settingTable(table);
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


        Object obj = getRow(rowIndex);

        for (int i = 0; i < columnNames.length; i++) {
            if (columnIndex == i) {
                try {
                    return PropertyUtils.getProperty(obj, columnNames[i]);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    public void setHeaders(JTable table, String[] columnsHeaderText) {

        if (columnsHeaderText.length > 0) {
            for (int i = 0; i < columnsHeaderText.length; i++) {

                if ((columnsHeaderText[i] != null) && (columnsHeaderText[i] != "")) {

                    table.getColumnModel().getColumn(i).setHeaderValue(columnsHeaderText[i]);

                }

            }
        }


    }

    public String[] getColumnsHeaderText() {

        return columnsHeaderText;
    }

    public void setColumnsHeaderText(String[] columnsHeaderText) {

        this.columnsHeaderText = columnsHeaderText;
    }

    /**
     * @should test MyTableAdapter
     */
    void tester() {

    }
}
