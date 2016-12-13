package texture.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import texture.dao.IStandDao;
import texture.dao.IUploadHistoryDao;
import texture.domain.Pagination;
import texture.domain.Stand;
import texture.domain.UploadHistory;
import texture.domain.User;
import texture.util.StrUtil;

/**
 * 冷却方法Service 实现
 * @author infodba
 *
 */
@Service
public class StandService implements IStandService{

	@Autowired
	private IStandDao standDao;
	
	@Autowired
	private IUploadHistoryDao uploadHistoryDao;
	
	@Override
	public Stand findStandById(String id) {
		return this.standDao.findStandById(id);
	}

	@Override
	public void saveStand(Stand stand) {
		this.standDao.saveStand(stand);
	}

	@Override
	public void delStandById(String id) {
		this.standDao.delStandById(id);
	}

	@Override
	public Pagination<Stand> getPageStand(int pageNo, int pageSize,
			Map<String, String> map) {
		return this.standDao.getPageStand(pageNo, pageSize, map);
	}

	@Override
	public List<Stand> findAllStand() {
		return this.standDao.findAllStand();
	}

	@Override
	public boolean checkStandByNameAndTexture(String id, String name,
			String texture) {
		Stand stand = this.standDao.checkStandByNameAndTexture(id, name, texture);
		if(stand!=null){
			return false;
		}
		return true;
	}

	@Override
	public void batchUpdateStand(List<Stand> newStands,User user) {
//			for (Stand stand : olds) {
//				this.standDao.removeStand(stand);
//			}
//		
//			for (Stand stand : newStands) {
//				this.standDao.saveStand(stand);
//			}
		
			for (Stand stand : newStands) {
				this.standDao.saveStand(stand);
			}

			//新增上传记录
			UploadHistory uploadHistory =new UploadHistory(null, user.getName(), user.getAccount(), StrUtil.getDateFormatCurrentTime(new Date()), "规范文件上传");
			this.uploadHistoryDao.insertUploadHistory(uploadHistory);
	}

	@Override
	public List<Stand> getStandsByTexture(String texture) {
		return this.standDao.getStandsByTexture(texture);
	}

	@Override
	public boolean batchUpdateStandName(String old_name, String new_name) {
		boolean b =true;
		List<Stand> stands = this.standDao.getStandsByName(old_name);
		
		if(stands.size()>0){
			//循环更新 规范名称
			for (Stand stand : stands) {
				stand.setName(new_name);
				this.standDao.saveStand(stand);
			}
		}else{
			//若无旧名称的规范，则返回false
			b=false;
		}
		return b;
	}



}
