package texture.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import texture.dao.ITextureReportHistoryDao;
import texture.domain.Pagination;
import texture.domain.TextureReportHistory;

@Service
public class TextureReportHistoryService implements ITextureReportHistoryService{

	@Autowired
	private ITextureReportHistoryDao textureReportHistoryDao;
	
	@Override
	public void saveTextureReportHistory(
			TextureReportHistory textureReportHistory) {
		this.textureReportHistoryDao.saveTextureReportHistory(textureReportHistory);
	}

	@Override
	public TextureReportHistory findTextureReportHistoryById(String id) {
		return this.textureReportHistoryDao.findTextureReportHistoryById(id);
	}

	@Override
	public Pagination<TextureReportHistory> getPageTextureReportHistoryByConditions(
			int pageNo, int pageSize, Map<String, String> map,String beginDate,String endDate) {
		return this.textureReportHistoryDao.getPageTextureReportHistoryByConditions(pageNo, pageSize, map,beginDate,endDate);
	}

	@Override
	public void delTextureReportHistory(String id) {
		this.textureReportHistoryDao.delTextureReportHistory(id);
	}

	@Override
	public List<TextureReportHistory> findTextureReportHistoryByTextureReportId(
			String textureReportId) {
		return this.textureReportHistoryDao.findTextureReportHistoryByTextureReportId(textureReportId);
	}

	@Override
	public List<TextureReportHistory> getTextureReportHistoryByConditions(
			Map<String, String> map, String beginDate, String endDate) {
		return this.textureReportHistoryDao.getTextureReportHistoryByConditions(map, beginDate, endDate);
	}
	

}
