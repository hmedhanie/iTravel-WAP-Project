package edu.miu.cs472.dao.post;

import edu.miu.cs472.dao.GenericJpaDao;
import edu.miu.cs472.domain.Photo;

public class PhotoDao extends GenericJpaDao<Long, Photo> implements IPhotoDao {

    public PhotoDao(){
        entityClass = Photo.class;
    }
}
