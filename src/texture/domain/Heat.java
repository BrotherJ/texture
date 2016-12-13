package texture.domain;

/**
 * 热处理
 * @author infodba
 *
 */
public class Heat {

	/**处理方法**/
	private String method;
	/**炉子类型: 0-->电炉   **/
	private String furnace_Type;
	/**温度  **/
	private String temperature;
	/**冷却方法  **/
	private String cooling_Method;
	/**保温时间  **/
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
