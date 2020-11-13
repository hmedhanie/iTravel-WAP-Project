package edu.miu.cs472.service;

import edu.miu.cs472.dao.user.IUserDao;
import edu.miu.cs472.dao.user.UserDao;
import edu.miu.cs472.domain.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private IUserDao userDao = new UserDao();
    public List<User> getUserNearBy(User user){
        List<User> allUsers = userDao.getUserNearBy(user);
        System.out.println(Arrays.toString(allUsers.toArray()));
        List<User> followers = userDao.getUserFollowers(user);
        System.out.println(Arrays.toString(followers.toArray()));
        List<Long> userIds = followers.stream().map(s->s.getId()).collect(Collectors.toList());
        List<User> finalUsers = allUsers.stream().filter(s->userIds.contains(s.getId())==false).collect(Collectors.toList());
        System.out.println(Arrays.toString(finalUsers.toArray()));


        return finalUsers;
    }
}
