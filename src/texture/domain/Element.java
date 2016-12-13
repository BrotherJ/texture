package texture.domain;


/**
 * 元素表，存放元素信息
 * @author infodba
 *
 */
public class Element {

	/**元素名称**/
	private String element_name;
	/**元素 最大值**/
	private double max;
	/**元素 最小值**/
	private double min;
	/**元素 供应商输入值**/
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
