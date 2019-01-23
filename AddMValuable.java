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
@WebServlet("/AddMValuable")
public class AddMValuable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMValuable() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			{	PrintWriter out=response.getWriter();
			    String  uid  = request.getParameter("user_id");
				String na = request.getParameter("name");
				String add=  request.getParameter("address");
				String cn = request.getParameter("contact_no");
				String st = request.getParameter("state");
				String ci = request.getParameter("city");
				String it = request.getParameter("item");
				String loc = request.getParameter("loc");
				String date = request.getParameter("date");
				
				
				
				
				System.out.println();
				String dbUrl = "jdbc:mysql://localhost:3306/test";
				String dbClass = "com.mysql.jdbc.Driver";
				String query2 = "select * from  missing_valuable_form1";
				String query = "select * from user_login";
				try {
				Class.forName(dbClass);
				Connection con = DriverManager.getConnection (dbUrl);
				if(con == null)
					out.println("error");
				
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				int k = 0;
				try
				{
					while(rs.next()) {
						if((uid.equals(rs.getString("user_id"))))
							k--;
					}}
					catch(SQLException e1){
					e1.printStackTrace();}
				
				if (k==0)
					response.sendRedirect("response2.jsp");
				else
				{
					      int i=stmt.executeUpdate("insert into missing_valuable_form1(user_id,name,address,contact_no,state,city,loc,date,status,item) values('"+uid+"','"+na+"','"+add+"','"+cn+"','"+st+"','"+ci+"','"+loc+"','"+date+"','missing','"+it+"')");
				ResultSet rs1 = stmt.executeQuery(query2); 
				System.out.println(rs1);
				System.out.println(i);
				response.sendRedirect("fsuccess.jsp");
				
				con.close();
				} //end try

				}

				catch(SQLException e) {
				e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			}	
		}

			
	

