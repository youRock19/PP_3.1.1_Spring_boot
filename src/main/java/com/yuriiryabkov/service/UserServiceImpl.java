package com.yuriiryabkov.service;


import com.yuriiryabkov.dao.UserDao;
import com.yuriiryabkov.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
//    @Transactional(readOnly = true)
    public List<User> read() {
        return userDao.read();
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(int id) {
       userDao.delete(id);
    }

    @Override
    public void update(User updateUser) {
        userDao.update(updateUser);
    }

    @Override
//    @Transactional(readOnly = true)
    public User getById(int id) {
        return userDao.getById(id);
    }

}
