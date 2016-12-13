package texture.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import texture.domain.Texture;

@Repository
public class TextureDao extends MongodbBaseDao<Texture> implements ITextureDao{

	//¼¯ºÏÃû³Æ
	private static String TEXTURE_COLLECTION ="texture";
	
	@Override
	protected Class<Texture> getEntityClass() {
		return Texture.class;
	}

	
	@Override
	public void saveTexture(Texture texture) {
		this.mongoTemplate.save(texture, TEXTURE_COLLECTION);
	}

	@Override
	public List<Texture> findAllTexture() {
		return this.findAll();
	}

	@Override
	public void removeTexture(Texture texture) {
		this.mongoTemplate.remove(texture,TEXTURE_COLLECTION);
	}


}
