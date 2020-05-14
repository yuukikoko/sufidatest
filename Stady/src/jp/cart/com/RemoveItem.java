package jp.cart.com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RemoveItem
 */
public class RemoveItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		   request.setCharacterEncoding("UTF-8");
		    String item = request.getParameter("item");

		    Cookie cookies[] = request.getCookies();
		    Cookie targetCookie = null;
		    for (int i = 0; i < cookies.length; i++) {
		        if (cookies[i].getName().equals("item")) {
		            targetCookie = cookies[i];
		        }
		    }
		    //選択された商品を削除
		    String stringCookie = targetCookie.getValue();
		    stringCookie += ",";
		    stringCookie = stringCookie.replace(item + ",", "");
		    if (stringCookie.length() != 0) {
		        stringCookie = stringCookie.substring(0, stringCookie.length() - 1);
		    }
		    targetCookie.setValue(stringCookie);
		    response.addCookie(targetCookie);

		    response.sendRedirect("/Stady/cart.jsp");
		}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
