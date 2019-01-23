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
@WebServlet("/AddGC")
public class AddGC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddGC() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			{	PrintWriter out=response.getWriter();
			HttpSession session3 = request.getSession();

				String us = request.getParameter("user_id");
				String na = request.getParameter("name");
				String co=request.getParameter("complaint");
				String cn=request.getParameter("cn");
				int maximum=1000000;
				int minimum=1000;
				int randomNum = minimum + (int)(Math.random()*maximum);
			    Integer cn1=new Integer(randomNum);
				 session3.setAttribute("rn",cn1);
				System.out.println();
				String dbUrl = "jdbc:mysql://localhost:3306/test";
				String dbClass = "com.mysql.jdbc.Driver";
				String query2 = "select * from add_general_complaint";
				String query = "select * from user_login";
			//	String query1 = "select * from add_general_complaint";
				try {
				Class.forName(dbClass);
				Connection con = DriverManager.getConnection (dbUrl);
				if(con == null)
					out.println("error");
				Statement stmt = con.createStatement();
				Statement stmt1 = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				ResultSet rs1 = stmt1.executeQuery(query2);
				int k = 0;
				int m = 0;
				try
				{
					while(rs.next()) {
			   if((us.equals(rs.getString("user_id"))))
							k++;
					}}
					catch(SQLException e1){
					e1.printStackTrace();}
				while(rs1.next()) {
					  if((cn1.equals(rs1.getString("complainno"))))
									m--;
							}
				System.out.println(m);
				
				if (k==0 || m<0)
					response.sendRedirect("gcresponse.jsp");
				else
				{
					      int i=stmt.executeUpdate("insert into add_general_complaint(user_id,name,complaint,status,complainno) values('"+us+"','"+na+"','"+co+"','pending','"+cn1+"')");
				//ResultSet rs2 = stmt.executeQuery(query2); 
				System.out.println(rs1);
				System.out.println(i);
				response.sendRedirect("csuccess.jsp");
				con.close();
				} //end try

				}

				catch(ClassNotFoundException e) {
				e.printStackTrace();
				}

				catch(SQLException e) {
				e.printStackTrace();
				}

			}
		}
}
			
	

