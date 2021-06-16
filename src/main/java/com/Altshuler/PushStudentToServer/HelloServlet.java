package com.Altshuler.PushStudentToServer;

import com.Altshuler.model.Student;
import com.Altshuler.util.ConnectorToDB;
import com.Altshuler.util.StudentsGenerator;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Students", value = "/Students")
public class HelloServlet extends HttpServlet {
    private static List<Student> studentList = new ArrayList<>();

    public void init() {
        List<Student> created = StudentsGenerator.generateStudents(10);
        ConnectorToDB.saveList(created);
        studentList = ConnectorToDB.getStudents();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        for (Student student: studentList) {
            out.println("<h1>" + student + "</h1>");
        }
        out.println("</body></html>");
    }

    public void destroy() {
    }
}