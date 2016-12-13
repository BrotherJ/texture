package texture.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import texture.dao.IHardDao;
import texture.domain.Hard;
import texture.domain.Pagination;

@Service
public class HardService implements IHardService{

	@Autowired
	private IHardDao hardDao;
	
	@Override
	public Hard findHardById(String id) {
		return this.hardDao.findHardById(id);
	}

	@Override
	public void saveHard(Hard hard) {
		this.hardDao.saveHard(hard);
	}

	@Override
	public void delHardById(String id) {
		this.hardDao.delHardById(id);
	}

	@Override
	public Pagination<Hard> getPageHard(int pageNo, int pageSize,
			Map<String, String> map) {
		return this.hardDao.getPageHard(pageNo, pageSize, map);
	}

	@Override
	public List<Hard> findAllHard() {
		return this.hardDao.findAllHard();
	}

	@Override
	public String getHbByHrc(String hrc) {
		return this.hardDao.getHbByHrc(hrc);
	}

	@Override
	public String getHrcByHb(String hb) {
		return this.hardDao.getHrcByHb(hb);
	}

	@Override
	public boolean checkHardByHBAndHRCAndHV(String id, String hb, String hrc,String hv) {
		Hard hard =this.hardDao.checkHardByHBAndHRCAndHV(id, hb, hrc,hv);
		if(hard!=null){
			return false;
		}
		return true;
	}

	@Override
	public String getHbByHv(String hv) {
		return this.hardDao.getHbByHv(hv);
	}

}
