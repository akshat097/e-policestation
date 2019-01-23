import java.sql.*;
import java.util.Date;
import java.util.UUID;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class log
 */
@WebServlet("/hireD")
public class hireD extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public hireD() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			{	PrintWriter out=response.getWriter();
		
				String na = request.getParameter("id");
				String fn=request.getParameter("purpose");
			
				try {
					
					Connection conn = null;
					  String url = "jdbc:mysql://localhost:3306/";
					  String dbName = "test";
					  String driver = "com.mysql.jdbc.Driver";
					  String query2="select * from add_detective_form";
					//  String strQuery = "select * from image_tab";
					  
					  Class.forName(driver).newInstance();
						java.sql.Connection  con = DriverManager.getConnection(url+dbName);
						  java.sql.PreparedStatement st = null;
						  Statement stmt = con.createStatement();

						  
						  int k=0;
							// int i1=stmt.executeUpdate("insert into hcss(username,password) values('"+log+"','"+s+"')");
							ResultSet rs = stmt.executeQuery(query2);
							while (rs.next()) {
					             if ((na.equals(rs.getString("detective_id")))) {
					            	  st = con.prepareStatement("insert into hire_detective(requested_id,purpose) values('"+na+"','"+fn+"')");
									  
									  int i = st.executeUpdate();
									  
									  System.out.println("Query Executed Successfully++++++++++++++");
									  k=-1;
							 break;
							 // the data
					             }
					             else
					            k++;	 }
						
							if(k>0)
						 {response.sendRedirect("misshireD.jsp");}
							else
								response.sendRedirect("fsuccess.jsp");	
						  st.close();
						  con.close();
					}
					catch (Exception e){
						e.printStackTrace();
						}

					
				}
			}}