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
 * 文件通用类
 * @author jiong.sun
 *
 */
public class FileManager {

	/**
	 * 下载文件
	 * @param path 
	 * @throws IOException 
	 */
	public static void downloadFile(String path,HttpServletResponse response) throws IOException{
		
		File file = new File(path);
		 // 取得文件名。
       String filename = file.getName();
       // 以流的形式下载文件。
       InputStream fis = new BufferedInputStream(new FileInputStream(path));
       byte[] buffer = new byte[fis.available()];
       fis.read(buffer);
       fis.close();
       // 清空response
       response.reset();
       // 设置response的Header
       response.addHeader("Content-Disposition", "attachment;filename=\"" + new String(filename.getBytes(),"ISO-8859-1")+"\"");
       response.addHeader("Content-Length", "" + file.length());
       OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
       response.setContentType("application/octet-stream");
       toClient.write(buffer);
       toClient.flush();
       toClient.close();
	}
	
	/**
	 * 将上传的文件下载到指定位置
	 * @param file
	 * @param uploadpath  上传文件路径+时间戳
	 * @throws IOException 
	 */
	public static void uploadfiles(MultipartFile file,String uploadpath) throws IOException{
			//判断文件路径是否存在，若不存在，则新建
			File dirPath = new File(uploadpath);
			 if (!dirPath.exists()) { 
				 dirPath.mkdirs(); 
			 }	
			//获取上传文件名称
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
	 * 将上传的文件下载到指定位置
	 * @param file
	 * @param uploadpath  上传文件路径+时间戳
	 * @throws IOException 
	 */
	public static void uploadfilesByOwnName(MultipartFile file,String uploadpath,String fileName) throws IOException{
			//判断文件路径是否存在，若不存在，则新建
			File dirPath = new File(uploadpath);
			 if (!dirPath.exists()) { 
				 dirPath.mkdirs(); 
			 }	
			//获取上传文件名称
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
	 * 根据文件路径删除文件
	 * @param path
	 */
	public static void deleteFile(String path){
		File file =new File(path);
		if(file.exists()){
			file.delete();
		}
	}
	
	/**
	 * 获取单元格值
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
