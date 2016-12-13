package texture.domain;

/**
 * 物料尺寸对照表
 * @author jiong.sun
 *
 */
public class MaterialSizeContrast {

	/**id**/
	private String id;
	
	/**物料号**/
	private String material_code;
	
	/**尺寸**/
	private String size;
	
	/**六角最小值**/
	private String minHex;
	
	/**厚六角最小值**/
	private String minHexHex;
	
	/**单位**/
	private String unit;

	public String getMaterial_code() {
		return material_code;
	}

	public void setMaterial_code(String material_code) {
		this.material_code = material_code;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
