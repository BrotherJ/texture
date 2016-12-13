package texture.service;

import java.util.List;
import java.util.Map;

import texture.domain.Pagination;
import texture.domain.Stand;
import texture.domain.Texture;

/**
 * 标准与版本号 Service
 * @author infodba
 *
 */
public interface ITextureService {
	
	
	/**
	 * 获取材质清单
	 * @return
	 */
	public List<Texture> findAllTexture();
	
	/**
	 * 批量更新 
	 * 旧的删除，新的新增
	 * @param olds     旧的集合
	 * @param news    新的集合
	 * @return
	 */
	public void batchUpdate(List<Texture> olds,List<Texture> news);
}
