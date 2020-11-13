package edu.miu.cs472.dao.post;


import edu.miu.cs472.dao.GenericJpaDao;

import edu.miu.cs472.domain.Comment;
import edu.miu.cs472.domain.Post;

import javax.persistence.Query;
import java.util.List;

public class CommentDao extends GenericJpaDao<Long, Comment> implements ICommentDao {

    public CommentDao() {
        entityClass = Comment.class;
    }

    @Override
    public List<Comment> findCommentsByPost(Post post) {
        String uid = ""+ post.getId();
        String sql = "SELECT distinct COMMENTS.* from COMMENTS where  COMMENTS.POST_ID = " + uid+ " ORDER BY COMMENTS.TIME desc";
        Query q = manager.createNativeQuery(sql,Comment.class);
        List<Comment> comments = q.getResultList();
        return comments;
    }
}
