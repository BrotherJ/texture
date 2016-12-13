package texture.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import texture.dao.IMaterialSizeContrastDao;
import texture.domain.MaterialSizeContrast;
import texture.domain.Pagination;


@Service
public class MaterialSizeContrastService implements IMaterialSizeContrastService{

	@Autowired
	private IMaterialSizeContrastDao materialSizeContrastDao;
	
	@Override
	public MaterialSizeContrast findByMaterialSizeContrastId(String id) {
		return this.materialSizeContrastDao.findByMaterialSizeContrastId(id);
	}

	@Override
	public void saveMaterialSizeContrast(MaterialSizeContrast materialSizeContrast) {
		this.materialSizeContrastDao.saveMaterialSizeContrast(materialSizeContrast);
	}

	@Override
	public void delById(String id) {
		this.materialSizeContrastDao.delById(id);
	}

	@Override
	public Pagination<MaterialSizeContrast> getPageMaterialSizeContrast(
			int pageNo, int pageSize, Map<String, String> map) {
		return this.materialSizeContrastDao.getPageMaterialSizeContrast(pageNo, pageSize, map);
	}

	@Override
	public List<MaterialSizeContrast> findAllMaterialSizeContrast() {
		return this.materialSizeContrastDao.findAllMaterialSizeContrast();
	}

	@Override
	public boolean checkMaterialSizeContrastByMatrialCode(String id,
			String material_code) {
		MaterialSizeContrast materialSizeContrast =this.materialSizeContrastDao.checkMaterialSizeContrastByMatrialCode(id, material_code);
		//若有值 ，返回true，否则返回false
		if(materialSizeContrast!=null){
			return true;
		}
		return false;
	}

	@Override
	public void removeMaterialSizeContrast(MaterialSizeContrast materialSizeContrast) {
		this.materialSizeContrastDao.removeMaterialSizeContrast(materialSizeContrast);
	}

	@Override
	public void batchUpdate(List<MaterialSizeContrast> olds,
			List<MaterialSizeContrast> news) {
		//循环遍历 删除
		for (MaterialSizeContrast old : olds) {
			this.materialSizeContrastDao.removeMaterialSizeContrast(old);
		}
		//循环遍历 新增
		for (MaterialSizeContrast materialSizeContrast : news) {
			this.materialSizeContrastDao.saveMaterialSizeContrast(materialSizeContrast);
		}
	}

	@Override
	public MaterialSizeContrast getMaterialSizeByMaterialCode(
			String material_code) {
		return this.materialSizeContrastDao.getMaterialSizeByMaterialCode(material_code);
	}

}
