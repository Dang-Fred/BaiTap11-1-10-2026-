package vn.hcmute.services.impl;

import vn.hcmute.dao.IUserDao_24110304;
import vn.hcmute.dao.impl.UserDaoImpl_24110304;
import vn.hcmute.models.Users_24110304;
import vn.hcmute.services.IUserService_24110304;

public class UserServiceImpl_24110304 implements IUserService_24110304 {
    private IUserDao_24110304 userDao = new UserDaoImpl_24110304();

    @Override
    public void register(Users_24110304 user) {
        userDao.insert(user);
    }

    @Override
    public Users_24110304 login(String username, String password) {
        Users_24110304 user = userDao.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}