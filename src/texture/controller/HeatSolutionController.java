package texture.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import texture.cons.CommonConstant;
import texture.domain.HeatSolution;
import texture.domain.Pagination;
import texture.service.IHeatSolutionService;
import texture.util.StrUtil;

@Controller
@RequestMapping(value="/heatSolution")
public class HeatSolutionController {

	@Autowired
	private IHeatSolutionService heatSolutionService;
	
	/**
	 * ��ʼ��ҳ��
	 * @return
	 */
	@RequestMapping(value="/init")
	public String init(HttpServletRequest request,Model model){
		//��ȡҳ��
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		Map<String, String> map =new HashMap<String, String>();
		//��������
		String cName = request.getParameter("cName");
		//Ӣ������
		String eName = request.getParameter("eName");
		//������������
		if(cName!=null){
			cName =StrUtil.convertChinessMessyCode(cName);
			map.put("cName", cName);
		}
		//������������
		if(eName!=null){
			eName =StrUtil.convertChinessMessyCode(eName);
			map.put("eName", eName);
		}
		
		//��ҳ��ѯ
		Pagination<HeatSolution> heatSolutions = this.heatSolutionService.getPageHeatSolution(currentPage, CommonConstant.PAGE_SIZE,map);
		model.addAttribute("page", heatSolutions);
		model.addAttribute("cName", cName);
		model.addAttribute("eName", eName);
		return "heat/init";
	}
	
	
	/**
	 * ҳ����ת
	 * @return
	 */
	@RequestMapping(value="/add")
	public String add(){
		return "heat/entity";
	}
	
	/**
	 * ҳ����ת
	 * @return
	 */
	@RequestMapping(value="/edit")
	public String edit(HttpServletRequest request,Model model){
		String id =request.getParameter("id");
		HeatSolution  heatSolution =this.heatSolutionService.findHeatSolutionById(id);
		
		model.addAttribute("heatSolution", heatSolution);
		return "heat/entity";
	}
	
	
	/**
	 * ���湦��
	 * @param request
	 * @param function
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveEditOrAdd")
	public String saveEditOrAdd(HttpServletRequest request,HeatSolution heatSolution){
		String jsonStr="";
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		try{
			//ǿ��ת�ɴ�д
			heatSolution.seteName(heatSolution.geteName().toUpperCase());
			this.heatSolutionService.saveHeatSolution(heatSolution);
			map.put("succeed", true);
			jsonStr = mapper.writeValueAsString(map);
		}catch(Exception e){
			e.printStackTrace();
			try{
				map.put("succeed", false);
				jsonStr = mapper.writeValueAsString(map);
			}catch(Exception e1){
				e.printStackTrace();
			}
		}
		return jsonStr;
	}
	
	/**
	 * ɾ��
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delHeatSolutionById")
	public String delFunctionById(HttpServletRequest request){
		String jsonStr="";
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		try{
			String id =request.getParameter("id");
			this.heatSolutionService.delHeatSolutionById(id);
			map.put("succeed", true);
			jsonStr = mapper.writeValueAsString(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return jsonStr;
	}
}
