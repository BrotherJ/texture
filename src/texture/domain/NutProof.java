package texture.domain;

/**
 * 螺母保证载荷
 * @author jiong.sun
 *
 */
public class NutProof {

	/**厚六角 标准 **/
	private  String hexHex;
	
	/**六角 标准 **/
	private String hex;
	/**单位**/
	private String unit;
	
	/**六角标准下限**/
	private String minHex;
	/**厚六角标准下限**/
	private String minHexHex;

	public String getHexHex() {
		return hexHex;
	}

	public void setHexHex(String hexHex) {
		this.hexHex = hexHex;
	}

	public String getHex() {
		return hex;
	}

	public void setHex(String hex) {
		this.hex = hex;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getMinHex() {
		return minHex;
	}

	public void setMinHex(String minHex) {
		this.minHex = minHex;
	}

	public String getMinHexHex() {
		return minHexHex;
	}

	public void setMinHexHex(String minHexHex) {
		this.minHexHex = minHexHex;
	}
	
}
