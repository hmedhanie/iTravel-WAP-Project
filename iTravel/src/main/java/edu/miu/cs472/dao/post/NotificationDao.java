package edu.miu.cs472.dao.post;



import edu.miu.cs472.dao.GenericJpaDao;
import edu.miu.cs472.domain.Notification;
import edu.miu.cs472.domain.User;

import javax.persistence.Query;
import java.util.List;

public class NotificationDao extends GenericJpaDao<Long, Notification> implements INotificationDao {

    public NotificationDao() {
        entityClass = Notification.class;
    }

    @Override
    public List<Notification> getNotificationsByUser(User user) {
        String uid = ""+ user.getId();
        String sql = "SELECT  NOTIFICATIONS.* from NOTIFICATIONS where NOTIFICATIONS.USER_ID = " + uid+ " and seen = 0 ORDER BY NOTIFICATIONS.notTime desc";
        Query q = manager.createNativeQuery(sql,Notification.class);
        List<Notification> notifications = q.getResultList();
        return notifications;
    }

    @Override
    public void updateNotifications(List<Notification> notifications) {
        for (Notification notification: notifications){
            notification.setSeen(true);
            update(notification);
        }
    }
}