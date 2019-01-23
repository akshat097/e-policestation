
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.UUID;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import com.mysql.jdbc.ResultSetMetaData;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginsrv
 */
@WebServlet("/userstatus")
public class userstatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userstatus() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			{   HttpSession session3 = request.getSession();
				System.out.println();
				String name=request.getParameter("name");
				String uid = (String)session3.getAttribute("username");
				String dbUrl = "jdbc:mysql://localhost:3306/test";
				String dbClass = "com.mysql.jdbc.Driver";
				String query2 = "select * from add_missing_person ";
				String status;
				try {
				Class.forName(dbClass);
				Connection con = DriverManager.getConnection (dbUrl);
				Statement stmt = con.createStatement();
			//	 String s = null;
		      //   try {
				//	s=shatest.SHA1(passd);
			//	} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
				//	e.printStackTrace();
			//	}
				
				int k=0;
				// int i1=stmt.executeUpdate("insert into hcss(username,password) values('"+log+"','"+s+"')");
				ResultSet rs = stmt.executeQuery(query2);
				while (rs.next()) {
		             if ((name.equals(rs.getString("missing_person_name")) && uid.equals(rs.getString("user_id")))) {
				String s=rs.getString("status");
				int rowCount = 0;
				PrintWriter out = response.getWriter();

				 out.println("<P ALIGN='center'><TABLE BORDER=1>");
				 java.sql.ResultSetMetaData rsmd = rs.getMetaData();
				 int columnCount = rsmd.getColumnCount();
				 // table header
				 out.println("<TR>");
				// (int i = 0; i < columnCount; i++) {
				   out.println("<TH>" + s + "</TH>");
				   k=-1;
				   System.out.println(k);
				 out.println("</TR>");
				 break;
				 // the data
		             }
		             else
		            k++;	 }
				 System.out.println(k);
				if(k>0)
				{ response.sendRedirect("userstatusmiss.jsp");}
				con.close();
				} //end try

				catch(ClassNotFoundException e) {
				e.printStackTrace();
				}

				catch(SQLException e) {
				e.printStackTrace();
				}

			}
		}
}
			
	

