package ddit.fileupload.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import ddit.vo.FileInfoVO;
import util.sqlMapClientFactory;

public class FileInfoDaoImpl implements IFileInfoDao {
	private SqlMapClient smc;
	
	private static IFileInfoDao dao;
	
	private FileInfoDaoImpl() {
		smc = sqlMapClientFactory.getSqlMapClient();
	}
	public static IFileInfoDao getInstance() {
		if(dao==null) dao = new FileInfoDaoImpl();
		return dao;
	}
	
	
	@Override
	public int insertFileInfo(FileInfoVO fileinfoVo) {
		int cnt = 0;
		try {
			Object obj = smc.insert("fileinfo.insertFileInfo", fileinfoVo);
			if(obj==null) cnt = 1;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	@Override
	public List<FileInfoVO> getAllFileInfo() {
		List<FileInfoVO> fileinfoList = null;
		
		try {
			fileinfoList = smc.queryForList("fileinfo.getAllFileInfo");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fileinfoList;
	}

	@Override
	public FileInfoVO getFileInfo(int fileNo) {
		FileInfoVO fileinfoVo = null;
		try {
			fileinfoVo = (FileInfoVO)smc.queryForObject("fileinfo.getFileInfo", fileNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fileinfoVo;
	}

}
