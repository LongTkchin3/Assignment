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
        private Student student;
        private boolean attend;
        private Date adate;
        private Slot slot;

    public Attendant() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isAttend() {
        return attend;
    }

    public void setAttend(boolean attdend) {
        this.attend = attdend;
    }

    public Date getAdate() {
        return adate;
    }

    public void setAdate(Date adate) {
        this.adate = adate;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
       
}
