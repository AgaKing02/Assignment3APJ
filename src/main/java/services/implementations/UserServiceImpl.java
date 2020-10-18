package services.implementations;

import interfaces.UserRepository;
import models.User;
import models.UserLoginData;
import repository.UserRepositoryImpl;
import services.UserService;


public class UserServiceImpl implements UserService {
    private final UserRepository userRepo = new UserRepositoryImpl();

    public User getUserByID(long id) {
        return userRepo.getUserByID(id);
    }

    public User getUserByUsername(String username) {
        return userRepo.getUserByUsername(username);
    }

    public void addUser(User user) {
        userRepo.add(user);
    }

    @Override
    public void updateUser(User user) {
        userRepo.update(user);
    }

    @Override
    public User checkUserExistence(UserLoginData userLoginData) {
        return userRepo.findUserByLogin(userLoginData);
    }
}

