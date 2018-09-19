package kr.it.edu.bordmvc.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.it.edu.bordmvc.ActionForward;
import kr.it.edu.bordmvc.BoardVO;
import kr.it.edu.bordmvc.common.Utils;
import kr.it.edu.bordmvc.common.Var;
import kr.it.edu.bordmvc.service.BoardListService;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);
		
		BoardListService service = new BoardListService();
		int btype = Utils.getParamInt(request.getParameter("btype"));
		ArrayList<BoardVO> data = service.getBoardList(btype);
		request.setAttribute("title", Var.TITLES[btype]);
		request.setAttribute("content", "boardList");
		request.setAttribute("btype", btype);
		request.setAttribute("data", data);

		return forward;
	}

}
