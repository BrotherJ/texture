package texture.domain;


/**
 * ���ϱ�  
 * @author infodba
 *
 */
public class Material {

	/**���Ϻ�**/
	private String material_code;
	/**�������**/
	private String material_name;
	/**Ӣ������**/
	private String material_name_en;
	/**���**/
	private String material_spec;
	/**����**/
	private int num;
	/**�ߴ�**/
	private String size;
	/**��ĸ ��֤�غ� **/
	private NutProof nutProof;
	
	public String getMaterial_code() {
		return material_code;
	}
	public void setMaterial_code(String material_code) {
		this.material_code = material_code;
	}
	public String getMaterial_name() {
		return material_name;
	}
	public void setMaterial_name(String material_name) {
		this.material_name = material_name;
	}
	public String getMaterial_spec() {
		return material_spec;
	}
	public void setMaterial_spec(String material_spec) {
		this.material_spec = material_spec;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getMaterial_name_en() {
		return material_name_en;
	}
	public void setMaterial_name_en(String material_name_en) {
		this.material_name_en = material_name_en;
	}
	public NutProof getNutProof() {
		return nutProof;
	}
	public void setNutProof(NutProof nutProof) {
		this.nutProof = nutProof;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	
	
}
