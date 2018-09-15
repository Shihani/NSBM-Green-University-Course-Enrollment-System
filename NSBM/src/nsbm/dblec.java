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
public class dblec {
    String url="jdbc:mysql://localhost:3306/nsbm";
    String username="root";
    String password="";
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    public boolean updatelec(lec l){
       try{
           
        con=DriverManager.getConnection(url,username, password);
        
        String query;
        query = "UPDATE lect SET Name='"+l.getName()+"',Age="+l.getAge()+",Email='"+l.getEmail()+"',TelephoneNo="+l.getTelephoneNo()+",NIC='"+l.getNIC()+"',Subject='"+l.getSubject()+"' WHERE Regid="+l.getRegid()+"";
        pst=(PreparedStatement)con.prepareStatement(query);
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
    
    
    public boolean  addlec(lec l) throws SQLException{
        try{
        con=DriverManager.getConnection(url,username, password);
        
        String query;
        query = "INSERT INTO lect VALUES(?,?,?,?,?,?,? )";
        pst=(PreparedStatement)con.prepareStatement(query);
        pst.setInt(1,l.getRegid());
        pst.setString(2, l.getName());
        pst.setInt(3,  l.getAge());
        pst.setString(4, l.getEmail());
        pst.setInt(5, l.getTelephoneNo());
        pst.setString(6, l.getNIC());
        pst.setString(7, l.getSubject());
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
    
    
    
    ArrayList<lec> getlec(){
        try{
            ArrayList<lec> list=new ArrayList<>();
            
        con=DriverManager.getConnection(url,username, password);
        
        String query;
        query =  "SELECT * FROM lect";
        pst=(PreparedStatement)con.prepareStatement(query);
        rs=pst.executeQuery();   
        while(rs.next()){
            lec ss=new lec();
            ss.setRegid(rs.getInt(1));
            ss.setName(rs.getString(2));
            ss.setAge(rs.getInt(3));
            ss.setEmail(rs.getString(4));
            ss.setTelephoneNo(rs.getInt(5));
            ss.setNIC(rs.getString(6));
            ss.setSubject(rs.getString(7));
            
            
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
    
    public boolean deletelec(lec l){
        try{
        con=DriverManager.getConnection(url,username, password);
        
        String query;
        query =  "DELETE FROM lect WHERE Regid="+l.getRegid() ;
        pst=(PreparedStatement)con.prepareStatement(query);
        pst.executeUpdate();   
            
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
        return false;
    }
    
    
}
