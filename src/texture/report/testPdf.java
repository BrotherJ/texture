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
	         //11�� �Ӵ�
	         Font fontZH = new Font(bfChinese, 11, Font.BOLD);
	         //10�� ��ͨ
	         Font fontPT = new Font(bfChinese, 10, Font.NORMAL);
	         //10�� ��ͨ
	         Font fontPT_S = new Font(bfChinese, 8, Font.NORMAL);
	         
	         //ͷ�����
	         setTableHead(document,fontZH,fontPT);
	         //������Ϣ���
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
	         
	         //Ԫ�ء�¯�š�������
	         setDetailInfo(document,fontPT_S,elements);
	         
	         //Ԫ�ء�¯�š������� ����ֵ ���
	         setDetailData(document,fontPT_S,elements);
	         
	         //�ȴ����ͷ
	         setHeatTreatMentTitle(document,fontPT_S);
	         
	         //�ȴ����ͷ����
	         setHeatTreatMentInfo(document,fontPT_S);
	         
	         //ȷ����Ϣ
	         setConfirmInfo(document,fontPT);
	         
	         //����ǩ�ֱ��
	         setSignTable(document,fontPT);
	       
	         
	         //�ڶ�ҳ
	         //ͷ�����
	         setTableHead(document,fontZH,fontPT);
	         //������Ϣ���
	         setOrderInfoTable(document,fontZH,fontPT);
	         
	         //Ԫ�ء�¯�š�������
	         setDetailInfo(document,fontPT_S,elements);
	         
	         //Ԫ�ء�¯�š������� ����ֵ ���
	         setDetailData(document,fontPT_S,elements);
	         
	         //�ȴ����ͷ
	         setHeatTreatMentTitle(document,fontPT_S);
	         
	         //�ȴ����ͷ����
	         setHeatTreatMentInfo(document,fontPT_S);
	         
	         //ȷ����Ϣ
	         setConfirmInfo(document,fontPT);
	         
	         //����ǩ�ֱ��
	         setSignTable(document,fontPT);
	        
	     } catch (Exception e) {
	         e.printStackTrace();
	     } finally {
	         document.close();
	     }
	}
	
	/**
	 * ���ñ�ͷ��Ϣ
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
	        //���õ�Ԫ��
	        PdfPCell cell1 =new PdfPCell();
	        //�������ݼ�����
	        Paragraph p1 =new Paragraph("��Ӧ�̹�˾����\n Supplier's Company Name/Address", fontZH);
	        //���������Ƿ���� 
	        p1.setAlignment(Element.ALIGN_CENTER);
	        //�ڵ�Ԫ������ʾ
	        cell1.addElement(p1);
	        //���� 3�кϲ�Ϊ1��
	        cell1.setRowspan(3);
	        table1.addCell(cell1);
	        
	        PdfPCell cell2 =new PdfPCell();
	        //�������ݼ�����
	        Paragraph p2 =new Paragraph("����֤����\nMATERIAL TEST CERTIFICATE\nEN10204-2004 Type 3.1", fontZH);
	        p2.setAlignment(Element.ALIGN_CENTER);
	        cell2.addElement(p2);
	        cell2.setRowspan(3);
	        table1.addCell(cell2);
	        
	        PdfPCell cell_bm =new PdfPCell(new Paragraph("����  Form No. ��NWS3100-01", fontPT));
	        cell_bm.setMinimumHeight(20);
	        table1.addCell(cell_bm);
	        PdfPCell cell_bb =new PdfPCell(new Paragraph("�汾�� Rev No. ��2015", fontPT));
	        cell_bb.setMinimumHeight(20);
	        table1.addCell(cell_bb);
	        PdfPCell cell_bh =new PdfPCell(new Paragraph("֤���� Cert No.��", fontPT));
	        cell_bh.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        cell_bh.setMinimumHeight(20);
	        table1.addCell(cell_bh);

	        document.add(table1);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ���ö�����Ϣ
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
	         
	         PdfPCell cell_cus =new PdfPCell(new Paragraph("�˿�\nCustomer",fontPT));
	         cell_cus.setMinimumHeight(30);
	         cell_cus.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell_cus.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         table2.addCell(cell_cus);
	         
	         PdfPCell cell_cus_name =new PdfPCell();
	         table2.addCell(cell_cus_name);
	         PdfPCell cell_order =new PdfPCell(new Paragraph("¯��\nHeat  No.",fontPT));
	         cell_order.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell_order.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         table2.addCell(cell_order);
	         PdfPCell cell_order_name =new PdfPCell();
	         table2.addCell(cell_order_name);
	         PdfPCell cell_material =new PdfPCell(new Paragraph("����\nMaterial",fontPT));
	         cell_material.setHorizontalAlignment(Element.ALIGN_CENTER);
	         cell_material.setVerticalAlignment(Element.ALIGN_MIDDLE);
	         table2.addCell(cell_material);
	         PdfPCell cell_material_info =new PdfPCell();
	         table2.addCell(cell_material_info);
	         PdfPCell cell_spe =new PdfPCell(new Paragraph("��׼�Ͱ汾��\nSpecification & Rev.No.",fontPT));
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
	 * ������ϸ��Ϣ�ı� 
	 * @param document
	 * @param fontPT_S
	 */
	public static void setDetailInfo(Document document,Font fontPT_S,List<String> elements){
		try{
			//����table 
			PdfPTable table_left =new PdfPTable(5+elements.size()+8);
			table_left.setWidthPercentage(100);
			table_left.setHorizontalAlignment(0);
			int arr[] = getCellWidth(elements);
			table_left.setWidths(arr);
			
			
			//����¯����
			PdfPCell cell0 =new PdfPCell(new Paragraph("���Ϻ�\nMaterial No.", fontPT_S));
	        cell0.setRowspan(4);
	        cell0.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell0.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell0);
			
	        //�������������
			PdfPCell cell1 =new PdfPCell(new Paragraph("�������\nPart Name", fontPT_S));
	        cell1.setRowspan(4);
	        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell1);
			
	        //������������
	        PdfPCell cell2 =new PdfPCell(new Paragraph("������\nPart Size", fontPT_S));
	        cell2.setRowspan(4);
	        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell2);
	        
	        //����������
	        PdfPCell cell3 =new PdfPCell(new Paragraph("����\nQTY", fontPT_S));
	        cell3.setRowspan(4);
	        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell3);
	        
	        PdfPCell cell_ys =new PdfPCell(new Paragraph("Ԫ��\nElement", fontPT_S));
	        cell_ys.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_ys.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        cell_ys.setRowspan(2);
	        table_left.addCell(cell_ys);
	        
	        //��ѧ�ɷ���
	        PdfPCell cell_hxcf =new PdfPCell(new Paragraph("��ѧ�ɷ� Chemical composition  (%)",fontPT_S));
	        cell_hxcf.setColspan(elements.size());
	        //���ø߶�
	        cell_hxcf.setMinimumHeight(40);
	        cell_hxcf.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_hxcf.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell_hxcf);
	        
	        //��е����
	        PdfPCell cell_jxxn =new PdfPCell(new Paragraph("��е���� Mechanical Property",fontPT_S));
	        cell_jxxn.setColspan(8);
	        cell_jxxn.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_jxxn.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell_jxxn);
	        
	        
	        //Ԫ����,��������
	        for (int i = 0; i < elements.size(); i++) {
	        	PdfPCell cell_i= new PdfPCell(new Paragraph(elements.get(i).toString(),fontPT_S));
	        	cell_i.setHorizontalAlignment(Element.ALIGN_CENTER);
	        	cell_i.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        	table_left.addCell(cell_i);
			}
	        
	        //����
	        PdfPCell cell_kl =new PdfPCell(new Paragraph("���� \nTS\n��Mpa��",fontPT_S));
	        cell_kl.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_kl.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell_kl);
	        //����
	        PdfPCell cell_qf =new PdfPCell(new Paragraph("����\nYS\n��Mpa��",fontPT_S));
	        cell_qf.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_qf.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell_qf);
	        //����
	        PdfPCell cell_ysn =new PdfPCell(new Paragraph("����\nE\n��%��",fontPT_S));
	        cell_ysn.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_ysn.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell_ysn);
	        //����
	        PdfPCell cell_ss =new PdfPCell(new Paragraph("���� \nR\n��%��",fontPT_S));
	        cell_ss.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_ss.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell_ss);
	        //Ӳ��
	        PdfPCell cell_yd =new PdfPCell(new Paragraph("Ӳ�� \nHardness\n��HB��",fontPT_S));
	        cell_yd.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_yd.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        table_left.addCell(cell_yd);
	        //�������Impact Test
	        PdfPCell cell_cj =new PdfPCell(new Paragraph("�������Impact Test\n���ֵ Akv��J\n�¶� Tem���棺",fontPT_S));
	        cell_cj.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_cj.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        cell_cj.setColspan(3);
	        table_left.addCell(cell_cj);
	        
	        
	        //maxֵ ��
	        PdfPCell cell_Max =new PdfPCell(new Paragraph("Max", fontPT_S));
	        cell_Max.setHorizontalAlignment(Element.ALIGN_CENTER);
	        cell_Max.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        cell_Max.setMinimumHeight(15);
	        table_left.addCell(cell_Max);
	        //��������
	        for (int i = 0; i < elements.size(); i++) {
	        	PdfPCell cell_i_Max= new PdfPCell();
	        	table_left.addCell(cell_i_Max);
			}
	        //���� 
	        PdfPCell cell_kl_Max= new PdfPCell();
        	table_left.addCell(cell_kl_Max);
        	//����
        	PdfPCell cell_qf_Max= new PdfPCell();
        	table_left.addCell(cell_qf_Max);
        	PdfPCell cell_ysn_Max= new PdfPCell();
        	table_left.addCell(cell_ysn_Max);
        	PdfPCell cell_ss_MAx= new PdfPCell();
        	table_left.addCell(cell_ss_MAx);
        	PdfPCell cell_yd_Max= new PdfPCell();
        	table_left.addCell(cell_yd_Max);
        	PdfPCell cell_cj_1= new PdfPCell(new Paragraph("Avg��           Min��",fontPT_S));
        	cell_cj_1.setColspan(3);
        	table_left.addCell(cell_cj_1);
        	
	        

	        
	        //min ��
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
	 * ������������䵽 �ո���
	 * @param document
	 * @param fontPT_S
	 * @param elements
	 */
	public static void setDetailData(Document document,Font fontPT_S,List<String> elements){
		try{
			//����table 
			PdfPTable table_left =new PdfPTable(5+elements.size()+8);
			table_left.setWidthPercentage(100);
			int arr[] = getCellWidth(elements);
			table_left.setWidths(arr);
			
			//����8��
			for (int i = 0; i < 8; i++) {
				//¯��
				PdfPCell cell_i_lh =new PdfPCell();
				cell_i_lh.setMinimumHeight(15);
				table_left.addCell(cell_i_lh);
				
				//�������
				PdfPCell cell_i_mc =new PdfPCell();
				table_left.addCell(cell_i_mc);
				
				//������
				PdfPCell cell_i_gg =new PdfPCell();
				table_left.addCell(cell_i_gg);
				
				//����
				PdfPCell cell_i_sl =new PdfPCell();
				table_left.addCell(cell_i_sl);
				
				//Ԫ��
				PdfPCell cell_i_ys =new PdfPCell();
				table_left.addCell(cell_i_ys);
				
				//������ӦԪ�غ������� 
				for (int j = 0; j < elements.size(); j++) {
					PdfPCell cell_i_j =new PdfPCell();
					table_left.addCell(cell_i_j);
				}
				
				//����
				PdfPCell cell_i_ls =new PdfPCell();
				table_left.addCell(cell_i_ls);
				
				//����
				PdfPCell cell_i_qf =new PdfPCell();
				table_left.addCell(cell_i_qf);
				
				//����
				PdfPCell cell_i_ysh =new PdfPCell();
				table_left.addCell(cell_i_ysh);
				
				//����
				PdfPCell cell_i_ss =new PdfPCell();
				table_left.addCell(cell_i_ss);
				
				//Ӳ��
				PdfPCell cell_i_yd =new PdfPCell();
				table_left.addCell(cell_i_yd);
				
				//�������
				PdfPCell cell_i_1 =new PdfPCell();
				table_left.addCell(cell_i_1);
				//�������
				PdfPCell cell_i_2 =new PdfPCell();
				table_left.addCell(cell_i_2);
				//�������
				PdfPCell cell_i_3 =new PdfPCell();
				table_left.addCell(cell_i_3);
			}
			document.add(table_left);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * �ȴ����ͷ
	 * @param document
	 * @param fontPT_S
	 */
	public static void setHeatTreatMentTitle(Document document,Font fontPT_S){
		try{
			PdfPTable ht_table =new PdfPTable(2);
			//���õ�Ԫ���Ȱٷֱ�
			int colWidths[]={70,30};
			ht_table.setWidthPercentage(100);
			ht_table.setWidths(colWidths);
			
			PdfPCell cell1 =new PdfPCell(new Paragraph("�ȴ���\nHeat Treatment",fontPT_S));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell1.setMinimumHeight(30);
			ht_table.addCell(cell1);
			
			PdfPCell cell2 =new PdfPCell(new Paragraph("������\nNDT",fontPT_S));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);
			ht_table.addCell(cell2);
			
			document.add(ht_table);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * �ȴ����������
	 * @param document
	 * @param fontPT_S
	 */
	public static void setHeatTreatMentInfo(Document document,Font fontPT_S){
		try{
			PdfPTable table =new PdfPTable(8);
			int widths[]={13,8,8,9,18,14,10,20};
			table.setWidthPercentage(100);
			table.setWidths(widths);
			
			PdfPCell cell_B_N =new PdfPCell(new Paragraph("�ȴ�������\nBatch No.",fontPT_S));
			cell_B_N.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_B_N.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell_B_N.setRowspan(6);
			table.addCell(cell_B_N);
			
			//��һ��
			//������
			PdfPCell cell_m =new PdfPCell(new Paragraph("������ \nMethod",fontPT_S));
			cell_m.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_m.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell_m.setMinimumHeight(30);
			table.addCell(cell_m);
			//¯������
			PdfPCell cell_ft =new PdfPCell(new Paragraph("¯������\nFurnace Type",fontPT_S));
			cell_ft.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_ft.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell_ft);
			//�¶� 
			PdfPCell cell_t =new PdfPCell(new Paragraph("�¶�\nTemperature���棩",fontPT_S));
			cell_t.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_t.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell_t);
			//��ȴ����
			PdfPCell cell_cm =new PdfPCell(new Paragraph("��ȴ����\nCooling Method",fontPT_S));
			cell_cm.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_cm.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell_cm);
			//����ʱ��
			PdfPCell cell_ht =new PdfPCell(new Paragraph("����ʱ��\nHolding Time��h��",fontPT_S));
			cell_ht.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_ht.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell_ht);
			//Ŀ�� VT 
			PdfPCell cell_vt =new PdfPCell(new Paragraph("\u25a1Ŀ�� VT",fontPT_S));
			cell_vt.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_vt.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell_vt);
			//�ϸ� Accept 
			PdfPCell cell_a =new PdfPCell(new Paragraph("�ϸ� Accept ",fontPT_S));
			cell_a.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_a.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell_a);
			
			
			//�ڶ���
			PdfPCell cell_2_m =new PdfPCell();
			cell_2_m.setMinimumHeight(15);
			table.addCell(cell_2_m);
			//¯������
			PdfPCell cell_2_ft =new PdfPCell();
			table.addCell(cell_2_ft);
			//�¶� 
			PdfPCell cell_2_t =new PdfPCell();
			table.addCell(cell_2_t);
			//��ȴ����
			PdfPCell cell_2_cm =new PdfPCell();
			table.addCell(cell_2_cm);
			//����ʱ��
			PdfPCell cell_2_ht =new PdfPCell();
			table.addCell(cell_2_ht);
			//����ʱ��д
			PdfPCell cell_2 =new PdfPCell(new Paragraph("����ʱ��д / Fill in if applicable",fontPT_S));
			cell_2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell_2.setColspan(2);
			table.addCell(cell_2);
			
			//������
			PdfPCell cell_3_m =new PdfPCell();
			cell_3_m.setMinimumHeight(15);
			table.addCell(cell_3_m);
			//¯������
			PdfPCell cell_3_ft =new PdfPCell();
			table.addCell(cell_3_ft);
			//�¶� 
			PdfPCell cell_3_t =new PdfPCell();
			table.addCell(cell_3_t);
			//��ȴ����
			PdfPCell cell_3_cm =new PdfPCell();
			table.addCell(cell_3_cm);
			//����ʱ��
			PdfPCell cell_3_ht =new PdfPCell();
			table.addCell(cell_3_ht);
			//Ŀ�� VT 
			PdfPCell cell_3_vt =new PdfPCell(new Paragraph("\u25a1��ɫ PT",fontPT_S));
			cell_3_vt.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_3_vt);
			//�ϸ� Accept 
			PdfPCell cell_3_a =new PdfPCell(new Paragraph("�ϸ� Accept ",fontPT_S));
			cell_3_a.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_3_a);
			
			//������
			PdfPCell cell_4_m =new PdfPCell();
			cell_4_m.setMinimumHeight(15);
			table.addCell(cell_4_m);
			//¯������
			PdfPCell cell_4_ft =new PdfPCell();
			table.addCell(cell_4_ft);
			//�¶� 
			PdfPCell cell_4_t =new PdfPCell();
			table.addCell(cell_4_t);
			//��ȴ����
			PdfPCell cell_4_cm =new PdfPCell();
			table.addCell(cell_4_cm);
			//����ʱ��
			PdfPCell cell_4_ht =new PdfPCell();
			table.addCell(cell_4_ht);
			//Ŀ�� VT 
			PdfPCell cell_4_vt =new PdfPCell(new Paragraph("\u25a1�ŷ� MT",fontPT_S));
			cell_4_vt.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_4_vt);
			//�ϸ� Accept 
			PdfPCell cell_4_a =new PdfPCell(new Paragraph("�ϸ� Accept ",fontPT_S));
			cell_4_a.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_4_a);
			
			//������
			PdfPCell cell_5_m =new PdfPCell();
			cell_5_m.setMinimumHeight(15);
			table.addCell(cell_5_m);
			//¯������
			PdfPCell cell_5_ft =new PdfPCell();
			table.addCell(cell_5_ft);
			//�¶� 
			PdfPCell cell_5_t =new PdfPCell();
			table.addCell(cell_5_t);
			//��ȴ����
			PdfPCell cell_5_cm =new PdfPCell();
			table.addCell(cell_5_cm);
			//����ʱ��
			PdfPCell cell_5_ht =new PdfPCell();
			table.addCell(cell_5_ht);
			//Ŀ�� VT 
			PdfPCell cell_5_vt =new PdfPCell(new Paragraph("\u25a1���� RT",fontPT_S));
			cell_5_vt.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_5_vt);
			//�ϸ� Accept 
			PdfPCell cell_5_a =new PdfPCell(new Paragraph("�ϸ� Accept ",fontPT_S));
			cell_5_a.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_5_a);
			
			//������
			PdfPCell cell_6_m =new PdfPCell();
			cell_6_m.setMinimumHeight(15);
			table.addCell(cell_6_m);
			//¯������
			PdfPCell cell_6_ft =new PdfPCell();
			table.addCell(cell_6_ft);
			//�¶� 
			PdfPCell cell_6_t =new PdfPCell();
			table.addCell(cell_6_t);
			//��ȴ����
			PdfPCell cell_6_cm =new PdfPCell();
			table.addCell(cell_6_cm);
			//����ʱ��
			PdfPCell cell_6_ht =new PdfPCell();
			table.addCell(cell_6_ht);
			//Ŀ�� VT 
			PdfPCell cell_6_vt =new PdfPCell(new Paragraph("\u25a1���� UT",fontPT_S));
			cell_6_vt.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_6_vt);
			//�ϸ� Accept 
			PdfPCell cell_6_a =new PdfPCell(new Paragraph("�ϸ� Accept ",fontPT_S));
			cell_6_a.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell_6_a);
			
			
			document.add(table);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * ȷ����Ϣ���
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
			String info = "��֤���ò���֤�������������ȷ�ĺ�׼ȷ�ģ������в����Ѱ���׼�͹˿�Ҫ����������졢��������������飬�������Ҫ��\n"
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
	 * ����ǩ�ֱ��
	 * @param document
	 * @param fontPT
	 */
	public static void setSignTable(Document document,Font fontPT){
		try{
			PdfPTable table =new PdfPTable(8);
			table.setWidthPercentage(100);
			int widths[]={10,10,10,10,15,15,15,15};
			table.setWidths(widths);
			
			//����
			PdfPCell cell1=new PdfPCell(new Paragraph("����\nPrepared by:\n(QC Inspector)", fontPT));
			cell1.setMinimumHeight(50);
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell1);
			
			//����ǩ��
			PdfPCell cell2=new PdfPCell();
			table.addCell(cell2);
			
			//��׼
			PdfPCell cell3=new PdfPCell(new Paragraph("��׼(��������)\nApproved by:\n(QA/QC Manager)", fontPT));
			cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell3);
			
			//��׼ǩ��
			PdfPCell cell4=new PdfPCell();
			table.addCell(cell4);
			
			//����
			PdfPCell cell5=new PdfPCell(new Paragraph("����\nDate", fontPT));
			cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell5);
			
			//���� ǩ��
			PdfPCell cell6=new PdfPCell();
			table.addCell(cell6);
			
			//�˿�/������
			PdfPCell cell7=new PdfPCell(new Paragraph("�˿�/��������׼\nApproved by\nCustomer/3rd Party", fontPT));
			cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell7.setVerticalAlignment(Element.ALIGN_MIDDLE);
			table.addCell(cell7);
			
			//�˿�/������ ǩ��
			PdfPCell cell8=new PdfPCell();
			table.addCell(cell8);
			
			
			document.add(table);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/**
	 * ��̬��ȡ��Ԫ����
	 * @param elements   ��ѧԪ�ؼ���
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
