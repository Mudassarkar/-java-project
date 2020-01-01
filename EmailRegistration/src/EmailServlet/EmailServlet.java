package EmailServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.EmailBean;

import EmailDAO.DaoClass;
import EmailDAO.DaoInterface;

/**
 * Servlet implementation class EmailServlet
 */
@WebServlet("/EmailServlet")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("********************* IN Get ***************");
		int id=Integer.parseInt(request.getParameter("id"));
		String email=request.getParameter("Email");
		String Password=request.getParameter("psw");
		
		EmailBean EB =new EmailBean();
		EB.setId(id);
		EB.setEmail(email);
		EB.setPassword(Password);
		
		
		DaoInterface D = new DaoClass();
		int i = 0;
		i=D.delete(id);
		System.out.println(i);
		RequestDispatcher r1;
		if(i> 0)
		{
			 r1= request.getRequestDispatcher("ViewTable.jsp");
			 r1.forward(request, response);
		}
		else
		{
			 r1 =request.getRequestDispatcher("ViewTable.jsp");
			 r1.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In Post *******************");
	
		System.out.println("again  In Post *******************");
		
		int id=Integer.parseInt(request.getParameter("id"));
		String email=request.getParameter("Email");
		String Password=request.getParameter("psw");
		
		EmailBean EB =new EmailBean();
		EB.setId(id);
		EB.setEmail(email);
		EB.setPassword(Password);
		System.out.println("ID: " +EB.getId());
		System.out.println("Email :" +EB.getEmail());
		System.out.println("Password :" +EB.getPassword());
		
		ServletContext sc = getServletContext();
		String Comp_name = sc.getInitParameter("Comp_Name");
		
		System.out.println(Comp_name);
		
		DaoInterface D = new DaoClass();
			int status = 0;
		status= D.insert(EB);
		if(status > 0)
		{
			RequestDispatcher rd= request.getRequestDispatcher("ViewTable.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("EmailReg.jsp");
			rd.forward(request, response);
		}
	
		
		
	}

}
