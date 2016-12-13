package texture.service;

import java.util.List;
import java.util.Map;

import texture.domain.Pagination;
import texture.domain.Stand;
import texture.domain.Texture;

/**
 * ��׼��汾�� Service
 * @author infodba
 *
 */
public interface ITextureService {
	
	
	/**
	 * ��ȡ�����嵥
	 * @return
	 */
	public List<Texture> findAllTexture();
	
	/**
	 * �������� 
	 * �ɵ�ɾ�����µ�����
	 * @param olds     �ɵļ���
	 * @param news    �µļ���
	 * @return
	 */
	public void batchUpdate(List<Texture> olds,List<Texture> news);
}
