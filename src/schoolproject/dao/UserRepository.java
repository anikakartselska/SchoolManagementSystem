package schoolproject.dao;

import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.enums.Gender;
import schoolproject.model.roles.User;

public interface UserRepository extends Repository <Long,String, User>{
    User changeFirstName(User user,String newFirstName) throws EntityNotFoundException;
    User changeSecondName(User user,String newSecondName) throws EntityNotFoundException;
    User changeThirdName(User user,String newThirdName) throws EntityNotFoundException;
    User changePassword(User user,String newPassword) throws EntityNotFoundException;
    User changeGender(User user, Gender newGender) throws EntityNotFoundException;
    User changePhoneNumber(User user,String newPhoneNumber) throws EntityNotFoundException;
    User changeAddress(User user,String newAddress) throws EntityNotFoundException;
    User findByEmail(String email);
    User findByUsername(String userName);
    User findByPhoneNumber(String phoneNumber);
}
