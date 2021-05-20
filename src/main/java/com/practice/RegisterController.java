package com.practice;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("starting");
		// TODO Auto-generated method stub
		String un1 = request.getParameter("un");
        String pw1 = request.getParameter("pw");
        String email=request.getParameter("emailid");
        String phone=request.getParameter("phone");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
// loads driver
            Connection c =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/meena", "root", "Sai@nc33qu"); // gets a new connection
            PreparedStatement ps = ((java.sql.Connection) c).prepareStatement("insert into register values(?,?,?,?)");
            ps.setString(1, un1);
            ps.setString(2,pw1);
            ps.setString(3,email);
            ps.setString(4, phone);
            System.out.println("inside update");
            int result=ps.executeUpdate();
            System.out.println("after result"+result);
            if(result!=0)
            {
            	response.sendRedirect("success.html");
            }
            else {
            	response.sendRedirect("error.html");
            }}
            catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
	}

}
