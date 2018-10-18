/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Account;

/**
 *
 * @author i1vag_000
 */
public class DAO {
    private Connection conn;
    public DAO()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/bookstoreweb"
            + "?useUnicode=true&characterEncoding=utf-8","root","0793145");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String checkUsername(String s)
    {
        String sql="SELECT * FROM BOOKSTOREWEB.TBLACCOUNT WHERE USERNAME=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, s);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) return "used";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "available";
    }
    
    public boolean addAccount(Account acc)
    {
        String sql="INSERT INTO BOOKSTOREWEB.TBLACCOUNT(USERNAME,PASSWORD,ROLE) VALUES(?,?,'CLIENT')";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, acc.getUsername());
            ps.setString(2, acc.getPassword());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void removeAccount(int id)
    {
        try {
            String sql="DELETE FROM BOOKSTOREWEB.TBLACCOUNT WHERE ID=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Account> getAccount()
    {
        ArrayList<Account> list = new ArrayList<>();
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLACCOUNT";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Account a = new Account();
                a.setId(rs.getInt("ID"));
                a.setUsername(rs.getString("USERNAME"));
                a.setPassword(rs.getString("PASSWORD"));
                a.setRole(rs.getString("ROLE"));
                list.add(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Account getAccount(String username, String password)
    {
        try {
            String sql="SELECT * FROM BOOKSTOREWEB.TBLACCOUNT WHERE USERNAME=? AND PASSWORD=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                Account a = new Account();
                a.setId(rs.getInt("ID"));
                a.setUsername(rs.getString("USERNAME"));
                a.setPassword(rs.getString("PASSWORD"));
                a.setRole(rs.getString("ROLE"));
                return a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Account getAccount(int id)
    {
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLACCOUNT WHERE ID=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Account a = new Account();
                a.setId(rs.getInt("ID"));
                a.setUsername(rs.getString("USERNAME"));
                a.setPassword(rs.getString("PASSWORD"));
                a.setRole(rs.getString("ROLE"));
                return a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Account getAccount(String username)
    {
        String sql = "SELECT * FROM BOOKSTOREWEB.TBLACCOUNT WHERE USERNAME=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Account a = new Account();
                a.setId(rs.getInt("ID"));
                a.setUsername(rs.getString("USERNAME"));
                a.setPassword(rs.getString("PASSWORD"));
                a.setRole(rs.getString("ROLE"));
                return a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
}
