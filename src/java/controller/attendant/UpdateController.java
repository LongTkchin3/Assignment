/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.attendant;

import dal.AttendantDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Attendant;
import model.Student;
import model.Table;
import model.Class;
import model.Slot;

/**
 *
 * @author Admin
 */
public class UpdateController extends HttpServlet {

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
            out.println("<title>Servlet UpdateController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateController at " + request.getContextPath() + "</h1>");
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
        Table table = (Table)request.getSession().getAttribute("table");
        Attendant a = new Attendant();
        a.setAdate(table.getCdate());
        a.setSlot(table.getSlot());       
        Class c = new Class();
        c.setCid(table.getClassroom().getCid());
        Student s = new Student();
        s.setClassroom(c);
        a.setStudent(s);
        ArrayList<Attendant> att = adb.getAttend(a);
        request.setAttribute("att",att);
        request.getRequestDispatcher("udetail.jsp").forward(request, response);
    }
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
            Attendant a = new Attendant();
            Student s = new Student();
            s.setSid(id);
            a.setStudent(s);
            a.setAdate(Date.valueOf(request.getParameter("adate" + id)));
            String attend_raw = request.getParameter("attend" + id);
            a.setAttend(attend_raw != null);
            Slot slot = new Slot();
            slot.setSlot_id(request.getParameter("slot_id")==null?(-1):Integer.parseInt(request.getParameter("slot_id")));
            a.setSlot(slot);
            lst.add(a);
        }
        adb.update(lst);
        response.sendRedirect("list");
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
