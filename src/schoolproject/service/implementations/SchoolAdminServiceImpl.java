package schoolproject.service.implementations;
import schoolproject.dao.SchoolClassRepo;
import schoolproject.dao.SubjectRepository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.identifiiables.UserIdentifiable;
import schoolproject.dao.rolerepositories.SchoolAdminRepository;
import schoolproject.dao.rolerepositories.StudentRepository;
import schoolproject.dao.rolerepositories.TeacherRepository;
import schoolproject.dao.rolerepositories.UserRepository;
import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;
import schoolproject.model.enums.Gender;
import schoolproject.model.enums.Status;
import schoolproject.model.roles.Parent;
import schoolproject.model.roles.SchoolAdmin;
import schoolproject.model.roles.Student;
import schoolproject.service.SchoolAdminService;
import schoolproject.util.ValidUser;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SchoolAdminServiceImpl<V extends UserIdentifiable & Identifiable<Long, String>> extends UserServiceImpl<SchoolAdmin> implements SchoolAdminService<V> {

    private UserRepository<V> userRepository;
    private ValidUser<V> validUser;
    private SchoolClassRepo schoolClassRepo;
    private SubjectRepository subjectRepository;
    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;

    public SchoolAdminServiceImpl(UserRepository<SchoolAdmin> userRepository, ValidUser<SchoolAdmin> userValidator, UserRepository<V> userRepository1, ValidUser<V> validUser, SchoolClassRepo schoolClassRepo, SubjectRepository subjectRepository, TeacherRepository teacherRepository, StudentRepository studentRepository) {
        super(userRepository, userValidator);
        this.userRepository = userRepository1;
        this.validUser = validUser;
        this.schoolClassRepo = schoolClassRepo;
        this.subjectRepository = subjectRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public V approveRegisterRequest(V user) throws EntityNotFoundException {
       return userRepository.changeStatus(user,Status.ACTIVE);
    }
    @Override
    public Collection<V> getAllUsersFromThisRole() {
        return userRepository.findAll();
    }

    @Override
    public SchoolClass addNewClass(SchoolClass schoolClass) throws EntityNotFoundException {
        teacherRepository.changeOwnClass(schoolClass.getMainTeacher(),schoolClass);
       schoolClass.getStudents().forEach((k,v)->
               {
                   try {
                       studentRepository.changeSchoolClass(v,schoolClass);
                   } catch (EntityNotFoundException e) {
                       e.printStackTrace();
                   }
               }
               );

        return schoolClassRepo.add(schoolClass);
    }

    @Override
    public Subject addNewSubject(Subject subject) throws EntityNotFoundException {
        schoolClassRepo.addSubject(subject.getSchoolClass(),subject);

        return subjectRepository.add(subject);
    }

    @Override
    public SchoolClass updateClass(SchoolClass schoolClass) throws EntityNotFoundException {
        teacherRepository.changeOwnClass(schoolClass.getMainTeacher(),schoolClass);
        schoolClass.getStudents().forEach((k,v)->
                {
                    try {
                        studentRepository.changeSchoolClass(v,schoolClass);
                    } catch (EntityNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        );

        return schoolClassRepo.update(schoolClass);
    }

    @Override
    public Subject updateSubject(Subject subject) throws EntityNotFoundException {
        schoolClassRepo.updateSubject(subject.getSchoolClass(),subject);
        schoolClassRepo.updateSubjectInWholeProgram(subject.getSchoolClass(),subject);
        return subjectRepository.update(subject);
    }

    @Override
    public SchoolClass deleteClass(SchoolClass schoolClass) throws EntityNotFoundException {
        teacherRepository.changeOwnClass(schoolClass.getMainTeacher(),null);
        schoolClass.getStudents().forEach((k,v)->
                {
                    try {
                        studentRepository.changeSchoolClass(v,null);
                    } catch (EntityNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        );

        return schoolClassRepo.delete(schoolClass);
    }

    @Override
    public Subject deleteSubject(Subject subject) throws EntityNotFoundException {
        schoolClassRepo.updateSubject(subject.getSchoolClass(),null);
        schoolClassRepo.removeSubjectFromWholeProgram(subject.getSchoolClass(),subject);
        return subjectRepository.delete(subject);
    }

    @Override
    public Student addParent(Student student, Parent parent) {
        return null;
    }

    @Override
    public Student removeParent(Student student, Parent parent) {
        return null;
    }


    @Override
    public V updateUser(V user) throws EntityNotFoundException, InvalidEntityDataException {


       validUser.validate(user);
        return userRepository.update(user);

    }

    @Override
    public V deleteAccount(V user) throws EntityNotFoundException {
        return userRepository.delete(user);
    }

    @Override
    public V changeFirstName(V user, String newFirstName) throws InvalidEntityDataException, EntityNotFoundException {

        var firstNameLen = newFirstName.trim().length();
        if(firstNameLen < 2 || firstNameLen > 20){

            throw  new InvalidEntityDataException(user.getClass().getName()+ " firstName "+ newFirstName+
                    " First name should be between 1 and 20 characters");
        }
        userRepository.changeFirstName(user,newFirstName);
        return user;
    }

    @Override
    public V changeSecondName(V user, String newSecondName) throws InvalidEntityDataException, EntityNotFoundException {
        var secondNameLen = newSecondName.trim().length();
        if(secondNameLen < 2 || secondNameLen > 20){

            throw  new InvalidEntityDataException(user.getClass().getName()+ " firstName "+ newSecondName+
                    " Second name should be between 1 and 20 characters");
        }
        userRepository.changeSecondName(user,newSecondName);
        return user;
    }

    @Override
    public V changeThirdName(V user, String newThirdName) throws InvalidEntityDataException, EntityNotFoundException {
        var thirdNameLen = newThirdName.trim().length();
        if(thirdNameLen < 2 || thirdNameLen > 20){

            throw  new InvalidEntityDataException(user.getClass().getName()+ " firstName "+ newThirdName+
                    " Second name should be between 1 and 20 characters");
        }
        userRepository.changeThirdName(user,newThirdName);
        return user;
    }



    @Override
    public V changeGender(V user, Gender newGender) throws EntityNotFoundException {
        return userRepository.changeGender(user,newGender);
    }

    @Override
    public V changePhoneNumber(V user, String newPhoneNumber) throws InvalidEntityDataException, EntityNotFoundException {
        Pattern pattern = Pattern.compile("^[0-9]{10}$");
        Matcher matcher = pattern.matcher(newPhoneNumber);

        if (!matcher.matches() || getUserRepository().findByPhoneNumber(newPhoneNumber)!=null) {
            throw  new InvalidEntityDataException(user.getClass().getName()+" phone number "+newPhoneNumber+
                    " Phone number should be 10 digits or is already used.");
        }
        return userRepository.changePhoneNumber(user,newPhoneNumber);
    }

    @Override
    public V changeAddress(V user, String newAddress) throws EntityNotFoundException {
        return userRepository.changeAddress(user,newAddress);
    }

}
