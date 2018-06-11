package servlet;

import java.io.IOException;
import java.util.ArrayList;
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
import model.User;
import model.UserLoginLogic;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//index.jspからPOST、loginResult.jspへフォワード

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		User u = new User(name, pass);
		UserLoginLogic ulLogic = new UserLoginLogic();
		boolean isLogin = ulLogic.execute(u);

		if(isLogin) {
			HttpSession session = request.getSession();
			session.setAttribute("u", u);
		}

		RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/loginResult.jsp");
		d.forward(request, response);

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//loginResult.jspからGET、main.jspへフォワード

		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("u");

		if(u == null) {
			//ログインしていない場合

			response.sendRedirect("/twitter-like/");
		}
		else {
			//ログインしている場合

			ServletContext application = this.getServletContext();
			@SuppressWarnings("unchecked")
			List<Twitter> tList = (List<Twitter>) application.getAttribute("tList");
			if(tList == null) {
				tList = new ArrayList<Twitter>();
				application.setAttribute("tList", tList);
			}

			RequestDispatcher d = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			d.forward(request, response);
		}

	}
}
