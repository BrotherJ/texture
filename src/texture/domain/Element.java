package texture.domain;


/**
 * Ԫ�ر����Ԫ����Ϣ
 * @author infodba
 *
 */
public class Element {

	/**Ԫ������**/
	private String element_name;
	/**Ԫ�� ���ֵ**/
	private double max;
	/**Ԫ�� ��Сֵ**/
	private double min;
	/**Ԫ�� ��Ӧ������ֵ**/
	private double ele_value;
	public String getElement_name() {
		return element_name;
	}
	public void setElement_name(String element_name) {
		this.element_name = element_name;
	}
	public double getMax() {
		return max;
	}
	public void setMax(double max) {
		this.max = max;
	}
	public double getMin() {
		return min;
	}
	public void setMin(double min) {
		this.min = min;
	}
	public double getEle_value() {
		return ele_value;
	}
	public void setEle_value(double ele_value) {
		this.ele_value = ele_value;
	}
	
}
