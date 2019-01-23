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
@WebServlet(name = "userlogin", urlPatterns = { "/userlogin" })


    
     public class userlogin extends HttpServlet {
	
	public userlogin() {
        super();
        // TODO Auto-generated constructor stub
    }
	 
	 
     
         protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, UnsupportedEncodingException {
		// TODO Auto-g9enerated method stub
        	 HttpSession session3 = request.getSession();
        	 session3.setMaxInactiveInterval(600);
        	 Connection conn = null;
        	 String pass = request.getParameter("password");
        	 String user = request.getParameter("user_id");
        	 session3.setAttribute("username",user);
        	// System.out.println(user);
        	 String username = (String)session3.getAttribute("username");
        	        	
        	 System.out.println(username);

        	 
			
    
      
         System.out.println(session3.getMaxInactiveInterval());
         try{
         Class.forName("com.mysql.jdbc.Driver");

         conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test");

         Statement stmt = conn.createStatement();
         String query = "SELECT * FROM user_login";

         ResultSet rs = stmt.executeQuery(query);
        
		int k=0;
                  while (rs.next()) {
             if (user.equals(rs.getString("user_id"))&& pass.equals(rs.getString("password")))
             {
                // String sessionID = UUID.randomUUID().toString();
                 //session.setAttribute("username", user);
                 //session.setAttribute("sessionID", sessionID);
                 k=-1;
             
                break;
                 
             }
             else if (user.equals("") || pass.equals("")) {
            		
            	 k++;
            	 
             }
             else {
            	
            	k++;
            	
            	}
         }
       
                  
                  if(k==-1)
                  {
                	  response.sendRedirect("aaaaaaaaaCitizenHome.jsp");
                  }
                  else
                	  {response.sendRedirect("response.jsp");}
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




         
       
