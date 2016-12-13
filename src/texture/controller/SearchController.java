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
 * 用于查询材质报告记录，不区分螺母及非螺母
 * @author jiong.sun
 *
 */
@Controller
@RequestMapping(value="/search")
public class SearchController {
	
	@Autowired
	private ITextureReportService textureReportService;
	
	/**
	 * 根据条件查询材质报告，不区分追加记录
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping(value="/initSearch")
	public String initSearch(Model model,HttpServletRequest request) throws ParseException{
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		//材质
		String texture = request.getParameter("texture");
		//处理中文乱码
		if(texture!=null){
			texture =StrUtil.convertChinessMessyCode(texture);
		}
		//炉号
		String furnace_No = request.getParameter("furnace_No");
		if(furnace_No!=null){
			furnace_No =StrUtil.convertChinessMessyCode(furnace_No);
		}
		// 物料号
		String material_code = StrUtil.nullToStr(request.getParameter("material_code"));
		
		//物料规格
		String material_spec = StrUtil.nullToStr(request.getParameter("material_spec"));
		if(material_spec!=null){
			material_spec =StrUtil.convertChinessMessyCode(material_spec);
		}
		
		System.out.println(texture+"<>"+furnace_No+"<>"+material_spec);
		
		Map<String, String> map =new HashMap<String, String>();
		//判断是否为空，若不为空，则添加到集合中
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
