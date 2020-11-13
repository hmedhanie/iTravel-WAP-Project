package edu.miu.cs472.dao.post;



import edu.miu.cs472.dao.IGenericJpaDao;
import edu.miu.cs472.domain.Post;
import edu.miu.cs472.domain.User;

import java.util.List;

public interface IPostDao extends IGenericJpaDao<Long, Post> {
    public abstract List<Post> getPostsUserHome(User userId);
    public abstract List<Post> getPostsUserHomePaged(User userId,Integer start,Integer interval);
    public abstract List<Post> getPostsByUser(User user);
}
