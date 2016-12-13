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
		//判断SAP同步过来的材质列表是否为空，若不为空，则更新
		if(news!=null){
			//删除原有记录
			for (Texture old : olds) {
				this.textureDao.removeTexture(old);
			}
			
			//新增记录
			for (Texture texture : news) {
				this.textureDao.saveTexture(texture);
			}
		}
	}

}
