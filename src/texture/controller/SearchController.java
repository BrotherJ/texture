package texture.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import texture.cons.CommonConstant;
import texture.domain.Pagination;
import texture.domain.TextureReport;
import texture.service.ITextureReportService;
import texture.util.StrUtil;


/**
 * ���ڲ�ѯ���ʱ����¼����������ĸ������ĸ
 * @author jiong.sun
 *
 */
@Controller
@RequestMapping(value="/search")
public class SearchController {
	
	@Autowired
	private ITextureReportService textureReportService;
	
	/**
	 * ����������ѯ���ʱ��棬������׷�Ӽ�¼
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/initSearch")
	public String initSearch(Model model,HttpServletRequest request) throws ParseException{
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		//����
		String texture = request.getParameter("texture");
		//������������
		if(texture!=null){
			texture =StrUtil.convertChinessMessyCode(texture);
		}
		//¯��
		String furnace_No = request.getParameter("furnace_No");
		if(furnace_No!=null){
			furnace_No =StrUtil.convertChinessMessyCode(furnace_No);
		}
		// ���Ϻ�
		String material_code = StrUtil.nullToStr(request.getParameter("material_code"));
		
		//���Ϲ��
		String material_spec = StrUtil.nullToStr(request.getParameter("material_spec"));
		if(material_spec!=null){
			material_spec =StrUtil.convertChinessMessyCode(material_spec);
		}
		
		System.out.println(texture+"<>"+furnace_No+"<>"+material_spec);
		
		Map<String, String> map =new HashMap<String, String>();
		//�ж��Ƿ�Ϊ�գ�����Ϊ�գ�����ӵ�������
		if(texture!=null ){
			map.put("texture", texture);
		}
		if(furnace_No!=null ){
			map.put("furnace_No", furnace_No);
		}
		
		
		Pagination<TextureReport> page =this.textureReportService.getPageTextureReportByMaterial(currentPage, CommonConstant.PAGE_SIZE, map,material_code,material_spec);
		model.addAttribute("page",page);
		model.addAttribute("texture", texture);
		model.addAttribute("furnace_No", furnace_No);
		model.addAttribute("material_code", material_code);
		model.addAttribute("material_spec", material_spec);
		
		return "search/init";
	}
	

}
