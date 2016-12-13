package texture.dao;

import java.util.List;
import java.util.Map;

import texture.domain.MaterialSizeContrast;
import texture.domain.Pagination;

/**
 * 物料尺寸对照关系 Dao
 * @author infodba
 *
 */
public interface IMaterialSizeContrastDao {

	/**
	 * 根据id获取物料 尺寸对照关系
	 * @param id
	 * @return
	 */
	public MaterialSizeContrast findByMaterialSizeContrastId(String id);
	
	/**
	 * 保存 物料尺寸对照关系
	 * @param materialSizeContrast
	 */
	public void saveMaterialSizeContrast(MaterialSizeContrast materialSizeContrast);
	/**
	 * 根据id 删除
	 * @param id
	 */
	public void delById(String id);
	
	/**
	 * 分页查询物料尺寸对照关系
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination<MaterialSizeContrast> getPageMaterialSizeContrast(int pageNo, int pageSize,Map<String, String> map);
	
	/**
	 * 获取所有物料尺寸对照关系
	 * @return
	 */
	public List<MaterialSizeContrast> findAllMaterialSizeContrast();
	
	/**
	 * 根据物料号检查是否已存在
	 * @param name  名称
	 * @param texture 材质
	 * @return
	 */
	public MaterialSizeContrast checkMaterialSizeContrastByMatrialCode(String id,String material_code);
	
	/**
	 * 删除标准与版本号对象
	 * @param stand
	 */
	public void removeMaterialSizeContrast(MaterialSizeContrast materialSizeContrast);
	
	/**
	 * 根据物料号获取物料 尺寸对照信息
	 * @param material_code
	 * @return
	 */
	public MaterialSizeContrast getMaterialSizeByMaterialCode(String material_code);

}
