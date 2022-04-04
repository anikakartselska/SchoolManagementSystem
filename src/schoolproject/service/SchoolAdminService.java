package schoolproject.service;

import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;
import schoolproject.model.enums.Gender;
import schoolproject.model.roles.Parent;
import schoolproject.model.roles.SchoolAdmin;
import schoolproject.model.roles.Student;
import schoolproject.model.roles.User;

import java.util.Collection;
import java.util.HashMap;

public interface SchoolAdminService<V> extends UserService<SchoolAdmin>{

    V approveRegisterRequest(V user) throws EntityNotFoundException;
    V changeGender(V user, Gender newGender) throws EntityNotFoundException;
    V changePhoneNumber(V user,String newPhoneNumber) throws InvalidEntityDataException, EntityNotFoundException;
    V changeAddress(V user,String newAddress) throws EntityNotFoundException;
     V updateUser(V user) throws EntityNotFoundException, InvalidEntityDataException;
     V deleteAccount(V user) throws EntityNotFoundException;
     V changeFirstName(V user,String newFirstName) throws EntityNotFoundException, InvalidEntityDataException;
     V changeSecondName(V user,String newSecondName) throws InvalidEntityDataException, EntityNotFoundException;
     V changeThirdName(V user,String newThirdName) throws InvalidEntityDataException, EntityNotFoundException;
     Collection<V> getAllUsersFromThisRole();
     SchoolClass addNewClass(SchoolClass schoolClass) throws EntityNotFoundException;
     Subject addNewSubject(Subject subject) throws EntityNotFoundException;
    SchoolClass updateClass(SchoolClass schoolClass) throws EntityNotFoundException;
    Subject updateSubject(Subject subject) throws EntityNotFoundException;
    SchoolClass deleteClass(SchoolClass schoolClass) throws EntityNotFoundException;
    Subject deleteSubject(Subject subject) throws EntityNotFoundException;
    Student addParent(Student student,Parent parent);
    Student removeParent(Student student,Parent parent);


}
