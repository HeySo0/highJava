package ddit.session;

import java.sql.SQLException;

import com.ibatis.sqlmap.client.SqlMapClient;

import ddit.vo.MemberVO;
import util.sqlMapClientFactory;

public class MemberDao {
	private SqlMapClient smc;
	   
	   private static MemberDao dao;
	   
	   private MemberDao() {
	      smc = sqlMapClientFactory.getSqlMapClient();
	   }
	   
	   public static MemberDao getInstance() {
	      if(dao==null) dao = new MemberDao();
	      return dao;
	   }
	   
	   
	   
	   /**
	    * 회원ID와 Password가 저장된 MemberVO객체를 인수값으로 받아서 해당 회원 정보를 반환하는 메서드
	    * @param memVo 검색할 회원ID와 Password가 저장된 MemberVO객체
	    * @return 검색성공 : 회원정보가 저장된 MemberVO객체, 검색실패 : null
	    */
	   public MemberVO getMember(MemberVO memVo) {
	      MemberVO loginMemberVo=null;
	      try {
	         loginMemberVo = (MemberVO) smc.queryForObject("member.getMember", memVo);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      return loginMemberVo;
	   }
}
