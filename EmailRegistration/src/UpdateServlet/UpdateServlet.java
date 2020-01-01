package UpdateServlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.EmailBean;

import EmailDAO.DaoClass;
import EmailDAO.DaoInterface;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("***********In Update Servlet get method********************");
		response.getWriter().append("Served at: ").append(request.getContextPath());		
		int id=Integer.parseInt(request.getParameter("id"));
		String email=request.getParameter("Email");
		String Password=request.getParameter("psw");
		
		EmailBean EB =new EmailBean();
		EB.setId(id);
		EB.setEmail(email);
		EB.setPassword(Password);
		
		System.out.println("%5%%%%%%%%%%%%%% after in update get method%%%%%%%%%%%%%%");
		DaoInterface D = new DaoClass();
			int s = 0;
		s= D.Update(EB);
		if(s > 0)
		{
			RequestDispatcher rd= request.getRequestDispatcher("ViewTable.jsp");
			rd.forward(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("ViewTable.jsp");
			rd.forward(request, response);
		}
		
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
