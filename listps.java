
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
@WebServlet("/listps")
public class listps extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listps() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			{
				System.out.println();
				String dbUrl = "jdbc:mysql://localhost:3306/test";
				String dbClass = "com.mysql.jdbc.Driver";
				String query2 = "select * from add_policestation_form";
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
				
				
				// int i1=stmt.executeUpdate("insert into hcss(username,password) values('"+log+"','"+s+"')");
				ResultSet rs = stmt.executeQuery(query2); 
				int rowCount = 0;
				PrintWriter out = response.getWriter();

				 out.println("<P ALIGN='center'><TABLE BORDER=1>");
				 java.sql.ResultSetMetaData rsmd = rs.getMetaData();
				 int columnCount = rsmd.getColumnCount();
				 // table header
				 out.println("<TR>");
				 for (int i = 0; i < columnCount; i++) {
				   out.println("<TH>" + rsmd.getColumnLabel(i + 1) + "</TH>");
				   }
				 out.println("</TR>");
				 // the data
				 while (rs.next()) {
				  rowCount++;
				  out.println("<TR>");
				  for (int i = 0; i < columnCount; i++) {
				    out.println("<TD>" + rs.getString(i + 1) + "</TD>");
				    }
				  out.println("</TR>");
				  }
				 out.println("</TABLE></P>");
				// return rowCount;
				
				//System.out.println(rs1);
				//System.out.println(i);
				//while (rs1.next()) {
				//System.out.println(rs1.getString("username")+ " "+ rs1.getString("password"));
				 //end while

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
			
	

