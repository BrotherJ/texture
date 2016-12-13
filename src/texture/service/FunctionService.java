package texture.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import texture.dao.IFunctionDao;
import texture.domain.Function;
import texture.domain.Pagination;

@Service
public class FunctionService implements IFunctionService {

	@Autowired
	private IFunctionDao functionDao;
	
	@Override
	public void saveFunction(Function function) {
		this.functionDao.saveFunction(function);
	}

	@Override
	public Function findFunctionById(String id) {
		return this.functionDao.findFunctionById(id);
	}

	@Override
	public Pagination<Function> getPageFunction(int pageNo, int pageSize,Map<String, String> map) {
		return this.functionDao.getPageFunction(pageNo, pageSize,map);
	}

	@Override
	public void delFunction(String id) {
		this.functionDao.delFunction(id);
	}

	@Override
	public List<Function> findAllFunctions() {
		return this.functionDao.findAllFunctions();
	}

	
}
