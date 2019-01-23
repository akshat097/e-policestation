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
@WebServlet("/ CComplain")
public class CComplain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CComplain() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			{	PrintWriter out=response.getWriter();
		
				String na = request.getParameter("name");
				String fn=request.getParameter("information");
				
				System.out.println();
				String dbUrl = "jdbc:mysql://localhost:3306/test";
				String dbClass = "com.mysql.jdbc.Driver";
				String query2 = "select * from CComplain ";
				try {
				Class.forName(dbClass);
				Connection con = DriverManager.getConnection (dbUrl);
				if(con == null)
					out.println("error");
				
				response.sendRedirect("fsuccess.jsp");
				
					while (rs1.next()) {
				Statement stmt = con.createStatement();
					      int i=stmt.executeUpdate("insert into CComplain(name,information) values('"+na+"','"+fn+"')");
				ResultSet rs1 = stmt.executeQuery(query2); 
				System.out.println(rs1);
				System.out.println(i);
				
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
			
	

