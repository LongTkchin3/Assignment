/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Class;
import model.Student;

/**
 *
 * @author Admin
 */
public class StudentDBContext extends DBContext<Student>{

    @Override
    public ArrayList<Student> list() {
        ArrayList<Student> std = new ArrayList<>();
        try {
            String sql = "SELECT s.sid,s.sname,s.simage,s.cid,s.available,c.cname "
                    + "FROM Student s INNER JOIN Class c\n" 
                    + "ON s.cid = c.cid";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Class c = new Class();
                c.setCid(rs.getInt("cid"));
                c.setCname(rs.getString("cname"));
                Student s = new Student();
                s.setSid(rs.getString("sid"));
                s.setSname(rs.getString("sname"));
                s.setImage(rs.getString("simage"));
                s.setCid(c);
                s.setAvailable(rs.getBoolean("available"));
                std.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return std;
    }

    @Override
    public Student get(Student model) {
       try {
            String sql = "SELECT s.sid,s.sname,s.simage,s.cid,s.available,c.cname "
                    + "FROM Student s INNER JOIN Class c\n" 
                    + "ON s.cid = c.cid "
                    + "WHERE s.sid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1,model.getSid());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Class c = new Class();
                c.setCid(rs.getInt("cid"));
                c.setCname(rs.getString("cname"));
                Student s = new Student();
                s.setSid(rs.getString("sid"));
                s.setSname(rs.getString("sname"));
                s.setImage(rs.getString("simage"));
                s.setCid(c);
                s.setAvailable(rs.getBoolean("available"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Student model) {
        try {
            String sql = "UPDATE [Student]\n" +
                        " SET   [sname]     = ?\n" +
                        "      ,[simage]    = ?\n" +
                        "      ,[cid]       = ?\n" +
                        "      ,[available] = ?\n" +
                        " WHERE [sid]       = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(5, model.getSid());
            stm.setString(1, model.getSname());
            stm.setString(2, model.getImage());
            stm.setInt(3, model.getCid().getCid());
            stm.setBoolean(4, model.isAvailable());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public ArrayList<Student> listStudent(Student model) {
        ArrayList<Student> std = new ArrayList<>();
        try {
            String sql = "SELECT s.sid,s.sname,s.simage,s.cid,s.available,c.cname "
                    + "FROM Student s INNER JOIN Class c\n" 
                    + "ON s.cid = c.cid WHERE s.cid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getCid().getCid());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Class c = new Class();
                c.setCid(rs.getInt("cid"));
                c.setCname(rs.getString("cname"));
                Student s = new Student();
                s.setSid(rs.getString("sid"));
                s.setSname(rs.getString("sname"));
                s.setImage(rs.getString("simage"));
                s.setCid(c);
                s.setAvailable(rs.getBoolean("available"));
                std.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return std;
    }
}
