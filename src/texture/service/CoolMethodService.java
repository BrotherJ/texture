package texture.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import texture.dao.ICoolMethodDao;
import texture.domain.CoolMethod;
import texture.domain.Pagination;

/**
 * 冷却方法Service 实现
 * @author infodba
 *
 */
@Service
public class CoolMethodService implements ICoolMethodService{

	@Autowired
	private ICoolMethodDao coolMethodDao;
	
	@Override
	public CoolMethod findCoolMethodById(String id) {
		return this.coolMethodDao.findCoolMethodById(id);
	}

	@Override
	public void saveCoolMethod(CoolMethod coolMethod) {
		this.coolMethodDao.saveCoolMethod(coolMethod);
	}

	@Override
	public void delCoolMethodById(String id) {
		this.coolMethodDao.delCoolMethodById(id);
	}

	@Override
	public Pagination<CoolMethod> getPageCoolMethod(int pageNo, int pageSize,
			Map<String, String> map) {
		return this.coolMethodDao.getPageCoolMethod(pageNo, pageSize, map);
	}

	@Override
	public List<CoolMethod> findAllCoolMethod() {
		return this.coolMethodDao.findAllCoolMethod();
	}

	@Override
	public CoolMethod getCoolMethodByEName(String eName) {
		return this.coolMethodDao.getCoolMethodByEName(eName);
	}

}
