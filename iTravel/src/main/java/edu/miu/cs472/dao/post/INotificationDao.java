package edu.miu.cs472.dao.post;



import edu.miu.cs472.dao.IGenericJpaDao;
import edu.miu.cs472.domain.Notification;
import edu.miu.cs472.domain.User;

import java.util.List;

public interface INotificationDao extends IGenericJpaDao<Long, Notification> {
    public  abstract  List<Notification> getNotificationsByUser(User user);
    public abstract   void updateNotifications(List<Notification> notifications);
}
