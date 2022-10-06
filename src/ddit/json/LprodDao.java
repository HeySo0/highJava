package ddit.json;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import ddit.vo.LprodVO;
import util.sqlMapClientFactory;

public class LprodDao {
	private SqlMapClient smc;
	
	private static LprodDao dao;
	
	private LprodDao() {
		smc = sqlMapClientFactory.getSqlMapClient();
	}
	
	public static LprodDao getInstance() {
		if(dao==null) dao = new LprodDao();
		return dao;
	}
	
	public List<LprodVO> getAllLprod(){
		List<LprodVO> lprodList = null;
		
		try {
			lprodList = smc.queryForList("lprod.getAllLprod");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lprodList;
	}
	
}
