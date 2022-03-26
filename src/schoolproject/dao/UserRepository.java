package schoolproject.dao;

import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.enums.Gender;
import schoolproject.model.roles.User;

public interface UserRepository<V extends UserIdentifiable> {
    V changeFirstName(V user,String newFirstName) throws EntityNotFoundException;
    V changeSecondName(V user,String newSecondName) throws EntityNotFoundException;
    V changeThirdName(V user,String newThirdName) throws EntityNotFoundException;
    V changePassword(V user,String newPassword) throws EntityNotFoundException;
    V changeGender(V user, Gender newGender) throws EntityNotFoundException;
    V changePhoneNumber(V user,String newPhoneNumber) throws EntityNotFoundException;
    V changeAddress(V user,String newAddress) throws EntityNotFoundException;
    V findByEmail(String email);
    V findByUsername(String userName);
    V findByPhoneNumber(String phoneNumber);
}
