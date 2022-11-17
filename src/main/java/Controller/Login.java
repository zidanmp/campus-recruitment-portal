package Controller;

import java.io.IOException;
import DAO.*;
import Model.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;	

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("admin")!=null)
		{
			String username=request.getParameter("username");
			String password=request.getParameter("password");
			if(username.equals("admin") && password.equals("admin123"))
			{
				HttpSession session=request.getSession();
				session.setAttribute("username", username);
				RequestDispatcher rd=request.getRequestDispatcher("adminhome.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "User name or pasword is not correct");
				RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
				rd.forward(request, response);
			}
		}
		if(request.getParameter("student")!=null)
		{
			String usn=request.getParameter("usn");
			String password=request.getParameter("password");
			String succ=Dao.loginStudent(usn,password);
			if(succ==null)
			{
					request.setAttribute("msg", "USN or pasword is not correct");
					RequestDispatcher rd=request.getRequestDispatcher("studentlogin.jsp");
					rd.forward(request, response);
			}
			else if(succ.equals("true"))
			{
				HttpSession session=request.getSession();
				session.setAttribute("username", usn);
				RequestDispatcher rd=request.getRequestDispatcher("studenthome.jsp");
				rd.forward(request, response);
			}
			else if(succ.equals("not_approved"))
			{
				request.setAttribute("msg", "Your registration request is not yet approved");
				RequestDispatcher rd=request.getRequestDispatcher("studentlogin.jsp");
				rd.forward(request, response);
			}
		}
		if(request.getParameter("forgot")!=null)
		{
			if(request.getParameter("ans")==null)
			{
				String ques=Dao.getQuestion(request.getParameter("usn"));
				if(ques!=null)
				{
					request.setAttribute("ques", ques);
				}
				else {
					request.setAttribute("msg", "Enter a proper USN");
				}
			}
			else
			{
				String password=Dao.getPassword(request.getParameter("usn"), request.getParameter("ans"));
				if(password!=null)
				{
					request.setAttribute("password", password);
				}
				else
				{
					request.setAttribute("msg", "Security answer is not matching");
				}
			}
			RequestDispatcher rd=request.getRequestDispatcher("forgotpassword.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("register")!=null)
		{
			Students register=new Students(request.getParameter("usn"),request.getParameter("name"),request.getParameter("email"),Long.parseLong(request.getParameter("phone")),request.getParameter("dept"),Float.parseFloat(request.getParameter("cgpa")),request.getParameter("password"),request.getParameter("squestion"),request.getParameter("sanswer"),"b",null,0);
			if(Dao.registerStudent(register))
			{
				request.setAttribute("msgg", "Your registration request is sent to TPO and you can login if it is approved.");
				RequestDispatcher rd=request.getRequestDispatcher("studentlogin.jsp");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("msg", "You have already registered with the given USN. Please Login.");
				RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
				rd.forward(request, response);
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
