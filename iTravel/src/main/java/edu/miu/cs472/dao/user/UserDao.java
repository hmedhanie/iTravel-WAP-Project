package edu.miu.cs472.dao.user;


import edu.miu.cs472.dao.GenericJpaDao;
import edu.miu.cs472.domain.User;

import javax.persistence.Query;
import java.util.List;

public class UserDao extends GenericJpaDao<Long, User> implements IUserDao {

    public UserDao(){
        entityClass = User.class;
    }

    @Override
    public List<User> getUserFollowers(User user) {
        String uid = ""+user.getId();
        String sql = "SELECT USERS.* from USERS,FOLLOW where USERS.ID = FOLLOW.followed_ID and FOLLOW.follower_ID = " + uid + " order by FOLLOW.followTime desc";
        Query q = manager.createNativeQuery(sql, User.class);
        List<User> users = q.getResultList();
        return users;
    }

    @Override
    public List<User> getUserFollowing(User user) {
        String uid = ""+user.getId();
        String sql = "SELECT USERS.* from USERS,FOLLOW where USERS.ID = FOLLOW.follower_ID and FOLLOW.followed_ID = " + uid + " order by FOLLOW.followTime desc";
        Query q = manager.createNativeQuery(sql, User.class);
        List<User> users = q.getResultList();
        return users;
    }

    @Override
    public List<User> getUserNearBy(User user) {
        String uid = ""+user.getId();
        String sql = "select * from USERS where USERS.ID != " + uid + " order by rand()";
        Query q = manager.createNativeQuery(sql, User.class);
        List<User> users = q.getResultList();
        return users;
    }
}
