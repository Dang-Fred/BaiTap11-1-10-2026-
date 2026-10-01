package vn.hcmute.dao;
import vn.hcmute.models.Users_24110304;

public interface IUserDao_24110304 {
    void insert(Users_24110304 user);
    Users_24110304 findByUsername(String username);
}