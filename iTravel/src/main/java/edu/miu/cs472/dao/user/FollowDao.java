package edu.miu.cs472.dao.user;


import edu.miu.cs472.dao.GenericJpaDao;
import edu.miu.cs472.domain.Follow;

public class FollowDao extends GenericJpaDao<Long, Follow> implements IFollowDao {

    public FollowDao(){
        entityClass = Follow.class;
    }
}
