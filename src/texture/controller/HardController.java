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
import texture.domain.Hard;
import texture.domain.Pagination;
import texture.service.IHardService;
import texture.util.SettingPropertyBeanUtil;
import texture.util.StrUtil;

@Controller
@RequestMapping(value="/hard")
public class HardController {

	@Autowired
	private IHardService hardService;
	
	@RequestMapping(value="/init")
	public String init(HttpServletRequest request,Model model){
		
		//��ȡҳ��
		int currentPage =request.getParameter("page") == null? 1:Integer.valueOf((request.getParameter("page")));
		Map<String, String> map =new HashMap<String, String>();
		//Ӳ��hrc
		String hrc = request.getParameter("hrc")==""?null:request.getParameter("hrc");
		//Ӳ��hb
		String hb = request.getParameter("hb")==""?null:request.getParameter("hb");
		//Ӳ��hb
		String hv = request.getParameter("hv")==""?null:request.getParameter("hv");
		if(hrc!=null){
			map.put("hrc", hrc);
		}
		if(hb!=null){
			map.put("hb", hb);
		}
		if(hv!=null){
			map.put("hv", hv);
		}
		
		//��ҳ��ѯ
		Pagination<Hard> hards = this.hardService.getPageHard(currentPage, CommonConstant.PAGE_SIZE,map);
		model.addAttribute("page", hards);
		model.addAttribute("hrc", hrc);
		model.addAttribute("hb", hb);
		model.addAttribute("hv", hv);
		return "hard/init";
	}
	
	/**
	 * ҳ����ת
	 * @return
	 */
	@RequestMapping(value="/add")
	public String add(){
		return "hard/entity";
	}
	
	/**
	 * ҳ����ת
	 * @return
	 */
	@RequestMapping(value="/edit")
	public String edit(HttpServletRequest request,Model model){
		String id =request.getParameter("id");
		Hard  hard =this.hardService.findHardById(id);
		
		model.addAttribute("hard", hard);
		return "hard/entity";
	}
	
	
	/**
	 * ���湦��
	 * @param request
	 * @param function
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/saveEditOrAdd")
	public String saveEditOrAdd(HttpServletRequest request,Hard hard){
		String jsonStr="";
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		try{
			
			boolean b =this.hardService.checkHardByHBAndHRCAndHV(hard.getId(),hard.getHb(),hard.getHrc(),hard.getHv());
			//�Ѵ���
			if(b){
				this.hardService.saveHard(hard);
				map.put("succeed", true);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg9"));
			}else{
				map.put("succeed", false);
				map.put("msg", SettingPropertyBeanUtil.getPropertyRtnInfo("rtnMsg21"));
			}
			jsonStr = mapper.writeValueAsString(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	/**
	 * ɾ��
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/delHardById")
	public String delHardById(HttpServletRequest request){
		String jsonStr="";
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		try{
			String id =request.getParameter("id");
			this.hardService.delHardById(id);
			map.put("succeed", true);
			jsonStr = mapper.writeValueAsString(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	/**
	 *	����hrcֵ��ȡ��Ӧ��HBֵ
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getHbByHrc")
	public String getHbByHrc(HttpServletRequest request){
		String jsonStr="";
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		try{
			String hrc = request.getParameter("hrc");
			
			if(!hrc.equals("")){
				//��ת��int����ת���ַ���������ȥ��С��������0
				String hb =this.hardService.getHbByHrc(StrUtil.formatDouble2(Double.parseDouble(hrc)));
				if(hb!=null){
					map.put("succeed", true);
					map.put("hb", hb);
				}else{
					map.put("succeed", false);
					map.put("msg", "û��ά����Ӧ��HBֵ�����������룡");
				}
				
				jsonStr = mapper.writeValueAsString(map);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	/**
	 *	����hrcֵ��ȡ��Ӧ��HBֵ
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getHbByHv")
	public String getHbByHv(HttpServletRequest request){
		String jsonStr="";
		Map<String, Object> map =new HashMap<String, Object>();
		ObjectMapper mapper =new ObjectMapper();
		try{
			String hv = request.getParameter("hv");
			
			if(!hv.equals("")){
				//��ת��int����ת���ַ���������ȥ��С��������0
				String hb =this.hardService.getHbByHv(StrUtil.formatDouble2(Double.parseDouble(hv)));
				if(hb!=null){
					map.put("succeed", true);
					map.put("hb", hb);
				}else{
					map.put("succeed", false);
					map.put("msg", "û��ά����Ӧ��HBֵ�����������룡");
				}
				
				jsonStr = mapper.writeValueAsString(map);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return jsonStr;
	}
}
