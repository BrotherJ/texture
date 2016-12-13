package texture.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.springframework.web.multipart.MultipartFile;


/**
 * �ļ�ͨ����
 * @author jiong.sun
 *
 */
public class FileManager {

	/**
	 * �����ļ�
	 * @param path 
	 * @throws IOException 
	 */
	public static void downloadFile(String path,HttpServletResponse response) throws IOException{
		
		File file = new File(path);
		 // ȡ���ļ�����
       String filename = file.getName();
       // ��������ʽ�����ļ���
       InputStream fis = new BufferedInputStream(new FileInputStream(path));
       byte[] buffer = new byte[fis.available()];
       fis.read(buffer);
       fis.close();
       // ���response
       response.reset();
       // ����response��Header
       response.addHeader("Content-Disposition", "attachment;filename=\"" + new String(filename.getBytes(),"ISO-8859-1")+"\"");
       response.addHeader("Content-Length", "" + file.length());
       OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
       response.setContentType("application/octet-stream");
       toClient.write(buffer);
       toClient.flush();
       toClient.close();
	}
	
	/**
	 * ���ϴ����ļ����ص�ָ��λ��
	 * @param file
	 * @param uploadpath  �ϴ��ļ�·��+ʱ���
	 * @throws IOException 
	 */
	public static void uploadfiles(MultipartFile file,String uploadpath) throws IOException{
			//�ж��ļ�·���Ƿ���ڣ��������ڣ����½�
			File dirPath = new File(uploadpath);
			 if (!dirPath.exists()) { 
				 dirPath.mkdirs(); 
			 }	
			//��ȡ�ϴ��ļ�����
			 String path = uploadpath+"/"+file.getOriginalFilename();
			System.out.println(path);
			
			 InputStream stream = file.getInputStream();
			 OutputStream bos = new FileOutputStream(path);  
			 int bytesRead = 0; 
			 byte[] buffer = new byte[8192];
			 while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) { 
				 bos.write(buffer, 0, bytesRead);   
			 }
			 bos.close();
			 stream.close(); 
		
	}
	
	/**
	 * ���ϴ����ļ����ص�ָ��λ��
	 * @param file
	 * @param uploadpath  �ϴ��ļ�·��+ʱ���
	 * @throws IOException 
	 */
	public static void uploadfilesByOwnName(MultipartFile file,String uploadpath,String fileName) throws IOException{
			//�ж��ļ�·���Ƿ���ڣ��������ڣ����½�
			File dirPath = new File(uploadpath);
			 if (!dirPath.exists()) { 
				 dirPath.mkdirs(); 
			 }	
			//��ȡ�ϴ��ļ�����
			 String path = uploadpath+"\\"+fileName;
			System.out.println(path);
			
			 InputStream stream = file.getInputStream();
			 OutputStream bos = new FileOutputStream(path);  
			 int bytesRead = 0; 
			 byte[] buffer = new byte[8192];
			 while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) { 
				 bos.write(buffer, 0, bytesRead);   
			 }
			 bos.close();
			 stream.close(); 
	}
	
	
	/**
	 * �����ļ�·��ɾ���ļ�
	 * @param path
	 */
	public static void deleteFile(String path){
		File file =new File(path);
		if(file.exists()){
			file.delete();
		}
	}
	
	/**
	 * ��ȡ��Ԫ��ֵ
	 * @param cell
	 * @return
	 */
	public static String getCellStringValue(XSSFCell cell) {    
        String cellValue = "";    
        switch (cell.getCellType()) {    
        case XSSFCell.CELL_TYPE_STRING:    
            cellValue = cell.getStringCellValue();    
            if(cellValue.trim().equals("")||cellValue.trim().length()<=0)    
                cellValue=" ";    
            break;    
        case XSSFCell.CELL_TYPE_NUMERIC:   
        	float floatValue = (float) cell.getNumericCellValue();
            cellValue = String.valueOf(floatValue);
            break;    
        case XSSFCell.CELL_TYPE_FORMULA:    
            cell.setCellType(XSSFCell.CELL_TYPE_NUMERIC);    
            cellValue = String.valueOf(cell.getNumericCellValue());    
            break;    
        case XSSFCell.CELL_TYPE_BLANK:    
            cellValue=" ";    
            break;    
        case XSSFCell.CELL_TYPE_BOOLEAN:    
            break;    
        case XSSFCell.CELL_TYPE_ERROR:    
            break;    
        default:    
            break;    
        }    
        return cellValue;    
    } 
	
}
