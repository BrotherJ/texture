package texture.domain;

/**
 * �ȴ���
 * @author infodba
 *
 */
public class Heat {

	/**������**/
	private String method;
	/**¯������: 0-->��¯   **/
	private String furnace_Type;
	/**�¶�  **/
	private String temperature;
	/**��ȴ����  **/
	private String cooling_Method;
	/**����ʱ��  **/
	private String holding_Time;
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getFurnace_Type() {
		return furnace_Type;
	}
	public void setFurnace_Type(String furnace_Type) {
		this.furnace_Type = furnace_Type;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getCooling_Method() {
		return cooling_Method;
	}
	public void setCooling_Method(String cooling_Method) {
		this.cooling_Method = cooling_Method;
	}
	public String getHolding_Time() {
		return holding_Time;
	}
	public void setHolding_Time(String holding_Time) {
		this.holding_Time = holding_Time;
	}
	
	
}
