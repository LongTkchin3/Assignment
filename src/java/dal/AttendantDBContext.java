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
import model.Slot;
import model.Student;
import model.Table;

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
            connection.setAutoCommit(false);
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
            for (Attendant att : atte) {
                PreparedStatement stm = connection.prepareStatement(sql);
                stm.setString(1, att.getStudent().getSid());
                stm.setBoolean(2, att.isAttend());
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
            connection.setAutoCommit(false);
            for (Attendant model : atte) {
                String sql = "UPDATE [Attendant]\n"
                        + " SET   [attend]     = ?\n"
                        + " WHERE 1=1";
                HashMap<Integer, Object[]> parameters = new HashMap<>();
                int indexParam = 1;
                if (model.getSlot().getSlot_id() != -1) {
                    sql += " AND slot_id = ?";
                    indexParam++;
                    Object[] params = new Object[2];
                    params[0] = Integer.class.getTypeName();
                    params[1] = model.getSlot().getSlot_id();
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
                if (model.getStudent() != null && model.getStudent().getSid() != null) {
                    sql += " AND sid = ?";
                    indexParam++;
                    Object[] params = new Object[2];
                    params[0] = String.class.getTypeName();
                    params[1] = model.getStudent().getSid();
                    parameters.put(indexParam, params);
                }
                PreparedStatement stm = connection.prepareStatement(sql);
                for (Map.Entry<Integer, Object[]> entry : parameters.entrySet()) {
                    Integer index = entry.getKey();
                    Object[] params = entry.getValue();
                    String type = params[0].toString();
                    if (type.equals(Integer.class.getTypeName())) {
                        stm.setInt(index, (Integer) params[1]);
                    }
                    if (type.equals(Date.class.getTypeName())) {
                        stm.setDate(index, Date.valueOf(params[1].toString()));
                    }
                    if (type.equals(String.class.getTypeName())) {
                        stm.setString(index, params[1].toString());
                    }
                }
                stm.setBoolean(1, model.isAttend());
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

    public ArrayList<Attendant> getAttend(Attendant model) {
        ArrayList<Attendant> attends = new ArrayList<>();
        try {
            String sql = "SELECT s.sid,s.sname,a.attend,a.adate,Slot.slot_id,Slot.sname,c.cid,c.cname\n"
                    + "FROM Attendant a INNER JOIN Student s\n"
                    + "ON a.sid = s.sid "
                    + "INNER JOIN Class c\n"
                    + "ON c.cid = s.cid "
                    + "INNER JOIN Slot\n"
                    + "ON a.slot_id = Slot.slot_id "
                    + "WHERE 1=1";
            HashMap<Integer, Object[]> parameters = new HashMap<>();
            int indexParam = 0;
            if (model.getStudent().getClassroom().getCid() > 0) {
                sql += " AND c.cid = ?";
                indexParam++;
                Object[] params = new Object[2];
                params[0] = Integer.class.getTypeName();
                params[1] = model.getStudent().getClassroom().getCid();
                parameters.put(indexParam, params);
            }
            if (model.getSlot().getSlot_id() > 0) {
                sql += " AND Slot.slot_id = ?";
                indexParam++;
                Object[] params = new Object[2];
                params[0] = Integer.class.getTypeName();
                params[1] = model.getSlot().getSlot_id();
                parameters.put(indexParam, params);
            }
            if (model.getAdate() != null) {
                sql += " AND a.adate = ?";
                indexParam++;
                Object[] params = new Object[2];
                params[0] = Date.class.getTypeName();
                params[1] = model.getAdate();
                parameters.put(indexParam, params);
            }

            PreparedStatement stm = connection.prepareStatement(sql);

            for (Map.Entry<Integer, Object[]> entry : parameters.entrySet()) {
                Integer index = entry.getKey();
                Object[] params = entry.getValue();
                String type = params[0].toString();
                if (type.equals(Integer.class.getTypeName())) {
                    stm.setInt(index, (Integer) params[1]);
                } else if (type.equals(Date.class.getTypeName())) {
                    stm.setDate(index, Date.valueOf(params[1].toString()));
                }
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Attendant a = new Attendant();
                a.setAdate(rs.getDate("adate"));
                a.setAttend(rs.getBoolean("attend"));
                Student s = new Student();
                s.setSid(rs.getString("sid"));
                s.setSname(rs.getString("sname"));
                Slot slot = new Slot();
                slot.setSlot_id(rs.getInt("slot_id"));
                slot.setName(rs.getString("sname"));
                a.setStudent(s);
                a.setSlot(slot);
                attends.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendantDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return attends;
    }

    public ArrayList<String> getAvailable(Table model) {
        ArrayList<String> student = new ArrayList<>();
        try {
            String sql = "SELECT a.[sid],COUNT(attend) as count\n"
                    + "FROM Attendant a inner join Student s \n"
                    + "ON a.[sid] = s.[sid]\n"
                    + "WHERE attend = 0 and cid=? and slot_id=?\n"
                    + "GROUP BY a.[sid]";
           
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getClassroom().getCid());
            stm.setInt(2, model.getSlot().getSlot_id());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String check = rs.getString("sid");
                check+="-"+rs.getString("count");          
                student.add(check);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AttendantDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }

}
