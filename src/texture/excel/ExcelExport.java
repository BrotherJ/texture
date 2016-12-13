package texture.excel;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import texture.domain.TextureReportHistory;

/**
 * ����excel
 * @author jiong.sun
 *
 */
public class ExcelExport {

	
	/**
	 * �����˻��嵥
	 * @param response
	 * @param textureReportHistories
	 */
	public static void exportExcel(HttpServletResponse response,List<TextureReportHistory> textureReportHistories){
		OutputStream ouputStream=null;
		try{
			//����һ��������
			XSSFWorkbook workbook =new XSSFWorkbook();
			//����һ��sheet
			XSSFSheet sheet = workbook.createSheet();
			//����ÿ�п��
			sheet.setColumnWidth(0, 4000);
			sheet.setColumnWidth(1, 4000);
			sheet.setColumnWidth(2, 8000);
			sheet.setColumnWidth(3, 4000);
			sheet.setColumnWidth(4, 5000);
			sheet.setColumnWidth(5, 8000);
			sheet.setColumnWidth(6, 8000);
			
			//����������ʽ
			XSSFFont font =workbook.createFont();
			font.setFontName("Verdana");
			font.setBoldweight((short) 100);
			font.setFontHeight((short) 300);
			
			//��Ԫ����ʽ   
			XSSFCellStyle cellStyle = workbook.createCellStyle();  
			cellStyle.setFont(font);
			
			createExcel(sheet, textureReportHistories, cellStyle);
			
			String exportFileName = "backList.xlsx";
			//������excel��ʽ��,��������ʽ���صķ�ʽ   
//			response.addHeader("Content-Disposition", "attachment;filename=backList"); 
//			response.addHeader("Content-type", "application/vnd.ms-excel");  
			response.setHeader("Content-Disposition", "attachment;filename=" + new String((exportFileName).getBytes(), "ISO-8859-1"));
			response.setContentType("application/vnd.ms-excel;charset=UTF-8");
		    ouputStream = response.getOutputStream();     
		    workbook.write(ouputStream);     
		    ouputStream.flush();    
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
	
	
	/**
	 * ����excel�ļ��� ���ݲ���
	 * @param sheet
	 * @param textureReportHistories
	 * @param cellStyle
	 */
	private static void createExcel(XSSFSheet sheet,List<TextureReportHistory> textureReportHistories,XSSFCellStyle cellStyle){
		//��һ��
		XSSFRow row1 = sheet.createRow(0);
		//��Ԫ��
		XSSFCell cell1 = row1.createCell(0);
		XSSFCell cell2 = row1.createCell(1);
		XSSFCell cell3 = row1.createCell(2);
		XSSFCell cell4 = row1.createCell(3);
		XSSFCell cell5 = row1.createCell(4);
		XSSFCell cell6 = row1.createCell(5);
		XSSFCell cell7 = row1.createCell(6);
		
		//���õ�һ�� ��Ԫ���ͷ
		cell1.setCellValue("����");
		cell2.setCellValue("¯��");
		cell3.setCellValue("��Ӧ��");
		cell4.setCellValue("��������");
		cell5.setCellValue("�˻���");
		cell6.setCellValue("�˻�����");
		cell7.setCellValue("�˻�ԭ��");
		
		//���õ�Ԫ����ʽ
		cell1.setCellStyle(cellStyle);
		cell2.setCellStyle(cellStyle);
		cell3.setCellStyle(cellStyle);
		cell4.setCellStyle(cellStyle);
		cell5.setCellStyle(cellStyle);
		cell6.setCellStyle(cellStyle);
		cell7.setCellStyle(cellStyle);
		
		//�ڶ��п�ʼ����
		for (int i = 0; i <textureReportHistories.size(); i++) {
			XSSFRow row = sheet.createRow(i+1);
			for (int j = 0; j < 7; j++) {
				XSSFCell cell = row.createCell(j);
				cell.setCellStyle(cellStyle);
				if(j==0){
					//����
					cell.setCellValue(textureReportHistories.get(i).getTexture());
				}
				else if(j==1){
					//¯��
					cell.setCellValue(textureReportHistories.get(i).getFurnace_No());
				}
				else if(j==2){
					//��Ӧ��
					cell.setCellValue(textureReportHistories.get(i).getCreateUser());
				}
				else if(j==3){
					//��������
					cell.setCellValue(textureReportHistories.get(i).getCreateTime());
				}
				else if(j==4){
					//�˻���
					cell.setCellValue(textureReportHistories.get(i).getReturnUser());
				}
				else if(j==5){
					//�˻�����
					cell.setCellValue(textureReportHistories.get(i).getReturnTime());
				}
				else if(j==6){
					//�˻�ԭ��
					cell.setCellValue(textureReportHistories.get(i).getRemark());
				}
			}
		}
	}
}
