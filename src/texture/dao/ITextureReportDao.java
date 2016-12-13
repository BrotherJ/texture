package texture.dao;

import java.util.List;
import java.util.Map;

import texture.domain.Pagination;
import texture.domain.TextureReport;

public interface ITextureReportDao {

	/**
	 * ������ʱ�����
	 * @param textureReport
	 */
	public void saveTextureReport(TextureReport textureReport);

	/**
	 * ����id���Ҳ��ʱ�����
	 * @param id
	 * @return
	 */
	public TextureReport findTextureReportById(String id);
	
	/**
	 * ����������ѯ���ʱ���
	 * @param pageNo
	 * @param pageSize
	 * @param map
	 * @return
	 */
	public Pagination<TextureReport> getPageTextureReportByConditions(int pageNo, int pageSize,Map<String, String> map,String beginDate,String endDate);
	
	/**
	 * ����¯�š����ʼ���Ƿ�Ψһ
	 * @param id
	 * @param texture     ����
	 * @param furnace_No  ¯��
	 * @return
	 */
	public List<TextureReport> checkUnique(String id,String texture,String furnace_No);
	
	/**
	 * ����֤���� �����ȡ��һ������
	 * @param certificate_No   ֤����
	 * @return
	 */
	public TextureReport getTopOneTextureReportByCertificateNo();
	
	/**
	 * ��鲻ͬ������ͬ¯���Ƿ����
	 * @param texture
	 * @param furnace_No
	 * @return
	 */
	public List<TextureReport> checkUnTextureAndSameFunaceNo(String texture,String furnace_No);
	
	/**
	 * ���ݲ���¯�Ż�ȡ������ͬ����¯�ŵļ�¼
	 * @param texture
	 * @param furnace_No
	 * @return
	 */
	public List<TextureReport> getTextureReportByTextureAndFunaceNo(String texture,String furnace_No);
	

	/**
	 * ���ݲ���/¯�� ��ȡ׷�ӵĲ��ʱ�����Ϣ
	 * @param texture       ����
	 * @param furnace_No ¯��
	 * @return
	 */
	public List<TextureReport> findAddByTextureAndFunaceNo(String texture,String furnace_No);
	
	/**
	 * ɾ������¯�ű���
	 * @param id
	 */
	public void delTextureReport(String id);
	
	/**
	 * ��ȡ��Ϊ���ж�Ӧ״̬��׷�Ӽ�¼
	 * @param texture       ����
	 * @param furnace_No ¯��
	 * @param status          ״̬
	 * @return
	 */
	public List<TextureReport> findAddTextureReportList(String texture,String furnace_No,String  status);
	
	/**
	 * ��ȡ��Ӧ״̬��׷�Ӽ�¼
	 * @param texture       ����
	 * @param furnace_No ¯��
	 * @param status          ״̬
	 * @return
	 */
	public List<TextureReport> findAddList(String texture,String furnace_No,String  status);
	
	/**
	 * ���ݲ���¯�Ż�ȡ��ʼ���ʱ���
	 * @param texture       ����
	 * @param furnace_No ¯��
	 * @return
	 */
	public TextureReport getInitialTextureReport(String texture,String furnace_No);
	
	/**
	 * ��ȡ��Ŧ��ά�� ����ͬ״̬�Ĳ��ʱ���
	 * @param isNw       
	 * @param status 
	 * @return
	 */
	public List<TextureReport> getIsNwAndSendSap(String isNw,String status);
	
	/**
	 * ����������ѯ���ʱ���,���ų�׷�Ӽ�¼
	 * @param pageNo
	 * @param pageSize
	 * @param map           ���ʡ�¯��
	 * @param material_code       ���Ϻ�
	 * @param material_spec       ���Ϲ��
	 * @return
	 */
	public Pagination<TextureReport> getPageTextureReportByMaterial(int pageNo, int pageSize,Map<String, String> map,String material_code,String material_spec);
}
