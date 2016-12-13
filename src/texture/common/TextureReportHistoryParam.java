package texture.common;

import java.util.Date;

import texture.cons.CommonConstant;
import texture.domain.TextureReport;
import texture.domain.TextureReportHistory;
import texture.domain.User;
import texture.util.StrUtil;

/**
 * 材质报告退回记录转换类
 * @author jiong.sun
 *
 */
public class TextureReportHistoryParam {

	/**
	 * 将textureReport对象转换成TextureReportHistory
	 * 作为退回历史记录
	 * @param textureReport
	 * @return
	 */
	public  static  TextureReportHistory convertTextureReportHistory(TextureReport textureReport,User user){
		TextureReportHistory textureReportHistory =new TextureReportHistory();
		/**材质报告id**/
		textureReportHistory.setTextureReportId(textureReport.getId());
		/**材质**/
		textureReportHistory.setTexture(textureReport.getTexture());
		/**炉号**/
		textureReportHistory.setFurnace_No(textureReport.getFurnace_No());
		/**标准与版本号**/
		textureReportHistory.setStandAndVersionNum(textureReport.getStandAndVersionNum());
		/**证书编号**/
		textureReportHistory.setCertificate_No(textureReport.getCertificate_No());
		/**表码**/
		textureReportHistory.setTable_no(textureReport.getTable_no());
		/**版本号**/
		textureReportHistory.setVersion(textureReport.getVersion());
		/** 目测 VT**/
		textureReportHistory.setVt(textureReport.getVt());
		/** 着色 PT**/
		textureReportHistory.setPt(textureReport.getPt());
		/** 磁粉 MT**/
		textureReportHistory.setMt(textureReport.getMt());
		/** 射线 RT**/
		textureReportHistory.setRt(textureReport.getRt());
		/** 超声 UT**/
		textureReportHistory.setUt(textureReport.getUt());
		/**ce**/
		textureReportHistory.setCe(textureReport.getCe());
		/**pren**/
		textureReportHistory.setPren(textureReport.getPren());
		/**PREN标准值**/
		textureReportHistory.setPren_standard(textureReport.getPren_standard());
		/**PREN标准值 判断符号  大于小于等于**/
		textureReportHistory.setPren_b(textureReport.getPren_b());
		/**元素集合**/
		textureReportHistory.setElements(textureReport.getElements());
		/**自定义元素集合**/
		textureReportHistory.setCustomizeElements(textureReport.getCustomizeElements());
		/**机械性能**/
		textureReportHistory.setMechanical(textureReport.getMechanical());
		/**该材质炉号对应的物料号集合**/
		textureReportHistory.setMaterials(textureReport.getMaterials());
		/**组合参数**/
		textureReportHistory.setzMtrCodeVOs(textureReport.getzMtrCodeVOs());
		/**对应热处理集合**/
		textureReportHistory.setHeats(textureReport.getHeats());
		/**材质报告状态： 0-->草稿   1-->待确认  2-->已确认  3-->传人sap  4-->作废 **/
		textureReportHistory.setStatus(textureReport.getStatus());
		/**创建供应商名称**/
		textureReportHistory.setCreateUser(textureReport.getCreateUser());
		/**创建供应商编号**/
		textureReportHistory.setSupplier_code(textureReport.getSupplier_code());
		/**供应商地址**/
		textureReportHistory.setAddress(textureReport.getAddress());
		/**创建日期**/
		textureReportHistory.setCreateTime(textureReport.getCreateTime());
		/**最后修改日期**/
		textureReportHistory.setLastModifyTime(textureReport.getLastModifyTime());
		/**最后修改用户**/
		textureReportHistory.setLastModifyUser(textureReport.getLastModifyUser());
		/**材质报告标志： 0-->螺柱及其他材质    1-->螺母**/
		textureReportHistory.setTextureSign(textureReport.getTextureSign());
		/**文件上传路径**/
		textureReportHistory.setUploadUrl(textureReport.getUploadUrl());
		/**材质报告是否上传附件:  0-->未上传   1-->已上传**/
		textureReportHistory.setUploadSign(textureReport.getUploadSign());
		/**热处理批次**/
		textureReportHistory.setBatch_No(textureReport.getBatch_No());
		/**追加标志  1-->表示是追加的  0或空表示未追加**/
		textureReportHistory.setAddSign(textureReport.getAddSign());
		/**是否NW确认过  0--> 未确认，1-->已确认**/
		textureReportHistory.setIsNwConfirmed(textureReport.getIsNwConfirmed());
		/**是否传人sap**/
		textureReportHistory.setIsSap(textureReport.getIsSap());
		/**传sap以后退回的记录标志  0-->附件退回   1-->数据退回**/
		textureReportHistory.setBackSign(textureReport.getBackSign());
		/**备注，记录退回理由**/
		textureReportHistory.setRemark(textureReport.getRemark());
		/**是否纽威维护用户(机械性能、热处理)   true-->纽威用户维护， false -->供应商维护**/
		textureReportHistory.setIsNw(textureReport.getIsNw());
		/**逻辑删除符号  1-->删除   0-->未删除**/
		textureReportHistory.setDeleted(CommonConstant.NOT_DELETED);
		/**退回用户**/
		textureReportHistory.setReturnUser(user.getName());
		/**退回时间**/
		textureReportHistory.setReturnTime(StrUtil.getDateFormatCurrentTime(new Date()));
		return textureReportHistory;
	}
}
