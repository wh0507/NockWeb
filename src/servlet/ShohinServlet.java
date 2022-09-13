package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sogo.ShohinBean;
import sogo.ShohinDAO;

/**
 * Servlet implementation class ShohinServlet
 */
@WebServlet("/ShohinServlet")
public class ShohinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストパラメータ取得
//		request.setCharacterEncoding("UTF-8");
//		String id = request.getParameter("id");
//		String name = request.getParameter("name");
//		String kakaku = request.getParameter("kakaku");

		//入力値をプロパティに設定
//		ShohinBean shBean = new ShohinBean();
//		shBean.setId(id);
//		shBean.setName(name);
//		shBean.setKakaku(Integer.parseInt(kakaku));

		//HttpSessionインスタンス取得
		HttpSession session = request.getSession();

		//セッションスコープからインスタンスを取得
		ShohinBean shBean = (ShohinBean) session.getAttribute("shBean");

		//DBへ保存
		ShohinDAO shDao = new ShohinDAO();
		int result = shDao.insert(shBean.getId(),shBean.getName(),shBean.getKakaku());

		if (result == 1) {
			String msg = "登録が完了しました";
			request.setAttribute("msg", msg);
			//結果画面にフォワード
			String forwardPath = "./web/jsp/mod.jsp?no=3";
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
		} else {

		}

	}

}
