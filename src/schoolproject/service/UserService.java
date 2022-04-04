package schoolproject.service;

import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.exceptions.InvalidEntityDataException;

public interface UserService <V>{

    V register(V user) ;
    V changeOwnPassword(V user,String newPassword) throws InvalidEntityDataException, EntityNotFoundException;
    V logIn(String email,String username,String password) throws InvalidEntityDataException, EntityNotFoundException;
    void showUserPersonalInfo(V user);
    V getUserById(Long id) throws EntityNotFoundException;

}
