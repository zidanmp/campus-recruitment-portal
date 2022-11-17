package Controller;

import java.io.IOException;
import java.util.ArrayList;

import DAO.Dao;
import Model.Students;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FetchRequests")
public class FetchRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Students> requests;
		requests=Dao.fetchRequests();
		if(requests!=null) {
		if(!requests.isEmpty())
		{
			request.setAttribute("requests", requests);
		}
		}
		RequestDispatcher rd=request.getRequestDispatcher("registrationrequests.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
