package texture.service;

import java.util.List;
import java.util.Map;

import texture.domain.MaterialSizeContrast;
import texture.domain.Pagination;

/**
 * ���ϳߴ���չ�ϵ Dao
 * @author infodba
 *
 */
public interface IMaterialSizeContrastService {

	/**
	 * ����id��ȡ���� �ߴ���չ�ϵ
	 * @param id
	 * @return
	 */
	public MaterialSizeContrast findByMaterialSizeContrastId(String id);
	
	/**
	 * ���� ���ϳߴ���չ�ϵ
	 * @param materialSizeContrast
	 */
	public void saveMaterialSizeContrast(MaterialSizeContrast materialSizeContrast);
	/**
	 * ����id ɾ��
	 * @param id
	 */
	public void delById(String id);
	
	/**
	 * ��ҳ��ѯ���ϳߴ���չ�ϵ
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public Pagination<MaterialSizeContrast> getPageMaterialSizeContrast(int pageNo, int pageSize,Map<String, String> map);
	
	/**
	 * ��ȡ�������ϳߴ���չ�ϵ
	 * @return
	 */
	public List<MaterialSizeContrast> findAllMaterialSizeContrast();
	
	/**
	 * �������Ϻż���Ƿ��Ѵ���
	 * @param name  ����
	 * @param texture ����
	 * @return
	 */
	public boolean checkMaterialSizeContrastByMatrialCode(String id,String material_code);
	
	/**
	 * ɾ����׼��汾�Ŷ���
	 * @param stand
	 */
	public void removeMaterialSizeContrast(MaterialSizeContrast materialSizeContrast);
	
	/**
	 * �������� ����/�ߴ���չ�ϵ
	 * @param olds      �ɵ�����
	 * @param news     ������õ�����
	 */
	public void batchUpdate(List<MaterialSizeContrast> olds ,List<MaterialSizeContrast> news);

	
	/**
	 * �������ϺŻ�ȡ���� �ߴ������Ϣ
	 * @param material_code
	 * @return
	 */
	public MaterialSizeContrast getMaterialSizeByMaterialCode(String material_code);
	
}
