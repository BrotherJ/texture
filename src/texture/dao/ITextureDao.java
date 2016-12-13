package texture.dao;

import java.util.List;

import texture.domain.Texture;

/**
 * 材质 Dao
 * @author infodba
 *
 */
public interface ITextureDao {

	/**
	 * 保存
	 * @param group
	 */
	public void saveTexture(Texture texture);
	
	/**
	 * 获取材质清单
	 * @return
	 */
	public List<Texture> findAllTexture();
	
	/**
	 * 删除材质信息
	 * @param stand
	 */
	public void removeTexture(Texture texture);
	

}
