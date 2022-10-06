package ddit.fileupload.service;

import java.util.List;

import ddit.fileupload.dao.FileInfoDaoImpl;
import ddit.fileupload.dao.IFileInfoDao;
import ddit.vo.FileInfoVO;

public class FileInfoServiceImpl implements IFileInfoService {
	private IFileInfoDao dao;
	private static IFileInfoService service;
	private FileInfoServiceImpl() {
		dao = FileInfoDaoImpl.getInstance();
	}
	
	public static IFileInfoService getInstance() {
		if(service==null) service = new FileInfoServiceImpl();
		return service;
	}
	
	
	@Override
	public int insertFileInfo(FileInfoVO fileinfoVo) {
		return dao.insertFileInfo(fileinfoVo);
	}

	@Override
	public List<FileInfoVO> getAllFileInfo() {
		return dao.getAllFileInfo();
	}

	@Override
	public FileInfoVO getFileInfo(int fileNo) {
		return dao.getFileInfo(fileNo);
	}

}
