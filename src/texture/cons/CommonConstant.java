package texture.cons;

/**
 *����Ӧ��ͨ�õĳ��� 
 *<br><b>������:</b>
 *<pre>|</pre>
 *@see
 *@since
 */
public class CommonConstant
{
   /**
    * �û�����ŵ�Session�еļ�����
    */
   public static final String USER_CONTEXT = "USER_CONTEXT";
   
   /**
    * �û�������Ա����ŵ�Session�еļ�����
    */
   public static final String USER_ADMIN_CONTEXT = "USER_ADMIN_CONTEXT";
   
   /**
    * ����¼ǰ��URL�ŵ�Session�еļ�����
    */
   public static final String LOGIN_TO_URL = "toUrl";
   
   /**
    * ÿҳ�ļ�¼��
    */
   public static final int PAGE_SIZE = 10;
   
   /**
    * �ļ��в�ѯ��ҳ����
    */
   public static final int FILE_PAGE_SIZE = 5;
   
   /**
    * ADMIN �û�����
    */
   public static final String USER_TYPE_ADMIN="0";
   /**
    * NEWAY �û�����
    */
   public static final String USER_TYPE_NEWAY="1";
   
   /**
    * ��Ӧ���û�����
    */
   public static final String USER_TYPE_SUPPLIER="2";
   
   /**
    * δ�߼�ɾ��
    */
   public static final String NOT_DELETED="0";
   
   /**
    * �߼�ɾ��
    */
   public static final String IS_DELETED="1";
   
   /**
    * ��Ӧ�� �ύ���ʱ���״̬
    */
   public static final String SUPPLIER_STATUS = "0";
   
   /**
    * NEWAY�û� �����ʱ�����SAP��״̬
    * 0-->�ݸ�״̬
    * 1-->��ȷ��״̬
    * 2-->��ȷ��״̬
    * 3-->�Ѵ���
    * 4-->����
    */
   public static final String NEWAY_STATUS_DRAFT = "0";
   public static final String NEWAY_STATUS_TOBECONFIRM = "1";
   public static final String NEWAY_STATUS_CONFIRMED = "2";
   public static final String NEWAY_STATUS_SENDTOSAP = "3";
   public static final String NEWAY_STATUS_CANCEL = "4";
   
   /**�Ƿ��ѱ�����sap  0-->��  1-->��**/
   public static final String TEXTURE_IS_SAP_NO ="0";
   public static final String TEXTURE_IS_SAP_YES ="1";
   
   /**��sap�Ժ��˻ر�־�� 0-->�����˻�  1-->�����˻�   2-->����/������������**/
   public static final String TEXTURE_BACK_SIGN_ATTACH="0";
   public static final String TEXTURE_BACK_SIGN_DATA="1";
   public static final String TEXTURE_BACK_SIGN_All="2";
   /**
    * ����Ա�û���
    */
   public static final String GROUP_TYPE_ADMIN="0";
   
   /**
    * neway�û���
    */
   public static final String GROUP_TYPE_NEWAY="1";
   
   /**
    * ��Ӧ���û���
    */
   public static final String GROUP_TYPE_SUPPLIER="2";
   
   /**׷�ӱ�־  1-->��ʾ��׷�ӵ�  0��ձ�ʾδ׷��**/
   public static final String TEXTURE_ADDSIGN_NO="0";
   public static final String TEXTURE_ADDSIGN_YES="1";
   
   /**�Ƿ�NWȷ�Ϲ�  0--> δȷ�ϣ�1-->��ȷ��**/
   public static final String TEXTURE_ISNW_CONFIRMED_NO = "0";
   public static final String TEXTURE_ISNW_CONFIRMED_YES = "1";
   
   /**Ӳ�ȵ�λΪHRC**/
   public static final String HARD_HRC="HRC";
   /**Ӳ�ȵ�λΪHV**/
   public static final String HARD_HV="HV";
   /**Ӳ�ȵ�λΪHB**/
   public static final String HARD_HB="HB";
   /**��������������**/
   public static final String TEXTURE_OTHER ="0";
   /**��ĸ**/
   public static final String TEXTURE_NUT="1";
   /**���ʱ��� δ�ϴ�����**/
   public static final String TEXTURE_UPLOAD_NO ="0";
   /**���ʱ��� ���ϴ�����**/
   public static final String TEXTURE_UPLOAD_YES ="1";
   
   /**���ʹ��ʱ�׼**/
   public static final String TEXTURE_STANDARD_INTERNATIONAL="0";
   /**����Neway��׼**/
   public static final String TEXTURE_STANDARD_NEWAY="1";
   
   /**��ӡ��־   �Ѵ�ӡ**/
   public static final String TEXTURE_PRINT_SIGN_YES="Y";
   /**��ӡ��־   δ��ӡ**/
   public static final String TEXTURE_PRINT_SIGN_NO="N";
   
   /**�淶ģ������**/
   public static final String UPLOAD_TEMPLATE_NAME="standTemplate.xlsx";
   
   
}
