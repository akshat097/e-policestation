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
@WebServlet("/AddPstation")
public class AddPstation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPstation() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			{	PrintWriter out=response.getWriter();
		
				String us = request.getParameter("user_id");
				String sn=request.getParameter("station_name");
				String psa = request.getParameter("psa");
				String pn = request.getParameter("phone_no");
				String in = request.getParameter("iname");
				String inu = request.getParameter("inum");
				String em = request.getParameter("email");		
				System.out.println();
				String dbUrl = "jdbc:mysql://localhost:3306/test";
				String dbClass = "com.mysql.jdbc.Driver";
				String query2 = "select * from add_policestation_form";
				try {
				Class.forName(dbClass);
				Connection con = DriverManager.getConnection (dbUrl);
				if(con == null)
					out.println("error");
				Statement stmt = con.createStatement();
					      int i=stmt.executeUpdate("insert into add_policestation_form (policestation_id,policestation_name,policestation_address,policestation_phone_no,policestation_incharge_name,policestation_incharge_mobile_no,policestation_incharge_email) values('"+us+"','"+sn+"','"+psa+"','"+pn+"','"+in+"','"+inu+"','"+em+"')");
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
			
	

