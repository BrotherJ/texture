package texture.domain;

import java.util.List;
import texture.domain.VO.ZMtrCodeVO;


/**
 * ���ʱ�׼�� -- ���ڴ��webservice ��ȡ���ʱ�׼��Ϣ
 * @author infodba
 *
 */
public class TextureStandard {

	/**����**/
	private String texture;
	/**���������ֶ�**/
	private String texture_stand;
	/**ce**/
	private String ce;
	/**pren**/
	private String pren;
	
	/**PREN��׼ֵ**/
	private double pren_standard;
	/**PREN��׼ֵ �жϷ���  ����С�ڵ���**/
	private String  pren_b;
	/**CE��׼ֵ**/
	private double ce_standard;
	
	/**��ѧԪ��**/
	private List<Element> elements;
	
	/**�ȴ���**/
	private List<Heat> heats;
	
	/**��е����**/
	private Mechanical mechanical;
	
	/**���»�е����**/
	private GwMechanical gwMechanical;
	
	/**��ϲ���**/
	private List<ZMtrCodeVO> zMtrCodeVOs;

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public String getTexture_stand() {
		return texture_stand;
	}

	public void setTexture_stand(String texture_stand) {
		this.texture_stand = texture_stand;
	}

	public String getCe() {
		return ce;
	}

	public void setCe(String ce) {
		this.ce = ce;
	}

	public String getPren() {
		return pren;
	}

	public void setPren(String pren) {
		this.pren = pren;
	}

	public List<Element> getElements() {
		return elements;
	}

	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

	public List<Heat> getHeats() {
		return heats;
	}

	public void setHeats(List<Heat> heats) {
		this.heats = heats;
	}

	public Mechanical getMechanical() {
		return mechanical;
	}

	public void setMechanical(Mechanical mechanical) {
		this.mechanical = mechanical;
	}
	
	public double getPren_standard() {
		return pren_standard;
	}

	public void setPren_standard(double pren_standard) {
		this.pren_standard = pren_standard;
	}

	public String getPren_b() {
		return pren_b;
	}

	public void setPren_b(String pren_b) {
		this.pren_b = pren_b;
	}

	public double getCe_standard() {
		return ce_standard;
	}

	public void setCe_standard(double ce_standard) {
		this.ce_standard = ce_standard;
	}

	public List<ZMtrCodeVO> getzMtrCodeVOs() {
		return zMtrCodeVOs;
	}

	public void setzMtrCodeVOs(List<ZMtrCodeVO> zMtrCodeVOs) {
		this.zMtrCodeVOs = zMtrCodeVOs;
	}

	public GwMechanical getGwMechanical() {
		return gwMechanical;
	}

	public void setGwMechanical(GwMechanical gwMechanical) {
		this.gwMechanical = gwMechanical;
	}
	

}
