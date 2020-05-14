package jp.sample1.com;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.bean.com.ResBean;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//ブラウザーからの送信をPOSTにて受け取る

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
//		ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
		//		問い合わせ内容の内容が入っているか判断
		//		内容がないときは、そのまま返す
		if (name.length() == 0 || title.length() == 0 || contents.length() == 0) {
			response.sendRedirect("Stady/aaa.jsp");
			//	ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
//			
			//Reslistで作成された内容をセッションにて送り保存する
			//			セッションに送った内容を表示する
		} else {
			List<ResBean> list = ResList.getInstance(name, title, contents);
			HttpSession session = request.getSession(true);
			session.setAttribute("list", list);
			response.sendRedirect("Stady/aaa.jsp");
		}
	}

}
