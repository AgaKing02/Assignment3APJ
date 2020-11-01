package kz.edu.astanait.services;

import kz.edu.astanait.models.User;
import kz.edu.astanait.models.UserLoginData;

public interface UserService {
    User getUserByID(long id);

    User getUserByUsername(String username);

    void addUser(User user);

    void updateUser(User user);

    User checkUserExistence(UserLoginData userLoginData);
}
