package texture.cons;

/**
 *整个应用通用的常量 
 *<br><b>类描述:</b>
 *<pre>|</pre>
 *@see
 *@since
 */
public class CommonConstant
{
   /**
    * 用户对象放到Session中的键名称
    */
   public static final String USER_CONTEXT = "USER_CONTEXT";
   
   /**
    * 用户、管理员对象放到Session中的键名称
    */
   public static final String USER_ADMIN_CONTEXT = "USER_ADMIN_CONTEXT";
   
   /**
    * 将登录前的URL放到Session中的键名称
    */
   public static final String LOGIN_TO_URL = "toUrl";
   
   /**
    * 每页的记录数
    */
   public static final int PAGE_SIZE = 10;
   
   /**
    * 文件夹查询分页数据
    */
   public static final int FILE_PAGE_SIZE = 5;
   
   /**
    * ADMIN 用户类型
    */
   public static final String USER_TYPE_ADMIN="0";
   /**
    * NEWAY 用户类型
    */
   public static final String USER_TYPE_NEWAY="1";
   
   /**
    * 供应商用户类型
    */
   public static final String USER_TYPE_SUPPLIER="2";
   
   /**
    * 未逻辑删除
    */
   public static final String NOT_DELETED="0";
   
   /**
    * 逻辑删除
    */
   public static final String IS_DELETED="1";
   
   /**
    * 供应商 提交材质报表状态
    */
   public static final String SUPPLIER_STATUS = "0";
   
   /**
    * NEWAY用户 将材质报表传入SAP后状态
    * 0-->草稿状态
    * 1-->待确认状态
    * 2-->已确认状态
    * 3-->已传人
    * 4-->作废
    */
   public static final String NEWAY_STATUS_DRAFT = "0";
   public static final String NEWAY_STATUS_TOBECONFIRM = "1";
   public static final String NEWAY_STATUS_CONFIRMED = "2";
   public static final String NEWAY_STATUS_SENDTOSAP = "3";
   public static final String NEWAY_STATUS_CANCEL = "4";
   
   /**是否已被传入sap  0-->否  1-->是**/
   public static final String TEXTURE_IS_SAP_NO ="0";
   public static final String TEXTURE_IS_SAP_YES ="1";
   
   /**传sap以后退回标志， 0-->附件退回  1-->数据退回   2-->数据/附件都有问题**/
   public static final String TEXTURE_BACK_SIGN_ATTACH="0";
   public static final String TEXTURE_BACK_SIGN_DATA="1";
   public static final String TEXTURE_BACK_SIGN_All="2";
   /**
    * 管理员用户组
    */
   public static final String GROUP_TYPE_ADMIN="0";
   
   /**
    * neway用户组
    */
   public static final String GROUP_TYPE_NEWAY="1";
   
   /**
    * 供应商用户组
    */
   public static final String GROUP_TYPE_SUPPLIER="2";
   
   /**追加标志  1-->表示是追加的  0或空表示未追加**/
   public static final String TEXTURE_ADDSIGN_NO="0";
   public static final String TEXTURE_ADDSIGN_YES="1";
   
   /**是否NW确认过  0--> 未确认，1-->已确认**/
   public static final String TEXTURE_ISNW_CONFIRMED_NO = "0";
   public static final String TEXTURE_ISNW_CONFIRMED_YES = "1";
   
   /**硬度单位为HRC**/
   public static final String HARD_HRC="HRC";
   /**硬度单位为HV**/
   public static final String HARD_HV="HV";
   /**硬度单位为HB**/
   public static final String HARD_HB="HB";
   /**螺柱及其他物料**/
   public static final String TEXTURE_OTHER ="0";
   /**螺母**/
   public static final String TEXTURE_NUT="1";
   /**材质报告 未上传附件**/
   public static final String TEXTURE_UPLOAD_NO ="0";
   /**材质报告 已上传附件**/
   public static final String TEXTURE_UPLOAD_YES ="1";
   
   /**材质国际标准**/
   public static final String TEXTURE_STANDARD_INTERNATIONAL="0";
   /**材质Neway标准**/
   public static final String TEXTURE_STANDARD_NEWAY="1";
   
   /**打印标志   已打印**/
   public static final String TEXTURE_PRINT_SIGN_YES="Y";
   /**打印标志   未打印**/
   public static final String TEXTURE_PRINT_SIGN_NO="N";
   
   /**规范模板名称**/
   public static final String UPLOAD_TEMPLATE_NAME="standTemplate.xlsx";
   
   
}
