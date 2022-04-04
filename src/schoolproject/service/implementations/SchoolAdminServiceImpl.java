package schoolproject.service.implementations;
import schoolproject.dao.SchoolClassRepo;
import schoolproject.dao.SubjectRepository;
import schoolproject.dao.exceptions.BusyClassException;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.identifiiables.UserIdentifiable;
import schoolproject.dao.impl.helperrepositories.PersistableRepositoryFileImpl;
import schoolproject.dao.rolerepositories.ParentRepository;
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
import schoolproject.model.roles.Teacher;
import schoolproject.service.SchoolAdminService;
import schoolproject.util.ValidUser;
import schoolproject.util.Validation;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SchoolAdminServiceImpl<V extends UserIdentifiable & Identifiable<Long, String>> extends UserServiceImpl<SchoolAdmin> implements SchoolAdminService<V> {

    private UserRepository<V> userRepository;
    private ValidUser<V> validUser;

    public SchoolAdminServiceImpl(UserRepository<SchoolAdmin> userRepository, ValidUser<SchoolAdmin> userValidator) {
        super(userRepository, userValidator);
    }

    @Override
    public V approveRegisterRequest(V user, UserRepository<V> userRepo) throws EntityNotFoundException {
       userRepo.changeStatus(user,Status.ACTIVE);
       userRepo.save();
       return user;
    }
    @Override
    public Collection<V> getAllEntitiesFromThisRepository(PersistableRepositoryFileImpl<Long,String,V> repository) {
        return repository.findAll();
    }
    @Override
    public V updateEntity(V entity, PersistableRepositoryFileImpl<Long,String,V> repository, ValidUser<V>validation) throws EntityNotFoundException, InvalidEntityDataException {


       validation.validate(entity);
       repository.update(entity);
        repository.save();
        return entity;

    }

    @Override
    public V addEntity(V entity, PersistableRepositoryFileImpl<Long, String, V> repository, Validation<V> validation) {
        try{
            validation.validate(entity);
            repository.add(entity);
            repository.save();

        } catch (InvalidEntityDataException e) {
            e.printStackTrace();
        }

        return entity;

    }

    @Override
    public V getEntityById(Long id, PersistableRepositoryFileImpl<Long, String, V> repository) throws EntityNotFoundException {
        V entity = repository.findById(id);
        if(entity == null) {
            throw new EntityNotFoundException();
        }
        return entity;
    }

    @Override
    public V deleteEntity(V entity, PersistableRepositoryFileImpl<Long,String,V> repository) throws EntityNotFoundException {
        var old = repository.delete(entity);
        repository.save();
        return old;
    }

    @Override
    public V changeFirstName(V user, UserRepository<V> userRepo, String newFirstName) throws InvalidEntityDataException, EntityNotFoundException {

        var firstNameLen = newFirstName.trim().length();
        if(firstNameLen < 2 || firstNameLen > 20){

            throw  new InvalidEntityDataException(user.getClass().getName()+ " firstName "+ newFirstName+
                    " First name should be between 1 and 20 characters");
        }
        userRepo.changeFirstName(user,newFirstName);
        userRepo.save();
        return user;
    }

    @Override
    public V changeSecondName(V user, UserRepository<V> userRepo, String newSecondName) throws InvalidEntityDataException, EntityNotFoundException {
        var secondNameLen = newSecondName.trim().length();
        if(secondNameLen < 2 || secondNameLen > 20){

            throw  new InvalidEntityDataException(user.getClass().getName()+ " firstName "+ newSecondName+
                    " Second name should be between 1 and 20 characters");
        }
        userRepo.changeSecondName(user,newSecondName);
        userRepo.save();
        return user;
    }

    @Override
    public V changeThirdName(V user, UserRepository<V> userRepo, String newThirdName) throws InvalidEntityDataException, EntityNotFoundException {
        var thirdNameLen = newThirdName.trim().length();
        if(thirdNameLen < 2 || thirdNameLen > 20){

            throw  new InvalidEntityDataException(user.getClass().getName()+ " firstName "+ newThirdName+
                    " Second name should be between 1 and 20 characters");
        }
        userRepo.changeThirdName(user,newThirdName);
        userRepo.save();
        return user;
    }

    @Override
    public V changeGender(V user, UserRepository<V> userRepo, Gender newGender) throws EntityNotFoundException {
       userRepo.changeGender(user,newGender);
        userRepo.save();
        return user;
    }

    @Override
    public V changePhoneNumber(V user, UserRepository<V> userRepo, String newPhoneNumber) throws InvalidEntityDataException, EntityNotFoundException {
        Pattern pattern = Pattern.compile("^[0-9]{10}$");
        Matcher matcher = pattern.matcher(newPhoneNumber);

        if (!matcher.matches() || getUserRepository().findByPhoneNumber(newPhoneNumber)!=null) {
            throw  new InvalidEntityDataException(user.getClass().getName()+" phone number "+newPhoneNumber+
                    " Phone number should be 10 digits or is already used.");
        }
        userRepo.changePhoneNumber(user,newPhoneNumber);
        userRepo.save();
        return user;
    }

    @Override
    public V changeAddress(V user, UserRepository<V> userRepo, String newAddress) throws EntityNotFoundException {
        userRepo.changeAddress(user,newAddress);
        userRepo.save();
        return user;
    }

    @Override
    public Subject changeName(Subject subject, SubjectRepository subjectRepository, String newName) throws InvalidEntityDataException, EntityNotFoundException {
        var subNameLen=newName.trim().length();
        if(subNameLen<1 || subNameLen>20)
        {
            throw  new InvalidEntityDataException(subject.getClass().getName()+ " subName "+ newName+
                    " The subject name length should be between 1 and 20 ");
        }
        subjectRepository.changeName(subject,newName);
        subjectRepository.save();
        return subject;
    }

    @Override
    public Subject changeTeacher(Subject subject, SubjectRepository subjectRepository, Teacher teacher) throws EntityNotFoundException {
        subjectRepository.changeTeacher(subject,teacher);
        subjectRepository.save();
        return subject;
    }

    @Override
    public Subject changeSchoolClass(Subject subject, SubjectRepository subjectRepository, SchoolClass schoolClass) throws EntityNotFoundException {
        subjectRepository.changeClass(subject,schoolClass);
        subjectRepository.save();
        return subject;
    }

    @Override
    public Subject changeWeeklyLessons(Subject subject, SubjectRepository subjectRepository, Integer weeklyLessons) throws InvalidEntityDataException, EntityNotFoundException {
        if(weeklyLessons<0 || weeklyLessons>10)
        {
            throw  new InvalidEntityDataException(subject.getClass().getName()+ " weeklyLessons"+ weeklyLessons+
                    " Weekly lessons shouldn't be > 10 or negative number ");
        }
        subjectRepository.changeWeeklyLessons(subject,weeklyLessons);
        subjectRepository.save();
        return subject;
    }

    @Override
    public SchoolClass changeTeacher(SchoolClass schoolClass, SchoolClassRepo schoolClassRepo, Teacher teacher) throws EntityNotFoundException {
        schoolClassRepo.changeTeacher(schoolClass,teacher);
        schoolClassRepo.save();
        return schoolClass;
    }

    @Override
    public SchoolClass addSubject(SchoolClass schoolClass, SchoolClassRepo schoolClassRepo, Subject subject) throws EntityNotFoundException {
        schoolClassRepo.addSubject(schoolClass,subject);
        schoolClassRepo.save();
        return schoolClass;
    }

    @Override
    public SchoolClass removeSubject(SchoolClass schoolClass, SchoolClassRepo schoolClassRepo, Subject subject) throws EntityNotFoundException {
        schoolClassRepo.deleteSubject(schoolClass,subject);
        schoolClassRepo.save();
        return schoolClass;
    }

    @Override
    public SchoolClass addStudent(SchoolClass schoolClass, SchoolClassRepo schoolClassRepo, Student student) throws EntityNotFoundException {
        schoolClassRepo.addStudent(schoolClass,student);
        schoolClassRepo.save();
        return schoolClass;
    }

    @Override
    public SchoolClass removeStudent(SchoolClass schoolClass, SchoolClassRepo schoolClassRepo, Student student) throws EntityNotFoundException {
        schoolClassRepo.deleteStudent(schoolClass,student);
        schoolClassRepo.save();
        return schoolClass;
    }

    @Override
    public SchoolClass addSubjectToProgram(SchoolClass schoolClass, SchoolClassRepo schoolClassRepo, Subject subject, Integer day, Integer classNumber) throws BusyClassException, EntityNotFoundException {
       if(schoolClass.getSubjects().containsKey(subject.getId()))
       {  schoolClassRepo.addSubjectToProgram(schoolClass,day,classNumber,subject);
       schoolClassRepo.save();}
       else throw new EntityNotFoundException("This subject isn't in this class' subjects");
       return schoolClass;

    }

    @Override
    public SchoolClass removeSubjectFromProgram(SchoolClass schoolClass, SchoolClassRepo schoolClassRepo, Subject subject, Integer day, Integer classNumber) throws EntityNotFoundException {
        schoolClassRepo.removeSubjectFromProgram(schoolClass,day,classNumber,subject);
        schoolClassRepo.save();
        return schoolClass;
    }

    @Override
    public Parent addStudent(Parent parent, ParentRepository parentRepository, Student student) throws EntityNotFoundException {
        parentRepository.addStudent(parent,student);
        parentRepository.save();
        return parent;
    }

    @Override
    public Parent removeStudent(Parent parent, ParentRepository parentRepository, Student student) throws EntityNotFoundException {
        parentRepository.removeStudent(parent,student);
        parentRepository.save();
        return parent;
    }

    @Override
    public Student changeSchoolClass(Student student, StudentRepository studentRepository, SchoolClass schoolClass) throws EntityNotFoundException {
        studentRepository.changeSchoolClass(student,schoolClass);
        studentRepository.save();
        return student;
    }

    @Override
    public Student addSubject(Student student, StudentRepository studentRepository, Subject subject) throws EntityNotFoundException {
        studentRepository.addSubject(student,subject);
        studentRepository.save();
        return student;
    }

    @Override
    public Student removeSubject(Student student, StudentRepository studentRepository, Subject subject) throws EntityNotFoundException {
        studentRepository.removeSubject(student,subject);
        studentRepository.save();
        return student;
    }

    @Override
    public Teacher changeOwnClass(Teacher teacher, TeacherRepository teacherRepository, SchoolClass schoolClass) throws EntityNotFoundException {
        teacherRepository.changeOwnClass(teacher,schoolClass);
        teacherRepository.save();
        return teacher;
    }

    @Override
    public Teacher addSubject(Teacher teacher, TeacherRepository teacherRepository, Subject subject) throws EntityNotFoundException {
        teacherRepository.addTeachingSubject(teacher,subject);
        teacherRepository.save();
        return teacher;
    }

    @Override
    public Teacher removeSubject(Teacher teacher, TeacherRepository teacherRepository, Subject subject) throws EntityNotFoundException {
        teacherRepository.removeTeachingSubject(teacher,subject);
        teacherRepository.save();
        return teacher;
    }

    @Override
    public Teacher addSubjectToProgram(Teacher teacher, TeacherRepository teacherRepository, Subject subject, Integer day, Integer classNumber) throws BusyClassException, EntityNotFoundException {
        if(teacher.getTeachingSubjects().containsKey(subject.getId()))
        {  teacherRepository.addSubjectToProgram(teacher,day,classNumber,subject);
            teacherRepository.save();}
        else throw new EntityNotFoundException("This subject isn't in this class' subjects");
        return teacher;
    }

    @Override
    public Teacher removeSubjectFromProgram(Teacher teacher, TeacherRepository teacherRepository, Subject subject, Integer day, Integer classNumber) throws BusyClassException, EntityNotFoundException {
        teacherRepository.removeSubjectFromProgram(teacher,day,classNumber,subject);
        teacherRepository.save();
        return teacher;
    }

}
