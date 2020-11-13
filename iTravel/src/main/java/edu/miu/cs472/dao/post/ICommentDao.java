package edu.miu.cs472.dao.post;



import edu.miu.cs472.dao.IGenericJpaDao;
import edu.miu.cs472.domain.Comment;
import edu.miu.cs472.domain.Post;

import java.util.List;

public interface ICommentDao extends IGenericJpaDao<Long , Comment> {
    List<Comment> findCommentsByPost(Post post);
}
