package texture.common;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import texture.domain.Pagination;
import texture.domain.VO.FileFolder;
import texture.util.SettingPropertyBeanUtil;

/**
 * ͨ�û�ȡ�ļ�������
 * @author jiong.sun
 *
 */
public class CommonFileMethod {

	/**
	 * ��ȡ���в���¯���ļ���
	 * @return
	 */
	public static List<FileFolder> getAllTextureFolder(String path){
		List<FileFolder> folders =new  ArrayList<FileFolder>();
		FileFolder folder=null;
		try{
			File f =new File(path) ;
			//�ж�f�Ƿ����ļ���
			if(f.isDirectory()){
				//�ͻ����� ����ȡ��·�������пͻ������ļ���
				File[] list = f.listFiles();
				//���������ͻ��������ļ��д�ŵ�
				for (int i = 0; i < list.length; i++) {
					if(list[i].isDirectory()){
						//��ȡ���в���¯���ļ���
						File[] czlh = list[i].listFiles();
						//������Щ����¯���ļ��У�����Щ���ݴ�ŵ�������
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
	 * ɸѡ�ļ�������Ϊ�����ֵ
	 * @param folders       �ļ��м���
	 * @param name		  ɸѡ������
	 * @return
	 */
	public  static List<FileFolder> filterFoldersByName(String name){
		 List<FileFolder> rtnFolders =new  ArrayList<FileFolder>(); 
		 List<FileFolder> folders = getAllTextureFolder(SettingPropertyBeanUtil.getPropertyInfo("attachPath"));
		//�������ϣ��ж��ļ��������Ƿ����������ַ�
		for (FileFolder folder : folders) {
			if(folder.getName().contains(name)){
				rtnFolders.add(folder);
			}
		}
		return rtnFolders;
	}
	
	/**
	 * ������ת���ɷ�ҳ����
	 * @param fileFolders             ��ѯ����
	 * @param currentPageNo     ��ǰҳ
	 * @param pageSize                ÿҳ��������¼
	 * @return
	 */
	public static Pagination<FileFolder> convertListToPage(List<FileFolder> fileFolders,int currentPageNo,int pageSize){
		Pagination<FileFolder> page =new Pagination<FileFolder>(currentPageNo, pageSize, fileFolders.size());
		//��ѯfileFolders������(ҳ��-1)*5 - ҳ��*5�ļ�¼
		
		List<FileFolder> pageFileFolders = getPageDatas(fileFolders, currentPageNo, pageSize);
		
		page.setDatas(pageFileFolders);
		return page;
	}
	
	
	/**
	 * ���ݷ�ҳ
	 * @param fileFolders          ɸѡ�����м���
	 * @param currentPageNo  ҳ��
	 * @param pageSize            ÿҳ����
	 * @return
	 */
	private static List<FileFolder> getPageDatas(List<FileFolder> fileFolders,int currentPageNo,int pageSize){
		
		List<FileFolder> pageFileFolders = new ArrayList<FileFolder>();
		if(fileFolders.size()>0){
			//�ܼ�¼
			int total = fileFolders.size();
			//��ҳ��
			int page =(int)Math.ceil((double)total/pageSize);
			
			
			//�ж�currentPageNo �Ƿ������һҳ�����ǣ���ȡ(currentPageNo-1)*pageSize �����һ����¼
			if(currentPageNo ==page  ){
				 for (int j = pageSize*(currentPageNo-1); j <total; j++) {
					 pageFileFolders.add(fileFolders.get(j));
				}
			}else{
				//ȡ(currentPageNo-1)*pageSize ��currentPageNo*pageSize����¼
				 for (int j = pageSize*(currentPageNo-1); j <currentPageNo*pageSize; j++) {
					 pageFileFolders.add(fileFolders.get(j));
				}
			}
		}
		return pageFileFolders;
	}
	
	
	/**
	 * ��ȡָ��·��������PDF�ļ�
	 * @param path
	 * @return
	 */
	public static List<FileFolder> getFilesInFolder(String path){
		List<FileFolder> folders =new  ArrayList<FileFolder>();
		FileFolder folder=null;
		File file =new File(path);
		if(file.isDirectory()){
			//��ȡ·���������ļ�
			File[] list = file.listFiles();
			
			//�������ж��Ƿ����ļ���
			for (File file2 : list) {
				//�������ļ����Һ�׺��.pdf,����ӵ�������
				if(!file2.isDirectory()&& file2.getName().contains(".pdf")){
					folder = new FileFolder( file2.getName(), file2.getPath().replace("\\", "\\\\"), "");
					folders.add(folder);
				}
			}
		}
		return folders;
	}
}
