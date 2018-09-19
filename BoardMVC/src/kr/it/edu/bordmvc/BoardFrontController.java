package kr.it.edu.bordmvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.it.edu.bordmvc.action.Action;
import kr.it.edu.bordmvc.action.BoardListAction;

@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {

	protected void doproc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String reqURI = request.getRequestURI();
		String ctxpath = request.getContextPath();
		String comd = reqURI.substring(ctxpath.length());
		ActionForward forward = null;
		Action action = null;
		if (comd.equals("/boardList.bo")) {
			action = new BoardListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (comd.equals("/boardDetail.bo")) {

		}

		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher rd = request.getRequestDispatcher(forward.getPath());
				rd.forward(request, response);
			}

		} else {
			// todo 없는 주소값 에러페이지 디스플레이 처리
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doproc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doproc(request, response);

	}

}
