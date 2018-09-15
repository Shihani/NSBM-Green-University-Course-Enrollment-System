/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nsbm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PC-MAC
 */
public class dbcs {
    String url="jdbc:mysql://localhost:3306/nsbm";
    String username="root";
    String password="";
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    public boolean updatesubject(cs c){
       try{
           
        con=DriverManager.getConnection(url,username, password);
        
        String query;
        query = "UPDATE cselect SET EnrollmentMonth='"+c.getEnrollmentMonth()+"',Semester1Subjects='"+c.getSemester1Subjects()+"',Semester2Subjects='"+c.getSemester2Subjects()+"' WHERE RegID=?";
        pst=(PreparedStatement)con.prepareStatement(query);
        pst.setInt(1, c.getRegID());
        pst.executeUpdate();
        return true;
        
       } catch (SQLException e) {
            System.out.print("exe---> "+e);
            return false;
        }
        
        finally{
            try{
                if(pst!=null){
                    pst.close();
                }
            }catch(SQLException e ){
                
            }
        }
        
   }
    
     public boolean  addsubject(cs c) throws SQLException{
        try{
        con=DriverManager.getConnection(url,username, password);
        
        String query;
        query = "INSERT INTO cselect VALUES(?,?,?,?)";
        pst=(PreparedStatement)con.prepareStatement(query);
        pst.setInt(1,c.getRegID());
        pst.setString(2, c.getEnrollmentMonth());
        pst.setString(3,  c.getSemester1Subjects());
        pst.setString(4, c.getSemester2Subjects());
        pst.executeUpdate();
        return true;
        }
        catch(SQLException e){
            System.out.print("exe---> "+e);
            return false;
        }
        finally{
            try{
                if(pst!=null){
                    pst.close();
                }
            }catch(SQLException e ){
                
            }
        }
    
    }
     
     ArrayList<cs> getsubject(){
        try{
            ArrayList<cs> list=new ArrayList<>();
            
        con=DriverManager.getConnection(url,username, password);
        
        String query;
        query =  "SELECT * FROM cselect";
        pst=(PreparedStatement)con.prepareStatement(query);
        rs=pst.executeQuery();   
        while(rs.next()){
            cs ss=new cs();
            ss.setRegID(rs.getInt(1));
            ss.setEnrollmentMonth(rs.getString(2));
            ss.setSemester1Subjects(rs.getString(3));
            ss.setSemester2Subjects(rs.getString(4));
            
            list.add(ss);
        } 
        return list;
        } 
        catch(SQLException e){
            System.out.print("exe---> "+e);
            
        }
        finally{
            try{
                if(pst!=null){
                    pst.close();
                }
            }catch(SQLException e ){
                
            }
        }
        return null;
        
        
    }
     
     
    
}
