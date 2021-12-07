/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendant;

/**
 *
 * @author Admin
 */
public class AttendantDBContext extends DBContext<Attendant> {

    @Override
    public ArrayList<Attendant> list() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Attendant get(Attendant model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert(Attendant model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Attendant model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Attendant model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void takeAttendance(ArrayList<Attendant> atte) {
        try {
            String sql = "INSERT INTO [Attendant]\n"
                    + "            ([sid]\n"
                    + "           ,[attend]\n"
                    + "           ,[adate]\n"
                    + "           ,[slot_id])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            connection.setAutoCommit(false);
            for (Attendant att : atte) {
                PreparedStatement stm = connection.prepareStatement(sql);
                stm.setString(1, att.getSid().getSid());
                stm.setBoolean(2, att.isAttdend());
                stm.setDate(3, att.getAdate());
                stm.setInt(4, att.getSlot().getSlot_id());
                stm.executeUpdate();
            }
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(AttendantDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(AttendantDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(AttendantDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void update(ArrayList<Attendant> atte) {
        try {
            String sql = "UPDATE [Student]\n"
                    + " SET   [attend]     = ?\n"
                    + " WHERE 1=1";
            connection.setAutoCommit(false);
            for (Attendant model : atte) {
                HashMap<Integer, Object[]> parameters = new HashMap<>();
            int indexParam = 0;
            if (model.getSid() != null && model.getSid().getCid() != null) {
                sql += " AND sid = ?";
                indexParam++;
                Object[] params = new Object[2];
                params[0] = String.class.getTypeName();
                params[1] = model.getSid().getCid();
                parameters.put(indexParam, params);
            }
            if (model.getAdate() != null) {
                sql += " AND adate = ?";                
                indexParam++;
                Object[] params = new Object[2];
                params[0] = Date.class.getTypeName();
                params[1] = model.getAdate();              
                parameters.put(indexParam, params);
            }
            if (model.getSlot()!= null && model.getSlot().getSlot_id()>0) {
                sql += " AND slot_id = ?";
                indexParam++;
                Object[] params = new Object[2];
                params[0] = Integer.class.getTypeName();
                params[1] = model.getSlot().getSlot_id();
                parameters.put(indexParam, params);
            }
            PreparedStatement stm = connection.prepareStatement(sql);
            for (Map.Entry<Integer, Object[]> entry : parameters.entrySet()) {
                Integer index = entry.getKey();
                Object[] params = entry.getValue();
                String type = params[0].toString();
                if (type.equals(String.class.getTypeName())) {
                    stm.setInt(index, (Integer) params[1]);
                } else if (type.equals(Date.class.getTypeName())) {
                    stm.setString(index, params[1].toString());
                } else if (type.equals(Integer.class.getTypeName())) {
                    stm.setString(index, params[1].toString());
                }
            }         
            stm.setBoolean(1, model.isAttdend());
            stm.executeUpdate();           
            }
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(AttendantDBContext.class.getName()).log(Level.SEVERE, null, ex);
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(AttendantDBContext.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(AttendantDBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
