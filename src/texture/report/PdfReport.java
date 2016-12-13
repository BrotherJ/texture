package texture.report;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import texture.client.ZMM_GET_MTRCZServiceStubTest;
import texture.common.CommonMethods;
import texture.cons.CommonConstant;
import texture.domain.CoolMethod;
import texture.domain.CustomizeElement;
import texture.domain.GwMechanical;
import texture.domain.Heat;
import texture.domain.HeatSolution;
import texture.domain.Material;
import texture.domain.Mechanical;
import texture.domain.TextureReport;
import texture.domain.User;
import texture.domain.VO.ZMtrCodeVO;
import texture.service.ContextUtil;
import texture.service.ICoolMethodService;
import texture.service.IHardService;
import texture.service.IHeatSolutionService;
import texture.service.IUserService;
import texture.util.SettingPropertyBeanUtil;
import texture.util.StrUtil;
import texture.util.StringCaculate;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * 生成PDF 材质报表
 * @author infodba
 *
 */
public class PdfReport {

	/**上限值**/
	public  static final double MAX_VALUE=9999;
	/**下限值**/
	public  static final double MIN_VALUE=0;

	/**
	 * 通过输出流的方式输出生成的pdf文件
	 * @param outputStream  输出流
	 * @return  文件路径
	 */
	public static void createPdfReport(OutputStream outputStream,TextureReport textureReport,User currentUser){
		 Document document = new Document(PageSize.A4.rotate(),10,10,20,10);
	        try { 
	         PdfWriter.getInstance(document,outputStream);
	         document.open();
	
	         BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);  
	         //11号 加粗
	         Font fontZH = new Font(bfChinese, 11, Font.BOLD);
	         //10号 普通
	         Font fontPT = new Font(bfChinese, 9, Font.NORMAL);
	         //10号 普通
	         Font fontPT_S = new Font(bfChinese, 7, Font.NORMAL);
	         
	         //设置盖章 
	         User user =getUserByCNameAndCAddress(textureReport.getCreateUser(), textureReport.getAddress());
	        
	         //化学元素
	         List<texture.domain.Element> elements =textureReport.getElements();
	         //自定义元素
	         List<CustomizeElement> customizeElements = textureReport.getCustomizeElements();
	         //机械性能
	         Mechanical mechanical =textureReport.getMechanical();
	         //物料
	         List<Material> materials =textureReport.getMaterials();
	         //热处理
	         List<Heat> heats =textureReport.getHeats();
	         //ce pren 值
	         String ce = textureReport.getCe();
	         String pren =textureReport.getPren();
	         
	         //一页只显示4条物料记录，有多余的记录则下一页显示
	         int s =(int)Math.ceil((double)materials.size()/4);
	         for (int i = 0; i < s; i++) {
	        	 List<Material> pageMaterials =getPdfPageMaterials(i, s, materials, 4);
        		
        		  //新开一页
	             document.newPage();
	             if(user!=null){
	            	 if(user.getStampPath()!=null){
			        	 Image image = Image.getInstance(user.getStampPath());
			        	 image.setAbsolutePosition(650, 10);
				         document.add(image);
	            	 }
		         }
        		//头部表格
		         setTableHead(document,fontZH,fontPT,fontPT_S,textureReport);
		         //订单信息表格
		         setOrderInfoTable(document,fontZH,fontPT,fontPT_S,textureReport);
		         //元素、炉号、零件表格
		         setDetailInfo(document,fontPT_S,fontPT,elements,customizeElements,mechanical,textureReport);
		         //元素、炉号、零件表格 具体值 表格
		         setDetailData(document,fontPT_S,elements,customizeElements,mechanical,pageMaterials,ce,pren,textureReport.getzMtrCodeVOs());
		         //热处理表头
		         setHeatTreatMentTitle(document,fontPT_S);
		         //热处理表头内容
		         setHeatTreatMentInfo(document,fontPT_S,heats,textureReport,currentUser);
		         //确认信息
		         setConfirmInfo(document,fontPT);
		         //设置签字表格
		         setSignTable(document,fontPT,textureReport,user);
	         }
	         
	      
	         //判断是否有高温机械性能，若有则新生成一页
	         GwMechanical gwMechanical = textureReport.getGwMechanical();
	         if(gwMechanical!=null){
			         for (int i = 0; i < s; i++) {
			         //获取每页应显示的物料
		        	 List<Material> pageMaterials =getPdfPageMaterials(i, s, materials, 4);
		        		
		        	 //新开一页
		             document.newPage();
		             if(user!=null){
		            	 if(user.getStampPath()!=null){
				        	 Image image = Image.getInstance(user.getStampPath());
				        	 image.setAbsolutePosition(650, 10);
					         document.add(image);
		            	 }
			         }
		             //头部表格
			         setTableHead(document,fontZH,fontPT,fontPT_S,textureReport);
			         //订单信息表格
			         setOrderInfoTable(document,fontZH,fontPT,fontPT_S,textureReport);
			         //元素、炉号、零件表格
			         setGwDetailInfo(document,fontPT_S,fontPT,elements,customizeElements,gwMechanical,mechanical,textureReport);
			         //元素、炉号、零件表格 具体值 表格
			         setGwDetailData(document,fontPT_S,elements,customizeElements,gwMechanical,mechanical,pageMaterials,ce,pren,textureReport.getzMtrCodeVOs());
			         //热处理表头
			         setHeatTreatMentTitle(document,fontPT_S);
			         //热处理表头内容
			         setHeatTreatMentInfo(document,fontPT_S,heats,textureReport,currentUser);
			         //确认信息
			         setConfirmInfo(document,fontPT);
			         //设置签字表格
			         setSignTable(document,fontPT,textureReport,user);
		         }
	         }
	         
	     } catch (Exception e) {
	         e.printStackTrace();
	     } finally {
	         document.close();
	     }
	}
	
	/**
	 * 在指定路径下生成pdf文件，并将文件路径返回
	 * @return  文件路径
	 */
	public static String createPdfReport(){
		 Document document = new Document(PageSize.A4.rotate(),10,10,20,10);
		 String path="";
	        try { 
        	 String filePath = SettingPropertyBeanUtil.getPropertyInfo("filepath");
        	 String fileName = StrUtil.getDateToStr(new Date());
        	 path =filePath +"\\"+fileName+".pdf";
	        	
	         PdfWriter.getInstance(document,new FileOutputStream(path));
	         document.open();
	
	         BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);  
	         //11号 加粗
	         Font fontZH = new Font(bfChinese, 11, Font.BOLD);
	         //10号 普通
	         Font fontPT = new Font(bfChinese, 10, Font.NORMAL);
	         //10号 普通
	         Font fontPT_S = new Font(bfChinese, 8, Font.NORMAL);
	         
	         //头部表格
	         setTableHead(document,fontZH,fontPT,fontPT_S,new TextureReport());
	         //订单信息表格
	         setOrderInfoTable(document,fontZH,fontPT,fontPT_S,new TextureReport());
	         
	         List<String> elements =new ArrayList<String>();
	         elements.add("C");
	         elements.add("SI");
	         elements.add("Mn");
	         elements.add("P");
	         elements.add("S");
	         elements.add("Cr");
	         elements.add("Ni");
	         elements.add("Mo");
	         elements.add("Cu");
	         
	         //元素、炉号、零件表格
	         //setDetailInfo(document,fontPT_S,elements);
	         
	         //元素、炉号、零件表格 具体值 表格
	         //setDetailData(document,fontPT_S,elements);
	         
	         //热处理表头
	         setHeatTreatMentTitle(document,fontPT_S);
	         
	         //热处理表头内容
//	         setHeatTreatMentInfo(document,fontPT_S);
	         
	         //确认信息
	         setConfirmInfo(document,fontPT);
	         
	         //设置签字表格
//	         setSignTable(document,fontPT);
	     } catch (Exception e) {
	         e.printStackTrace();
	     } finally {
	         document.close();
	     }
	     return path;  
	}
	
	/**
	 * 设置表头信息
	 * @param document
	 * @param fontZH
	 * @param fontPT
	 * @param textureReport  材质报告对象
	 */
	public static void setTableHead(Document document,Font fontZH,Font fontPT,Font fontPT_S,TextureReport textureReport){
		try{
			PdfPTable table1 =new PdfPTable(3);
	        int headerwidths[] = { 30,40,30 }; // percentage
	        table1.setWidths(headerwidths);
	        table1.setWidthPercentage(100);
	        //设置单元格
	        PdfPCell cell1 =new PdfPCell();
	       
	        //获取用户 信息
	        User user =getUserByCNameAndCAddress(textureReport.getCreateUser(), textureReport.getAddress());
	        //设置内容及字体
	        Paragraph p1=null;
	        Paragraph p1_1=null;
	        if(user!=null){
	        	p1=new Paragraph(textureReport.getCreateUser()+"\n"+textureReport.getAddress(),fontZH);
		        p1_1=new Paragraph(user.getNameEn()+"\n"+user.getAddressEn(),fontPT_S);
	        }
	        else{
	        	p1=new Paragraph(textureReport.getCreateUser()+"\n"+textureReport.getAddress(),fontZH);
		        p1_1=new Paragraph("",fontPT_S);
	        }
	        
	        //设置字体是否居中 
	        p1.setAlignment(Element.ALIGN_CENTER);
	        p1_1.setAlignment(Element.ALIGN_CENTER);
	        //在单元格中显示
	        cell1.addElement(p1);
	        cell1.addElement(p1_1);
	        //设置 3行合并为1行
	        cell1.setRowspan(3);
	        table1.addCell(cell1);
	        
	        PdfPCell cell2 =new PdfPCell();
	        //设置内容及字体
	        Paragraph p2 =new Paragraph("材质证明书\nMATERIAL TEST CERTIFICATE\nEN10204-2004 Type 3.1", fontZH);
	        p2.setAlignment(Element.ALIGN_CENTER);
	        cell2.addElement(p2);
	        cell2.setRowspan(3);
	        table1.addCell(cell2);
	        
	        PdfPCell cell_bm =new PdfPCell(new Paragraph("表码  Form No. ："+textureReport.getTable_no(), fontPT));
	        cell_bm.setMinimumHeight(20);
	        table1.addCell(cell_bm);
	        PdfPCell cell_bb =new PdfPCell(new Paragraph("版本号 Rev No. ："+textureReport.getVersion(), fontPT));
	        cell_bb.setMinimumHeight(20);
	        table1.addCell(cell_bb);
	        PdfPCell cell_bh =new PdfPCell(new Paragraph("证书编号 Cert No.："+textureReport.getCertificate_No(), fontPT));
	        cell_bh.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        cell_bh.setMinimumHeight(20);
	        table1.addCell(cell_bh);

	        document.add(table1);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 设置订单信息
	 * @param document
	 * @param fontZH
	 * @param fontPT
	 */
	public static void setOrderInfoTable(Document document,Font fontZH,Font fontPT,Font fontPT_S,TextureReport textureReport){
		try{
			PdfPTable table2 =new PdfPTable(8);
	         int tablewidths[] = { 10,15,10,8,10,20,12,15 }; // percentage
	         table2.setWidths(tablewidths);
	         table2.setWidthPercentage(100);
	         
	         PdfPCell cell_cus =new PdfPCell(new Paragraph("顾客\nCustomer",fontPT));
	         cell_cus.setMinimumHeight(30);
	         cell_cus.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell_cus.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         table2.addCell(cell_cus);
	         
	         PdfPCell cell_cus_name =new PdfPCell();
	         Paragraph p1 =new Paragraph("苏州纽威阀门股份有限公司",fontPT);
	         Paragraph p2 =new Paragraph("NEWAY VALVE(SUZHOU)CO.,LTD",fontPT_S);
	         cell_cus_name.addElement(p1);
	         cell_cus_name.addElement(p2);
	         cell_cus_name.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         cell_cus_name.setHorizontalAlignment(Element.ALIGN_CENTER);
	         table2.addCell(cell_cus_name);
	         PdfPCell cell_order =new PdfPCell(new Paragraph("炉号\nHeat  No.",fontPT));
	         cell_order.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell_order.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         table2.addCell(cell_order);
	         //炉号内容
	         PdfPCell cell_order_name =new PdfPCell(new Paragraph(textureReport.getFurnace_No(),fontPT));
//	         cell_order_name.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell_order_name.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         table2.addCell(cell_order_name);
	         
	         
	         PdfPCell cell_material =new PdfPCell(new Paragraph("材料\nMaterial",fontPT));
	         cell_material.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell_material.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         table2.addCell(cell_material);
	         //材质内容
	         String textureContext = "";
	         //判断材质描述字段是否为null
	         if(textureReport.getTexture_stand()==null){
	        	 textureContext = textureReport.getTexture();
	         }else{
	        	 //textureContext=textureReport.getTexture_stand()+" "+textureReport.getTexture() ;
	        	 //由于此处材质需要显示MTR材质而不是NW材质
	        	 textureContext=textureReport.getTexture_stand()+" "+ZMM_GET_MTRCZServiceStubTest.getMTRZcz(textureReport.getMaterials().get(0).getMaterial_code(),textureReport.getTexture()) ;
	         }
	         PdfPCell cell_material_info =new PdfPCell(new Paragraph(textureContext,fontPT));
	         cell_material_info.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         table2.addCell(cell_material_info);
	         
	         
	         PdfPCell cell_spe =new PdfPCell(new Paragraph("标准和版本号\nSpecification & Rev.No.",fontPT));
	         cell_spe.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell_spe.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         table2.addCell(cell_spe);
	         //标准和版本内容
	         PdfPCell cell_spe_info =new PdfPCell(new Paragraph(textureReport.getStandAndVersionNum(),fontPT));
	         cell_spe_info.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         table2.addCell(cell_spe_info);
	         document.add(table2);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 生成详细信息的表单 
	 * @param document
	 * @param fontPT_S
	 */
	public static void setDetailInfo(Document document,Font fontPT_S,Font fontPT,List<texture.domain.Element> elements,List<CustomizeElement> customizeElements,Mechanical mechanical,TextureReport textureReport){
		try{
			//设置table 
			PdfPTable table_left=null;
			//自定义元素总数
			int customizeElementSize=0;
			if(customizeElements!=null){
				customizeElementSize= customizeElements.size();
				table_left =new PdfPTable(5+elements.size()+customizeElementSize+8+2);
			}else{
				table_left =new PdfPTable(5+elements.size()+8+2);
			}
			
			table_left.setWidthPercentage(100);
			table_left.setHorizontalAlignment(0);
			float arr[] = getCellWidth(elements,customizeElements);
			table_left.setWidths(arr);
			
			
			//设置物料号列
			PdfPCell cell0 =new PdfPCell(new Paragraph("物料号\nMaterial No.", fontPT_S));
	        setCell(cell0, fontPT_S, 4, 0, 0, true, true);
	        table_left.addCell(cell0);
			
	        //设置零件名称列
			PdfPCell cell1 =new PdfPCell(new Paragraph("零件名称\nPart Name", fontPT_S));
	        setCell(cell1, fontPT_S, 4, 0, 0, true, true);
	        table_left.addCell(cell1);
			
	        //设置零件规格列
	        PdfPCell cell2 =new PdfPCell(new Paragraph("零件规格\nPart Size", fontPT_S));
	        setCell(cell2, fontPT_S, 4, 0, 0, true, true);
	        table_left.addCell(cell2);
	        
	        //设置数量列
	        PdfPCell cell3 =new PdfPCell(new Paragraph("数量\nQTY", fontPT_S));
	        setCell(cell3, fontPT_S, 4, 0, 0, true, true);
	        table_left.addCell(cell3);
	        
	        PdfPCell cell_ys =new PdfPCell(new Paragraph("元素\nElement", fontPT_S));
	        setCell(cell_ys, fontPT_S, 2, 0, 0, true, true);
	        table_left.addCell(cell_ys);
	        
	        //化学成分列
	        PdfPCell cell_hxcf =new PdfPCell(new Paragraph("化学成分 Chemical composition  (%)",fontPT));
	        //所有元素+ce+pren
//	        cell_hxcf.setColspan(elements.size()+2);
//	        //设置高度
	        setCell(cell_hxcf, fontPT_S, 0, elements.size()+customizeElementSize+2, 35, true, true);
	        table_left.addCell(cell_hxcf);
	        
	        //机械性能
	        PdfPCell cell_jxxn =new PdfPCell(new Paragraph("机械性能 Mechanical Property",fontPT));
	        setCell(cell_jxxn, fontPT_S, 0, 8, 0, true, true);
	        table_left.addCell(cell_jxxn);
	        
	        
	        //元素行,遍历集合
	        for (int i = 0; i < elements.size(); i++) {
	        	PdfPCell cell_i= new PdfPCell(new Paragraph(elements.get(i).getElement_name(),fontPT_S));
	        	setCell(cell_i, fontPT_S, 0, 0, 0, true, true);
	        	table_left.addCell(cell_i);
			}
	        //自定义元素行，遍历
	        if(customizeElements!=null){
		        for (int i = 0; i <customizeElements.size(); i++) {
		        	PdfPCell cell_i= new PdfPCell(new Paragraph(customizeElements.get(i).getElement_name(),fontPT_S));
		        	setCell(cell_i, fontPT_S, 0, 0, 0, true, true);
		        	table_left.addCell(cell_i);
				}
	        }
	      	//CE
	        PdfPCell cell_ce =new PdfPCell(new Paragraph("CE",fontPT_S));
	        setCell(cell_ce, fontPT_S, 0, 0, 0, true, true);
	        table_left.addCell(cell_ce);
	        //PREN
	        PdfPCell cell_pren =new PdfPCell(new Paragraph("PREN",fontPT_S));
	        setCell(cell_pren, fontPT_S, 0, 0, 0, true, true);
	        table_left.addCell(cell_pren);
	        
	        
	        //抗拉
	        PdfPCell cell_kl =new PdfPCell(new Paragraph("抗拉 \nTS\n(Mpa)",fontPT_S));
	        setCell(cell_kl, fontPT_S, 0, 0, 0, true, true);
	        table_left.addCell(cell_kl);
	        //屈服
	        PdfPCell cell_qf =new PdfPCell(new Paragraph("屈服\nYS\n(Mpa)",fontPT_S));
	        setCell( cell_qf, fontPT_S, 0, 0, 0, true, true);
	        table_left.addCell(cell_qf);
	        //延伸
	        PdfPCell cell_ysn =new PdfPCell(new Paragraph("延伸\nE\n(%)",fontPT_S));
	        setCell( cell_ysn, fontPT_S, 0, 0, 0, true, true);
	        table_left.addCell(cell_ysn);
	        //收缩
	        PdfPCell cell_ss =new PdfPCell(new Paragraph("收缩 \nR\n(%)",fontPT_S));
	        setCell( cell_ss, fontPT_S, 0, 0, 0, true, true);
	        table_left.addCell(cell_ss);
	        //硬度
	        PdfPCell cell_yd =new PdfPCell(new Paragraph("硬度 \nHardness\n(HB)",fontPT_S));
	        setCell( cell_yd, fontPT_S, 0, 0, 0, true, true);
	        table_left.addCell(cell_yd);
	        //冲击试验Impact Test
	        //若实际温度为空时，取标准冲击温度
	        String cjwd = mechanical.getSjwd()==null ?StrUtil.nullToStr(mechanical.getCjwd()):StrUtil.nullToStr(mechanical.getSjwd());
	        PdfPCell cell_cj =new PdfPCell(new Paragraph("冲击试验Impact Test\n冲击值 Akv，J\n温度 Tem:"+cjwd+"℃：",fontPT_S));
	        setCell( cell_cj, fontPT_S, 0, 3, 0, true, true);
	        table_left.addCell(cell_cj);
	        
	        
	        //max值 行
	        PdfPCell cell_Max =new PdfPCell(new Paragraph("Max", fontPT_S));
	        setCell( cell_Max, fontPT_S, 0, 0, 20, true, true);
	        table_left.addCell(cell_Max);
	        //遍历集合
	        for (int i = 0; i < elements.size(); i++) {
	        	PdfPCell cell_i_Max=null;
	        	if(elements.get(i).getMax() == MAX_VALUE || elements.get(i).getMax() == MIN_VALUE){
	        		cell_i_Max= new PdfPCell();
	        	}else{
	        		cell_i_Max= new PdfPCell(new Paragraph(StrUtil.formatDouble(elements.get(i).getMax()),fontPT_S));
	        	}
	        	
	        	setCell( cell_i_Max, fontPT_S, 0, 0, 20, true, true);
	        	table_left.addCell(cell_i_Max);
			}
	        //自定义元素行，遍历
	        if(customizeElements!=null){
		        for (int i = 0; i <customizeElements.size(); i++) {
		        	PdfPCell cell_i= new PdfPCell();
		        	setCell(cell_i, fontPT_S, 0, 0, 0, true, true);
		        	table_left.addCell(cell_i);
				}
	        }
	        //CE
	        PdfPCell cell_ce_Max=null;
	        //获取公式信息
	        List<ZMtrCodeVO> zMtrCodeVOs= textureReport.getzMtrCodeVOs();
	        ZMtrCodeVO zMtrCodeVO=null;
	        if(zMtrCodeVOs!=null){
	        	//判断是否需要计算CE值 ，若需要，则显示CE标准值
		        if(textureReport.getCe().toString().equals("true")){
			        for (ZMtrCodeVO zMtrCodeVO1 : zMtrCodeVOs) {
						if(zMtrCodeVO1.getZmtr_code().equals("CE")){
							//判断碳元素含量及公式是否满足要求
							boolean isNeedCeCheck = CommonMethods.isNeedCeCheck(elements, zMtrCodeVO1);
							if(isNeedCeCheck){
								zMtrCodeVO = zMtrCodeVO1;
							}
						}
					}
		        	//判断上限是否为空
		        	if(zMtrCodeVO.getUpper_value()!=null){
		        		cell_ce_Max = new PdfPCell(new Paragraph(zMtrCodeVO.getUpper_value(),fontPT_S));
		        	}else{
			        	cell_ce_Max = new PdfPCell();
			        }
		        }else{
		        	cell_ce_Max = new PdfPCell();
		        }
	        }else{
	        	cell_ce_Max = new PdfPCell();
	        }
	        setCell(cell_ce_Max, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_ce_Max);
        	
        	//PREN 
	        PdfPCell cell_pren_Max=null;
	        if(zMtrCodeVOs!=null){
	        	//判断是否需要显示pren标准值
		        if(textureReport.getPren().toString().equals("true")){
		        	//遍历所有公式，判断是否有mtr显示名称为PREN的
			        for (ZMtrCodeVO zMtrCodeVO1 : zMtrCodeVOs) {
						if(zMtrCodeVO1.getZmtr_code().equals("PREN")){
							zMtrCodeVO = zMtrCodeVO1;
						}
					}
		        	//判断上限是否为空
		        	if(zMtrCodeVO.getUpper_value()!=null){
		        		cell_pren_Max = new PdfPCell(new Paragraph(zMtrCodeVO.getUpper_value(),fontPT_S));
		        	}else{
		        		cell_pren_Max = new PdfPCell();
			        }
		        }else{
		        	cell_pren_Max = new PdfPCell();
		        }
	        }else{
	        	cell_pren_Max = new PdfPCell();
	        }
	        setCell(cell_pren_Max, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_pren_Max);
	        
	        //抗拉 
        	PdfPCell cell_kl_Max=null;
        	if(mechanical.getKl_max()==MAX_VALUE){
        		cell_kl_Max= new PdfPCell();
        	}else{
        		cell_kl_Max= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(mechanical.getKl_max()),fontPT_S));
        	}
	        setCell( cell_kl_Max, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_kl_Max);
        	//屈服
        	PdfPCell cell_qf_Max=null;
        	if(mechanical.getQf_max()==MAX_VALUE){
        		cell_qf_Max= new PdfPCell();
        	}else{
        		cell_qf_Max= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(mechanical.getQf_max()),fontPT_S));
        	}
        	setCell( cell_qf_Max, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_qf_Max);
        	//延伸
        	PdfPCell cell_ysn_Max=null;
        	if(mechanical.getYsh_max()==MAX_VALUE){
        		cell_ysn_Max= new PdfPCell();
        	}else{
        		cell_ysn_Max= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(mechanical.getYsh_max()),fontPT_S));
        	}
        	setCell( cell_ysn_Max, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_ysn_Max);
        	//收缩
        	PdfPCell cell_ss_MAx=null;
        	if(mechanical.getSs_max()==MAX_VALUE){
        		cell_ss_MAx= new PdfPCell();
        	}else{
        		cell_ss_MAx= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(mechanical.getSs_max()),fontPT_S));
        	}
        	setCell( cell_ss_MAx, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_ss_MAx);
        	//硬度
        	PdfPCell cell_yd_Max=null;
        	if(mechanical.getYd_max()==MAX_VALUE){
        		cell_yd_Max= new PdfPCell();
        	}else{
        		cell_yd_Max= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(mechanical.getYd_max()),fontPT_S));
        	}
        	setCell( cell_yd_Max, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_yd_Max);
        	
        	PdfPCell cell_cj_1= new PdfPCell(new Paragraph("Avg："+StrUtil.nullToStr(mechanical.getCj_avg())+"      Min："+StrUtil.nullToStr(mechanical.getCj_min()),fontPT_S));
        	setCell( cell_cj_1, fontPT_S, 0, 3, 0, false, false);
        	table_left.addCell(cell_cj_1);
        	
	        //min 行
	        PdfPCell cell_Min =new PdfPCell(new Paragraph("Min", fontPT_S));
	        setCell( cell_Min, fontPT_S, 0, 0, 20, true, true);
	        table_left.addCell(cell_Min);
	        for (int i = 0; i < elements.size(); i++) {
	        	PdfPCell cell_i_Min=null;
	        	if(elements.get(i).getMin()==MIN_VALUE){
	        		cell_i_Min= new PdfPCell();
	        	}else{
	        		cell_i_Min= new PdfPCell(new Paragraph(StrUtil.formatDouble(elements.get(i).getMin()),fontPT_S));
	        	}
	        	setCell( cell_i_Min, fontPT_S, 0, 0, 0, true, true);
	        	table_left.addCell(cell_i_Min);
			}
	        //自定义元素
	        if(customizeElements!=null){
		        for (int i = 0; i <customizeElements.size(); i++) {
		        	PdfPCell cell_i= new PdfPCell();
		        	setCell(cell_i, fontPT_S, 0, 0, 0, true, true);
		        	table_left.addCell(cell_i);
				}
	        }
	        //CE
	        PdfPCell cell_ce_Min= new PdfPCell();
	        if(zMtrCodeVOs!=null){
	        	//判断是否需要显示CE值 ，若需要，则显示CE标准值
		        if(textureReport.getCe().toString().equals("true")){
			        for (ZMtrCodeVO zMtrCodeVO1 : zMtrCodeVOs) {
						if(zMtrCodeVO1.getZmtr_code().equals("CE")){
							//判断碳元素含量及公式是否满足要求
							boolean isNeedCeCheck = CommonMethods.isNeedCeCheck(elements, zMtrCodeVO1);
							if(isNeedCeCheck){
								zMtrCodeVO = zMtrCodeVO1;
							}
						}
					}
		        	//判断上限是否为空
		        	if(zMtrCodeVO.getLower_value()!=null){
		        		cell_ce_Min = new PdfPCell(new Paragraph(zMtrCodeVO.getLower_value(),fontPT_S));
		        	}else{
		        		cell_ce_Min = new PdfPCell();
			        }
		        }else{
		        	cell_ce_Min = new PdfPCell();
		        }
	        }else{
	        	cell_ce_Min = new PdfPCell();
	        }
	        setCell(cell_ce_Min, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_ce_Min);
        	//PREN 
	        PdfPCell cell_pren_Min= null;
	        if(zMtrCodeVOs!=null){
	        	if(textureReport.getPren().toString().equals("true")){
			        for (ZMtrCodeVO zMtrCodeVO1 : zMtrCodeVOs) {
						if(zMtrCodeVO1.getZmtr_code().equals("PREN")){
							zMtrCodeVO = zMtrCodeVO1;
						}
					}
		        	//判断上限是否为空
		        	if(zMtrCodeVO.getLower_value()!=null){
		        		cell_pren_Min = new PdfPCell(new Paragraph(zMtrCodeVO.getLower_value(),fontPT_S));
		        	}else{
		        		cell_pren_Min = new PdfPCell();
			        }
		        }else{
		        	cell_pren_Min = new PdfPCell();
		        }
	        }else{
	        	cell_pren_Min = new PdfPCell();
	        }
	        
	        setCell(cell_pren_Min, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_pren_Min);
        	
        	//抗拉 min
        	PdfPCell cell_kl_Min= null;
        	if(mechanical.getKl_min()==MIN_VALUE){
        		cell_kl_Min= new PdfPCell();
        	}else{
        		cell_kl_Min= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(mechanical.getKl_min()),fontPT_S));
        	}
	        setCell( cell_kl_Min, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_kl_Min);
        	
        	//屈服
        	PdfPCell cell_qf_Min= null;
        	if(mechanical.getQf_min()==MIN_VALUE){
        		cell_qf_Min= new PdfPCell();
        	}else{
        		cell_qf_Min= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(mechanical.getQf_min()),fontPT_S));
        	}
        	setCell( cell_qf_Min, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_qf_Min);
        	
        	//延伸
        	PdfPCell cell_ysn_Min= null;
        	if(mechanical.getYsh_min()==MIN_VALUE){
        		cell_ysn_Min= new PdfPCell();
        	}else{
        		cell_ysn_Min= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(mechanical.getYsh_min()),fontPT_S));
        	}
        	setCell( cell_ysn_Min, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_ysn_Min);
        	
        	//收缩
        	PdfPCell cell_ss_Min= null;
        	if(mechanical.getSs_min()==MIN_VALUE){
        		cell_ss_Min= new PdfPCell();
        	}else{
        		cell_ss_Min= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(mechanical.getSs_min()),fontPT_S));
        	}
        	setCell( cell_ss_Min, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_ss_Min);
        	
        	//硬度
        	PdfPCell cell_yd_Min= null;
        	if(mechanical.getYd_min()==MIN_VALUE){
        		cell_yd_Min= new PdfPCell();
        	}else{
        		cell_yd_Min= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(mechanical.getYd_min()),fontPT_S));
        	}
        	setCell( cell_yd_Min, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_yd_Min);
        	
        	//冲击温度
        	PdfPCell cell_cj_1_1= new PdfPCell(new Paragraph("1",fontPT_S));
        	setCell( cell_cj_1_1, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_cj_1_1);
        	
        	//平均值
        	PdfPCell cell_cj_1_2= new PdfPCell(new Paragraph("2",fontPT_S));
        	setCell( cell_cj_1_2, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_cj_1_2);
        	
        	//最小值
        	PdfPCell cell_cj_1_3= new PdfPCell(new Paragraph("3",fontPT_S));
        	setCell( cell_cj_1_3, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_cj_1_3);
        	
			document.add(table_left);

			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 *  生成详细信息的表单 (高温机械性能)
	 * @param document
	 * @param fontPT_S
	 * @param fontPT
	 * @param elements
	 * @param customizeElements
	 * @param gwMechanical
	 * @param mechanical
	 * @param textureReport
	 */
	public static void setGwDetailInfo(Document document,Font fontPT_S,Font fontPT,List<texture.domain.Element> elements,List<CustomizeElement> customizeElements,GwMechanical gwMechanical,Mechanical mechanical,TextureReport textureReport){
		try{
			//设置table 
			PdfPTable table_left=null;
			//自定义元素总数
			int customizeElementSize=0;
			if(customizeElements!=null){
				customizeElementSize= customizeElements.size();
				table_left =new PdfPTable(5+elements.size()+customizeElementSize+8+2);
			}else{
				table_left =new PdfPTable(5+elements.size()+8+2);
			}
			
			table_left.setWidthPercentage(100);
			table_left.setHorizontalAlignment(0);
			float arr[] = getCellWidth(elements,customizeElements);
			table_left.setWidths(arr);
			
			
			//设置物料号列
			PdfPCell cell0 =new PdfPCell(new Paragraph("物料号\nMaterial No.", fontPT_S));
	        setCell(cell0, fontPT_S, 4, 0, 0, true, true);
	        table_left.addCell(cell0);
			
	        //设置零件名称列
			PdfPCell cell1 =new PdfPCell(new Paragraph("零件名称\nPart Name", fontPT_S));
	        setCell(cell1, fontPT_S, 4, 0, 0, true, true);
	        table_left.addCell(cell1);
			
	        //设置零件规格列
	        PdfPCell cell2 =new PdfPCell(new Paragraph("零件规格\nPart Size", fontPT_S));
	        setCell(cell2, fontPT_S, 4, 0, 0, true, true);
	        table_left.addCell(cell2);
	        
	        //设置数量列
	        PdfPCell cell3 =new PdfPCell(new Paragraph("数量\nQTY", fontPT_S));
	        setCell(cell3, fontPT_S, 4, 0, 0, true, true);
	        table_left.addCell(cell3);
	        
	        PdfPCell cell_ys =new PdfPCell(new Paragraph("元素\nElement", fontPT_S));
	        setCell(cell_ys, fontPT_S, 2, 0, 0, true, true);
	        table_left.addCell(cell_ys);
	        
	        //化学成分列
	        PdfPCell cell_hxcf =new PdfPCell(new Paragraph("化学成分 Chemical composition  (%)",fontPT));
	        //所有元素+ce+pren
//	        cell_hxcf.setColspan(elements.size()+2);
//	        //设置高度
	        setCell(cell_hxcf, fontPT_S, 0, elements.size()+customizeElementSize+2, 35, true, true);
	        table_left.addCell(cell_hxcf);
	        
	        //高温机械性能
	        PdfPCell cell_jxxn =new PdfPCell(new Paragraph("高温机械性能 Mechanical Property:"+StrUtil.nullToStr(gwMechanical.getWd())+"℃",fontPT));
	        setCell(cell_jxxn, fontPT_S, 0, 8, 0, true, true);
	        table_left.addCell(cell_jxxn);
	        
	        
	        //元素行,遍历集合
	        for (int i = 0; i < elements.size(); i++) {
	        	PdfPCell cell_i= new PdfPCell(new Paragraph(elements.get(i).getElement_name(),fontPT_S));
	        	setCell(cell_i, fontPT_S, 0, 0, 0, true, true);
	        	table_left.addCell(cell_i);
			}
	        //自定义元素行，遍历
	        if(customizeElements!=null){
		        for (int i = 0; i <customizeElements.size(); i++) {
		        	PdfPCell cell_i= new PdfPCell(new Paragraph(customizeElements.get(i).getElement_name(),fontPT_S));
		        	setCell(cell_i, fontPT_S, 0, 0, 0, true, true);
		        	table_left.addCell(cell_i);
				}
	        }
	      	//CE
	        PdfPCell cell_ce =new PdfPCell(new Paragraph("CE",fontPT_S));
	        setCell(cell_ce, fontPT_S, 0, 0, 0, true, true);
	        table_left.addCell(cell_ce);
	        //PREN
	        PdfPCell cell_pren =new PdfPCell(new Paragraph("PREN",fontPT_S));
	        setCell(cell_pren, fontPT_S, 0, 0, 0, true, true);
	        table_left.addCell(cell_pren);
	        
	        
	        //抗拉
	        PdfPCell cell_kl =new PdfPCell(new Paragraph("抗拉 \nTS\n(Mpa)",fontPT_S));
	        setCell(cell_kl, fontPT_S, 0, 0, 0, true, true);
	        table_left.addCell(cell_kl);
	        //屈服
	        PdfPCell cell_qf =new PdfPCell(new Paragraph("屈服\nYS\n(Mpa)",fontPT_S));
	        setCell( cell_qf, fontPT_S, 0, 0, 0, true, true);
	        table_left.addCell(cell_qf);
	        //延伸
	        PdfPCell cell_ysn =new PdfPCell(new Paragraph("延伸\nE\n(%)",fontPT_S));
	        setCell( cell_ysn, fontPT_S, 0, 0, 0, true, true);
	        table_left.addCell(cell_ysn);
	        //收缩
	        PdfPCell cell_ss =new PdfPCell(new Paragraph("收缩 \nR\n(%)",fontPT_S));
	        setCell( cell_ss, fontPT_S, 0, 0, 0, true, true);
	        table_left.addCell(cell_ss);
	        //硬度
	        PdfPCell cell_yd =new PdfPCell(new Paragraph("硬度 \nHardness\n(HB)",fontPT_S));
	        setCell( cell_yd, fontPT_S, 0, 0, 0, true, true);
	        table_left.addCell(cell_yd);
	        //冲击试验Impact Test
	        //若实际温度为空时，取标准冲击温度
	        String cjwd = mechanical.getSjwd()==null ?StrUtil.nullToStr(mechanical.getCjwd()):StrUtil.nullToStr(mechanical.getSjwd());
	        PdfPCell cell_cj =new PdfPCell(new Paragraph("冲击试验Impact Test\n冲击值 Akv，J\n温度 Tem:"+cjwd+"℃：",fontPT_S));
	        setCell( cell_cj, fontPT_S, 0, 3, 0, true, true);
	        table_left.addCell(cell_cj);
	        
	        
	        //max值 行
	        PdfPCell cell_Max =new PdfPCell(new Paragraph("Max", fontPT_S));
	        setCell( cell_Max, fontPT_S, 0, 0, 20, true, true);
	        table_left.addCell(cell_Max);
	        //遍历集合
	        for (int i = 0; i < elements.size(); i++) {
	        	PdfPCell cell_i_Max=null;
	        	if(elements.get(i).getMax() == MAX_VALUE || elements.get(i).getMax() == MIN_VALUE){
	        		cell_i_Max= new PdfPCell();
	        	}else{
	        		cell_i_Max= new PdfPCell(new Paragraph(StrUtil.formatDouble(elements.get(i).getMax()),fontPT_S));
	        	}
	        	
	        	setCell( cell_i_Max, fontPT_S, 0, 0, 20, true, true);
	        	table_left.addCell(cell_i_Max);
			}
	        //自定义元素行，遍历
	        if(customizeElements!=null){
		        for (int i = 0; i <customizeElements.size(); i++) {
		        	PdfPCell cell_i= new PdfPCell();
		        	setCell(cell_i, fontPT_S, 0, 0, 0, true, true);
		        	table_left.addCell(cell_i);
				}
	        }
	        //CE
	        PdfPCell cell_ce_Max=null;
	        //获取公式信息
	        List<ZMtrCodeVO> zMtrCodeVOs= textureReport.getzMtrCodeVOs();
	        ZMtrCodeVO zMtrCodeVO=null;
	        if(zMtrCodeVOs!=null){
	        	//判断是否需要计算CE值 ，若需要，则显示CE标准值
		        if(textureReport.getCe().toString().equals("true")){
			        for (ZMtrCodeVO zMtrCodeVO1 : zMtrCodeVOs) {
						if(zMtrCodeVO1.getZmtr_code().equals("CE")){
							//判断碳元素含量及公式是否满足要求
							boolean isNeedCeCheck = CommonMethods.isNeedCeCheck(elements, zMtrCodeVO1);
							if(isNeedCeCheck){
								zMtrCodeVO = zMtrCodeVO1;
							}
						}
					}
		        	//判断上限是否为空
		        	if(zMtrCodeVO.getUpper_value()!=null){
		        		cell_ce_Max = new PdfPCell(new Paragraph(zMtrCodeVO.getUpper_value(),fontPT_S));
		        	}else{
			        	cell_ce_Max = new PdfPCell();
			        }
		        }else{
		        	cell_ce_Max = new PdfPCell();
		        }
	        }else{
	        	cell_ce_Max = new PdfPCell();
	        }
	        setCell(cell_ce_Max, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_ce_Max);
        	
        	//PREN 
	        PdfPCell cell_pren_Max=null;
	        if(zMtrCodeVOs!=null){
	        	//判断是否需要显示pren标准值
		        if(textureReport.getPren().toString().equals("true")){
		        	//遍历所有公式，判断是否有mtr显示名称为PREN的
			        for (ZMtrCodeVO zMtrCodeVO1 : zMtrCodeVOs) {
						if(zMtrCodeVO1.getZmtr_code().equals("PREN")){
							zMtrCodeVO = zMtrCodeVO1;
						}
					}
		        	//判断上限是否为空
		        	if(zMtrCodeVO.getUpper_value()!=null){
		        		cell_pren_Max = new PdfPCell(new Paragraph(zMtrCodeVO.getUpper_value(),fontPT_S));
		        	}else{
		        		cell_pren_Max = new PdfPCell();
			        }
		        }else{
		        	cell_pren_Max = new PdfPCell();
		        }
	        }else{
	        	cell_pren_Max = new PdfPCell();
	        }
	        setCell(cell_pren_Max, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_pren_Max);
	        
	        //抗拉 
        	PdfPCell cell_kl_Max=null;
        	if(gwMechanical.getGwkl_max()==MAX_VALUE){
        		cell_kl_Max= new PdfPCell();
        	}else{
        		cell_kl_Max= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(gwMechanical.getGwkl_max()),fontPT_S));
        	}
	        setCell( cell_kl_Max, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_kl_Max);
        	//屈服
        	PdfPCell cell_qf_Max=null;
        	if(gwMechanical.getGwqf_max()==MAX_VALUE){
        		cell_qf_Max= new PdfPCell();
        	}else{
        		cell_qf_Max= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(gwMechanical.getGwqf_max()),fontPT_S));
        	}
        	setCell( cell_qf_Max, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_qf_Max);
        	//延伸
        	PdfPCell cell_ysn_Max=null;
        	if(gwMechanical.getGwysh_max()==MAX_VALUE){
        		cell_ysn_Max= new PdfPCell();
        	}else{
        		cell_ysn_Max= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(gwMechanical.getGwysh_max()),fontPT_S));
        	}
        	setCell( cell_ysn_Max, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_ysn_Max);
        	//收缩
        	PdfPCell cell_ss_MAx=null;
        	if(gwMechanical.getGwss_max()==MAX_VALUE){
        		cell_ss_MAx= new PdfPCell();
        	}else{
        		cell_ss_MAx= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(gwMechanical.getGwss_max()),fontPT_S));
        	}
        	setCell( cell_ss_MAx, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_ss_MAx);
        	//硬度
        	PdfPCell cell_yd_Max=null;
        	if(mechanical.getYd_max()==MAX_VALUE){
        		cell_yd_Max= new PdfPCell();
        	}else{
        		cell_yd_Max= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(mechanical.getYd_max()),fontPT_S));
        	}
        	setCell( cell_yd_Max, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_yd_Max);
        	
        	PdfPCell cell_cj_1= new PdfPCell(new Paragraph("Avg："+StrUtil.nullToStr(mechanical.getCj_avg())+"      Min："+StrUtil.nullToStr(mechanical.getCj_min()),fontPT_S));
        	setCell( cell_cj_1, fontPT_S, 0, 3, 0, false, false);
        	table_left.addCell(cell_cj_1);
        	
	        //min 行
	        PdfPCell cell_Min =new PdfPCell(new Paragraph("Min", fontPT_S));
	        setCell( cell_Min, fontPT_S, 0, 0, 20, true, true);
	        table_left.addCell(cell_Min);
	        for (int i = 0; i < elements.size(); i++) {
	        	PdfPCell cell_i_Min=null;
	        	if(elements.get(i).getMin()==MIN_VALUE){
	        		cell_i_Min= new PdfPCell();
	        	}else{
	        		cell_i_Min= new PdfPCell(new Paragraph(StrUtil.formatDouble(elements.get(i).getMin()),fontPT_S));
	        	}
	        	setCell( cell_i_Min, fontPT_S, 0, 0, 0, true, true);
	        	table_left.addCell(cell_i_Min);
			}
	        //自定义元素
	        if(customizeElements!=null){
		        for (int i = 0; i <customizeElements.size(); i++) {
		        	PdfPCell cell_i= new PdfPCell();
		        	setCell(cell_i, fontPT_S, 0, 0, 0, true, true);
		        	table_left.addCell(cell_i);
				}
	        }
	        //CE
	        PdfPCell cell_ce_Min= new PdfPCell();
	        if(zMtrCodeVOs!=null){
	        	//判断是否需要显示CE值 ，若需要，则显示CE标准值
		        if(textureReport.getCe().toString().equals("true")){
			        for (ZMtrCodeVO zMtrCodeVO1 : zMtrCodeVOs) {
						if(zMtrCodeVO1.getZmtr_code().equals("CE")){
							//判断碳元素含量及公式是否满足要求
							boolean isNeedCeCheck = CommonMethods.isNeedCeCheck(elements, zMtrCodeVO1);
							if(isNeedCeCheck){
								zMtrCodeVO = zMtrCodeVO1;
							}
						}
					}
		        	//判断上限是否为空
		        	if(zMtrCodeVO.getLower_value()!=null){
		        		cell_ce_Min = new PdfPCell(new Paragraph(zMtrCodeVO.getLower_value(),fontPT_S));
		        	}else{
		        		cell_ce_Min = new PdfPCell();
			        }
		        }else{
		        	cell_ce_Min = new PdfPCell();
		        }
	        }else{
	        	cell_ce_Min = new PdfPCell();
	        }
	        setCell(cell_ce_Min, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_ce_Min);
        	//PREN 
	        PdfPCell cell_pren_Min= null;
	        if(zMtrCodeVOs!=null){
	        	if(textureReport.getPren().toString().equals("true")){
			        for (ZMtrCodeVO zMtrCodeVO1 : zMtrCodeVOs) {
						if(zMtrCodeVO1.getZmtr_code().equals("PREN")){
							zMtrCodeVO = zMtrCodeVO1;
						}
					}
		        	//判断上限是否为空
		        	if(zMtrCodeVO.getLower_value()!=null){
		        		cell_pren_Min = new PdfPCell(new Paragraph(zMtrCodeVO.getLower_value(),fontPT_S));
		        	}else{
		        		cell_pren_Min = new PdfPCell();
			        }
		        }else{
		        	cell_pren_Min = new PdfPCell();
		        }
	        }else{
	        	cell_pren_Min = new PdfPCell();
	        }
	        
	        setCell(cell_pren_Min, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_pren_Min);
        	
        	//抗拉 min
        	PdfPCell cell_kl_Min= null;
        	if(gwMechanical.getGwkl_min()==MIN_VALUE){
        		cell_kl_Min= new PdfPCell();
        	}else{
        		cell_kl_Min= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(gwMechanical.getGwkl_min()),fontPT_S));
        	}
	        setCell( cell_kl_Min, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_kl_Min);
        	
        	//屈服
        	PdfPCell cell_qf_Min= null;
        	if(gwMechanical.getGwqf_min()==MIN_VALUE){
        		cell_qf_Min= new PdfPCell();
        	}else{
        		cell_qf_Min= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(gwMechanical.getGwqf_min()),fontPT_S));
        	}
        	setCell( cell_qf_Min, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_qf_Min);
        	
        	//延伸
        	PdfPCell cell_ysn_Min= null;
        	if(gwMechanical.getGwysh_min()==MIN_VALUE){
        		cell_ysn_Min= new PdfPCell();
        	}else{
        		cell_ysn_Min= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(gwMechanical.getGwysh_min()),fontPT_S));
        	}
        	setCell( cell_ysn_Min, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_ysn_Min);
        	
        	//收缩
        	PdfPCell cell_ss_Min= null;
        	if(gwMechanical.getGwss_min()==MIN_VALUE){
        		cell_ss_Min= new PdfPCell();
        	}else{
        		cell_ss_Min= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(gwMechanical.getGwss_min()),fontPT_S));
        	}
        	setCell( cell_ss_Min, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_ss_Min);
        	
        	//硬度
        	PdfPCell cell_yd_Min= null;
        	if(mechanical.getYd_min()==MIN_VALUE){
        		cell_yd_Min= new PdfPCell();
        	}else{
        		cell_yd_Min= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(mechanical.getYd_min()),fontPT_S));
        	}
        	setCell( cell_yd_Min, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_yd_Min);
        	
        	//冲击温度
        	PdfPCell cell_cj_1_1= new PdfPCell(new Paragraph("1",fontPT_S));
        	setCell( cell_cj_1_1, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_cj_1_1);
        	
        	//平均值
        	PdfPCell cell_cj_1_2= new PdfPCell(new Paragraph("2",fontPT_S));
        	setCell( cell_cj_1_2, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_cj_1_2);
        	
        	//最小值
        	PdfPCell cell_cj_1_3= new PdfPCell(new Paragraph("3",fontPT_S));
        	setCell( cell_cj_1_3, fontPT_S, 0, 0, 0, true, true);
        	table_left.addCell(cell_cj_1_3);
        	
			document.add(table_left);

			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 将具体内容填充到 空格中
	 * @param document
	 * @param fontPT_S
	 * @param elements
	 */
	public static void setDetailData(Document document,Font fontPT_S,List<texture.domain.Element> elements,List<CustomizeElement> customizeElements,Mechanical mechanical,List<Material> materials,String ce,String pren,List<ZMtrCodeVO> zMtrCodeVOs){
		try{
			//设置table 
			PdfPTable table_left =null;
			if(customizeElements!=null){
				table_left =new PdfPTable(5+elements.size()+customizeElements.size()+8+2);
			}else{
				table_left =new PdfPTable(5+elements.size()+8+2);
			}
			
			table_left.setWidthPercentage(100);
			//计算每个单元格宽度
			float arr[] = getCellWidth(elements,customizeElements);
			table_left.setWidths(arr);

			//遍历所有物料
			for (int i = 0; i < materials.size(); i++) {
				PdfPCell cell_i_wl =new PdfPCell(new Paragraph(materials.get(i).getMaterial_code(),fontPT_S));
				setCell( cell_i_wl, fontPT_S, 0, 0, 30, true, true);
				table_left.addCell(cell_i_wl);
				
				//零件名称
				String material_name_i="";
				if(materials.get(i).getMaterial_name_en()!=null){
					material_name_i=materials.get(i).getMaterial_name()+"\n"+materials.get(i).getMaterial_name_en();
				}else{
					material_name_i=materials.get(i).getMaterial_name();
				}
				PdfPCell cell_i_mc =new PdfPCell(new Paragraph(material_name_i,fontPT_S));
				setCell( cell_i_mc, fontPT_S, 0, 0, 0, true, true);
				table_left.addCell(cell_i_mc);
				
				//零件规格
				PdfPCell cell_i_gg =new PdfPCell(new Paragraph(materials.get(i).getMaterial_spec(),fontPT_S));
				setCell( cell_i_gg, fontPT_S, 0, 0, 0, true, true);
				table_left.addCell(cell_i_gg);
				
				//数量
				PdfPCell cell_i_sl =new PdfPCell(new Paragraph(String.valueOf(materials.get(i).getNum()),fontPT_S));
				setCell( cell_i_sl, fontPT_S, 0, 0, 0, true, true);
				table_left.addCell(cell_i_sl);
				
				//元素
				PdfPCell cell_i_ys =new PdfPCell();
				table_left.addCell(cell_i_ys);
				
				//化学元素值
				for (int j = 0; j < elements.size(); j++) {
					PdfPCell cell_i_j =new PdfPCell(new Paragraph(StrUtil.formatDouble(elements.get(j).getEle_value()),fontPT_S));
					setCell( cell_i_j, fontPT_S, 0, 0, 0, true, true);
					table_left.addCell(cell_i_j);
				}
				
				//化学元素值
				if(customizeElements!=null){
					for (int j = 0; j < customizeElements.size(); j++) {
						PdfPCell cell_i_j =new PdfPCell(new Paragraph(StrUtil.formatDouble(customizeElements.get(j).getElement_value()),fontPT_S));
						setCell( cell_i_j, fontPT_S, 0, 0, 0, true, true);
						table_left.addCell(cell_i_j);
					}
				}
				
				
				//ce
				PdfPCell cell_i_ce;
				if ("true".equals(ce.toString())) {
					String ce_value = new PdfReport().calculateCE(zMtrCodeVOs,elements,customizeElements);
					cell_i_ce =new PdfPCell(new Paragraph(ce_value,fontPT_S));
				}else{
					cell_i_ce =new PdfPCell();
				}
				setCell( cell_i_ce, fontPT_S, 0, 0, 0, true, true);
				table_left.addCell(cell_i_ce);
				
				//pren
				PdfPCell cell_i_pren;
				if ("true".equals(pren.toString())) {
					String pren_value = new PdfReport().calculatePREN(zMtrCodeVOs,elements);
					cell_i_pren =new PdfPCell(new Paragraph(pren_value,fontPT_S));
				}else{
					cell_i_pren =new PdfPCell();
				}
				setCell( cell_i_pren, fontPT_S, 0, 0, 0, true, true);
				table_left.addCell(cell_i_pren);
				
				//拉伸
				PdfPCell cell_i_ls =new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(mechanical.getKl()),fontPT_S));
				setCell( cell_i_ls, fontPT_S, 0, 0, 0, true, true);
				table_left.addCell(cell_i_ls);
				
				//屈服
				PdfPCell cell_i_qf =new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(mechanical.getQf()),fontPT_S));
				setCell( cell_i_qf, fontPT_S, 0, 0, 0, true, true);
				table_left.addCell(cell_i_qf);
				
				//延伸
				PdfPCell cell_i_ysh =new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(mechanical.getYsh()),fontPT_S));
				setCell( cell_i_ysh, fontPT_S, 0, 0, 0, true, true);
				table_left.addCell(cell_i_ysh);
				
				//收缩
				PdfPCell cell_i_ss =new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(mechanical.getSs()),fontPT_S));
				setCell( cell_i_ss, fontPT_S, 0, 0, 0, true, true);
				table_left.addCell(cell_i_ss);
				
				//硬度
				PdfPCell cell_i_yd =null;
				//根据硬度单位 ，判断是否需要对照成HB
				if(mechanical.getYddw()!=null&&mechanical.getYddw().equals(CommonConstant.HARD_HRC)){
					String hrcToHb = changeHrcToHb(mechanical.getYd());
					cell_i_yd= new PdfPCell(new Paragraph(hrcToHb,fontPT_S));
				}else if(mechanical.getYddw()!=null&&mechanical.getYddw().equals(CommonConstant.HARD_HV)){
					String hvToHb = changeHvToHb(mechanical.getYd());
					cell_i_yd= new PdfPCell(new Paragraph(hvToHb,fontPT_S));
				}else{
					cell_i_yd= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(mechanical.getYd()),fontPT_S));
				}
				setCell( cell_i_yd, fontPT_S, 0, 0, 0, true, true);
				table_left.addCell(cell_i_yd);
				
				//冲击试验
				if(mechanical.getCjz1()!=null){
					PdfPCell cell_i_1 =new PdfPCell(new Paragraph(String.valueOf(mechanical.getCjz1()),fontPT_S));
					setCell( cell_i_1, fontPT_S, 0, 0, 0, true, true);
					table_left.addCell(cell_i_1);
				}else{
					PdfPCell cell_i_1 =new PdfPCell();
					setCell( cell_i_1, fontPT_S, 0, 0, 0, true, true);
					table_left.addCell(cell_i_1);
				}
				
				//冲击试验
				if(mechanical.getCjz2()!=null){
					PdfPCell cell_i_2 =new PdfPCell(new Paragraph(String.valueOf(mechanical.getCjz2()),fontPT_S));
					setCell( cell_i_2, fontPT_S, 0, 0, 0, true, true);
					table_left.addCell(cell_i_2);
				}else{
					PdfPCell cell_i_2 =new PdfPCell();
					setCell( cell_i_2, fontPT_S, 0, 0, 0, true, true);
					table_left.addCell(cell_i_2);
				}
				
				//冲击试验
				if(mechanical.getCjz3()!=null){
					PdfPCell cell_i_3 =new PdfPCell(new Paragraph(String.valueOf(mechanical.getCjz3()),fontPT_S));
					setCell( cell_i_3, fontPT_S, 0, 0, 0, true, true);
					table_left.addCell(cell_i_3);
				}else{
					PdfPCell cell_i_3 =new PdfPCell();
//					cell_i_3.setHorizontalAlignment(Element.ALIGN_CENTER);
					setCell( cell_i_3, fontPT_S, 0, 0, 0, true, true);
					table_left.addCell(cell_i_3);
				}
			}
			
			
			//设置4行
			for (int i = 0; i < 4-materials.size(); i++) {
				//物料号
				PdfPCell cell_i_wl =new PdfPCell();
				cell_i_wl.setMinimumHeight(30);
				table_left.addCell(cell_i_wl);
				
				//零件名称
				PdfPCell cell_i_mc =new PdfPCell();
				table_left.addCell(cell_i_mc);
				
				//零件规格
				PdfPCell cell_i_gg =new PdfPCell();
				table_left.addCell(cell_i_gg);
				
				//数量
				PdfPCell cell_i_sl =new PdfPCell();
				table_left.addCell(cell_i_sl);
				
				//元素
				PdfPCell cell_i_ys =new PdfPCell();
				table_left.addCell(cell_i_ys);
				
				//遍历对应元素含量集合 
				for (int j = 0; j < elements.size(); j++) {
					PdfPCell cell_i_j =new PdfPCell();
					table_left.addCell(cell_i_j);
				}
				//自定义元素
				if(customizeElements!=null){
					for (int j = 0; j < customizeElements.size(); j++) {
						PdfPCell cell_i_j =new PdfPCell();
						table_left.addCell(cell_i_j);
					}
				}
				
				//ce
				PdfPCell cell_i_ce =new PdfPCell();
				table_left.addCell(cell_i_ce);
				
				//pren
				PdfPCell cell_i_pren =new PdfPCell();
				table_left.addCell(cell_i_pren);
				
				//拉伸
				PdfPCell cell_i_ls =new PdfPCell();
				table_left.addCell(cell_i_ls);
				
				//屈服
				PdfPCell cell_i_qf =new PdfPCell();
				table_left.addCell(cell_i_qf);
				
				//延伸
				PdfPCell cell_i_ysh =new PdfPCell();
				table_left.addCell(cell_i_ysh);
				
				//收缩
				PdfPCell cell_i_ss =new PdfPCell();
				table_left.addCell(cell_i_ss);
				
				//硬度
				PdfPCell cell_i_yd =new PdfPCell();
				table_left.addCell(cell_i_yd);
				
				//冲击试验
				PdfPCell cell_i_1 =new PdfPCell();
				table_left.addCell(cell_i_1);
				//冲击试验
				PdfPCell cell_i_2 =new PdfPCell();
				table_left.addCell(cell_i_2);
				//冲击试验
				PdfPCell cell_i_3 =new PdfPCell();
				table_left.addCell(cell_i_3);
			}
			document.add(table_left);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 高温机械性能实际值填充
	 * @param document
	 * @param fontPT_S
	 * @param elements
	 * @param customizeElements
	 * @param gwMechanical
	 * @param mechanical
	 * @param materials
	 * @param ce
	 * @param pren
	 * @param zMtrCodeVOs
	 */
	public static void setGwDetailData(Document document,Font fontPT_S,List<texture.domain.Element> elements,List<CustomizeElement> customizeElements,GwMechanical gwMechanical,Mechanical mechanical,List<Material> materials,String ce,String pren,List<ZMtrCodeVO> zMtrCodeVOs){
		try{
			//设置table 
			PdfPTable table_left =null;
			if(customizeElements!=null){
				table_left =new PdfPTable(5+elements.size()+customizeElements.size()+8+2);
			}else{
				table_left =new PdfPTable(5+elements.size()+8+2);
			}
			
			table_left.setWidthPercentage(100);
			//计算每个单元格宽度
			float arr[] = getCellWidth(elements,customizeElements);
			table_left.setWidths(arr);

			//遍历所有物料
			for (int i = 0; i < materials.size(); i++) {
				PdfPCell cell_i_wl =new PdfPCell(new Paragraph(materials.get(i).getMaterial_code(),fontPT_S));
				setCell( cell_i_wl, fontPT_S, 0, 0, 30, true, true);
				table_left.addCell(cell_i_wl);
				
				//零件名称
				String material_name_i="";
				if(materials.get(i).getMaterial_name_en()!=null){
					material_name_i=materials.get(i).getMaterial_name()+"\n"+materials.get(i).getMaterial_name_en();
				}else{
					material_name_i=materials.get(i).getMaterial_name();
				}
				PdfPCell cell_i_mc =new PdfPCell(new Paragraph(material_name_i,fontPT_S));
				setCell( cell_i_mc, fontPT_S, 0, 0, 0, true, true);
				table_left.addCell(cell_i_mc);
				
				//零件规格
				PdfPCell cell_i_gg =new PdfPCell(new Paragraph(materials.get(i).getMaterial_spec(),fontPT_S));
				setCell( cell_i_gg, fontPT_S, 0, 0, 0, true, true);
				table_left.addCell(cell_i_gg);
				
				//数量
				PdfPCell cell_i_sl =new PdfPCell(new Paragraph(String.valueOf(materials.get(i).getNum()),fontPT_S));
				setCell( cell_i_sl, fontPT_S, 0, 0, 0, true, true);
				table_left.addCell(cell_i_sl);
				
				//元素
				PdfPCell cell_i_ys =new PdfPCell();
				table_left.addCell(cell_i_ys);
				
				//化学元素值
				for (int j = 0; j < elements.size(); j++) {
					PdfPCell cell_i_j =new PdfPCell(new Paragraph(StrUtil.formatDouble(elements.get(j).getEle_value()),fontPT_S));
					setCell( cell_i_j, fontPT_S, 0, 0, 0, true, true);
					table_left.addCell(cell_i_j);
				}
				
				//化学元素值
				if(customizeElements!=null){
					for (int j = 0; j < customizeElements.size(); j++) {
						PdfPCell cell_i_j =new PdfPCell(new Paragraph(StrUtil.formatDouble(customizeElements.get(j).getElement_value()),fontPT_S));
						setCell( cell_i_j, fontPT_S, 0, 0, 0, true, true);
						table_left.addCell(cell_i_j);
					}
				}
				
				
				//ce
				PdfPCell cell_i_ce;
				if ("true".equals(ce.toString())) {
					String ce_value = new PdfReport().calculateCE(zMtrCodeVOs,elements,customizeElements);
					cell_i_ce =new PdfPCell(new Paragraph(ce_value,fontPT_S));
				}else{
					cell_i_ce =new PdfPCell();
				}
				setCell( cell_i_ce, fontPT_S, 0, 0, 0, true, true);
				table_left.addCell(cell_i_ce);
				
				//pren
				PdfPCell cell_i_pren;
				if ("true".equals(pren.toString())) {
					String pren_value = new PdfReport().calculatePREN(zMtrCodeVOs,elements);
					cell_i_pren =new PdfPCell(new Paragraph(pren_value,fontPT_S));
				}else{
					cell_i_pren =new PdfPCell();
				}
				setCell( cell_i_pren, fontPT_S, 0, 0, 0, true, true);
				table_left.addCell(cell_i_pren);
				
				//拉伸
				PdfPCell cell_i_ls =new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(gwMechanical.getGwkl()),fontPT_S));
				setCell( cell_i_ls, fontPT_S, 0, 0, 0, true, true);
				table_left.addCell(cell_i_ls);
				
				//屈服
				PdfPCell cell_i_qf =new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(gwMechanical.getGwqf()),fontPT_S));
				setCell( cell_i_qf, fontPT_S, 0, 0, 0, true, true);
				table_left.addCell(cell_i_qf);
				
				//延伸
				PdfPCell cell_i_ysh =new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(gwMechanical.getGwysh()),fontPT_S));
				setCell( cell_i_ysh, fontPT_S, 0, 0, 0, true, true);
				table_left.addCell(cell_i_ysh);
				
				//收缩
				PdfPCell cell_i_ss =new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(gwMechanical.getGwss()),fontPT_S));
				setCell( cell_i_ss, fontPT_S, 0, 0, 0, true, true);
				table_left.addCell(cell_i_ss);
				
				//硬度
				PdfPCell cell_i_yd =null;
				//根据硬度单位 ，判断是否需要对照成HB
				if(mechanical.getYddw()!=null&&mechanical.getYddw().equals(CommonConstant.HARD_HRC)){
					String hrcToHb = changeHrcToHb(mechanical.getYd());
					cell_i_yd= new PdfPCell(new Paragraph(hrcToHb,fontPT_S));
				}else if(mechanical.getYddw()!=null&&mechanical.getYddw().equals(CommonConstant.HARD_HV)){
					String hvToHb = changeHvToHb(mechanical.getYd());
					cell_i_yd= new PdfPCell(new Paragraph(hvToHb,fontPT_S));
				}else{
					cell_i_yd= new PdfPCell(new Paragraph(StrUtil.formatDoubleToInt(mechanical.getYd()),fontPT_S));
				}
				setCell( cell_i_yd, fontPT_S, 0, 0, 0, true, true);
				table_left.addCell(cell_i_yd);
				
				//冲击试验
				if(mechanical.getCjz1()!=null){
					PdfPCell cell_i_1 =new PdfPCell(new Paragraph(String.valueOf(mechanical.getCjz1()),fontPT_S));
					setCell( cell_i_1, fontPT_S, 0, 0, 0, true, true);
					table_left.addCell(cell_i_1);
				}else{
					PdfPCell cell_i_1 =new PdfPCell();
					setCell( cell_i_1, fontPT_S, 0, 0, 0, true, true);
					table_left.addCell(cell_i_1);
				}
				
				//冲击试验
				if(mechanical.getCjz2()!=null){
					PdfPCell cell_i_2 =new PdfPCell(new Paragraph(String.valueOf(mechanical.getCjz2()),fontPT_S));
					setCell( cell_i_2, fontPT_S, 0, 0, 0, true, true);
					table_left.addCell(cell_i_2);
				}else{
					PdfPCell cell_i_2 =new PdfPCell();
					setCell( cell_i_2, fontPT_S, 0, 0, 0, true, true);
					table_left.addCell(cell_i_2);
				}
				
				//冲击试验
				if(mechanical.getCjz3()!=null){
					PdfPCell cell_i_3 =new PdfPCell(new Paragraph(String.valueOf(mechanical.getCjz3()),fontPT_S));
					setCell( cell_i_3, fontPT_S, 0, 0, 0, true, true);
					table_left.addCell(cell_i_3);
				}else{
					PdfPCell cell_i_3 =new PdfPCell();
//					cell_i_3.setHorizontalAlignment(Element.ALIGN_CENTER);
					setCell( cell_i_3, fontPT_S, 0, 0, 0, true, true);
					table_left.addCell(cell_i_3);
				}
			}
			
			
			//设置4行
			for (int i = 0; i < 4-materials.size(); i++) {
				//物料号
				PdfPCell cell_i_wl =new PdfPCell();
				cell_i_wl.setMinimumHeight(30);
				table_left.addCell(cell_i_wl);
				
				//零件名称
				PdfPCell cell_i_mc =new PdfPCell();
				table_left.addCell(cell_i_mc);
				
				//零件规格
				PdfPCell cell_i_gg =new PdfPCell();
				table_left.addCell(cell_i_gg);
				
				//数量
				PdfPCell cell_i_sl =new PdfPCell();
				table_left.addCell(cell_i_sl);
				
				//元素
				PdfPCell cell_i_ys =new PdfPCell();
				table_left.addCell(cell_i_ys);
				
				//遍历对应元素含量集合 
				for (int j = 0; j < elements.size(); j++) {
					PdfPCell cell_i_j =new PdfPCell();
					table_left.addCell(cell_i_j);
				}
				//自定义元素
				if(customizeElements!=null){
					for (int j = 0; j < customizeElements.size(); j++) {
						PdfPCell cell_i_j =new PdfPCell();
						table_left.addCell(cell_i_j);
					}
				}
				
				//ce
				PdfPCell cell_i_ce =new PdfPCell();
				table_left.addCell(cell_i_ce);
				
				//pren
				PdfPCell cell_i_pren =new PdfPCell();
				table_left.addCell(cell_i_pren);
				
				//拉伸
				PdfPCell cell_i_ls =new PdfPCell();
				table_left.addCell(cell_i_ls);
				
				//屈服
				PdfPCell cell_i_qf =new PdfPCell();
				table_left.addCell(cell_i_qf);
				
				//延伸
				PdfPCell cell_i_ysh =new PdfPCell();
				table_left.addCell(cell_i_ysh);
				
				//收缩
				PdfPCell cell_i_ss =new PdfPCell();
				table_left.addCell(cell_i_ss);
				
				//硬度
				PdfPCell cell_i_yd =new PdfPCell();
				table_left.addCell(cell_i_yd);
				
				//冲击试验
				PdfPCell cell_i_1 =new PdfPCell();
				table_left.addCell(cell_i_1);
				//冲击试验
				PdfPCell cell_i_2 =new PdfPCell();
				table_left.addCell(cell_i_2);
				//冲击试验
				PdfPCell cell_i_3 =new PdfPCell();
				table_left.addCell(cell_i_3);
			}
			document.add(table_left);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 热处理表头
	 * @param document
	 * @param fontPT_S
	 */
	public static void setHeatTreatMentTitle(Document document,Font fontPT_S){
		try{
			PdfPTable ht_table =new PdfPTable(2);
			//设置单元格宽度百分比
			int colWidths[]={70,30};
			ht_table.setWidthPercentage(100);
			ht_table.setWidths(colWidths);
			
			PdfPCell cell1 =new PdfPCell(new Paragraph("热处理\nHeat Treatment",fontPT_S));
			setCell( cell1, fontPT_S, 0, 0, 30, true, true);
			ht_table.addCell(cell1);
			
			PdfPCell cell2 =new PdfPCell(new Paragraph("无损检测\nNDT",fontPT_S));
			setCell( cell2, fontPT_S, 0, 0, 0, true, true);
			ht_table.addCell(cell2);
			
			document.add(ht_table);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 热处理具体内容
	 * @param document
	 * @param fontPT_S
	 */
	public static void setHeatTreatMentInfo(Document document,Font fontPT_S,List<Heat> heats,TextureReport textureReport,User user){
		try{
			PdfPTable table =new PdfPTable(8);
			int widths[]={13,10,18,10,9,10,10,20};
			table.setWidthPercentage(100);
			table.setWidths(widths);
			
			PdfPCell cell_B_N =new PdfPCell(new Paragraph("热处理批号\nBatch No.\n\n"+textureReport.getBatch_No(),fontPT_S));
			setCell( cell_B_N, fontPT_S, 6, 0, 0, true, true);
			table.addCell(cell_B_N);
			
			
			//第一行
			//处理方法
			PdfPCell cell_m =new PdfPCell(new Paragraph("处理方法 \nMethod",fontPT_S));
			setCell( cell_m, fontPT_S, 0, 0, 22, true, true);
			table.addCell(cell_m);
			//炉子类型
			PdfPCell cell_ft =new PdfPCell(new Paragraph("炉子类型\nFurnace Type",fontPT_S));
			setCell( cell_ft, fontPT_S, 0, 0, 0, true, true);
			table.addCell(cell_ft);
			//温度 
			PdfPCell cell_t =new PdfPCell(new Paragraph("温度\nTemperature（℃）",fontPT_S));
			setCell( cell_t, fontPT_S, 0, 0, 0, true, true);
			table.addCell(cell_t);
			//冷却方法
			PdfPCell cell_cm =new PdfPCell(new Paragraph("冷却方法\nCooling Method",fontPT_S));
			setCell( cell_cm, fontPT_S, 0, 0, 0, true, true);
			table.addCell(cell_cm);
			//保温时间
			PdfPCell cell_ht =new PdfPCell(new Paragraph("保温时间\nHolding Time（h）",fontPT_S));
			setCell( cell_ht, fontPT_S, 0, 0, 0, true, true);
			table.addCell(cell_ht);
			
			PdfPCell cell_vt=null;
			//目测 VT 
			if("true".equals(textureReport.getVt().toString())){
				cell_vt =new PdfPCell(new Paragraph("\u25a0目测 VT",fontPT_S));
			}else{
				cell_vt =new PdfPCell(new Paragraph("\u25a1目测 VT",fontPT_S));
			}
			setCell( cell_vt, fontPT_S, 0, 0, 0, true, true);
			table.addCell(cell_vt);
			//合格 Accept 
			PdfPCell cell_a =new PdfPCell(new Paragraph("合格 Accept ",fontPT_S));
			setCell( cell_a, fontPT_S, 0, 0, 0, true, true);
			table.addCell(cell_a);
			
			//纽威维护 且是供应商登陆
			if(StrUtil.nullToStr(textureReport.getIsNw()).equals("true")){
				//第二行
				//处理方法
				PdfPCell cell_2_m =new PdfPCell();
				setCell( cell_2_m, fontPT_S, 0, 0, 18, true, true);
				table.addCell(cell_2_m);
				//炉子类型
				PdfPCell cell_2_ft =new PdfPCell();
				setCell( cell_2_ft, fontPT_S, 0, 0, 0, true, true);
				table.addCell(cell_2_ft);
				//温度 
				PdfPCell cell_2_t =new PdfPCell();
				setCell( cell_2_t, fontPT_S, 0, 0, 0, true, true);
				table.addCell(cell_2_t);
				//冷却方法
				PdfPCell cell_2_cm =new PdfPCell();
				setCell( cell_2_cm, fontPT_S, 0, 0, 0, true, true);
				table.addCell(cell_2_cm);
				//保温时间
				PdfPCell cell_2_ht =new PdfPCell();
				setCell( cell_2_ht, fontPT_S, 0, 0, 0, true, true);
				table.addCell(cell_2_ht);
				//适用时填写
				PdfPCell cell_2 =new PdfPCell(new Paragraph("适用时填写 / Fill in if applicable",fontPT_S));
				setCell( cell_2, fontPT_S, 0, 2, 0, true, true);
				table.addCell(cell_2);
				
				//第三行
				PdfPCell cell_3_m =new PdfPCell();
				setCell( cell_3_m, fontPT_S, 0, 0, 18, true, true);
				table.addCell(cell_3_m);
				//炉子类型
				PdfPCell cell_3_ft =new PdfPCell();
				table.addCell(cell_3_ft);
				//温度 
				PdfPCell cell_3_t =new PdfPCell();
				table.addCell(cell_3_t);
				//冷却方法
				PdfPCell cell_3_cm =new PdfPCell();
				table.addCell(cell_3_cm);
				//保温时间
				PdfPCell cell_3_ht =new PdfPCell();
				table.addCell(cell_3_ht);
				//着色PT
				PdfPCell cell_3_vt=null;
				if("true".equals(textureReport.getPt().toString())){
					cell_3_vt =new PdfPCell(new Paragraph("\u25a0着色 PT",fontPT_S));
				}else{
					cell_3_vt =new PdfPCell(new Paragraph("\u25a1着色 PT",fontPT_S));
				}
				cell_3_vt.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell_3_vt);
				//合格 Accept 
				PdfPCell cell_3_a =new PdfPCell(new Paragraph("合格 Accept ",fontPT_S));
				cell_3_a.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell_3_a);
				
				//第四行
				PdfPCell cell_4_m =new PdfPCell();
				setCell( cell_4_m, fontPT_S, 0, 0, 18, true, true);
				table.addCell(cell_4_m);
				//炉子类型
				PdfPCell cell_4_ft =new PdfPCell();
				table.addCell(cell_4_ft);
				//温度 
				PdfPCell cell_4_t =new PdfPCell();
				table.addCell(cell_4_t);
				//冷却方法
				PdfPCell cell_4_cm =new PdfPCell();
				table.addCell(cell_4_cm);
				//保温时间
				PdfPCell cell_4_ht =new PdfPCell();
				table.addCell(cell_4_ht);
				//目测 VT 
				PdfPCell cell_4_vt =null;
				if("true".equals(textureReport.getMt().toString())){
					cell_4_vt =new PdfPCell(new Paragraph("\u25a0磁粉 MT",fontPT_S));
				}else{
					cell_4_vt =new PdfPCell(new Paragraph("\u25a1磁粉 MT",fontPT_S));
				}
				setCell( cell_4_vt, fontPT_S, 0, 0, 0, true, true);
				table.addCell(cell_4_vt);
				//合格 Accept 
				PdfPCell cell_4_a =new PdfPCell(new Paragraph("合格 Accept ",fontPT_S));
				setCell( cell_4_a, fontPT_S, 0, 0, 0, true, true);
				table.addCell(cell_4_a);
				
				//第五行
				PdfPCell cell_5_m =new PdfPCell();
				setCell( cell_5_m, fontPT_S, 0, 0, 18, true, true);
				table.addCell(cell_5_m);
				//炉子类型
				PdfPCell cell_5_ft =new PdfPCell();
				table.addCell(cell_5_ft);
				//温度 
				PdfPCell cell_5_t =new PdfPCell();
				table.addCell(cell_5_t);
				//冷却方法
				PdfPCell cell_5_cm =new PdfPCell();
				table.addCell(cell_5_cm);
				//保温时间
				PdfPCell cell_5_ht =new PdfPCell();
				table.addCell(cell_5_ht);
				//射线 RT
				PdfPCell cell_5_vt =null;
				if("true".equals(textureReport.getRt().toString())){
					cell_5_vt =new PdfPCell(new Paragraph("\u25a0射线 RT",fontPT_S));
				}else{
					cell_5_vt =new PdfPCell(new Paragraph("\u25a1射线 RT",fontPT_S));
				}
				
				cell_5_vt.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell_5_vt);
				//合格 Accept 
				PdfPCell cell_5_a =new PdfPCell(new Paragraph("合格 Accept ",fontPT_S));
				cell_5_a.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell_5_a);
				
				//第六行
				PdfPCell cell_6_m =new PdfPCell();
				setCell( cell_6_m, fontPT_S, 0, 0,18, true, true);
				table.addCell(cell_6_m);
				//炉子类型
				PdfPCell cell_6_ft =new PdfPCell();
				table.addCell(cell_6_ft);
				//温度 
				PdfPCell cell_6_t =new PdfPCell();
				table.addCell(cell_6_t);
				//冷却方法
				PdfPCell cell_6_cm =new PdfPCell();
				table.addCell(cell_6_cm);
				//保温时间
				PdfPCell cell_6_ht =new PdfPCell();
				table.addCell(cell_6_ht);
				//超声 UT 
				PdfPCell cell_6_vt=null;
				if("true".equals(textureReport.getUt().toString())){
					cell_6_vt =new PdfPCell(new Paragraph("\u25a0超声 UT",fontPT_S));
				}else{
					cell_6_vt =new PdfPCell(new Paragraph("\u25a1超声 UT",fontPT_S));
				}
				cell_6_vt.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell_6_vt);
				//合格 Accept 
				PdfPCell cell_6_a =new PdfPCell(new Paragraph("合格 Accept ",fontPT_S));
				cell_6_a.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell_6_a);
			}else{
				//第二行
				//处理方法
				PdfPCell cell_2_m =new PdfPCell(new Paragraph(getHeatSolutionNameByEName(StrUtil.nullToStr(heats.get(0).getMethod()))+"\n"+StrUtil.nullToStr(heats.get(0).getMethod()), fontPT_S));
				setCell( cell_2_m, fontPT_S, 0, 0, 18, true, true);
				table.addCell(cell_2_m);
				//炉子类型
				PdfPCell cell_2_ft =new PdfPCell(new Paragraph(getFuncTypeName(StrUtil.nullToStr(heats.get(0).getFurnace_Type()))+"\n"+StrUtil.nullToStr(heats.get(0).getFurnace_Type()), fontPT_S));
				setCell( cell_2_ft, fontPT_S, 0, 0, 0, true, true);
				table.addCell(cell_2_ft);
				//温度 
				PdfPCell cell_2_t =new PdfPCell(new Paragraph(StrUtil.nullToStr(heats.get(0).getTemperature()), fontPT_S));
				setCell( cell_2_t, fontPT_S, 0, 0, 0, true, true);
				table.addCell(cell_2_t);
				//冷却方法
				PdfPCell cell_2_cm =new PdfPCell(new Paragraph(getCoolMethodNameByEName(StrUtil.nullToStr(heats.get(0).getCooling_Method()))+"\n"+StrUtil.nullToStr(heats.get(0).getCooling_Method()), fontPT_S));
				setCell( cell_2_cm, fontPT_S, 0, 0, 0, true, true);
				table.addCell(cell_2_cm);
				//保温时间
				PdfPCell cell_2_ht =new PdfPCell(new Paragraph(StrUtil.nullToStr(heats.get(0).getHolding_Time()), fontPT_S));
				setCell( cell_2_ht, fontPT_S, 0, 0, 0, true, true);
				table.addCell(cell_2_ht);
				//适用时填写
				PdfPCell cell_2 =new PdfPCell(new Paragraph("适用时填写 / Fill in if applicable",fontPT_S));
				setCell( cell_2, fontPT_S, 0, 2, 0, true, true);
				table.addCell(cell_2);
				
				//第三行
				if(heats.size()>=2){
					PdfPCell cell_3_m =new PdfPCell(new Paragraph(getHeatSolutionNameByEName(StrUtil.nullToStr(heats.get(1).getMethod()))+"\n"+StrUtil.nullToStr(heats.get(1).getMethod()), fontPT_S));
					setCell( cell_3_m, fontPT_S, 0, 0, 18, true, true);
					table.addCell(cell_3_m);
					//炉子类型
					PdfPCell cell_3_ft =new PdfPCell(new Paragraph(getFuncTypeName(StrUtil.nullToStr(heats.get(1).getFurnace_Type()))+"\n"+StrUtil.nullToStr(heats.get(1).getFurnace_Type()), fontPT_S));
					setCell( cell_3_ft, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_3_ft);
					//温度 
					PdfPCell cell_3_t =new PdfPCell(new Paragraph(StrUtil.nullToStr(heats.get(1).getTemperature()), fontPT_S));
					setCell( cell_3_t, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_3_t);
					//冷却方法
					PdfPCell cell_3_cm =new PdfPCell(new Paragraph(getCoolMethodNameByEName(StrUtil.nullToStr(heats.get(1).getCooling_Method()))+"\n"+StrUtil.nullToStr(heats.get(1).getCooling_Method()), fontPT_S));
					setCell( cell_3_cm, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_3_cm);
					//保温时间
					PdfPCell cell_3_ht =new PdfPCell(new Paragraph(StrUtil.nullToStr(heats.get(1).getHolding_Time()), fontPT_S));
					setCell( cell_3_ht, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_3_ht);
					//着色PT
					PdfPCell cell_3_vt=null;
					if("true".equals(textureReport.getPt().toString())){
						cell_3_vt =new PdfPCell(new Paragraph("\u25a0着色 PT",fontPT_S));
					}else{
						cell_3_vt =new PdfPCell(new Paragraph("\u25a1着色 PT",fontPT_S));
					}
					setCell( cell_3_vt, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_3_vt);
					//合格 Accept 
					PdfPCell cell_3_a =new PdfPCell(new Paragraph("合格 Accept ",fontPT_S));
					setCell( cell_3_a, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_3_a);
				}else{
					PdfPCell cell_3_m =new PdfPCell();
					setCell( cell_3_m, fontPT_S, 0, 0, 18, true, true);
					table.addCell(cell_3_m);
					//炉子类型
					PdfPCell cell_3_ft =new PdfPCell();
					table.addCell(cell_3_ft);
					//温度 
					PdfPCell cell_3_t =new PdfPCell();
					table.addCell(cell_3_t);
					//冷却方法
					PdfPCell cell_3_cm =new PdfPCell();
					table.addCell(cell_3_cm);
					//保温时间
					PdfPCell cell_3_ht =new PdfPCell();
					table.addCell(cell_3_ht);
					//着色PT
					PdfPCell cell_3_vt=null;
					if("true".equals(textureReport.getPt().toString())){
						cell_3_vt =new PdfPCell(new Paragraph("\u25a0着色 PT",fontPT_S));
					}else{
						cell_3_vt =new PdfPCell(new Paragraph("\u25a1着色 PT",fontPT_S));
					}
					cell_3_vt.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell_3_vt);
					//合格 Accept 
					PdfPCell cell_3_a =new PdfPCell(new Paragraph("合格 Accept ",fontPT_S));
					cell_3_a.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell_3_a);
				}
				
				
				//第四行
				if(heats.size()>=3){
					//处理方法
					PdfPCell cell_4_m =new PdfPCell(new Paragraph(getHeatSolutionNameByEName(StrUtil.nullToStr(heats.get(2).getMethod()))+"\n"+StrUtil.nullToStr(heats.get(2).getMethod()), fontPT_S));
					setCell( cell_4_m, fontPT_S, 0, 0, 18, true, true);
					table.addCell(cell_4_m);
					//炉子类型
					PdfPCell cell_4_ft =new PdfPCell(new Paragraph(getFuncTypeName(StrUtil.nullToStr(heats.get(2).getFurnace_Type()))+"\n"+StrUtil.nullToStr(heats.get(2).getFurnace_Type()), fontPT_S));
					setCell( cell_4_ft, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_4_ft);
					//温度 
					PdfPCell cell_4_t =new PdfPCell(new Paragraph(StrUtil.nullToStr(heats.get(2).getTemperature()), fontPT_S));
					setCell( cell_4_t, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_4_t);
					//冷却方法
					PdfPCell cell_4_cm =new PdfPCell(new Paragraph(getCoolMethodNameByEName(StrUtil.nullToStr(heats.get(2).getCooling_Method()))+"\n"+StrUtil.nullToStr(heats.get(2).getCooling_Method()), fontPT_S));
					setCell( cell_4_cm, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_4_cm);
					//保温时间
					PdfPCell cell_4_ht =new PdfPCell(new Paragraph(StrUtil.nullToStr(heats.get(2).getHolding_Time()), fontPT_S));
					setCell( cell_4_ht, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_4_ht);
					//磁粉 MT
					PdfPCell cell_4_vt =null;
					if("true".equals(textureReport.getMt().toString())){
						cell_4_vt =new PdfPCell(new Paragraph("\u25a0磁粉 MT",fontPT_S));
					}else{
						cell_4_vt =new PdfPCell(new Paragraph("\u25a1磁粉 MT",fontPT_S));
					}
					setCell( cell_4_vt, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_4_vt);
					//合格 Accept 
					PdfPCell cell_4_a =new PdfPCell(new Paragraph("合格 Accept ",fontPT_S));
					setCell( cell_4_a, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_4_a);
				}else{
					PdfPCell cell_4_m =new PdfPCell();
					setCell( cell_4_m, fontPT_S, 0, 0, 18, true, true);
					table.addCell(cell_4_m);
					//炉子类型
					PdfPCell cell_4_ft =new PdfPCell();
					table.addCell(cell_4_ft);
					//温度 
					PdfPCell cell_4_t =new PdfPCell();
					table.addCell(cell_4_t);
					//冷却方法
					PdfPCell cell_4_cm =new PdfPCell();
					table.addCell(cell_4_cm);
					//保温时间
					PdfPCell cell_4_ht =new PdfPCell();
					table.addCell(cell_4_ht);
					//目测 VT 
					PdfPCell cell_4_vt =null;
					if("true".equals(textureReport.getMt().toString())){
						cell_4_vt =new PdfPCell(new Paragraph("\u25a0磁粉 MT",fontPT_S));
					}else{
						cell_4_vt =new PdfPCell(new Paragraph("\u25a1磁粉 MT",fontPT_S));
					}
					setCell( cell_4_vt, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_4_vt);
					//合格 Accept 
					PdfPCell cell_4_a =new PdfPCell(new Paragraph("合格 Accept ",fontPT_S));
					setCell( cell_4_a, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_4_a);
				}
				
				
				//第五行
				if(heats.size()>=4){
					//处理方法
					PdfPCell cell_5_m =new PdfPCell(new Paragraph(getHeatSolutionNameByEName(StrUtil.nullToStr(heats.get(3).getMethod()))+"\n"+StrUtil.nullToStr(heats.get(3).getMethod()), fontPT_S));
					setCell( cell_5_m, fontPT_S, 0, 0, 18, true, true);
					table.addCell(cell_5_m);
					//炉子类型
					PdfPCell cell_5_ft =new PdfPCell(new Paragraph(getFuncTypeName(StrUtil.nullToStr(heats.get(3).getFurnace_Type()))+"\n"+StrUtil.nullToStr(heats.get(3).getFurnace_Type()), fontPT_S));
					setCell( cell_5_ft, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_5_ft);
					//温度 
					PdfPCell cell_5_t =new PdfPCell(new Paragraph(StrUtil.nullToStr(heats.get(3).getTemperature()), fontPT_S));
					setCell( cell_5_t, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_5_t);
					//冷却方法
					PdfPCell cell_5_cm =new PdfPCell(new Paragraph(getCoolMethodNameByEName(StrUtil.nullToStr(heats.get(3).getCooling_Method()))+"\n"+StrUtil.nullToStr(heats.get(3).getCooling_Method()), fontPT_S));
					setCell( cell_5_cm, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_5_cm);
					//保温时间
					PdfPCell cell_5_ht =new PdfPCell(new Paragraph(StrUtil.nullToStr(heats.get(3).getHolding_Time()), fontPT_S));
					setCell( cell_5_ht, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_5_ht);
					//射线 RT
					PdfPCell cell_5_vt =null;
					if("true".equals(textureReport.getRt().toString())){
						cell_5_vt =new PdfPCell(new Paragraph("\u25a0射线 RT",fontPT_S));
					}else{
						cell_5_vt =new PdfPCell(new Paragraph("\u25a1射线 RT",fontPT_S));
					}
					setCell( cell_5_vt, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_5_vt);
					//合格 Accept 
					PdfPCell cell_5_a =new PdfPCell(new Paragraph("合格 Accept ",fontPT_S));
					setCell( cell_5_a, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_5_a);
				}else{
					PdfPCell cell_5_m =new PdfPCell();
					setCell( cell_5_m, fontPT_S, 0, 0, 18, true, true);
					table.addCell(cell_5_m);
					//炉子类型
					PdfPCell cell_5_ft =new PdfPCell();
					table.addCell(cell_5_ft);
					//温度 
					PdfPCell cell_5_t =new PdfPCell();
					table.addCell(cell_5_t);
					//冷却方法
					PdfPCell cell_5_cm =new PdfPCell();
					table.addCell(cell_5_cm);
					//保温时间
					PdfPCell cell_5_ht =new PdfPCell();
					table.addCell(cell_5_ht);
					//射线 RT
					PdfPCell cell_5_vt =null;
					if("true".equals(textureReport.getRt().toString())){
						cell_5_vt =new PdfPCell(new Paragraph("\u25a0射线 RT",fontPT_S));
					}else{
						cell_5_vt =new PdfPCell(new Paragraph("\u25a1射线 RT",fontPT_S));
					}
					
					cell_5_vt.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell_5_vt);
					//合格 Accept 
					PdfPCell cell_5_a =new PdfPCell(new Paragraph("合格 Accept ",fontPT_S));
					cell_5_a.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell_5_a);
				}
				
				
				//第六行
				if(heats.size()>=5){
					//处理方法
					PdfPCell cell_6_m =new PdfPCell(new Paragraph(getHeatSolutionNameByEName(StrUtil.nullToStr(heats.get(4).getMethod()))+"\n"+StrUtil.nullToStr(heats.get(4).getMethod()), fontPT_S));
					setCell( cell_6_m, fontPT_S, 0, 0, 18, true, true);
					table.addCell(cell_6_m);
					//炉子类型
					PdfPCell cell_6_ft =new PdfPCell(new Paragraph(getFuncTypeName(StrUtil.nullToStr(heats.get(4).getFurnace_Type()))+"\n"+StrUtil.nullToStr(heats.get(4).getFurnace_Type()), fontPT_S));
					setCell( cell_6_ft, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_6_ft);
					//温度 
					PdfPCell cell_6_t =new PdfPCell(new Paragraph(StrUtil.nullToStr(heats.get(4).getTemperature()), fontPT_S));
					setCell( cell_6_t, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_6_t);
					//冷却方法
					PdfPCell cell_6_cm =new PdfPCell(new Paragraph(getCoolMethodNameByEName(StrUtil.nullToStr(heats.get(4).getCooling_Method()))+"\n"+StrUtil.nullToStr(heats.get(4).getCooling_Method()), fontPT_S));
					setCell( cell_6_cm, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_6_cm);
					//保温时间
					PdfPCell cell_6_ht =new PdfPCell(new Paragraph(StrUtil.nullToStr(heats.get(4).getHolding_Time()), fontPT_S));
					setCell( cell_6_ht, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_6_ht);
					//超声 UT 
					PdfPCell cell_6_vt=null;
					if("true".equals(textureReport.getUt().toString())){
						cell_6_vt =new PdfPCell(new Paragraph("\u25a0超声 UT",fontPT_S));
					}else{
						cell_6_vt =new PdfPCell(new Paragraph("\u25a1超声 UT",fontPT_S));
					}
					setCell( cell_6_vt, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_6_vt);
					//合格 Accept 
					PdfPCell cell_6_a =new PdfPCell(new Paragraph("合格 Accept ",fontPT_S));
					setCell( cell_6_a, fontPT_S, 0, 0, 0, true, true);
					table.addCell(cell_6_a);
				}else{
					PdfPCell cell_6_m =new PdfPCell();
					setCell( cell_6_m, fontPT_S, 0, 0,18, true, true);
					table.addCell(cell_6_m);
					//炉子类型
					PdfPCell cell_6_ft =new PdfPCell();
					table.addCell(cell_6_ft);
					//温度 
					PdfPCell cell_6_t =new PdfPCell();
					table.addCell(cell_6_t);
					//冷却方法
					PdfPCell cell_6_cm =new PdfPCell();
					table.addCell(cell_6_cm);
					//保温时间
					PdfPCell cell_6_ht =new PdfPCell();
					table.addCell(cell_6_ht);
					//超声 UT 
					PdfPCell cell_6_vt=null;
					if("true".equals(textureReport.getUt().toString())){
						cell_6_vt =new PdfPCell(new Paragraph("\u25a0超声 UT",fontPT_S));
					}else{
						cell_6_vt =new PdfPCell(new Paragraph("\u25a1超声 UT",fontPT_S));
					}
					cell_6_vt.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell_6_vt);
					//合格 Accept 
					PdfPCell cell_6_a =new PdfPCell(new Paragraph("合格 Accept ",fontPT_S));
					cell_6_a.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell_6_a);
				}
			}
			
			document.add(table);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 确认信息表格
	 * @param document
	 * @param fontPT_S
	 */
	public static void setConfirmInfo(Document document,Font fontPT){
		try{
			PdfPTable table =new PdfPTable(1);
			table.setWidthPercentage(100);
			
			PdfPCell cell =new PdfPCell();
			cell.setMinimumHeight(40);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			String info = "兹证明该材质证明书的内容是正确的和准确的，且所有材料已按标准和顾客要求进行了制造、抽样、检验和试验，结果符合要求。\n"
					+ "We hereby certify that the contents of this material test certificate are correct and accurate and the materials are manufactured, sampled ,tested and inspected\n"
					+ "in accordance with the material specification and customer requirements. All test and inspection results are found to meet the requirements.";
			
			Paragraph p =new Paragraph(info, fontPT);
			cell.setPhrase(p);
			
			table.addCell(cell);
			document.add(table);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 设置签字表格
	 * @param document
	 * @param fontPT
	 */
	public static void setSignTable(Document document,Font fontPT,TextureReport textureReport,User user){
		try{
			PdfPTable table =new PdfPTable(6);
			table.setWidthPercentage(100);
			int widths[]={13,20,13,20,14,20};
			table.setWidths(widths);
			
			//编制
			PdfPCell cell1=new PdfPCell(new Paragraph("编制\nPrepared by:\n(QC Inspector)", fontPT));
			cell1.setMinimumHeight(50);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
			
			//编制签字
			PdfPCell cell2 = new PdfPCell();
			if(user!=null){
				if(user.getPreparedByPath()!=null){
					Image image =Image.getInstance(user.getPreparedByPath());
					image.scaleAbsoluteHeight(46);
					image.scaleAbsoluteWidth(60);
					cell2.addElement(image);
				}
			}
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell2);
			
			//批准
			PdfPCell cell3=new PdfPCell(new Paragraph("批准(质量经理)\nApproved by:\n(QA/QC Manager)", fontPT));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell3);
			
			//批准签字
			PdfPCell cell4=new PdfPCell();
			if(user!=null){
				if(user.getApprovePath()!=null){
					Image image =Image.getInstance(user.getApprovePath());
					image.scaleAbsoluteHeight(46);
					image.scaleAbsoluteWidth(60);
					cell4.addElement(image);
				}
			}
			
			cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell4);
			
			//日期
			PdfPCell cell5=new PdfPCell(new Paragraph("日期\nDate", fontPT));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell5);
			
			//日期 签字
			PdfPCell cell6=new PdfPCell(new Paragraph(textureReport.getCreateTime(),fontPT));
			cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell6.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell6);
			
			//顾客/第三方
//			PdfPCell cell7=new PdfPCell(new Paragraph("顾客/第三方批准\nApproved by\nCustomer/3rd Party", fontPT));
//			cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
//			cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
//			table.addCell(cell7);
//			
//			//顾客/第三方 签字
//			PdfPCell cell8=new PdfPCell();
//			table.addCell(cell8);
			
			
			document.add(table);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * 动态获取单元格宽度
	 * @param elements   化学元素集合
	 * @return
	 */
	public static float[] getCellWidth(List<texture.domain.Element> elements,List<CustomizeElement> customizeElements){
		float arr[] =null;
		int customizeElementSize=0;
		if(customizeElements!=null){
			customizeElementSize= customizeElements.size();
			arr=	new float[5+elements.size()+customizeElementSize+10];
		}else{
			arr= new float[5+elements.size()+10];
		}
		
		arr[0] = 5f;
		arr[1] = 9f;
		arr[2] = 7f;
		arr[3] = 3f;
		arr[4] = 3.5f;
		
		
		arr[arr.length-10] = 3f;
		arr[arr.length-9] = 3f;
		arr[arr.length-8] = 3f;
		arr[arr.length-7] = 3f;
		arr[arr.length-6] = 3f;
		arr[arr.length-5] = 3f;
		arr[arr.length-4] = 3.8f;
		arr[arr.length-3] = 3f;
		arr[arr.length-2] = 3f;
		arr[arr.length-1] = 3f;
		
		for (int i = 0; i < elements.size(); i++) {
			arr[i+5] = (100-arr[0]-arr[1]-arr[2]-arr[3]-arr[4]-arr[arr.length-10]-arr[arr.length-9]
					-arr[arr.length-8]-arr[arr.length-7]-arr[arr.length-6]-arr[arr.length-5]-arr[arr.length-4]
							-arr[arr.length-3]-arr[arr.length-2]-arr[arr.length-1])/(elements.size()+customizeElementSize);
		}
		if(customizeElements!=null){
			for (int i = 0; i < customizeElements.size(); i++) {
				arr[i+5+elements.size()] = (100-arr[0]-arr[1]-arr[2]-arr[3]-arr[4]-arr[arr.length-10]-arr[arr.length-9]
						-arr[arr.length-8]-arr[arr.length-7]-arr[arr.length-6]-arr[arr.length-5]-arr[arr.length-4]
								-arr[arr.length-3]-arr[arr.length-2]-arr[arr.length-1])/(elements.size()+customizeElementSize);
			}
		}
		return arr;
	}
	
	
	/**
	 * 计算CE值
	 * @param elements
	 * @return
	 */
	public String calculateCE(List<ZMtrCodeVO> zMtrCodeVOs,List<texture.domain.Element> elements,List<CustomizeElement> customizeElements){
		double CE=0;
		//遍历所有公式信息
		if(zMtrCodeVOs!=null){
			for (ZMtrCodeVO zMtrCodeVO : zMtrCodeVOs) {
				//根据MTR显示名称 判断是验证CE、PREN、TCRE、Mn/C、Nb、Ti
				if(zMtrCodeVO.getZmtr_code().equals("CE")){
					//根据实际碳元素含量及公式判断是否需要进行验证
					boolean isNeedCeCheck = CommonMethods.isNeedCeCheck(elements, zMtrCodeVO);
					//验证CE值
					if(isNeedCeCheck){
						//checkStr=checkStr+calculateAndCheckCE(zMtrCodeVO,textureReport.getElements(),textureReport.getCustomizeElements());
						//获取公式
						String formula = zMtrCodeVO.getFormule();
						//替换公式
						formula  =CommonMethods.translation(formula, elements,customizeElements);
						//异常处理，由于新的CE公式中有B元素，但是标准中无此元素，可能会漏选导致程序异常，此处强制转换为0
						formula = formula.replace("B", "0");
						//计算公式 
						String CE_str = new StringCaculate().parse(formula).toString();
						CE = Double.parseDouble(CE_str);
					}
				}
			}
		}
		return StrUtil.formatDouble(CE);
	}
	
	/**
	 * 计算Pren值
	 * @param elements
	 * @return
	 */
	public String calculatePREN(List<ZMtrCodeVO> zMtrCodeVOs,List<texture.domain.Element> elements){
		double Pren=0;
		//判断zMtrCodeVOs是否为空，避免勾选pren，但是没有公式的情况
		if(zMtrCodeVOs!=null){
			//遍历
			for (ZMtrCodeVO zMtrCodeVO : zMtrCodeVOs) {
				//根据MTR显示名称 判断是验证CE、PREN、TCRE、Mn/C、Nb、Ti
				if(zMtrCodeVO.getZmtr_code().equals("PREN")){
					double Cr_value=0;
					double Mo_value=0;
					double N_value=0;
					double W_value=0;
					
					//判断使用哪个公式
					if(zMtrCodeVO.getFormule().equals("Cr+3.3xMo+16xN")){
						//遍历化学元素集合
						for (texture.domain.Element element : elements) {
							//判断是否是C元素
							if("Cr".equals(element.getElement_name().toString())){
								Cr_value = element.getEle_value();
							}else if("Mo".equals(element.getElement_name().toString())){
								Mo_value = element.getEle_value();
							}else if("N".equals(element.getElement_name().toString())){
								N_value = element.getEle_value();
							}
						}
						Pren = Cr_value+3.3*Mo_value+16*N_value;
					}else{
						//遍历化学元素集合
						for (texture.domain.Element element : elements) {
							//判断是否是C元素
							if("Cr".equals(element.getElement_name().toString())){
								Cr_value = element.getEle_value();
							}else if("Mo".equals(element.getElement_name().toString())){
								Mo_value = element.getEle_value();
							}else if("N".equals(element.getElement_name().toString())){
								N_value = element.getEle_value();
							}else if("W".equals(element.getElement_name().toString())){
								W_value = element.getEle_value();
							}
						}
						Pren = Cr_value+3.3*(Mo_value+0.5*W_value)+16*N_value;
					}
				}
			}
		}
		return StrUtil.formatDouble(Pren);
	}
	
	
	/**
	 * 针对合并单元格后的单元格，设置单元格格式
	 * @param cell
	 * @param fontSize       字体
	 * @param rowspan     合并单元行
	 * @param colspan	    合并单元列
	 * @param minHeight    最小高度
	 * @param ha     判断是否水平居中
	 * @param va     判断是否垂直居中
	 */
	public static void setCell(PdfPCell cell,
			Font fontSize,int rowspan,int colspan,float minHeight,boolean ha,boolean va){
		//合并单元列
		if(colspan!=0){
			cell.setColspan(colspan);
		}
		//合并单元行
		if(rowspan!=0){
			cell.setRowspan(rowspan);
		}
		//最低高度
		if(minHeight!=0){
			cell.setMinimumHeight(minHeight);
		}
		//判断是否需要 水平居中
		if(ha){
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		}
		//判断是否需要垂直居中
		if(va){
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
		}
	}
	
	/**
	 * 获取炉型中文名称
	 * @param funcType
	 * @return
	 */
	public static String getFuncTypeName(String funcType){
		Map<String, String> map =new HashMap<String, String>();
		map.put("ELECTRIC", "电炉");
		map.put("GAS", "液化气炉");
		map.put("GAS/ELECTRIC", "液化气炉/电炉");
		String rtn = map.get(funcType);
		return rtn==null?"":rtn;
	}
	
	/**
	 * 根据英文名称获取冷却方法的中文
	 * @param eName
	 * @return
	 */
	public static String getCoolMethodNameByEName(String eName){
		//注入
		ICoolMethodService coolMethodService = ContextUtil.act.getBean(ICoolMethodService.class);
		CoolMethod coolMethod =coolMethodService.getCoolMethodByEName(eName);
		return coolMethod==null?"":coolMethod.getcName();
	}
	
	/**
	 * 根据英文名称获取热处理的中文
	 * @param eName
	 * @return
	 */
	public static String getHeatSolutionNameByEName(String eName){
		//注入
		IHeatSolutionService heatSolutionService = ContextUtil.act.getBean(IHeatSolutionService.class);
		HeatSolution heatSolution=heatSolutionService.getHeatSolutionByEName(eName);
		return heatSolution==null?"":heatSolution.getcName();
	}
	
	/**
	 * 根据中文名称和地址获取用户信息
	 * @param cName
	 * @param cAddress
	 * @return
	 */
	public static User getUserByCNameAndCAddress(String cName,String cAddress){
		IUserService userService =ContextUtil.act.getBean(IUserService.class);
		User user =userService.findUserByCNameAndCAddress(cName, cAddress);
		return user;
	}
	
	/**
	 * 将单位为hrc的值对照为单位为HB的值
	 * @param yd   硬度数值
	 * @return
	 */
	public static String changeHrcToHb(double yd){
		IHardService hardService =ContextUtil.act.getBean(IHardService.class);
		String hb = hardService.getHbByHrc(StrUtil.formatDouble2(yd));
		return hb;
	}
	
	/**
	 * 将单位为hrc的值对照为单位为HB的值
	 * @param yd   硬度数值
	 * @return
	 */
	public static String changeHvToHb(double yd){
		IHardService hardService =ContextUtil.act.getBean(IHardService.class);
		String hb = hardService.getHbByHv(StrUtil.formatDouble2(yd));
		return hb;
	}
	
	/**
	 * 获取每页 需要显示的物料集合 
	 * @param pageNo               当前页
	 * @param totalPage            总页数
	 * @param materials             物料集合
	 * @param pageSize              每页显示数量
	 * @return
	 */
	private static List<Material> getPdfPageMaterials(int pageNo,int totalPage,List<Material> materials,int pageSize){
		List<Material> pageMaterials =new ArrayList<Material>();
		
		//判断是否只有1页,则表示显示所有的记录
		if(totalPage == 1){
			pageMaterials=materials;
		}else{
			//若最后一页，那么可能不全
			if(pageNo==totalPage-1){
				 for (int j = pageSize*pageNo; j < materials.size(); j++) {
					 pageMaterials.add(materials.get(j));
				}
			 }else{
				 //显示当前页*每页数量  -->(当前页+1)*每页数量
				 for (int j = pageSize*pageNo; j < pageSize*pageNo+pageSize; j++) {
					 pageMaterials.add(materials.get(j));
				}
			 }
		}
		 return  pageMaterials;
	}
}
