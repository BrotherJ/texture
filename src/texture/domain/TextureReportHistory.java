package texture.domain;

import java.util.List;

import texture.domain.VO.ZMtrCodeVO;


/**
 * ���ʱ����
 * @author infodba
 *
 */
public class TextureReportHistory {

	private String id;
	
	/**���ʱ���ID**/
	private String textureReportId;
	
	/**����**/
	private String texture;
	/**���ʱ�׼**/
	private String texture_stand;
	/**¯��**/
	private String furnace_No;
	/**��׼��汾��**/
	private String standAndVersionNum;
	/**֤����**/
	private String certificate_No;
	/**����**/
	private String table_no;
	/**�汾��**/
	private String version;
	
	/** Ŀ�� VT  0:δ��ѡ�� 1����ѡ**/
	private String vt;
	/** ��ɫ PT   0:δ��ѡ�� 1����ѡ**/
	private String pt;
	/** �ŷ� MT   0:δ��ѡ�� 1����ѡ**/
	private String mt;
	/** ���� RT  0:δ��ѡ�� 1����ѡ**/
	private String rt;
	/** ���� UT  0:δ��ѡ�� 1����ѡ**/
	private String ut;
	
	/**ce**/
	private String ce;
	/**pren**/
	private String pren;
	/**PREN��׼ֵ**/
	private double pren_standard;
	/**PREN��׼ֵ �жϷ���  ����С�ڵ���**/
	private String  pren_b;
	/**Ԫ�ؼ���**/
	private List<Element> elements;	
	/**�Զ���Ԫ�ؼ���**/
	private List<CustomizeElement> customizeElements;
	/**��е����**/
	private Mechanical mechanical;

	
	/**�ò���¯�Ŷ�Ӧ�����Ϻż���**/
	private List<Material> materials;
	
	/**��ϲ���**/
	private List<ZMtrCodeVO> zMtrCodeVOs;
	
	/**��Ӧ�ȴ�����**/
	private List<Heat> heats;
	/**���ʱ���״̬�� 0-->�ݸ�   1-->��ȷ��  2-->��ȷ��  3-->����sap  4-->���� **/
	private String status;
	
	/**������Ӧ������**/
	private String createUser;
	/**������Ӧ�̱��**/
	private String supplier_code;
		
	/**��Ӧ�̵�ַ**/
	private String address;
	
	/**��������**/
	private String createTime;
	
	/**����޸�����**/
	private String lastModifyTime;
	
	/**����޸��û�**/
	private String lastModifyUser;

	
	/**���ʱ����־�� 0-->��������������    1-->��ĸ**/
	private String textureSign;
	
	/**�ļ��ϴ�·��**/
	private String uploadUrl;
	
	/**���ʱ����Ƿ��ϴ�����:  0-->δ�ϴ�   1-->���ϴ�**/
	private String uploadSign;
	
	/**�ȴ�������**/
	private String batch_No;

	/**׷�ӱ�־  1-->��ʾ��׷�ӵ�  0��ձ�ʾδ׷��**/
	private String addSign;
	
	/**�Ƿ�NWȷ�Ϲ�  0--> δȷ�ϣ�1-->��ȷ��**/
	private String isNwConfirmed;
	
	/**�Ƿ���sap**/
	private String isSap;
	
	/**��sap�Ժ��˻صļ�¼��־  0-->�����˻�   1-->�����˻�**/
	private String backSign;
	
	/**��ע����¼�˻�����**/
	private String remark;
	
	/**�Ƿ�Ŧ��ά���û�(��е���ܡ��ȴ���)   true-->Ŧ���û�ά���� false -->��Ӧ��ά��**/
	private String isNw;
	
	/**�߼�ɾ������  1-->ɾ��   0-->δɾ��**/
	private String deleted;
	
	/**�˻�ʱ��**/
	private String returnTime;
	/**�˻��û�**/
	private String returnUser;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTexture() {
		return texture;
	}
	public void setTexture(String texture) {
		this.texture = texture;
	}
	public String getTexture_stand() {
		return texture_stand;
	}
	public void setTexture_stand(String texture_stand) {
		this.texture_stand = texture_stand;
	}
	public String getFurnace_No() {
		return furnace_No;
	}
	public void setFurnace_No(String furnace_No) {
		this.furnace_No = furnace_No;
	}
	public String getStandAndVersionNum() {
		return standAndVersionNum;
	}
	public void setStandAndVersionNum(String standAndVersionNum) {
		this.standAndVersionNum = standAndVersionNum;
	}
	public String getCertificate_No() {
		return certificate_No;
	}
	public void setCertificate_No(String certificate_No) {
		this.certificate_No = certificate_No;
	}
	public String getVt() {
		return vt;
	}
	public void setVt(String vt) {
		this.vt = vt;
	}
	public String getPt() {
		return pt;
	}
	public void setPt(String pt) {
		this.pt = pt;
	}
	public String getMt() {
		return mt;
	}
	public void setMt(String mt) {
		this.mt = mt;
	}
	public String getRt() {
		return rt;
	}
	public void setRt(String rt) {
		this.rt = rt;
	}
	public String getUt() {
		return ut;
	}
	public void setUt(String ut) {
		this.ut = ut;
	}
	
	public List<Material> getMaterials() {
		return materials;
	}
	public void setMaterials(List<Material> materials) {
		this.materials = materials;
	}
	
	public List<Heat> getHeats() {
		return heats;
	}
	public void setHeats(List<Heat> heats) {
		this.heats = heats;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
	public String getTable_no() {
		return table_no;
	}
	public void setTable_no(String table_no) {
		this.table_no = table_no;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getCe() {
		return ce;
	}
	public void setCe(String ce) {
		this.ce = ce;
	}
	public String getPren() {
		return pren;
	}
	public void setPren(String pren) {
		this.pren = pren;
	}
	public String getLastModifyTime() {
		return lastModifyTime;
	}
	public void setLastModifyTime(String lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}
	public String getLastModifyUser() {
		return lastModifyUser;
	}
	public void setLastModifyUser(String lastModifyUser) {
		this.lastModifyUser = lastModifyUser;
	}
	public List<Element> getElements() {
		return elements;
	}
	public void setElements(List<Element> elements) {
		this.elements = elements;
	}
	public Mechanical getMechanical() {
		return mechanical;
	}
	public void setMechanical(Mechanical mechanical) {
		this.mechanical = mechanical;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getTextureSign() {
		return textureSign;
	}
	public void setTextureSign(String textureSign) {
		this.textureSign = textureSign;
	}
	public String getUploadSign() {
		return uploadSign;
	}
	public void setUploadSign(String uploadSign) {
		this.uploadSign = uploadSign;
	}
	public double getPren_standard() {
		return pren_standard;
	}
	public void setPren_standard(double pren_standard) {
		this.pren_standard = pren_standard;
	}
	public String getPren_b() {
		return pren_b;
	}
	public void setPren_b(String pren_b) {
		this.pren_b = pren_b;
	}
	public String getBatch_No() {
		return batch_No;
	}
	public void setBatch_No(String batch_No) {
		this.batch_No = batch_No;
	}
	public String getAddSign() {
		return addSign;
	}
	public void setAddSign(String addSign) {
		this.addSign = addSign;
	}
	public String getUploadUrl() {
		return uploadUrl;
	}
	public void setUploadUrl(String uploadUrl) {
		this.uploadUrl = uploadUrl;
	}
	public String getIsSap() {
		return isSap;
	}
	public void setIsSap(String isSap) {
		this.isSap = isSap;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSupplier_code() {
		return supplier_code;
	}
	public void setSupplier_code(String supplier_code) {
		this.supplier_code = supplier_code;
	}
	public String getBackSign() {
		return backSign;
	}
	public void setBackSign(String backSign) {
		this.backSign = backSign;
	}
	public String getIsNw() {
		return isNw;
	}
	public void setIsNw(String isNw) {
		this.isNw = isNw;
	}
	public List<CustomizeElement> getCustomizeElements() {
		return customizeElements;
	}
	public void setCustomizeElements(List<CustomizeElement> customizeElements) {
		this.customizeElements = customizeElements;
	}
	public List<ZMtrCodeVO> getzMtrCodeVOs() {
		return zMtrCodeVOs;
	}
	
	public void setzMtrCodeVOs(List<ZMtrCodeVO> zMtrCodeVOs) {
		this.zMtrCodeVOs = zMtrCodeVOs;
	}
	public String getIsNwConfirmed() {
		return isNwConfirmed;
	}
	public void setIsNwConfirmed(String isNwConfirmed) {
		this.isNwConfirmed = isNwConfirmed;
	}
	public String getDeleted() {
		return deleted;
	}
	public void setDeleted(String deleted) {
		this.deleted = deleted;
	}
	public String getTextureReportId() {
		return textureReportId;
	}
	public void setTextureReportId(String textureReportId) {
		this.textureReportId = textureReportId;
	}
	public String getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(String returnTime) {
		this.returnTime = returnTime;
	}
	public String getReturnUser() {
		return returnUser;
	}
	public void setReturnUser(String returnUser) {
		this.returnUser = returnUser;
	}
	
	
}
