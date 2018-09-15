
package nsbm;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBOperationp {
    String url="jdbc:mysql://localhost:3306/nsbm";
    String username="root";
    String password="";
    Connection con=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    
   public boolean updateStudent(Studentp s1){
       try{
           
        con=DriverManager.getConnection(url,username, password);
        
        String query;
        query = "UPDATE studentp SET Name='"+s1.getName()+"',DateOfBirth='"+s1.getDateOfBirth()+"',NIC='"+s1.getNIC()+"',Address='"+s1.getAddress()+"',Gender='"+s1.getGender()+"',TelephoneNo="+s1.getTelephoneNo()+",Email='"+s1.getEmail()+"',EnrollmentMonth='"+s1.getEnrollmentMonth()+"',PreviousEducationResults='"+s1.getPreviousEducationResults()+"',Faculty='"+s1.getFaculty()+"' WHERE RegID="+s1.getRegID()+"";
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
       
       
       
    
    
   public boolean  addStudent(Studentp s1) throws SQLException{
        try{
        con=DriverManager.getConnection(url,username, password);
        
        String query;
        query = "INSERT INTO studentp VALUES(?,?,?,?,?,?,?,?,?,?,? )";
        pst=(PreparedStatement)con.prepareStatement(query);
        pst.setInt(1,s1.getRegID());
        pst.setString(2, s1.getName());
        pst.setString(3,  s1.getDateOfBirth());
        pst.setString(4, s1.getNIC());
        pst.setString(5, s1.getAddress());
        pst.setString(6, s1.getGender());
        pst.setInt(7, s1.getTelephoneNo());
        pst.setString(8, s1.getEmail());
        pst.setString(9, s1.getEnrollmentMonth());
        pst.setString(10, s1.getPreviousEducationResults());
        pst.setString(11, s1.getFaculty());
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
    ArrayList<Studentp> getStudent(){
        try{
            ArrayList<Studentp> list=new ArrayList<>();
            
        con=DriverManager.getConnection(url,username, password);
        
        String query;
        query =  "SELECT * FROM studentp";
        pst=(PreparedStatement)con.prepareStatement(query);
        rs=pst.executeQuery();   
        while(rs.next()){
            Studentp ss=new Studentp();
            ss.setRegID(rs.getInt(1));
            ss.setName(rs.getString(2));
            ss.setDateOfBirth(rs.getString(3));
            ss.setNIC(rs.getString(4));
            ss.setAddress(rs.getString(5));
            ss.setGender(rs.getString(6));
            ss.setTelephoneNo(rs.getInt(7));
            ss.setEmail(rs.getString(8));
            ss.setEnrollmentMonth(rs.getString(9));
            ss.setPreviousEducationResults(rs.getString(10));
            ss.setFaculty(rs.getString(11));
            
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
    
    public boolean deleteStudent(Studentp s1){
        try{
        con=DriverManager.getConnection(url,username, password);
        
        String query;
        query =  "DELETE FROM studentp WHERE RegID="+s1.getRegID() ;
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
  

    void addstudent(Studentp s1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
