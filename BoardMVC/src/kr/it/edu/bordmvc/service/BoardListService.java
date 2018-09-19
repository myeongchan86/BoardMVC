package kr.it.edu.bordmvc.service;

import java.util.ArrayList;

import kr.it.edu.bordmvc.BoardVO;
import kr.it.edu.bordmvc.common.BoardDAO;

public class BoardListService {

	public ArrayList<BoardVO> getBoardList(int btype) {
		ArrayList<BoardVO> result = null;
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.getBoardList(btype);

		for (BoardVO vo : result) {
			System.out.printf("bid :%d\n", vo.getBid());
			System.out.printf("bittle :%s\n", vo.getBtitle());
			System.out.printf("bcontent :%s\n", vo.getBcontent());
			System.out.printf("bregdate:%s\n", vo.getBregdate());
			System.out.println("-------------");
		}

		return result;
	}

}
