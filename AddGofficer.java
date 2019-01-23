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
@WebServlet("/AddGofficer")
public class AddGofficer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGofficer() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			{	PrintWriter out=response.getWriter();
		
				String us = request.getParameter("user_id");
				String na=request.getParameter("name");
				String mo = request.getParameter("mobile_no");
				String ad = request.getParameter("address");
				String em = request.getParameter("e_mail");
				String po = request.getParameter("post");
				String de = request.getParameter("department");
				System.out.println();
				String dbUrl = "jdbc:mysql://localhost:3306/test";
				String dbClass = "com.mysql.jdbc.Driver";
				String query2 = "select * from add_government_officer";
				try {
				Class.forName(dbClass);
				Connection con = DriverManager.getConnection (dbUrl);
				if(con == null)
					out.println("error");
				Statement stmt = con.createStatement();
					      int i=stmt.executeUpdate("insert into add_government_officer(user_id,name,mobile_no,address,e_mail,post,department) values('"+us+"','"+na+"','"+mo+"','"+ad+"','"+em+"','"+po+"','"+de+"')");
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
			
	

