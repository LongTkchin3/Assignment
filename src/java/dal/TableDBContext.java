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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Slot;
import model.Table;
import model.Class;
import model.Teacher;

/**
 *
 * @author Admin
 */
public class TableDBContext extends DBContext<Table> {

    @Override
    public ArrayList<Table> list() {
        ArrayList<Table> table = new ArrayList<>();
        try {
            String sql = "SELECT t.id,t.cid,t.cdate,t.slot_id,t.tid,c.cname,s.sname,Teacher.tname "
                    + "From [Table] t Inner join Class c on t.cid=c.cid "
                    + "Inner join Slot s on t.slot_id=s.slot_id "
                    + "Inner join Teacher on t.tid=Teacher.tid ";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Slot s = new Slot();
                s.setSlot_id(rs.getInt("slot_id"));
                s.setName(rs.getString("sname"));
                Teacher t = new Teacher();
                t.setTid(rs.getString("tid"));
                t.setTname(rs.getString("tname"));
                t.setImage(rs.getString("timage"));
                Class c = new Class();
                c.setCid(rs.getInt("cid"));
                c.setCname(rs.getString("cname"));
                Table tab = new Table();
                tab.setId(rs.getInt("id"));
                tab.setClassroom(c);
                tab.setCdate(rs.getDate("cdate"));
                tab.setSlot(s);
                tab.setTeacher(t);
                table.add(tab);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return table;
    }

    @Override
    public Table get(Table model) {
        try {
            String sql = "SELECT t.id,t.cid,t.cdate,t.slot_id,t.tid,c.cname,s.sname,Teacher.tname,Teacher.timage "
                    + "From [Table] t Inner join Class c on t.cid=c.cid "
                    + "Inner join Slot s on t.slot_id=s.slot_id "
                    + "Inner join Teacher on t.tid=Teacher.tid  WHERE t.id =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1,model.getId());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Slot s = new Slot();
                s.setSlot_id(rs.getInt("slot_id"));
                s.setName(rs.getString("sname"));
                Teacher t = new Teacher();
                t.setTid(rs.getString("tid"));
                t.setTname(rs.getString("tname"));
                t.setImage(rs.getString("timage"));
                Class c = new Class();
                c.setCid(rs.getInt("cid"));
                c.setCname(rs.getString("cname"));
                Table tab = new Table();
                tab.setId(rs.getInt("id"));
                tab.setClassroom(c);
                tab.setCdate(rs.getDate("cdate"));
                tab.setSlot(s);
                tab.setTeacher(t);
                return tab;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void insert(Table model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Table model) {
         try {
            String sql = "UPDATE [Table]\n"
                    + "   SET [cdate] = ? \n"  
                    + "      ,[slot_id] = ?\n"
                    + " WHERE [id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(3, model.getId());
            stm.setDate(1, model.getCdate());
            stm.setInt(2, model.getSlot().getSlot_id());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TableDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Table model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<Table> getClass(String tid) {
        ArrayList<Table> table = new ArrayList<>();
        try {
            String sql = "SELECT t.id,t.cid,t.cdate,t.slot_id,t.tid,c.cname,s.sname,Teacher.tname,Teacher.timage "
                    + "From [Table] t Inner join Class c on t.cid=c.cid "
                    + "Inner join Slot s on t.slot_id=s.slot_id "
                    + "Inner join Teacher on t.tid=Teacher.tid "
                    + "WHERE 1=1";
//            String sql = "SELECT s.sid,s.sname,s.gender,s.dob,d.did,d.dname\n" +
//                    "FROM Student s INNER JOIN Department d\n" +
//                    "ON s.did = d.did WHERE 1=1 ";
            HashMap<Integer, Object[]> parameters = new HashMap<>();
            int indexParam = 0;
            if (tid.length() > 0) {
                sql += " AND Teacher.tid like '%'+?+'%' ORDER BY cdate ASC";
                indexParam++;
                Object[] params = new Object[2];
                params[0] = String.class.getTypeName();
                params[1] = tid;
                parameters.put(indexParam, params);
            }

            PreparedStatement stm = connection.prepareStatement(sql);

            for (Map.Entry<Integer, Object[]> entry : parameters.entrySet()) {
                Integer index = entry.getKey();
                Object[] params = entry.getValue();
                String type = params[0].toString();
                if (type.equals(String.class.getTypeName())) {
                    stm.setString(index, params[1].toString());
                }
            }

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Slot s = new Slot();
                s.setSlot_id(rs.getInt("slot_id"));
                s.setName(rs.getString("sname"));
                Teacher t = new Teacher();
                t.setTid(rs.getString("tid"));
                t.setTname(rs.getString("tname"));
                t.setImage(rs.getString("timage"));
                Class c = new Class();
                c.setCid(rs.getInt("cid"));
                c.setCname(rs.getString("cname"));
                Table tab = new Table();
                tab.setId(rs.getInt("id"));
                tab.setClassroom(c);
                tab.setCdate(rs.getDate("cdate"));
                tab.setSlot(s);
                tab.setTeacher(t);
                table.add(tab);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return table;
    }
    
    public void updateAttend(Table model,Slot slot) {
         try {
            String sql = "UPDATE [Attendant]\n"
                    + "   SET [slot_id] = ?\n"
                    + " WHERE [slot_id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, model.getSlot().getSlot_id());
            stm.setInt(2, slot.getSlot_id());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TableDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Table getTable(Table model) {
        try {
            String sql = "SELECT t.id,t.cid,t.cdate,t.slot_id,t.tid,c.cname,s.sname,Teacher.tname,Teacher.timage "
                    + "From [Table] t Inner join Class c on t.cid=c.cid "
                    + "Inner join Slot s on t.slot_id=s.slot_id "
                    + "Inner join Teacher on t.tid=Teacher.tid  WHERE t.slot_id =? AND t.cdate = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1,model.getSlot().getSlot_id());
            stm.setDate(2,model.getCdate());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Slot s = new Slot();
                s.setSlot_id(rs.getInt("slot_id"));
                s.setName(rs.getString("sname"));
                Teacher t = new Teacher();
                t.setTid(rs.getString("tid"));
                t.setTname(rs.getString("tname"));
                t.setImage(rs.getString("timage"));
                Class c = new Class();
                c.setCid(rs.getInt("cid"));
                c.setCname(rs.getString("cname"));
                Table tab = new Table();
                tab.setId(rs.getInt("id"));
                tab.setClassroom(c);
                tab.setCdate(rs.getDate("cdate"));
                tab.setSlot(s);
                tab.setTeacher(t);
                return tab;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
