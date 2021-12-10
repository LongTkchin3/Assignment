/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.table;

import dal.SlotDBContext;
import dal.TableDBContext;
import dal.TeacherDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Slot;
import model.Table;
import model.Teacher;

/**
 *
 * @author Admin
 */
public class ListController extends HttpServlet {

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
            out.println("<title>Servlet GetClassController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GetClassController at " + request.getContextPath() + "</h1>");
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
        ArrayList<Teacher> teachers = teacherdb.list();
        request.setAttribute("teachers", teachers);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
    TeacherDBContext teacherdb = new TeacherDBContext();
    TableDBContext tdb = new TableDBContext();
    SlotDBContext sdb = new SlotDBContext();
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
        String tid = request.getParameter("tid");
        request.getSession().setAttribute("tid", tid);
        ArrayList<Table> table = tdb.getClass(tid);
        for (Table t : table) {
        Calendar cal = Calendar.getInstance();
        cal.set(t.getCdate().getYear()+1, t.getCdate().getMonth(),t.getCdate().getDay());
        DateFormat formatter = new SimpleDateFormat("EEEE", Locale.getDefault());
        t.setDow(formatter.format(cal.getTime()));
        }
        request.setAttribute("class", table);
        ArrayList<Slot> slot = sdb.list(); 
        request.setAttribute("slot", slot);  
        request.getRequestDispatcher("list.jsp").forward(request, response);
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
