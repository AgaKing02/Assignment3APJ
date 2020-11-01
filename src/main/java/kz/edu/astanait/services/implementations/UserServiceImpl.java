package kz.edu.astanait.services.implementations;

import kz.edu.astanait.interfaces.UserRepository;
import kz.edu.astanait.models.User;
import kz.edu.astanait.models.UserLoginData;
import kz.edu.astanait.repository.UserRepositoryImpl;
import kz.edu.astanait.services.UserService;


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

