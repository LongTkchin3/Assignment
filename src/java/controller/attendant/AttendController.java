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
import model.Table;

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
        Table table = (Table) request.getSession().getAttribute("table");
        Class c = new Class();
        c.setCid(table.getClassroom().getCid());
        Student s = new Student();
        s.setClassroom(c);
        ArrayList<Student> students = sdb.listStudent(s);
        request.setAttribute("student", students);
        request.getRequestDispatcher("attend.jsp").forward(request, response);
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
        Table t = (Table) request.getSession().getAttribute("table");
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
            slot.setSlot_id(Integer.parseInt(request.getParameter("slot_id")));
            a.setSlot(slot);
            lst.add(a);
        }
        if (request.getParameterValues("index") != null) {
            String[] indexs = request.getParameterValues("index");
            for (String index : indexs) {
                Attendant a = new Attendant();
                Student student = new Student();
                student.setSid(request.getParameter("sid" + index));
                student.setSname(request.getParameter("sname" + index));
                Student stu = sdb.get(student);
                if (stu != null) {
                    request.setAttribute("msg", "StudentID(MSSV) doesn't exsit.Please add student before take attendance!");
                    Table table = (Table) request.getSession().getAttribute("table");
                    Class c = new Class();
                    c.setCid(table.getClassroom().getCid());
                    Student s = new Student();
                    s.setClassroom(c);
                    ArrayList<Student> students = sdb.listStudent(s);
                    request.setAttribute("student", students);
                    request.getRequestDispatcher("attend.jsp").forward(request, response);
                }
                a.setStudent(student);
                a.setAdate(Date.valueOf(request.getParameter("adate" + index)));
                String attend_raw = request.getParameter("attend" + index);
                a.setAttend(attend_raw != null);
                Slot slot = new Slot();
                slot.setSlot_id(Integer.parseInt(request.getParameter("slot_id")));
                a.setSlot(slot);
                lst.add(a);
            }
        }
        adb.takeAttendance(lst);
        ArrayList<String> check = adb.getAvailable(t);
        check.forEach((string) -> {
            Student s = new Student();
            String[] a = string.split("-");
            int x = Integer.parseInt(a[1]);
            if (x > 5) {
                s.setSid(a[0]);
                Student student = sdb.get(s);
                student.setAvailable(false);
                sdb.update(student);
            }
        });
        request.getRequestDispatcher("update.jsp").forward(request, response);
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
