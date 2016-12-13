package texture.domain;

import java.util.List;

import texture.domain.VO.ZMtrCodeVO;


/**
 * 材质报告表
 * @author infodba
 *
 */
public class TextureReportHistory {

	private String id;
	
	/**材质报告ID**/
	private String textureReportId;
	
	/**材质**/
	private String texture;
	/**材质标准**/
	private String texture_stand;
	/**炉号**/
	private String furnace_No;
	/**标准与版本号**/
	private String standAndVersionNum;
	/**证书编号**/
	private String certificate_No;
	/**表码**/
	private String table_no;
	/**版本号**/
	private String version;
	
	/** 目测 VT  0:未勾选， 1：勾选**/
	private String vt;
	/** 着色 PT   0:未勾选， 1：勾选**/
	private String pt;
	/** 磁粉 MT   0:未勾选， 1：勾选**/
	private String mt;
	/** 射线 RT  0:未勾选， 1：勾选**/
	private String rt;
	/** 超声 UT  0:未勾选， 1：勾选**/
	private String ut;
	
	/**ce**/
	private String ce;
	/**pren**/
	private String pren;
	/**PREN标准值**/
	private double pren_standard;
	/**PREN标准值 判断符号  大于小于等于**/
	private String  pren_b;
	/**元素集合**/
	private List<Element> elements;	
	/**自定义元素集合**/
	private List<CustomizeElement> customizeElements;
	/**机械性能**/
	private Mechanical mechanical;

	
	/**该材质炉号对应的物料号集合**/
	private List<Material> materials;
	
	/**组合参数**/
	private List<ZMtrCodeVO> zMtrCodeVOs;
	
	/**对应热处理集合**/
	private List<Heat> heats;
	/**材质报告状态： 0-->草稿   1-->待确认  2-->已确认  3-->传人sap  4-->作废 **/
	private String status;
	
	/**创建供应商名称**/
	private String createUser;
	/**创建供应商编号**/
	private String supplier_code;
		
	/**供应商地址**/
	private String address;
	
	/**创建日期**/
	private String createTime;
	
	/**最后修改日期**/
	private String lastModifyTime;
	
	/**最后修改用户**/
	private String lastModifyUser;

	
	/**材质报告标志： 0-->螺柱及其他材质    1-->螺母**/
	private String textureSign;
	
	/**文件上传路径**/
	private String uploadUrl;
	
	/**材质报告是否上传附件:  0-->未上传   1-->已上传**/
	private String uploadSign;
	
	/**热处理批次**/
	private String batch_No;

	/**追加标志  1-->表示是追加的  0或空表示未追加**/
	private String addSign;
	
	/**是否NW确认过  0--> 未确认，1-->已确认**/
	private String isNwConfirmed;
	
	/**是否传人sap**/
	private String isSap;
	
	/**传sap以后退回的记录标志  0-->附件退回   1-->数据退回**/
	private String backSign;
	
	/**备注，记录退回理由**/
	private String remark;
	
	/**是否纽威维护用户(机械性能、热处理)   true-->纽威用户维护， false -->供应商维护**/
	private String isNw;
	
	/**逻辑删除符号  1-->删除   0-->未删除**/
	private String deleted;
	
	/**退回时间**/
	private String returnTime;
	/**退回用户**/
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
