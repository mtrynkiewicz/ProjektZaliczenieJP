package Trynio.service;

import Trynio.dao.ProffessionDao;
import Trynio.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserDao userDao;

    @Override
    public boolean canBeLoggedIn(String userName, String password) {
        return userDao.isLoggedIn(userName,password);
    }
}
