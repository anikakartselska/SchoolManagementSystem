package schoolproject.service;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.identifiiables.UserIdentifiable;
import schoolproject.dao.rolerepositories.UserRepository;
import schoolproject.model.enums.Gender;
import schoolproject.model.roles.SchoolAdmin;
import schoolproject.util.ValidUser;
import java.util.Collection;


public interface SchoolAdminService<V extends UserIdentifiable & Identifiable<Long, String>> extends UserService<SchoolAdmin>{

//USER MANAGE
    V changeGender(V user, UserRepository<V> userRepo, Gender newGender) throws EntityNotFoundException;
    V changePhoneNumber(V user, UserRepository<V> userRepo,String newPhoneNumber) throws InvalidEntityDataException, EntityNotFoundException;
    V changeAddress(V user, UserRepository<V> userRepo,String newAddress) throws EntityNotFoundException;
     V updateUser(V user, UserRepository<V> userRepo, ValidUser<V>validation) throws EntityNotFoundException, InvalidEntityDataException;
     V deleteAccount(V user, UserRepository<V> userRepo) throws EntityNotFoundException;
     V changeFirstName(V user, UserRepository<V> userRepo,String newFirstName) throws EntityNotFoundException, InvalidEntityDataException;
     V changeSecondName(V user, UserRepository<V> userRepo,String newSecondName) throws InvalidEntityDataException, EntityNotFoundException;
     V changeThirdName(V user, UserRepository<V> userRepo,String newThirdName) throws InvalidEntityDataException, EntityNotFoundException;
     V approveRegisterRequest(V user, UserRepository<V> userRepo) throws EntityNotFoundException;
     Collection<V> getAllUsersFromThisRole( UserRepository<V> userRepo);



}
