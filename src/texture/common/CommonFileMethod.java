package texture.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import texture.domain.Pagination;
import texture.domain.VO.FileFolder;
import texture.util.SettingPropertyBeanUtil;

/**
 * 通用获取文件处理方法
 * @author jiong.sun
 *
 */
public class CommonFileMethod {

	/**
	 * 获取所有材质炉号文件夹
	 * @return
	 */
	public static List<FileFolder> getAllTextureFolder(String path){
		List<FileFolder> folders =new  ArrayList<FileFolder>();
		FileFolder folder=null;
		try{
			File f =new File(path) ;
			//判断f是否是文件夹
			if(f.isDirectory()){
				//客户代码 ，获取该路径下所有客户代码文件夹
				File[] list = f.listFiles();
				//遍历，将客户代码下文件夹存放到
				for (int i = 0; i < list.length; i++) {
					if(list[i].isDirectory()){
						//获取所有材质炉号文件夹
						File[] czlh = list[i].listFiles();
						//遍历这些材质炉号文件夹，将这些内容存放到集合中
						for (int j = 0; j < czlh.length; j++) {
							folder = new FileFolder(czlh[j].getName(), path+"\\"+list[i].getName()+"\\"+czlh[j].getName(),list[i].getName());
							folders.add(folder);
						}
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return folders;
	}
	
	
	/**
	 * 筛选文件夹名称为输入的值
	 * @param folders       文件夹集合
	 * @param name		  筛选的名称
	 * @return
	 */
	public  static List<FileFolder> filterFoldersByName(String name){
		 List<FileFolder> rtnFolders =new  ArrayList<FileFolder>(); 
		 List<FileFolder> folders = getAllTextureFolder(SettingPropertyBeanUtil.getPropertyInfo("attachPath"));
		//遍历集合，判断文件夹名称是否包含输入的字符
		for (FileFolder folder : folders) {
			if(folder.getName().contains(name)){
				rtnFolders.add(folder);
			}
		}
		return rtnFolders;
	}
	
	/**
	 * 将集合转换成分页对象
	 * @param fileFolders             查询集合
	 * @param currentPageNo     当前页
	 * @param pageSize                每页多少条记录
	 * @return
	 */
	public static Pagination<FileFolder> convertListToPage(List<FileFolder> fileFolders,int currentPageNo,int pageSize){
		Pagination<FileFolder> page =new Pagination<FileFolder>(currentPageNo, pageSize, fileFolders.size());
		//查询fileFolders集合中(页码-1)*5 - 页码*5的记录
		
		List<FileFolder> pageFileFolders = getPageDatas(fileFolders, currentPageNo, pageSize);
		
		page.setDatas(pageFileFolders);
		return page;
	}
	
	
	/**
	 * 数据分页
	 * @param fileFolders          筛选后所有集合
	 * @param currentPageNo  页码
	 * @param pageSize            每页数量
	 * @return
	 */
	private static List<FileFolder> getPageDatas(List<FileFolder> fileFolders,int currentPageNo,int pageSize){
		
		List<FileFolder> pageFileFolders = new ArrayList<FileFolder>();
		if(fileFolders.size()>0){
			//总记录
			int total = fileFolders.size();
			//总页数
			int page =(int)Math.ceil((double)total/pageSize);
			
			
			//判断currentPageNo 是否是最后一页，若是，则取(currentPageNo-1)*pageSize 到最后一条记录
			if(currentPageNo ==page  ){
				 for (int j = pageSize*(currentPageNo-1); j <total; j++) {
					 pageFileFolders.add(fileFolders.get(j));
				}
			}else{
				//取(currentPageNo-1)*pageSize 到currentPageNo*pageSize条记录
				 for (int j = pageSize*(currentPageNo-1); j <currentPageNo*pageSize; j++) {
					 pageFileFolders.add(fileFolders.get(j));
				}
			}
		}
		return pageFileFolders;
	}
	
	
	/**
	 * 获取指定路径下所有PDF文件
	 * @param path
	 * @return
	 */
	public static List<FileFolder> getFilesInFolder(String path){
		List<FileFolder> folders =new  ArrayList<FileFolder>();
		FileFolder folder=null;
		File file =new File(path);
		if(file.isDirectory()){
			//获取路径下所有文件
			File[] list = file.listFiles();
			
			//遍历，判断是否是文件夹
			for (File file2 : list) {
				//若不是文件夹且后缀是.pdf,则添加到集合中
				if(!file2.isDirectory()&& file2.getName().contains(".pdf")){
					folder = new FileFolder( file2.getName(), file2.getPath().replace("\\", "\\\\"), "");
					folders.add(folder);
				}
			}
		}
		return folders;
	}
}
