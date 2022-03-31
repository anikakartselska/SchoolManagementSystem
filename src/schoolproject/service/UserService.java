package schoolproject.service;

import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.model.enums.Gender;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface UserService <V>{

    V register(V user) ;
    V changeOwnPassword(V user,String newPassword) throws InvalidEntityDataException, EntityNotFoundException;
    V logIn(String email,String username,String password) throws InvalidEntityDataException, EntityNotFoundException;
    void showUserPersonalInfo(V user);


    V getUserById(Long id) throws EntityNotFoundException;
}
