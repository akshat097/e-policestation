/**
	 * @param args
	 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.UUID;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "ngologin", urlPatterns = { "/ngologin" })


    
     public class ngologin extends HttpServlet {
	
	public ngologin() {
        super();
        // TODO Auto-generated constructor stub
    }
	 
	 
     
         protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UnsupportedEncodingException {
		// TODO Auto-g9enerated method stub
        	// HttpSession session = request.getSession();
        	 //session.setMaxInactiveInterval(60);
        	 Connection conn = null;
        	 String pass = request.getParameter("password");
        	 String user = request.getParameter("ngo_id");
        	 
        	        	
         	
        	 
			
    
      
      //   System.out.println(session.getMaxInactiveInterval());
         try{
         Class.forName("com.mysql.jdbc.Driver");

         conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test");

         Statement stmt = conn.createStatement();
         String query = "SELECT * FROM ngo_login";

         ResultSet rs = stmt.executeQuery(query);
        
		
                  while (rs.next()) {
             if ((user.equals(rs.getString("ngo_id")) && pass.equals(rs.getString("password")))) {
                // String sessionID = UUID.randomUUID().toString();
                 //session.setAttribute("username", user);
                 //session.setAttribute("sessionID", sessionID);
                 response.sendRedirect("aaaaaaaaaangohome.jsp");
             }
             else if (user.equals("") || pass.equals("")) {
            	 response.getWriter().println("Enter a username and password.");
             }
             else {
            	 response.getWriter().println("Either your username or password is incorrect or could not be found.");
            	 response.getWriter().println("Please try again, or click the link below to register.");
             }
         }
     }
         
     catch (ClassNotFoundException e) {
         System.err.println("Error loading driver: " + e);
         response.getWriter().println("<tr>Error loading driver: " + e + "</tr>");
     }
     catch (SQLException e) {
         System.err.println("Error with connection: " + e);
         response.getWriter().println("<tr>Error with connection: " + e + "</tr>");
     }
   
         
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

 }
          
}




         
       
