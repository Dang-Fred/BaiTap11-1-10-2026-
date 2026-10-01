package vn.hcmute.services;
import vn.hcmute.models.Users_24110304;

public interface IUserService_24110304 {
    void register(Users_24110304 user);
    Users_24110304 login(String username, String password);
}