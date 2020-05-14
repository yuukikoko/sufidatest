package jp.sample.com;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* Servlet implementation class Validator
*/
public class Sinnki extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request,
	 *                                                   HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String mail = request.getParameter("mail");
		String cellphoneNumber = request.getParameter("cellphoneNumber");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");

		//	チェックの中にある各変数(内容）をエラーメッセージと組み合わせる
		String[] errorMessages = check(name, password,mail, cellphoneNumber, gender, age);

		//		エラーがあるかの確認
		boolean isError = false;
		for (int i = 0; i < errorMessages.length; i++) {
			if (errorMessages[i] != null) {
				isError = true;
				break;
			}
		}
		//	エラーの時は登録ページに戻す
		if (isError) {
			request.setAttribute("errorMessages", errorMessages);
			String url = "/touroku.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			//		内容が正しいときは次のページに行く
		} else {
			String url = "/seiki.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
		}
	}

	//----------------------------------------------------------------------------------------------------
//	配列を6つ用意しエラー内容を入れていく
	private String[] check(String name, String password, String mail, String cellphoneNumber, String gender,String age ) {

		String[] errorMessages = new String[7];


        if (name.length() == 0) {
            errorMessages[0] = "名前が入力されていません。";
        }

        if (password.length() == 0) {
            errorMessages[1] = "パスワードが入力されていません。";
        } else{
            if (!(isMatch(password, "\\w{6,}") &&  isFind(password, "[a-z]") && isFind(password, "[0-9]"))) {
                errorMessages[1] = "パスワードが簡略すぎます。" +
                     "6文字以上でアルファベットのと小文字と数値を混用してください。";
            }
        }

        if (mail.length() == 0) {
            errorMessages[2] = "メールアドレスが入力されていません";

        if (cellphoneNumber.length() == 0) {
            errorMessages[3] = "携帯電話番号が入力されていません。";
        } else {
            if (!isMatch(cellphoneNumber, "\\d{3}\\-\\d{4}\\-\\d{4}")) {
                errorMessages[4] = "正しい携帯電話番号を入力してください。" +
                                       "xxx-xxxx-xxxxのようにハイフンを含めて入力してください。";
            }
        }

        if (gender == null) {
            errorMessages[5] = "性別が選択されていません。";
        }

        if (age.equals("none")) {
            errorMessages[6] = "年齢が選択されていません。";
        }

	}
		return errorMessages;

	}

//正規表現にて決めごと通りになっているかを確認する

	private boolean isMatch(String input, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		return m.matches();
	}

	private boolean isFind(String input, String regex) {
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(input);
		return m.find();
	}

}