package texture.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


import texture.domain.Element;
import texture.domain.Material;
import texture.domain.Mechanical;
import texture.domain.TextureReport;
import texture.exception.UserExistException;
import texture.util.SettingPropertyBeanUtil;


/**
 * json转对象
 * @author jiong.sun
 *
 */
public class testJson {

	
	public static void main(String[] args) throws  UserExistException, JsonGenerationException, JsonMappingException, IOException {
		
		Material materil= new Material();
		materil.setMaterial_code("10010001");
		materil.setMaterial_name("阀体");
		materil.setMaterial_spec("test");
		
		List<Element> elements =new ArrayList<Element>();
		
		Element e1= new Element();
		e1.setElement_name("C");
		e1.setEle_value(2);
		e1.setMax(5);
		e1.setMin(0);
		elements.add(e1);
		
		Element e2= new Element();
		e2.setElement_name("SI");
		e2.setEle_value(2);
		e2.setMax(5);
		e2.setMin(0);
		elements.add(e2);
		
		Element e3= new Element();
		e3.setElement_name("Mn");
		e3.setEle_value(2);
		e3.setMax(5);
		e3.setMin(0);
		elements.add(e3);
		
		Element e4= new Element();
		e4.setElement_name("Zn");
		e4.setEle_value(2);
		e4.setMax(5);
		e4.setMin(0);
		elements.add(e4);
		
//		materil.setElements(elements);
		
		Mechanical mechanical =new Mechanical();
		mechanical.setKl(2.2);
		mechanical.setQf(2.2);
		mechanical.setYsh(2.2);
		mechanical.setSs(2.2);
		mechanical.setYd(2.2);
		mechanical.setCjz1("2.2");
		mechanical.setCjz2("2.2");
		mechanical.setCjz3("2.2");
		
//		materil.setMechanical(mechanical);
		
		String s = objectToJson(materil);
		System.out.println(s);
		
//		String json = "{'material_code':'10010001',material_name:'阀体','material_spec':'test','elements':[{'element_name':'C','max':5.0,'min':0.0,'ele_value':2.0},{'element_name':'SI','max':5.0,'min':0.0,'ele_value':2.0},{'element_name':'Mn','max':5.0,'min':0.0,'ele_value':2.0},{'element_name':'Zn','max':5.0,'min':0.0,'ele_value':2.0}],'mechanical':null}";
		String json = "{texture:'wcb',texture_stand:'1111',furnace_No:'123',standAndVersionNum:'www',certificate_No:'v1',table_no:'1131',version:'v2'}";
//		Material material =jsonToObject(json);
//		System.out.println(material.getMaterial_code()+"<>");
//		List<Element> elements2=material.getElements();
//		for (Element element : elements2) {
//			System.out.println(element.getElement_name());
//		}
		TextureReport textureReport=jsonToTexureReport(json);
		
		System.out.println(textureReport.getTexture());
	}
	
	public static String objectToJson(Material material) throws JsonGenerationException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		String s =mapper.writeValueAsString(material);
		
		return s;
	}
	
	/**
	 * json转成材质报告对象
	 * @param json
	 * @return
	 * @throws UserExistException
	 */
	public static TextureReport jsonToTexureReport(String json) throws UserExistException{
		TextureReport materil =null;
		try{
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
			mapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
			materil = mapper.readValue(json.toString(), TextureReport.class);  
		}catch (Exception e) {
			throw  new UserExistException(SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg40"));
		}
		return materil;
	}
	

	
	public static Material jsonToObject(String json) throws JsonParseException, JsonMappingException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		mapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
		Material materil = mapper.readValue(json.toString(), Material.class);  
		
		return materil;
	}
}
