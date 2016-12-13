package texture.report;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class testPdf {

	
	public static void main(String[] args) {
		double s =9999.0;
		double t=9999;
		if(s==9999){
			System.out.println("xxxx");
		}else{
			System.out.println("yyyy");
		}
		
		 Document document = new Document(PageSize.A4.rotate(),10,10,20,10);
	        try { 
			PdfWriter.getInstance(document,
	                 new FileOutputStream("c:\\TableCellBorder.pdf"));
	         document.open();
	
	         BaseFont bfChinese = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", false);  
	         //11号 加粗
	         Font fontZH = new Font(bfChinese, 11, Font.BOLD);
	         //10号 普通
	         Font fontPT = new Font(bfChinese, 10, Font.NORMAL);
	         //10号 普通
	         Font fontPT_S = new Font(bfChinese, 8, Font.NORMAL);
	         
	         //头部表格
	         setTableHead(document,fontZH,fontPT);
	         //订单信息表格
	         setOrderInfoTable(document,fontZH,fontPT);
	         
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
	         setDetailInfo(document,fontPT_S,elements);
	         
	         //元素、炉号、零件表格 具体值 表格
	         setDetailData(document,fontPT_S,elements);
	         
	         //热处理表头
	         setHeatTreatMentTitle(document,fontPT_S);
	         
	         //热处理表头内容
	         setHeatTreatMentInfo(document,fontPT_S);
	         
	         //确认信息
	         setConfirmInfo(document,fontPT);
	         
	         //设置签字表格
	         setSignTable(document,fontPT);
	       
	         
	         //第二页
	         //头部表格
	         setTableHead(document,fontZH,fontPT);
	         //订单信息表格
	         setOrderInfoTable(document,fontZH,fontPT);
	         
	         //元素、炉号、零件表格
	         setDetailInfo(document,fontPT_S,elements);
	         
	         //元素、炉号、零件表格 具体值 表格
	         setDetailData(document,fontPT_S,elements);
	         
	         //热处理表头
	         setHeatTreatMentTitle(document,fontPT_S);
	         
	         //热处理表头内容
	         setHeatTreatMentInfo(document,fontPT_S);
	         
	         //确认信息
	         setConfirmInfo(document,fontPT);
	         
	         //设置签字表格
	         setSignTable(document,fontPT);
	        
	     } catch (Exception e) {
	         e.printStackTrace();
	     } finally {
	         document.close();
	     }
	}
	
	/**
	 * 设置表头信息
	 * @param document
	 * @param fontZH
	 * @param fontPT
	 */
	public static void setTableHead(Document document,Font fontZH,Font fontPT){
		try{
			PdfPTable table1 =new PdfPTable(3);
	        int headerwidths[] = { 30,40,30 }; // percentage
	        table1.setWidths(headerwidths);
	        table1.setWidthPercentage(100);
	        //设置单元格
	        PdfPCell cell1 =new PdfPCell();
	        //设置内容及字体
	        Paragraph p1 =new Paragraph("供应商公司名称\n Supplier's Company Name/Address", fontZH);
	        //设置字体是否居中 
	        p1.setAlignment(Element.ALIGN_CENTER);
	        //在单元格中显示
	        cell1.addElement(p1);
	        //设置 3列合并为1列
	        cell1.setRowspan(3);
	        table1.addCell(cell1);
	        
	        PdfPCell cell2 =new PdfPCell();
	        //设置内容及字体
	        Paragraph p2 =new Paragraph("材质证明书\nMATERIAL TEST CERTIFICATE\nEN10204-2004 Type 3.1", fontZH);
	        p2.setAlignment(Element.ALIGN_CENTER);
	        cell2.addElement(p2);
	        cell2.setRowspan(3);
	        table1.addCell(cell2);
	        
	        PdfPCell cell_bm =new PdfPCell(new Paragraph("表码  Form No. ：NWS3100-01", fontPT));
	        cell_bm.setMinimumHeight(20);
	        table1.addCell(cell_bm);
	        PdfPCell cell_bb =new PdfPCell(new Paragraph("版本号 Rev No. ：2015", fontPT));
	        cell_bb.setMinimumHeight(20);
	        table1.addCell(cell_bb);
	        PdfPCell cell_bh =new PdfPCell(new Paragraph("证书编号 Cert No.：", fontPT));
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
	public static void setOrderInfoTable(Document document,Font fontZH,Font fontPT){
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
	         table2.addCell(cell_cus_name);
	         PdfPCell cell_order =new PdfPCell(new Paragraph("炉号\nHeat  No.",fontPT));
	         cell_order.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell_order.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         table2.addCell(cell_order);
	         PdfPCell cell_order_name =new PdfPCell();
	         table2.addCell(cell_order_name);
	         PdfPCell cell_material =new PdfPCell(new Paragraph("材料\nMaterial",fontPT));
	         cell_material.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell_material.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         table2.addCell(cell_material);
	         PdfPCell cell_material_info =new PdfPCell();
	         table2.addCell(cell_material_info);
	         PdfPCell cell_spe =new PdfPCell(new Paragraph("标准和版本号\nSpecification & Rev.No.",fontPT));
	         cell_spe.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell_spe.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         table2.addCell(cell_spe);
	         PdfPCell cell_spe_info =new PdfPCell();
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
	public static void setDetailInfo(Document document,Font fontPT_S,List<String> elements){
		try{
			//设置table 
			PdfPTable table_left =new PdfPTable(5+elements.size()+8);
			table_left.setWidthPercentage(100);
			table_left.setHorizontalAlignment(0);
			int arr[] = getCellWidth(elements);
			table_left.setWidths(arr);
			
			
			//设置炉号列
			PdfPCell cell0 =new PdfPCell(new Paragraph("物料号\nMaterial No.", fontPT_S));
	        cell0.setRowspan(4);
	        cell0.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell0.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell0);
			
	        //设置零件名称列
			PdfPCell cell1 =new PdfPCell(new Paragraph("零件名称\nPart Name", fontPT_S));
	        cell1.setRowspan(4);
	        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell1);
			
	        //设置零件规格列
	        PdfPCell cell2 =new PdfPCell(new Paragraph("零件规格\nPart Size", fontPT_S));
	        cell2.setRowspan(4);
	        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell2);
	        
	        //设置数量列
	        PdfPCell cell3 =new PdfPCell(new Paragraph("数量\nQTY", fontPT_S));
	        cell3.setRowspan(4);
	        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell3);
	        
	        PdfPCell cell_ys =new PdfPCell(new Paragraph("元素\nElement", fontPT_S));
	        cell_ys.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_ys.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        cell_ys.setRowspan(2);
	        table_left.addCell(cell_ys);
	        
	        //化学成分列
	        PdfPCell cell_hxcf =new PdfPCell(new Paragraph("化学成分 Chemical composition  (%)",fontPT_S));
	        cell_hxcf.setColspan(elements.size());
	        //设置高度
	        cell_hxcf.setMinimumHeight(40);
	        cell_hxcf.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_hxcf.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell_hxcf);
	        
	        //机械性能
	        PdfPCell cell_jxxn =new PdfPCell(new Paragraph("机械性能 Mechanical Property",fontPT_S));
	        cell_jxxn.setColspan(8);
	        cell_jxxn.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_jxxn.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell_jxxn);
	        
	        
	        //元素行,遍历集合
	        for (int i = 0; i < elements.size(); i++) {
	        	PdfPCell cell_i= new PdfPCell(new Paragraph(elements.get(i).toString(),fontPT_S));
	        	cell_i.setHorizontalAlignment(Element.ALIGN_CENTER);
	        	cell_i.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        	table_left.addCell(cell_i);
			}
	        
	        //抗拉
	        PdfPCell cell_kl =new PdfPCell(new Paragraph("抗拉 \nTS\n（Mpa）",fontPT_S));
	        cell_kl.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_kl.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell_kl);
	        //屈服
	        PdfPCell cell_qf =new PdfPCell(new Paragraph("屈服\nYS\n（Mpa）",fontPT_S));
	        cell_qf.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_qf.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell_qf);
	        //延伸
	        PdfPCell cell_ysn =new PdfPCell(new Paragraph("延伸\nE\n（%）",fontPT_S));
	        cell_ysn.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_ysn.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell_ysn);
	        //收缩
	        PdfPCell cell_ss =new PdfPCell(new Paragraph("收缩 \nR\n（%）",fontPT_S));
	        cell_ss.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_ss.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell_ss);
	        //硬度
	        PdfPCell cell_yd =new PdfPCell(new Paragraph("硬度 \nHardness\n（HB）",fontPT_S));
	        cell_yd.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_yd.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell_yd);
	        //冲击试验Impact Test
	        PdfPCell cell_cj =new PdfPCell(new Paragraph("冲击试验Impact Test\n冲击值 Akv，J\n温度 Tem。℃：",fontPT_S));
	        cell_cj.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_cj.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        cell_cj.setColspan(3);
	        table_left.addCell(cell_cj);
	        
	        
	        //max值 行
	        PdfPCell cell_Max =new PdfPCell(new Paragraph("Max", fontPT_S));
	        cell_Max.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_Max.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        cell_Max.setMinimumHeight(15);
	        table_left.addCell(cell_Max);
	        //遍历集合
	        for (int i = 0; i < elements.size(); i++) {
	        	PdfPCell cell_i_Max= new PdfPCell();
	        	table_left.addCell(cell_i_Max);
			}
	        //抗拉 
	        PdfPCell cell_kl_Max= new PdfPCell();
        	table_left.addCell(cell_kl_Max);
        	//屈服
        	PdfPCell cell_qf_Max= new PdfPCell();
        	table_left.addCell(cell_qf_Max);
        	PdfPCell cell_ysn_Max= new PdfPCell();
        	table_left.addCell(cell_ysn_Max);
        	PdfPCell cell_ss_MAx= new PdfPCell();
        	table_left.addCell(cell_ss_MAx);
        	PdfPCell cell_yd_Max= new PdfPCell();
        	table_left.addCell(cell_yd_Max);
        	PdfPCell cell_cj_1= new PdfPCell(new Paragraph("Avg：           Min：",fontPT_S));
        	cell_cj_1.setColspan(3);
        	table_left.addCell(cell_cj_1);
        	
	        

	        
	        //min 行
	        PdfPCell cell_Min =new PdfPCell(new Paragraph("Min", fontPT_S));
	        cell_Min.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_Min.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        cell_Min.setMinimumHeight(15);
	        table_left.addCell(cell_Min);
	        for (int i = 0; i < elements.size(); i++) {
	        	PdfPCell cell_i_Min= new PdfPCell();
	        	table_left.addCell(cell_i_Min);
			}
	        
	        PdfPCell cell_kl_Min= new PdfPCell();
        	table_left.addCell(cell_kl_Min);
        	PdfPCell cell_qf_Min= new PdfPCell();
        	table_left.addCell(cell_qf_Min);
        	PdfPCell cell_ysn_Min= new PdfPCell();
        	table_left.addCell(cell_ysn_Min);
        	PdfPCell cell_ss_Min= new PdfPCell();
        	table_left.addCell(cell_ss_Min);
        	PdfPCell cell_yd_Min= new PdfPCell();
        	table_left.addCell(cell_yd_Min);
        	PdfPCell cell_cj_1_1= new PdfPCell(new Paragraph("1",fontPT_S));
        	table_left.addCell(cell_cj_1_1);
        	PdfPCell cell_cj_1_2= new PdfPCell(new Paragraph("2",fontPT_S));
        	table_left.addCell(cell_cj_1_2);
        	PdfPCell cell_cj_1_3= new PdfPCell(new Paragraph("3",fontPT_S));
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
	public static void setDetailData(Document document,Font fontPT_S,List<String> elements){
		try{
			//设置table 
			PdfPTable table_left =new PdfPTable(5+elements.size()+8);
			table_left.setWidthPercentage(100);
			int arr[] = getCellWidth(elements);
			table_left.setWidths(arr);
			
			//设置8行
			for (int i = 0; i < 8; i++) {
				//炉号
				PdfPCell cell_i_lh =new PdfPCell();
				cell_i_lh.setMinimumHeight(15);
				table_left.addCell(cell_i_lh);
				
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
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell1.setMinimumHeight(30);
			ht_table.addCell(cell1);
			
			PdfPCell cell2 =new PdfPCell(new Paragraph("无损检测\nNDT",fontPT_S));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
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
	public static void setHeatTreatMentInfo(Document document,Font fontPT_S){
		try{
			PdfPTable table =new PdfPTable(8);
			int widths[]={13,8,8,9,18,14,10,20};
			table.setWidthPercentage(100);
			table.setWidths(widths);
			
			PdfPCell cell_B_N =new PdfPCell(new Paragraph("热处理批号\nBatch No.",fontPT_S));
			cell_B_N.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_B_N.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell_B_N.setRowspan(6);
			table.addCell(cell_B_N);
			
			//第一行
			//处理方法
			PdfPCell cell_m =new PdfPCell(new Paragraph("处理方法 \nMethod",fontPT_S));
			cell_m.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_m.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell_m.setMinimumHeight(30);
			table.addCell(cell_m);
			//炉子类型
			PdfPCell cell_ft =new PdfPCell(new Paragraph("炉子类型\nFurnace Type",fontPT_S));
			cell_ft.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_ft.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell_ft);
			//温度 
			PdfPCell cell_t =new PdfPCell(new Paragraph("温度\nTemperature（℃）",fontPT_S));
			cell_t.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_t.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell_t);
			//冷却方法
			PdfPCell cell_cm =new PdfPCell(new Paragraph("冷却方法\nCooling Method",fontPT_S));
			cell_cm.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_cm.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell_cm);
			//保温时间
			PdfPCell cell_ht =new PdfPCell(new Paragraph("保温时间\nHolding Time（h）",fontPT_S));
			cell_ht.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_ht.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell_ht);
			//目测 VT 
			PdfPCell cell_vt =new PdfPCell(new Paragraph("\u25a1目测 VT",fontPT_S));
			cell_vt.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_vt.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell_vt);
			//合格 Accept 
			PdfPCell cell_a =new PdfPCell(new Paragraph("合格 Accept ",fontPT_S));
			cell_a.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_a.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell_a);
			
			
			//第二行
			PdfPCell cell_2_m =new PdfPCell();
			cell_2_m.setMinimumHeight(15);
			table.addCell(cell_2_m);
			//炉子类型
			PdfPCell cell_2_ft =new PdfPCell();
			table.addCell(cell_2_ft);
			//温度 
			PdfPCell cell_2_t =new PdfPCell();
			table.addCell(cell_2_t);
			//冷却方法
			PdfPCell cell_2_cm =new PdfPCell();
			table.addCell(cell_2_cm);
			//保温时间
			PdfPCell cell_2_ht =new PdfPCell();
			table.addCell(cell_2_ht);
			//适用时填写
			PdfPCell cell_2 =new PdfPCell(new Paragraph("适用时填写 / Fill in if applicable",fontPT_S));
			cell_2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_2.setColspan(2);
			table.addCell(cell_2);
			
			//第三行
			PdfPCell cell_3_m =new PdfPCell();
			cell_3_m.setMinimumHeight(15);
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
			//目测 VT 
			PdfPCell cell_3_vt =new PdfPCell(new Paragraph("\u25a1着色 PT",fontPT_S));
			cell_3_vt.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_3_vt);
			//合格 Accept 
			PdfPCell cell_3_a =new PdfPCell(new Paragraph("合格 Accept ",fontPT_S));
			cell_3_a.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_3_a);
			
			//第四行
			PdfPCell cell_4_m =new PdfPCell();
			cell_4_m.setMinimumHeight(15);
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
			PdfPCell cell_4_vt =new PdfPCell(new Paragraph("\u25a1磁粉 MT",fontPT_S));
			cell_4_vt.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_4_vt);
			//合格 Accept 
			PdfPCell cell_4_a =new PdfPCell(new Paragraph("合格 Accept ",fontPT_S));
			cell_4_a.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_4_a);
			
			//第五行
			PdfPCell cell_5_m =new PdfPCell();
			cell_5_m.setMinimumHeight(15);
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
			//目测 VT 
			PdfPCell cell_5_vt =new PdfPCell(new Paragraph("\u25a1射线 RT",fontPT_S));
			cell_5_vt.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_5_vt);
			//合格 Accept 
			PdfPCell cell_5_a =new PdfPCell(new Paragraph("合格 Accept ",fontPT_S));
			cell_5_a.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_5_a);
			
			//第六行
			PdfPCell cell_6_m =new PdfPCell();
			cell_6_m.setMinimumHeight(15);
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
			//目测 VT 
			PdfPCell cell_6_vt =new PdfPCell(new Paragraph("\u25a1超声 UT",fontPT_S));
			cell_6_vt.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_6_vt);
			//合格 Accept 
			PdfPCell cell_6_a =new PdfPCell(new Paragraph("合格 Accept ",fontPT_S));
			cell_6_a.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_6_a);
			
			
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
			cell.setMinimumHeight(50);
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
	public static void setSignTable(Document document,Font fontPT){
		try{
			PdfPTable table =new PdfPTable(8);
			table.setWidthPercentage(100);
			int widths[]={10,10,10,10,15,15,15,15};
			table.setWidths(widths);
			
			//编制
			PdfPCell cell1=new PdfPCell(new Paragraph("编制\nPrepared by:\n(QC Inspector)", fontPT));
			cell1.setMinimumHeight(50);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
			
			//编制签字
			PdfPCell cell2=new PdfPCell();
			table.addCell(cell2);
			
			//批准
			PdfPCell cell3=new PdfPCell(new Paragraph("批准(质量经理)\nApproved by:\n(QA/QC Manager)", fontPT));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell3);
			
			//批准签字
			PdfPCell cell4=new PdfPCell();
			table.addCell(cell4);
			
			//日期
			PdfPCell cell5=new PdfPCell(new Paragraph("日期\nDate", fontPT));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell5);
			
			//日期 签字
			PdfPCell cell6=new PdfPCell();
			table.addCell(cell6);
			
			//顾客/第三方
			PdfPCell cell7=new PdfPCell(new Paragraph("顾客/第三方批准\nApproved by\nCustomer/3rd Party", fontPT));
			cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell7);
			
			//顾客/第三方 签字
			PdfPCell cell8=new PdfPCell();
			table.addCell(cell8);
			
			
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
	public static int[] getCellWidth(List<String> elements){
		int arr[] =new int[5+elements.size()+8];
		arr[0] = 5;
		arr[1] = 5;
		arr[2] = 5;
		arr[3] = 3;
		arr[4] = 4;
		
		
		
		arr[arr.length-8] = 3;
		arr[arr.length-7] = 3;
		arr[arr.length-6] = 3;
		arr[arr.length-5] = 3;
		arr[arr.length-4] = 3;
		arr[arr.length-3] = 3;
		arr[arr.length-2] = 3;
		arr[arr.length-1] = 3;
		
		for (int i = 0; i < elements.size(); i++) {
			arr[i+5] = (100-arr[0]-arr[1]-arr[2]-arr[3]-arr[4]
					-arr[arr.length-8]-arr[arr.length-7]-arr[arr.length-6]-arr[arr.length-5]-arr[arr.length-4]
							-arr[arr.length-3]-arr[arr.length-2]-arr[arr.length-1])/elements.size();
		}
		return arr;
	}
}
