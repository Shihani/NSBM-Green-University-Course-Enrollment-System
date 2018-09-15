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
public class csdetails extends AbstractTableModel {
    private static final String[] COLUMN_NAMES={"RegID","EnrollmentMonth","Semester1Subjects","Semester2Subjects"};
    private static ArrayList<cs> list;
    csdetails(ArrayList<cs> stList ){
        list=stList;
    }

    @Override
    public int getRowCount() {
         return list.size();
    }
    @Override
    public String getColumnName(int columnIndex){
        return COLUMN_NAMES[columnIndex];   
    }
   

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex ){
           case 0:
               return list.get(rowIndex).getRegID();
           case 1:
               return list.get(rowIndex).getEnrollmentMonth();
           case 2:
               return list.get(rowIndex).getSemester1Subjects();
           case 3:
               return list.get(rowIndex).getSemester2Subjects();
           default:
               return "error";
               
       }
    }

    

    @Override
    public int getColumnCount() {
        return COLUMN_NAMES.length;
    }
    
    
}
