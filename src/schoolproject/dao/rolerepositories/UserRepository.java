package schoolproject.dao.rolerepositories;

import schoolproject.dao.PersistableRepository;
import schoolproject.dao.Repository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.identifiiables.UserIdentifiable;
import schoolproject.model.enums.Gender;
import schoolproject.model.enums.Status;

public interface UserRepository<V extends UserIdentifiable & Identifiable<Long, String>> extends PersistableRepository<Long,String,V> {
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
    V changeStatus(V user, Status status) throws EntityNotFoundException;
}
