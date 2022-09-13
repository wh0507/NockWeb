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

@WebServlet("/ControlServlet")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//		String action = request.getParameter("action");

		//リクエストパラメータ取得
		request.setCharacterEncoding("UTF-8");
//		String no = request.getParameter("no");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String kakaku = request.getParameter("kakaku");

		//入力値をプロパティに設定
		ShohinBean shBean = new ShohinBean();
		shBean.setId(id);
		shBean.setName(name);
		shBean.setKakaku(Integer.parseInt(kakaku));

		//HttpSessionインスタンス取得
		HttpSession session = request.getSession();
		//セッションスコープにインスタンスを保存
		session.setAttribute("shBean", shBean);
		//セッションスコープからインスタンスを取得
		ShohinBean s = (ShohinBean) session.getAttribute("shBean");

		if (id != null && id.length() != 0) {
			//確認画面にフォワード
			String forwardPath = "./web/jsp/kakunin.jsp?no=3";
			RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
			dispatcher.forward(request, response);
		} else {

		}

//		//DBへ登録
//		ShohinDAO shDao = new ShohinDAO();
//		shDao.insert(shBean.getId(), shBean.getName(), shBean.getKakaku());

	}

}
