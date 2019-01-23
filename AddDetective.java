import java.sql.*;
import java.util.Date;
import java.util.UUID;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
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
@WebServlet("/AddDetective")
public class AddDetective extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDetective() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			{	PrintWriter out=response.getWriter();
		
				String id = request.getParameter("Detective_ID");
				String dn=request.getParameter("Detective_Name");
				String dm = request.getParameter("Detective_Mobile_No");
				String de = request.getParameter("Detective_Email");
				String dc = request.getParameter("Detective_Company");
				String dw = request.getParameter("Detective_Working_Area");
				
				System.out.println();
				String dbUrl = "jdbc:mysql://localhost:3306/test";
				String dbClass = "com.mysql.jdbc.Driver";
				String query2 = "select * from add_detective_form";
				try {
				Class.forName(dbClass);
				Connection con = DriverManager.getConnection (dbUrl);
				if(con == null)
					out.println("error");
				Statement stmt = con.createStatement();
					      int i=stmt.executeUpdate("insert into add_detective_form(detective_id,detective_name,detective_mobile_no,detective_email,detective_company,detective_working_area) values('"+id+"','"+dn+"','"+dm+"','"+de+"','"+dc+"','"+dw+"')");
				ResultSet rs1 = stmt.executeQuery(query2); 
				System.out.println(rs1);
				System.out.println(i);
				response.sendRedirect("psuccess.jsp");
				while (rs1.next()) {
			//	System.out.println(rs1.getString("username")+ " "+ rs1.getString("password"));
				} //end while

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
			
	

