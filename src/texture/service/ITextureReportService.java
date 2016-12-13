package texture.service;

import java.util.List;
import java.util.Map;

import texture.domain.Pagination;
import texture.domain.TextureReport;
import texture.domain.User;

public interface ITextureReportService {

	/**
	 * ������ʱ�����
	 * @param textureReport
	 */
	public void saveTextureReport(TextureReport textureReport);
	
	/**
	 * ����������ѯ���ʱ���
	 * @param pageNo
	 * @param pageSize
	 * @param map
	 * @return
	 */
	public Pagination<TextureReport> getPageTextureReportByConditions(int pageNo, int pageSize,Map<String, String> map,String beginDate,String endDate);
	
	/**
	 * ����id ��ȡ���ʱ�����Ϣ
	 * @param id
	 * @return
	 */
	public TextureReport findById(String id);
	
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
	 * ���²��ʱ��漯��
	 * @param textureReports
	 * @param uploadSign   ���ʱ����Ƿ��ϴ������ֶ�
	 */
	public void saveTextureReports(List<TextureReport> textureReports,String uploadSign);
	
	/**
	 * �˻ػ򳷻ز��ʱ���
	 * ɾ���ò��ʱ����Ӧ�ĸ���
	 * @param id     id
	 * @param status  ״̬
	 */
	public void backOrWithDrawTextureReportStatus(String id,String status,User user);
	
	/**
	 * �ύ��ȷ�� ���²��ʱ���״̬
	 * @param id
	 * @param status
	 */
	public void submitOrConfirmUpdateTextureReport(String id,String status);
	
	/**
	 * �ύ��ȷ�� ���²��ʱ���״̬
	 * @param id
	 * @param status
	 * @param isNwConfirmed   �Ƿ�nwȷ��
	 */
	public void confirmTextureReport(String id,String status,String isNwConfirmed,User user);
	
	/**
	 * �˻ز��ʱ���
	 * @param id   id
	 * @param remark  �˻ر�ע/ԭ��
	 */
	public void returnTextureReport(String id,String remark,User user);
	
	
	/**
	 * ���ݲ���/¯�� ��ȡ׷�ӵĲ��ʱ�����Ϣ
	 * @param texture       ����
	 * @param furnace_No ¯��
	 * @return
	 */
	public List<TextureReport> findAddByTextureAndFunaceNo(String texture,String furnace_No);
	
	/**
	 * ������ʱ���ʱ������������׷�ӵļ�¼
	 * @param texture                   ���ʱ���
	 */
	public void saveTextureLinkedAdd(TextureReport textureReport);
	
	/**
	 * ɾ��¯�Ų��ʱ������
	 * @param id
	 */
	public void delTextureReportInfoById(String id);
	
	/**
	 * ��Ӧ���ύ���ʱ���
	 * @param textureReport   ��ǰ���ʱ�����Ϣ
	 * @param addList             �����˻�ԭ�������ݴ���Ĳݸ�״̬׷�Ӽ�¼����
	 */
	public void submitDraft(TextureReport textureReport,List<TextureReport> addList);
	
	/**
	 * �˻ز��ʱ���  
	 * @param id   id
	 * @param remark  �˻ر�ע/ԭ��
	 * @param user     �˻��û�
	 * @param backSign  �˻ر�־ 0-->�����˻�  1-->�����˻�
	 */
	public void returnTextureReport(String id,String remark,User user,String backSign);
	
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
	 * ���ݲ���¯�Ż�ȡ��ʼ���ʱ���
	 * @param texture       ����
	 * @param furnace_No ¯��
	 * @return
	 */
	public List<TextureReport> getIsNwAndSendSap(String isNw,String status);
	
	/**
	 * ɾ�����ʱ���ĸ���
	 * @param id
	 */
	public void delAttachFile(String  id);
	
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
