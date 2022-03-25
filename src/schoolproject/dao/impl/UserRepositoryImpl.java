package schoolproject.dao.impl;

import schoolproject.dao.UserRepository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.enums.Gender;
import schoolproject.model.roles.User;

public class UserRepositoryImpl extends RepositoryImpl<Long,String, User> implements UserRepository {

    @Override
    public User changeFirstName(User user, String newFirstName) throws EntityNotFoundException {
       User updatedUser=user;
       updatedUser.setFirstName(newFirstName);
      return update(updatedUser);
    }

    @Override
    public User changeSecondName(User user, String newSecondName) throws EntityNotFoundException {
        User updatedUser=user;
        updatedUser.setSecondName(newSecondName);
        return update(updatedUser);
    }

    @Override
    public User changeThirdName(User user, String newThirdName) throws EntityNotFoundException {
        User updatedUser=user;
        updatedUser.setThirdName(newThirdName);
        return update(updatedUser);
    }

    @Override
    public User changePassword(User user, String newPassword) throws EntityNotFoundException {

        User updatedUser=user;
        updatedUser.setPassword(newPassword);
        return update(updatedUser);
    }

    @Override
    public User changeGender(User user, Gender newGender) throws EntityNotFoundException {
        User updatedUser=user;
        updatedUser.setGender(newGender);
        return update(updatedUser);
    }

    @Override
    public User changePhoneNumber(User user, String newPhoneNumber) throws EntityNotFoundException {
        User updatedUser=user;
        updatedUser.setPhoneNumber(newPhoneNumber);
        return update(updatedUser);
    }

    @Override
    public User changeAddress(User user, String newAddress) throws EntityNotFoundException {
        User updatedUser=user;
        updatedUser.setAddress(newAddress);
        return update(updatedUser);
    }

    @Override
    public User findByEmail(String email) {

        for(User user: findAll())
            if(user.getEmail().equals(email))
                return user;
            return null;
    }

    @Override
    public User findByUsername(String userName) {
        for(User user: findAll())
            if(user.getUsername().equals(userName))
                return user;
        return null;
    }

    @Override
    public User findByPhoneNumber(String phoneNumber) {
        for(User user: findAll())
            if(user.getPhoneNumber().equals(phoneNumber))
                return user;

        return null;
    }
}
