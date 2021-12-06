/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Admin
 */
public class Table extends BaseModel {
        private int id;
        private Class cid;
        private Date cdate;
        private Slot slot_id;
        private Teacher tid;

    public Table() {
    }

    public Table(int id, Class cid, Date cdate, Slot slot_id, Teacher tid) {
        this.id = id;
        this.cid = cid;
        this.cdate = cdate;
        this.slot_id = slot_id;
        this.tid = tid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Class getCid() {
        return cid;
    }

    public void setCid(Class cid) {
        this.cid = cid;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Slot getSlot_id() {
        return slot_id;
    }

    public void setSlot_id(Slot slot_id) {
        this.slot_id = slot_id;
    }

    public Teacher getTid() {
        return tid;
    }

    public void setTid(Teacher tid) {
        this.tid = tid;
    }

   
}
