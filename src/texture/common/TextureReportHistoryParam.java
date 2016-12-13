package texture.common;

import java.util.Date;

import texture.cons.CommonConstant;
import texture.domain.TextureReport;
import texture.domain.TextureReportHistory;
import texture.domain.User;
import texture.util.StrUtil;

/**
 * ���ʱ����˻ؼ�¼ת����
 * @author jiong.sun
 *
 */
public class TextureReportHistoryParam {

	/**
	 * ��textureReport����ת����TextureReportHistory
	 * ��Ϊ�˻���ʷ��¼
	 * @param textureReport
	 * @return
	 */
	public  static  TextureReportHistory convertTextureReportHistory(TextureReport textureReport,User user){
		TextureReportHistory textureReportHistory =new TextureReportHistory();
		/**���ʱ���id**/
		textureReportHistory.setTextureReportId(textureReport.getId());
		/**����**/
		textureReportHistory.setTexture(textureReport.getTexture());
		/**¯��**/
		textureReportHistory.setFurnace_No(textureReport.getFurnace_No());
		/**��׼��汾��**/
		textureReportHistory.setStandAndVersionNum(textureReport.getStandAndVersionNum());
		/**֤����**/
		textureReportHistory.setCertificate_No(textureReport.getCertificate_No());
		/**����**/
		textureReportHistory.setTable_no(textureReport.getTable_no());
		/**�汾��**/
		textureReportHistory.setVersion(textureReport.getVersion());
		/** Ŀ�� VT**/
		textureReportHistory.setVt(textureReport.getVt());
		/** ��ɫ PT**/
		textureReportHistory.setPt(textureReport.getPt());
		/** �ŷ� MT**/
		textureReportHistory.setMt(textureReport.getMt());
		/** ���� RT**/
		textureReportHistory.setRt(textureReport.getRt());
		/** ���� UT**/
		textureReportHistory.setUt(textureReport.getUt());
		/**ce**/
		textureReportHistory.setCe(textureReport.getCe());
		/**pren**/
		textureReportHistory.setPren(textureReport.getPren());
		/**PREN��׼ֵ**/
		textureReportHistory.setPren_standard(textureReport.getPren_standard());
		/**PREN��׼ֵ �жϷ���  ����С�ڵ���**/
		textureReportHistory.setPren_b(textureReport.getPren_b());
		/**Ԫ�ؼ���**/
		textureReportHistory.setElements(textureReport.getElements());
		/**�Զ���Ԫ�ؼ���**/
		textureReportHistory.setCustomizeElements(textureReport.getCustomizeElements());
		/**��е����**/
		textureReportHistory.setMechanical(textureReport.getMechanical());
		/**�ò���¯�Ŷ�Ӧ�����Ϻż���**/
		textureReportHistory.setMaterials(textureReport.getMaterials());
		/**��ϲ���**/
		textureReportHistory.setzMtrCodeVOs(textureReport.getzMtrCodeVOs());
		/**��Ӧ�ȴ�����**/
		textureReportHistory.setHeats(textureReport.getHeats());
		/**���ʱ���״̬�� 0-->�ݸ�   1-->��ȷ��  2-->��ȷ��  3-->����sap  4-->���� **/
		textureReportHistory.setStatus(textureReport.getStatus());
		/**������Ӧ������**/
		textureReportHistory.setCreateUser(textureReport.getCreateUser());
		/**������Ӧ�̱��**/
		textureReportHistory.setSupplier_code(textureReport.getSupplier_code());
		/**��Ӧ�̵�ַ**/
		textureReportHistory.setAddress(textureReport.getAddress());
		/**��������**/
		textureReportHistory.setCreateTime(textureReport.getCreateTime());
		/**����޸�����**/
		textureReportHistory.setLastModifyTime(textureReport.getLastModifyTime());
		/**����޸��û�**/
		textureReportHistory.setLastModifyUser(textureReport.getLastModifyUser());
		/**���ʱ����־�� 0-->��������������    1-->��ĸ**/
		textureReportHistory.setTextureSign(textureReport.getTextureSign());
		/**�ļ��ϴ�·��**/
		textureReportHistory.setUploadUrl(textureReport.getUploadUrl());
		/**���ʱ����Ƿ��ϴ�����:  0-->δ�ϴ�   1-->���ϴ�**/
		textureReportHistory.setUploadSign(textureReport.getUploadSign());
		/**�ȴ�������**/
		textureReportHistory.setBatch_No(textureReport.getBatch_No());
		/**׷�ӱ�־  1-->��ʾ��׷�ӵ�  0��ձ�ʾδ׷��**/
		textureReportHistory.setAddSign(textureReport.getAddSign());
		/**�Ƿ�NWȷ�Ϲ�  0--> δȷ�ϣ�1-->��ȷ��**/
		textureReportHistory.setIsNwConfirmed(textureReport.getIsNwConfirmed());
		/**�Ƿ���sap**/
		textureReportHistory.setIsSap(textureReport.getIsSap());
		/**��sap�Ժ��˻صļ�¼��־  0-->�����˻�   1-->�����˻�**/
		textureReportHistory.setBackSign(textureReport.getBackSign());
		/**��ע����¼�˻�����**/
		textureReportHistory.setRemark(textureReport.getRemark());
		/**�Ƿ�Ŧ��ά���û�(��е���ܡ��ȴ���)   true-->Ŧ���û�ά���� false -->��Ӧ��ά��**/
		textureReportHistory.setIsNw(textureReport.getIsNw());
		/**�߼�ɾ������  1-->ɾ��   0-->δɾ��**/
		textureReportHistory.setDeleted(CommonConstant.NOT_DELETED);
		/**�˻��û�**/
		textureReportHistory.setReturnUser(user.getName());
		/**�˻�ʱ��**/
		textureReportHistory.setReturnTime(StrUtil.getDateFormatCurrentTime(new Date()));
		return textureReportHistory;
	}
}
