package kr.it.edu.bordmvc.common;

import static kr.it.edu.bordmvc.common.DBConnection.close;
import static kr.it.edu.bordmvc.common.DBConnection.getConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.it.edu.bordmvc.BoardVO;

public class BoardDAO {

	private static BoardDAO dao;

	private BoardDAO() {
	} // private 생성자

	public static BoardDAO getInstance() { // 싱글톤 패턴
		if (dao == null) {
			dao = new BoardDAO();

		}
		return dao;
	}

	public ArrayList<BoardVO> getBoardList(int btype) {
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String query = " select bid, btitle, to_char(bregdate,'YYYY-MM-DD hh24:mi')as bregdate from t_board" + btype
				+ "ORDER BY bid desc";

		try {
			con = getConn();
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();

			while (rs.next()) {
				int bid = rs.getInt("bid");
				String btitle = rs.getString("btitle");
				String bregdate = rs.getString("bregdate");

				BoardVO bv = new BoardVO();
				bv.setBid(bid);
				bv.setBtitle(btitle);
				bv.setBregdate(bregdate);
				result.add(bv);

			}

		} catch (SQLException e) {

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			close(con, ps, rs);
		}

		return result;
	}

}