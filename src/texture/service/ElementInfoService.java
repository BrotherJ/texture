package texture.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import texture.dao.IElementInfoDao;
import texture.domain.ElementInfo;
import texture.domain.Pagination;

@Service
public class ElementInfoService implements IElementInfoService{

	@Autowired
	private IElementInfoDao elementInfoDao;
	
	@Override
	public ElementInfo findElementInfoById(String id) {
		return this.elementInfoDao.findElementInfoById(id);
	}

	@Override
	public void saveElementInfo(ElementInfo element) {
		this.elementInfoDao.saveElementInfo(element);
	}

	@Override
	public void delElementInfoById(String id) {
		this.elementInfoDao.delElementInfoById(id);
	}

	@Override
	public Pagination<ElementInfo> getPageElementInfo(int pageNo, int pageSize,
			Map<String, String> map) {
		return this.elementInfoDao.getPageElementInfo(pageNo, pageSize, map);
	}

	@Override
	public List<ElementInfo> findAllElementInfo() {
		return this.elementInfoDao.findAllElementInfo();
	}

	@Override
	public boolean checkElementInfoByName(String id, String name) {
		ElementInfo elementInfo = this.elementInfoDao.checkElementInfoByName(id, name);
		if(elementInfo!=null){
			return false;
		}
		return true;
	}

	@Override
	public void removeElementInfo(ElementInfo elementInfo) {
		this.elementInfoDao.removeElementInfo(elementInfo);
	}

}
