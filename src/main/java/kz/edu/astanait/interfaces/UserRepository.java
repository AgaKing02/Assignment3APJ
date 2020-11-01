package kz.edu.astanait.interfaces;

import kz.edu.astanait.models.User;
import kz.edu.astanait.models.UserLoginData;

import java.util.List;

public interface UserRepository extends EntityRepository<User> {
    User getUserByID(long id);

    User findUserByLogin(UserLoginData data);

    User getUserByUsername(String username);

    List<User> getAllUsers();
}
