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

/**
 *
 * @author Admin
 */
public class ClassDBContext extends DBContext<Class> {

    @Override
    public ArrayList<Class> list() {
        ArrayList<Class> clas = new ArrayList<>();
        try {
            String sql = "SELECT cid,cname "
                    + "FROM Class";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Class c = new Class();
                c.setCid(rs.getInt("cid"));
                c.setCname(rs.getString("cname"));
                clas.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clas;
    }

    @Override
    public Class get(Class model) {
         try {
            String sql = "SELECT cid,cname "
                    + "FROM Class \n" 
                    + "WHERE cid=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1,model.getCid());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Class c = new Class();
                c.setCid(rs.getInt("cid"));
                c.setCname(rs.getString("cname"));              
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Class model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Class model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Class model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
