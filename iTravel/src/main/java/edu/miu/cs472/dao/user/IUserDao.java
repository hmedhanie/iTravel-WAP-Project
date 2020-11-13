package edu.miu.cs472.dao.user;



import edu.miu.cs472.dao.IGenericJpaDao;
import edu.miu.cs472.domain.User;

import java.util.List;

public interface IUserDao extends IGenericJpaDao<Long, User> {
    public abstract List<User> getUserFollowers(User user);
    public abstract List<User> getUserFollowing(User user);
    public abstract List<User> getUserNearBy(User user);
}
