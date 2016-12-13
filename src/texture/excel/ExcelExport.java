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
 * 导出excel
 * @author jiong.sun
 *
 */
public class ExcelExport {

	
	/**
	 * 导出退回清单
	 * @param response
	 * @param textureReportHistories
	 */
	public static void exportExcel(HttpServletResponse response,List<TextureReportHistory> textureReportHistories){
		OutputStream ouputStream=null;
		try{
			//声明一个工作薄
			XSSFWorkbook workbook =new XSSFWorkbook();
			//生成一个sheet
			XSSFSheet sheet = workbook.createSheet();
			//设置每列宽度
			sheet.setColumnWidth(0, 4000);
			sheet.setColumnWidth(1, 4000);
			sheet.setColumnWidth(2, 8000);
			sheet.setColumnWidth(3, 4000);
			sheet.setColumnWidth(4, 5000);
			sheet.setColumnWidth(5, 8000);
			sheet.setColumnWidth(6, 8000);
			
			//设置字体样式
			XSSFFont font =workbook.createFont();
			font.setFontName("Verdana");
			font.setBoldweight((short) 100);
			font.setFontHeight((short) 300);
			
			//单元格样式   
			XSSFCellStyle cellStyle = workbook.createCellStyle();  
			cellStyle.setFont(font);
			
			createExcel(sheet, textureReportHistories, cellStyle);
			
			String exportFileName = "backList.xlsx";
			//导出成excel形式的,用流的形式下载的方式   
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
	 * 创建excel文件的 内容部分
	 * @param sheet
	 * @param textureReportHistories
	 * @param cellStyle
	 */
	private static void createExcel(XSSFSheet sheet,List<TextureReportHistory> textureReportHistories,XSSFCellStyle cellStyle){
		//第一行
		XSSFRow row1 = sheet.createRow(0);
		//单元格
		XSSFCell cell1 = row1.createCell(0);
		XSSFCell cell2 = row1.createCell(1);
		XSSFCell cell3 = row1.createCell(2);
		XSSFCell cell4 = row1.createCell(3);
		XSSFCell cell5 = row1.createCell(4);
		XSSFCell cell6 = row1.createCell(5);
		XSSFCell cell7 = row1.createCell(6);
		
		//设置第一行 单元格表头
		cell1.setCellValue("材质");
		cell2.setCellValue("炉号");
		cell3.setCellValue("供应商");
		cell4.setCellValue("创建日期");
		cell5.setCellValue("退回人");
		cell6.setCellValue("退回日期");
		cell7.setCellValue("退回原因");
		
		//设置单元格样式
		cell1.setCellStyle(cellStyle);
		cell2.setCellStyle(cellStyle);
		cell3.setCellStyle(cellStyle);
		cell4.setCellStyle(cellStyle);
		cell5.setCellStyle(cellStyle);
		cell6.setCellStyle(cellStyle);
		cell7.setCellStyle(cellStyle);
		
		//第二行开始遍历
		for (int i = 0; i <textureReportHistories.size(); i++) {
			XSSFRow row = sheet.createRow(i+1);
			for (int j = 0; j < 7; j++) {
				XSSFCell cell = row.createCell(j);
				cell.setCellStyle(cellStyle);
				if(j==0){
					//材质
					cell.setCellValue(textureReportHistories.get(i).getTexture());
				}
				else if(j==1){
					//炉号
					cell.setCellValue(textureReportHistories.get(i).getFurnace_No());
				}
				else if(j==2){
					//供应商
					cell.setCellValue(textureReportHistories.get(i).getCreateUser());
				}
				else if(j==3){
					//创建日期
					cell.setCellValue(textureReportHistories.get(i).getCreateTime());
				}
				else if(j==4){
					//退回人
					cell.setCellValue(textureReportHistories.get(i).getReturnUser());
				}
				else if(j==5){
					//退回日期
					cell.setCellValue(textureReportHistories.get(i).getReturnTime());
				}
				else if(j==6){
					//退回原因
					cell.setCellValue(textureReportHistories.get(i).getRemark());
				}
			}
		}
	}
}
