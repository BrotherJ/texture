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

import texture.cons.CommonConstant;
import texture.domain.Stand;
import texture.util.StrUtil;

/**
 * �����淶����ʵĶ�Ӧ�嵥
 * @author jiong.sun
 *
 */
public class PoiExportStands {
	
	/**
	 * ����
	 * @param response
	 * @param textureReportHistories
	 */
	public static void exportExcel(HttpServletResponse response,List<Stand> stands){
		OutputStream ouputStream=null;
		try{
			//����һ��������
			XSSFWorkbook workbook =new XSSFWorkbook();
			//����һ��sheet
			XSSFSheet sheet = workbook.createSheet();
			//����ÿ�п��
			sheet.setColumnWidth(0, 12000);
			sheet.setColumnWidth(1, 6000);
			sheet.setColumnWidth(2, 22000);
			sheet.setColumnWidth(3, 6000);
			
			//����������ʽ
			XSSFFont font =workbook.createFont();
			font.setFontName("Verdana");
			font.setBoldweight((short) 100);
			font.setFontHeight((short) 300);
			
			//��Ԫ����ʽ   
			XSSFCellStyle cellStyle = workbook.createCellStyle();  
			cellStyle.setFont(font);
			
			createExcel(sheet, stands, cellStyle);
			
			String exportFileName = "standTemplate.xlsx";
			//������excel��ʽ��,��������ʽ���صķ�ʽ   
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
	private static void createExcel(XSSFSheet sheet,List<Stand> stands,XSSFCellStyle cellStyle){
		//��һ��
		XSSFRow row1 = sheet.createRow(0);
		//��Ԫ��
		XSSFCell cell1 = row1.createCell(0);
		XSSFCell cell2 = row1.createCell(1);
		XSSFCell cell3 = row1.createCell(2);
		XSSFCell cell4 = row1.createCell(3);

		
		//���õ�һ�� ��Ԫ���ͷ
		cell1.setCellValue("ID");
		cell2.setCellValue("����");
		cell3.setCellValue("�淶����");
		cell4.setCellValue("ɾ��('X'��ʾɾ��)");
		
		//���õ�Ԫ����ʽ
		cell1.setCellStyle(cellStyle);
		cell2.setCellStyle(cellStyle);
		cell3.setCellStyle(cellStyle);
		cell4.setCellStyle(cellStyle);

		
		//�ڶ��п�ʼ����
		for (int i = 0; i <stands.size(); i++) {
			XSSFRow row = sheet.createRow(i+1);
			for (int j = 0; j < 4; j++) {
				XSSFCell cell = row.createCell(j);
				cell.setCellStyle(cellStyle);
				if(j==0){
					//ID
					cell.setCellValue(stands.get(i).getId());
				}
				else if(j==1){
					//����
					cell.setCellValue(stands.get(i).getTexture());
				}
				else if(j==2){
					//�淶����
					cell.setCellValue(stands.get(i).getName());
				}
				else if(j==3){
					if(StrUtil.nullToStr(stands.get(i).getDeleted()).equals(CommonConstant.IS_DELETED)){
						//ɾ����־
						cell.setCellValue("X");
					}
				}
			}
		}
	}
}
