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
 * ��ȡ������ɹ���׼excel�����и�ʽת�����и�ʽ
 * @author jiong.sun
 *
 */
public class readTextureStandExcel {

	/**
	 * ����excel
	 * @param path
	 * @return
	 */
	public static List<TextureStandVO> analysisExcel(String path){
		List<TextureStandVO> textureStandVOs =new ArrayList<TextureStandVO>();
		try{
			//��ȡ�ļ�
			XSSFWorkbook wb =new XSSFWorkbook(path);
			XSSFSheet sheet= wb.getSheetAt(0);
			XSSFRow row=null;
			//���ڵ�һ���Ǳ�����  ����Ҫͳ��
			for (int i = sheet.getFirstRowNum()+1; i < sheet.getLastRowNum()+1; i++) {
				row = sheet.getRow(i);
				String texture ="";
				String stand_code="";
				String stand_Name="";
				TextureStandVO textureStandVO=null;
				//����������
				for (int j = row.getFirstCellNum(); j < row.getLastCellNum(); j++) {
					
					//��һ��  ������Ϣ
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
						//�ж��Ƿ��еڶ�����׼��Ϣ
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
							//�ж��Ƿ��е�3����׼��Ϣ
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
							//�ж��Ƿ��е�4����׼��Ϣ
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
							//�ж��Ƿ��е�5����׼��Ϣ
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
							//�ж��Ƿ��е�6����׼��Ϣ
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
							//�ж��Ƿ��е�7����׼��Ϣ
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
		List<TextureStandVO> textureStandVOs = analysisExcel("C:\\���ʼ��ɹ��淶�б�_δ����.xlsx");
		System.out.println(textureStandVOs.size());
		exportExcel(textureStandVOs);
	}
	
	/**
	 * ���excel����
	 * @param materials
	 */
	public static void exportExcel(List<TextureStandVO> textureStandVOs){
		try{
			  FileOutputStream fos = new FileOutputStream("c:\\ת�����ʽ.xls");
			  //����һ��������
				HSSFWorkbook workbook =new HSSFWorkbook();
				
				//����һ��sheet
				HSSFSheet sheet = workbook.createSheet();
				HSSFRow row0 = sheet.createRow(0);
				HSSFCell cell01 = row0.createCell(0);
				HSSFCell cell02 = row0.createCell(1);
				HSSFCell cell03 = row0.createCell(2);
				
				cell01.setCellValue("����");
				cell02.setCellValue("�ɹ��淶���");
				cell03.setCellValue("�ɹ��淶����");

				
				//����
				for (int i = 1; i <= textureStandVOs.size(); i++) {
					HSSFRow row = sheet.createRow(i);
					for (int j = 0; j < 3; j++) {
						HSSFCell cell = row.createCell(j);
						//����
						if(j==0){
							cell.setCellValue(textureStandVOs.get(i-1).getTexture());
						}
						//�ɹ��淶���
						if(j==1){
							cell.setCellValue(textureStandVOs.get(i-1).getStand_code());
						}
						//�ɹ��淶����
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
