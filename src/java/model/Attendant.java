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
public class Attendant extends BaseModel {
        private Student sid;
        private boolean attdend;
        private Date adate;

    public Attendant() {
    }

    public Attendant(Student sid, boolean attdend, Date adate) {
        this.sid = sid;
        this.attdend = attdend;
        this.adate = adate;
    }

    public Student getSid() {
        return sid;
    }

    public void setSid(Student sid) {
        this.sid = sid;
    }

    public boolean isAttdend() {
        return attdend;
    }

    public void setAttdend(boolean attdend) {
        this.attdend = attdend;
    }

    public Date getAdate() {
        return adate;
    }

    public void setAdate(Date adate) {
        this.adate = adate;
    }
       
}
