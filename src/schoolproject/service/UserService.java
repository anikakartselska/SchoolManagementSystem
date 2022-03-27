package schoolproject.service;

import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.model.enums.Gender;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface UserService <V>{
    Collection<V> getAllUsersFromThisRole();
    V getUserById(Long id) throws EntityNotFoundException;
    V register(V user) ;
    V updateUser(V user) throws EntityNotFoundException, InvalidEntityDataException;
    V deleteAccount(V user) throws EntityNotFoundException;
    V changeOwnFirstName(V user,String newFirstName) throws EntityNotFoundException;
    V changeOwnSecondName(V user,String newSecondName);
    V changeOwnThirdName(V user,String newThirdName);
    V changeOwnPassword(V user,String newPassword);
    V changeOwnGender(V user, Gender newGender);
    V changeOwnPhoneNumber(V user,String newPhoneNumber);
    V changeAddress(V user,String newAddress);
    V logIn(String email,String username,String password);
    /*Collection<V> findAll();
    V findById(K id);
    V add(V entity);
    V update(V entity) throws EntityNotFoundException;
    V delete(V entity) throws EntityNotFoundException;*/
}
