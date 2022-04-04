package schoolproject.service;
import schoolproject.dao.SchoolClassRepo;
import schoolproject.dao.SubjectRepository;
import schoolproject.dao.exceptions.BusyClassException;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.identifiiables.UserIdentifiable;
import schoolproject.dao.impl.helperrepositories.PersistableRepositoryFileImpl;
import schoolproject.dao.impl.helperrepositories.RepositoryImpl;
import schoolproject.dao.rolerepositories.ParentRepository;
import schoolproject.dao.rolerepositories.StudentRepository;
import schoolproject.dao.rolerepositories.TeacherRepository;
import schoolproject.dao.rolerepositories.UserRepository;
import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;
import schoolproject.model.enums.Gender;
import schoolproject.model.roles.Parent;
import schoolproject.model.roles.SchoolAdmin;
import schoolproject.model.roles.Student;
import schoolproject.model.roles.Teacher;
import schoolproject.util.ValidUser;
import schoolproject.util.Validation;

import java.util.Collection;


public interface SchoolAdminService<V extends UserIdentifiable & Identifiable<Long, String>> extends UserService<SchoolAdmin>{

//USER MANAGE
    V changeGender(V user, UserRepository<V> userRepo, Gender newGender) throws EntityNotFoundException;
    V changePhoneNumber(V user, UserRepository<V> userRepo,String newPhoneNumber) throws InvalidEntityDataException, EntityNotFoundException;
    V changeAddress(V user, UserRepository<V> userRepo,String newAddress) throws EntityNotFoundException;


     V changeFirstName(V user, UserRepository<V> userRepo,String newFirstName) throws EntityNotFoundException, InvalidEntityDataException;
     V changeSecondName(V user, UserRepository<V> userRepo,String newSecondName) throws InvalidEntityDataException, EntityNotFoundException;
     V changeThirdName(V user, UserRepository<V> userRepo,String newThirdName) throws InvalidEntityDataException, EntityNotFoundException;
     V approveRegisterRequest(V user, UserRepository<V> userRepo) throws EntityNotFoundException;
     ////
     Collection<V> getAllEntitiesFromThisRepository( PersistableRepositoryFileImpl<Long,String,V> repository);
    V deleteEntity(V entity, PersistableRepositoryFileImpl<Long,String,V> repository) throws EntityNotFoundException;
    V updateEntity(V entity, PersistableRepositoryFileImpl<Long,String,V> repository, ValidUser<V>validation) throws EntityNotFoundException, InvalidEntityDataException;
    V addEntity(V entity, PersistableRepositoryFileImpl<Long,String,V>repository, Validation<V>validation);
    V getEntityById(Long id, PersistableRepositoryFileImpl<Long,String,V>repository) throws EntityNotFoundException;

    ////
    Subject changeName(Subject subject, SubjectRepository subjectRepository,String newName) throws InvalidEntityDataException, EntityNotFoundException;
    Subject changeTeacher(Subject subject, SubjectRepository subjectRepository, Teacher teacher) throws EntityNotFoundException;
    Subject changeSchoolClass(Subject subject, SubjectRepository subjectRepository, SchoolClass schoolClass) throws EntityNotFoundException;
    Subject changeWeeklyLessons(Subject subject, SubjectRepository subjectRepository, Integer weeklyLessons) throws InvalidEntityDataException, EntityNotFoundException;


    ////
    SchoolClass changeTeacher(SchoolClass schoolClass, SchoolClassRepo schoolClassRepo, Teacher teacher) throws EntityNotFoundException;
    SchoolClass addSubject(SchoolClass schoolClass,SchoolClassRepo schoolClassRepo,Subject subject) throws EntityNotFoundException;
    SchoolClass removeSubject(SchoolClass schoolClass,SchoolClassRepo schoolClassRepo,Subject subject) throws EntityNotFoundException;
    SchoolClass addStudent(SchoolClass schoolClass,SchoolClassRepo schoolClassRepo, Student student) throws EntityNotFoundException;
    SchoolClass removeStudent(SchoolClass schoolClass,SchoolClassRepo schoolClassRepo, Student student) throws EntityNotFoundException;
    SchoolClass addSubjectToProgram(SchoolClass schoolClass,SchoolClassRepo schoolClassRepo,Subject subject,Integer day, Integer classNumber) throws BusyClassException, EntityNotFoundException;
    SchoolClass removeSubjectFromProgram(SchoolClass schoolClass,SchoolClassRepo schoolClassRepo,Subject subject,Integer day, Integer classNumber) throws EntityNotFoundException;

    ///
    Parent addStudent(Parent parent, ParentRepository parentRepository,Student student) throws EntityNotFoundException;
    Parent removeStudent(Parent parent, ParentRepository parentRepository,Student student) throws EntityNotFoundException;

    ///
    Student changeSchoolClass(Student student, StudentRepository studentRepository,SchoolClass schoolClass) throws EntityNotFoundException;
    Student addSubject(Student student, StudentRepository studentRepository,Subject subject) throws EntityNotFoundException;
    Student removeSubject(Student student, StudentRepository studentRepository,Subject subject) throws EntityNotFoundException;

    ////
    Teacher changeOwnClass(Teacher teacher, TeacherRepository teacherRepository,SchoolClass schoolClass) throws EntityNotFoundException;
    Teacher addSubject(Teacher teacher,TeacherRepository teacherRepository,Subject subject) throws EntityNotFoundException;
    Teacher removeSubject(Teacher teacher,TeacherRepository teacherRepository,Subject subject) throws EntityNotFoundException;
    Teacher addSubjectToProgram(Teacher teacher,TeacherRepository teacherRepository,Subject subject,Integer day, Integer classNumber) throws BusyClassException, EntityNotFoundException;
    Teacher removeSubjectFromProgram(Teacher teacher,TeacherRepository teacherRepository,Subject subject,Integer day, Integer classNumber) throws BusyClassException, EntityNotFoundException;
}
