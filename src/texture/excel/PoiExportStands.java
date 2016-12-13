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
 * 导出规范与材质的对应清单
 * @author jiong.sun
 *
 */
public class PoiExportStands {
	
	/**
	 * 导出
	 * @param response
	 * @param textureReportHistories
	 */
	public static void exportExcel(HttpServletResponse response,List<Stand> stands){
		OutputStream ouputStream=null;
		try{
			//声明一个工作薄
			XSSFWorkbook workbook =new XSSFWorkbook();
			//生成一个sheet
			XSSFSheet sheet = workbook.createSheet();
			//设置每列宽度
			sheet.setColumnWidth(0, 12000);
			sheet.setColumnWidth(1, 6000);
			sheet.setColumnWidth(2, 22000);
			sheet.setColumnWidth(3, 6000);
			
			//设置字体样式
			XSSFFont font =workbook.createFont();
			font.setFontName("Verdana");
			font.setBoldweight((short) 100);
			font.setFontHeight((short) 300);
			
			//单元格样式   
			XSSFCellStyle cellStyle = workbook.createCellStyle();  
			cellStyle.setFont(font);
			
			createExcel(sheet, stands, cellStyle);
			
			String exportFileName = "standTemplate.xlsx";
			//导出成excel形式的,用流的形式下载的方式   
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
	private static void createExcel(XSSFSheet sheet,List<Stand> stands,XSSFCellStyle cellStyle){
		//第一行
		XSSFRow row1 = sheet.createRow(0);
		//单元格
		XSSFCell cell1 = row1.createCell(0);
		XSSFCell cell2 = row1.createCell(1);
		XSSFCell cell3 = row1.createCell(2);
		XSSFCell cell4 = row1.createCell(3);

		
		//设置第一行 单元格表头
		cell1.setCellValue("ID");
		cell2.setCellValue("材质");
		cell3.setCellValue("规范名称");
		cell4.setCellValue("删除('X'表示删除)");
		
		//设置单元格样式
		cell1.setCellStyle(cellStyle);
		cell2.setCellStyle(cellStyle);
		cell3.setCellStyle(cellStyle);
		cell4.setCellStyle(cellStyle);

		
		//第二行开始遍历
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
					//材质
					cell.setCellValue(stands.get(i).getTexture());
				}
				else if(j==2){
					//规范名称
					cell.setCellValue(stands.get(i).getName());
				}
				else if(j==3){
					if(StrUtil.nullToStr(stands.get(i).getDeleted()).equals(CommonConstant.IS_DELETED)){
						//删除标志
						cell.setCellValue("X");
					}
				}
			}
		}
	}
}
