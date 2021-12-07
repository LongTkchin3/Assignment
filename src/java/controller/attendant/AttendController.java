/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.attendant;

import dal.AttendantDBContext;
import dal.ClassDBContext;
import dal.StudentDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Attendant;
import model.Class;
import model.Slot;
import model.Student;

/**
 *
 * @author Admin
 */
public class AttendController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AttendController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AttendController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int cid = Integer.parseInt(request.getParameter("cid"));
        int slot_id = Integer.parseInt(request.getParameter("slot_id"));
        Class c = new Class();
        c.setCid(cid);
        Student s = new Student();
        s.setCid(c);        
        ArrayList<Student> lst = sdb.listStudent(s);
        request.setAttribute("student", lst);
        request.setAttribute("slot_id", slot_id);
        request.getRequestDispatcher("test2.jsp").forward(request, response);
    }
    ClassDBContext cdb = new ClassDBContext();
    StudentDBContext sdb = new StudentDBContext();
    AttendantDBContext adb = new AttendantDBContext();

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Attendant> lst = new ArrayList<>();
        String[] sid = request.getParameterValues("sid");
        for (String id : sid) {
            Attendant a=new Attendant();
            Student s = new Student();
            s.setSid(id);
            a.setSid(s);
            a.setAdate(Date.valueOf(request.getParameter("adate"+id)));
            String attend_raw= request.getParameter("attend"+id);
            a.setAttdend(attend_raw!=null);
            Slot slot = new Slot();
            slot.setSlot_id(Integer.parseInt(request.getParameter("slot_id")));
            a.setSlot(slot);
            lst.add(a);
        }
        adb.takeAttendance(lst);
        response.getWriter().println("done");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
