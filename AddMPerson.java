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
@WebServlet("/AddMPerson")
public class AddMPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMPerson() {
        super();
        // TODO Auto-generated constructor stub
    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			{	PrintWriter out=response.getWriter();
			    String  uid  = request.getParameter("user_id");
				String na = request.getParameter("name");
				String fn=  request.getParameter("Fname");
				String mt = request.getParameter("Mtime");
				String lp = request.getParameter("Last");
				String si = request.getParameter("Sign");
				String cn = request.getParameter("Contactno");
				String dom = request.getParameter("dom");
				
				
				
				
				System.out.println();
				String dbUrl = "jdbc:mysql://localhost:3306/test";
				String dbClass = "com.mysql.jdbc.Driver";
				String query2 = "select * from add_missing_person";
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
					response.sendRedirect("response1.jsp");
				else
				{
					      int i=stmt.executeUpdate("insert into add_missing_person(missing_person_name,fathers_name,missing_time,last_place,any_sign_for_missing_person,contact_number,user_id,status,date) values('"+na+"','"+fn+"','"+mt+"','"+lp+"','"+si+"','"+cn+"','"+uid+"','missing','"+dom+"')");
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

			
	

