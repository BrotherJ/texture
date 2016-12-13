package texture.dao;

import java.util.List;

import texture.domain.Texture;

/**
 * ���� Dao
 * @author infodba
 *
 */
public interface ITextureDao {

	/**
	 * ����
	 * @param group
	 */
	public void saveTexture(Texture texture);
	
	/**
	 * ��ȡ�����嵥
	 * @return
	 */
	public List<Texture> findAllTexture();
	
	/**
	 * ɾ��������Ϣ
	 * @param stand
	 */
	public void removeTexture(Texture texture);
	

}
