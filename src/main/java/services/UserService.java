package services;

import models.User;
import models.UserLoginData;

public interface UserService {
    User getUserByID(long id);

    User getUserByUsername(String username);

    void addUser(User user);

    void updateUser(User user);

    User checkUserExistence(UserLoginData userLoginData);
}
