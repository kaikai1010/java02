package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Twitter;
import model.TwitterPostLogic;
import model.User;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//main.jspからGET、logout.jspにフォワード

		HttpSession session = request.getSession();
		session.invalidate();

		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/logout.jsp");
		d.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//main.jspからPOST、main.jspにフォワード

		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");

		if(text == null || text.length() == 0) {
			String errorMsg = "つぶやきが入力されていません。";
			request.setAttribute("errorMsg", errorMsg);
		}
		else {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("u");
		String twitterName = u.getName();

		Twitter t = new Twitter(twitterName, text);

		ServletContext application = this.getServletContext();
		@SuppressWarnings("unchecked")
		List<Twitter> tList = (List<Twitter>) application.getAttribute("tList");

		TwitterPostLogic tpLogic = new TwitterPostLogic();
		tpLogic.execute(tList, t);

		application.setAttribute("tList", tList);
		}

		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		d.forward(request, response);

	}
}
