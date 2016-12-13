package texture.test;


import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import texture.util.FileManager;

/**
 * 读取材质与采购标准excel，由行格式转换成列格式
 * @author jiong.sun
 *
 */
public class readTextureStandExcel {

	/**
	 * 解析excel
	 * @param path
	 * @return
	 */
	public static List<TextureStandVO> analysisExcel(String path){
		List<TextureStandVO> textureStandVOs =new ArrayList<TextureStandVO>();
		try{
			//获取文件
			XSSFWorkbook wb =new XSSFWorkbook(path);
			XSSFSheet sheet= wb.getSheetAt(0);
			XSSFRow row=null;
			//由于第一行是标题行  不需要统计
			for (int i = sheet.getFirstRowNum()+1; i < sheet.getLastRowNum()+1; i++) {
				row = sheet.getRow(i);
				String texture ="";
				String stand_code="";
				String stand_Name="";
				TextureStandVO textureStandVO=null;
				//遍历所有列
				for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
					
					//第一列  材质信息
					if(j==0){
						texture =FileManager.getCellStringValue(row.getCell(j));
					}
					if(j==1){
						stand_code=row.getCell(j).getStringCellValue();
						textureStandVO = new TextureStandVO();
						textureStandVO.setTexture(texture);
						textureStandVO.setStand_code(stand_code);
					}
					if(j==2){
						stand_Name=row.getCell(j).getStringCellValue();
						textureStandVO.setStand_Name(stand_Name);
						textureStandVOs.add(textureStandVO);
					}
					if(j==3){
						//判断是否有第二个标准信息
						if(row.getCell(j)!=null){
//							stand_code = row.getCell(j).getStringCellValue();
							stand_code =FileManager.getCellStringValue(row.getCell(j));
							if(!stand_code.equals(" ")){
								textureStandVO = new TextureStandVO();
								textureStandVO.setTexture(texture);
								textureStandVO.setStand_code(stand_code);
								textureStandVO.setStand_Name(row.getCell(4).getStringCellValue());
								textureStandVOs.add(textureStandVO);
							}
						}
					}
					if(j==5){
						if(row.getCell(j)!=null){
							//判断是否有第3个标准信息
							stand_code =FileManager.getCellStringValue(row.getCell(j));
							if(!stand_code.equals(" ")){
								textureStandVO = new TextureStandVO();
								textureStandVO.setTexture(texture);
								textureStandVO.setStand_code(stand_code);
								textureStandVO.setStand_Name(row.getCell(6).getStringCellValue());
								textureStandVOs.add(textureStandVO);
							}
						}
					}
					if(j==7){
						if(row.getCell(j)!=null){
							//判断是否有第4个标准信息
							stand_code =FileManager.getCellStringValue(row.getCell(j));
							if(!stand_code.equals(" ")){
								textureStandVO = new TextureStandVO();
								textureStandVO.setTexture(texture);
								textureStandVO.setStand_code(stand_code);
								textureStandVO.setStand_Name(row.getCell(8).getStringCellValue());
								textureStandVOs.add(textureStandVO);
							}
						}
					}
					if(j==9){
						if(row.getCell(j)!=null){
							//判断是否有第5个标准信息
							stand_code =FileManager.getCellStringValue(row.getCell(j));
							if(!stand_code.equals(" ")){
								textureStandVO = new TextureStandVO();
								textureStandVO.setTexture(texture);
								textureStandVO.setStand_code(stand_code);
								textureStandVO.setStand_Name(row.getCell(10).getStringCellValue());
								textureStandVOs.add(textureStandVO);
							}
						}
					}
					if(j==11){
						if(row.getCell(j)!=null){
							//判断是否有第6个标准信息
							stand_code =FileManager.getCellStringValue(row.getCell(j));
							if(!stand_code.equals(" ")){
								textureStandVO = new TextureStandVO();
								textureStandVO.setTexture(texture);
								textureStandVO.setStand_code(stand_code);
								textureStandVO.setStand_Name(row.getCell(12).getStringCellValue());
								textureStandVOs.add(textureStandVO);
							}
						}
					}
					if(j==13){
						if(row.getCell(j)!=null){
							//判断是否有第7个标准信息
							stand_code =FileManager.getCellStringValue(row.getCell(j));
							if(!stand_code.equals(" ")){
								textureStandVO = new TextureStandVO();
								textureStandVO.setTexture(texture);
								textureStandVO.setStand_code(stand_code);
								textureStandVO.setStand_Name(row.getCell(14).getStringCellValue());
								textureStandVOs.add(textureStandVO);
							}
						}
					}
				}
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return textureStandVOs;
	}
	
	
	public static void main(String[] args) {
		List<TextureStandVO> textureStandVOs = analysisExcel("C:\\材质及采购规范列表_未整理.xlsx");
		System.out.println(textureStandVOs.size());
		exportExcel(textureStandVOs);
	}
	
	/**
	 * 输出excel报表
	 * @param materials
	 */
	public static void exportExcel(List<TextureStandVO> textureStandVOs){
		try{
			  FileOutputStream fos = new FileOutputStream("c:\\转换后格式.xls");
			  //声明一个工作薄
				HSSFWorkbook workbook =new HSSFWorkbook();
				
				//生成一个sheet
				HSSFSheet sheet = workbook.createSheet();
				HSSFRow row0 = sheet.createRow(0);
				HSSFCell cell01 = row0.createCell(0);
				HSSFCell cell02 = row0.createCell(1);
				HSSFCell cell03 = row0.createCell(2);
				
				cell01.setCellValue("材质");
				cell02.setCellValue("采购规范编号");
				cell03.setCellValue("采购规范名称");

				
				//遍历
				for (int i = 1; i <= textureStandVOs.size(); i++) {
					HSSFRow row = sheet.createRow(i);
					for (int j = 0; j < 3; j++) {
						HSSFCell cell = row.createCell(j);
						//材质
						if(j==0){
							cell.setCellValue(textureStandVOs.get(i-1).getTexture());
						}
						//采购规范编号
						if(j==1){
							cell.setCellValue(textureStandVOs.get(i-1).getStand_code());
						}
						//采购规范名称
						if(j==2){
							cell.setCellValue(textureStandVOs.get(i-1).getStand_Name());
						}
						
					}
				}
				workbook.write(fos);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
