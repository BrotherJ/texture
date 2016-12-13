package texture.domain.VO;

/**
 * ��ϲ�����
 * @author jiong.sun
 *
 */
public class ZMtrCodeVO {

	/**MTR��ʾ����**/
	private String zmtr_code;
	
	/**��ʽ**/
	private String formule;
	
	/**���޷���**/
	private String lower_sign;
	/**����ֵ**/
	private String lower_value;
	
	/**���޷���**/
	private String upper_sign;
	
	/**����ֵ**/
	private String upper_value;
	
	/**MTRʵ��ֵ�����**/
	private String cal_flag;
	
	

	public ZMtrCodeVO() {
		super();
	}

	public ZMtrCodeVO(String zmtr_code, String formule, String lower_sign,
			String lower_value, String upper_sign, String upper_value,
			String cal_flag) {
		super();
		this.zmtr_code = zmtr_code;
		this.formule = formule;
		this.lower_sign = lower_sign;
		this.lower_value = lower_value;
		this.upper_sign = upper_sign;
		this.upper_value = upper_value;
		this.cal_flag = cal_flag;
	}

	public String getZmtr_code() {
		return zmtr_code;
	}

	public void setZmtr_code(String zmtr_code) {
		this.zmtr_code = zmtr_code;
	}

	public String getFormule() {
		return formule;
	}

	public void setFormule(String formule) {
		this.formule = formule;
	}

	public String getLower_sign() {
		return lower_sign;
	}

	public void setLower_sign(String lower_sign) {
		this.lower_sign = lower_sign;
	}

	public String getLower_value() {
		return lower_value;
	}

	public void setLower_value(String lower_value) {
		this.lower_value = lower_value;
	}

	public String getUpper_sign() {
		return upper_sign;
	}

	public void setUpper_sign(String upper_sign) {
		this.upper_sign = upper_sign;
	}

	public String getUpper_value() {
		return upper_value;
	}

	public void setUpper_value(String upper_value) {
		this.upper_value = upper_value;
	}

	public String getCal_flag() {
		return cal_flag;
	}

	public void setCal_flag(String cal_flag) {
		this.cal_flag = cal_flag;
	}
	
	
}
