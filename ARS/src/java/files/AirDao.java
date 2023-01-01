
package files;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AirDao {
    
     Connection con = null;
    void connection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/airlinedb";
            con = DriverManager.getConnection(url, "root", "");
        }
        catch(Exception ex)
        {
            System.out.println(ex.toString());
        }
    }
    public int Insert(Profile p)
    {
        connection();
        int res = 0;
        try
        {
            String qry = "insert into passenger values (?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, p.uname);
            pst.setString(2, p.upassw);
            pst.setString(3, p.ufn);
            pst.setString(4, p.uln);
            pst.setString(5, p.uaddr);
            pst.setString(6, p.utel);
            pst.setString(7, p.uemail);
            res = pst.executeUpdate();
            
        }
        catch(Exception ex)
        {
             System.out.println(ex.toString());
        }
        return res;
    }
    
      public int FInsert(Details d)
    {
        connection();
        int res = 0;
        try
        {
            String qry = "insert into fdetails values (?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, d.fid);
            pst.setString(2, d.aid);
            pst.setString(3, d.aname);
            pst.setString(4, d.floc);
            pst.setString(5, d.toloc);
            pst.setString(6, d.dept);
            pst.setString(7, d.atime);
            pst.setString(8, d.duration);
            pst.setString(9, d.tseats);
            pst.setString(10, d.fdepdate);
            pst.setString(11, d.fprice);
            pst.setString(12, d.avseats);
            res = pst.executeUpdate();
            
        }
        catch(Exception ex)
        {
             System.out.println(ex.toString());
        }
        return res;
    }
    
      
      //login for admin
   public ResultSet SelectByUserNamePassword(Profile p)
    {
        connection();
        ResultSet res = null;
        try
        {
            String qry = "select * from admin where admin = ? and pass = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, p.admin);
            pst.setString(2, p.pass);
            
            res = pst.executeQuery();
            
        }
        catch(Exception ex)
        {
             System.out.println(ex.toString());
        }
        return res;
    }
   
   
   
    //Select by id for admin add
   public ResultSet SelectById(Details d)
    {
        connection();
        ResultSet res = null;
        try
        {
            String qry = "select * from fdetails where fid = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, d.fid);
            
            res = pst.executeQuery();
            
        }
        catch(Exception ex)
        {
             System.out.println(ex.toString());
        }
        return res;
    }
   
   //update for admin side
       public int Update(Details d)
    {
        connection();
        int res = 0;
        try
        {
            String qry = "update fdetails set aid = ?, aname = ?, floc = ?, toloc = ?, dept = ?, atime = ?, duration = ?, tseats = ?, fdepdate = ?, fprice = ?, avseats = ? where fid= ?";
            PreparedStatement pst = con.prepareStatement(qry);
            
            pst.setString(1, d.aid);
            pst.setString(2, d.aname);
            pst.setString(3, d.floc);
            pst.setString(4, d.toloc);
             pst.setString(5, d.dept);
            pst.setString(6, d.atime);
            pst.setString(7, d.duration);
            pst.setString(8, d.tseats);
             pst.setString(9, d.fdepdate);
            pst.setString(10, d.fprice);
            pst.setString(11, d.avseats);
            pst.setString(12, d.fid);
            res = pst.executeUpdate();
            
        }
        catch(Exception ex)
        {
             System.out.println(ex.toString());
        }
        return res;
    }
     
   // Select All For Admin Side    
   public ResultSet SelectAll()
    {
        connection();
        ResultSet res = null;
        try
        {
            String qry = "select * from fdetails ";
            Statement pst = con.createStatement();
            res = pst.executeQuery(qry);
            
        }
        catch(Exception ex)
        {
             System.out.println(ex.toString());
        }
        return res;
    }    
   
   // Admin Delete Details of flight
   public int Delete(Details d)
    {
        connection();
        int res = 0;
        try
        {
            String qry = "delete from fdetails where fid = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, d.fid);
            
            res = pst.executeUpdate();
            
        }
        catch(Exception ex)
        {
             System.out.println(ex.toString());
        }
        return res;
    }


     // user login Query
   public ResultSet SelectByUser(Profile p)
    {
        connection();
        ResultSet res = null;
        try
        {
            String qry = "select * from passenger where uname = ? and upassw = ?";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, p.uname);
            pst.setString(2, p.upassw);
            
            res = pst.executeQuery();
            
        }
        catch(Exception ex)
        {
             System.out.println(ex.toString());
        }
        return res;
    }
   
   //Card Details Insert
       public int InsertC(Card c)
    {
        connection();
        int res = 0;
        try
        {
            String qry = "insert into card values (?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(qry);
            pst.setString(1, c.cnum);
            pst.setString(2, c.ccv);
            pst.setString(3, c.exm);
            pst.setString(4, c.exy);
            pst.setString(5, c.uname);
            res = pst.executeUpdate();
            
        }
        catch(Exception ex)
        {
             System.out.println(ex.toString());
        }
        return res;
    }
       
   //Admin Side to see User Details 
         public ResultSet SelectAllU()
    {
        connection();
        ResultSet res = null;
        try
        {
            String qry = "select * from passenger ";
            Statement pst = con.createStatement();
            res = pst.executeQuery(qry);
            
        }
        catch(Exception ex)
        {
             System.out.println(ex.toString());
        }
        return res;
    }
   
         
   // Admin Side Select Query for passenger & card Details
          public ResultSet SelectAllUD()
    {
        connection();
        ResultSet res = null;
        try
        {
            String qry = "SELECT p.uname, upassw,uemail,cnum,ccv from passenger p,card c WHERE p.uname=c.uname ";
            Statement pst = con.createStatement();
            res = pst.executeQuery(qry);
            
        }
        catch(Exception ex)
        {
             System.out.println(ex.toString());
        }
        return res;
    }
     
          
   
}
