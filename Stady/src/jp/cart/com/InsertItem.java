package jp.cart.com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertItem
 */
public class InsertItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		String item = request.getParameter("item");

//		cookieを取得
		   Cookie cookies[] = request.getCookies();
		    Cookie targetCookie = null;

//		   //カートが空かどうか（Cookieが存在するかどうか）
//		    cookie内でitemがないかを調べて、なければtargetcookieに入れる
		    if (cookies != null) {
		        for (int i = 0; i < cookies.length; i++) {
		            if (cookies[i].getName().equals("item")) {
		                targetCookie = cookies[i];
		            }
		        }
		    }

		    //カートが空かどうか（指定された名前が存在するかどうか）
//		    itemがカート内に入っているかを判断する
//		    targetcookie内にitemがないときはitemを作成しいれる（重複防止）
		    if (targetCookie == null) {
		        targetCookie = new Cookie("item", item);

//		        もしある場合はカートの中に購入済か見る
//		        購入済ではないときは選択されたitemの商品をカートに入れる
		    } else {
		        String stringCookie = targetCookie.getValue();
		        //商品がカートに挿入済みかどうか
		        if (stringCookie.length() == 0) {
		            stringCookie = item;
		        } else {
		            String[] pieces = stringCookie.split(",");
		            boolean duplication = false;
		            for (int i = 0; i < pieces.length; i++) {
		                if(pieces[i].equals(item)) {
		                    duplication = true;
		                    break;
		                }
		            }

		            //選択された商品がカートにない場合
		            if (!duplication) {
		                stringCookie += "," + item;
		            }
		        }
		        targetCookie.setValue(stringCookie);
		    }

		    response.addCookie(targetCookie);
		    response.sendRedirect("/Stady/cart.jsp");
		}

//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
