import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
@WebServlet("/demo")
public class demo extends HttpServlet {
    private static final long serialVersionUID = 1L;
         
 
  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
        response.setContentType("text/html");
          
        PrintWriter out = response.getWriter();
        String name= request.getParameter("Name");
        out.println("Welcome:"+name);
        String gender= request.getParameter("Gender");
        String nationality= request.getParameter("Nationality");
        String query="INSERT INTO register(Name,Gender,Nation) values('"+name+"','"+gender+"','"+nationality+"')";
        try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
	        Statement stmt=con.createStatement();
	        int res=stmt.executeUpdate(query);
	        ResultSet rs=stmt.executeQuery("SELECT * FROM register");
	        con.close();
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }
}