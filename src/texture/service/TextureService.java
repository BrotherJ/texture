package texture.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import texture.dao.ITextureDao;
import texture.domain.Texture;

@Service
public class TextureService implements ITextureService{

	@Autowired
	private ITextureDao textureDao;
	
	@Override
	public List<Texture> findAllTexture() {
		return this.textureDao.findAllTexture();
	}

	@Override
	public void batchUpdate(List<Texture> olds, List<Texture> news) {
		//�ж�SAPͬ�������Ĳ����б��Ƿ�Ϊ�գ�����Ϊ�գ������
		if(news!=null){
			//ɾ��ԭ�м�¼
			for (Texture old : olds) {
				this.textureDao.removeTexture(old);
			}
			
			//������¼
			for (Texture texture : news) {
				this.textureDao.saveTexture(texture);
			}
		}
	}

}
