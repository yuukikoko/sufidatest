package jp.sample.com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Password
 */
public class Password extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//------------------------------------------------------------

	//	定数セット
	private String mail = "aaa";
	private String password = "aaa";
	//------------------------------------------------------------
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Password() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		request.setCharacterEncoding("UTF-8");

		String mail = request.getParameter("mail");
		String password = request.getParameter("password");

		//セッションの新規作成
		HttpSession session = request.getSession(true);

		//		入力された内容が正しいかを照合している
		if (this.mail.equals(mail) && this.password.equals(password)) {
			//内容が正しいとき
			session.setAttribute("status", "login");
			session.setAttribute("password", "password");
			response.sendRedirect("/Stady/Menbership.jsp");
			//			入力内容が間違いの時
		} else {
			session.setAttribute("status", "logout");
			response.sendRedirect("/Stady/login.jsp");
		}
	}

}
