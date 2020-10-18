package interfaces;

import models.User;
import models.UserLoginData;

public interface UserRepository extends EntityRepository<User> {
    User getUserByID(long id);

    User findUserByLogin(UserLoginData data);

    User getUserByUsername(String username);
}
