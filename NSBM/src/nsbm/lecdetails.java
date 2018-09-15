/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC-MAC
 */
class lecdetails extends AbstractTableModel {
    private static final String[] COLUMN_NAMES={"Regid","Name","Email","Subject"};
    private static ArrayList<lec> list;
    lecdetails(ArrayList<lec> stList ){
        list=stList;
    }

    @Override
    public int getRowCount() {
        return list.size();
    }
    public String getColumnName(int columnIndex){
        return COLUMN_NAMES[columnIndex];   
    }

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         switch(columnIndex ){
           case 0:
               return list.get(rowIndex).getRegid();
           case 1:
               return list.get(rowIndex).getName();
           case 2:
               return list.get(rowIndex).getEmail();
           case 3:
               return list.get(rowIndex).getSubject();
           default:
               return "error";
               
       }
    }
    
}
