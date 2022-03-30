package schoolproject;
import schoolproject.dao.DaoFactory;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.impl.DaoFactoryImpl;
import schoolproject.dao.rolerepositories.ParentRepository;
import schoolproject.dao.rolerepositories.StudentRepository;
import schoolproject.dao.rolerepositories.TeacherRepository;
import schoolproject.dao.rolerepositories.UserRepository;
import schoolproject.model.enums.Gender;
import schoolproject.model.roles.Student;
import schoolproject.model.roles.Teacher;
import schoolproject.service.StudentService;
import schoolproject.service.TeacherService;
import schoolproject.service.implementations.StudentServiceImpl;
import schoolproject.service.implementations.TeacherServiceImpl;
import schoolproject.util.ValidStudent;
import schoolproject.util.ValidUser;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;


public class Main {


    public static void main(String[] args) {


        DaoFactory daoFactory=new DaoFactoryImpl();
        UserRepository<Teacher> userRepository=daoFactory.createTeacherRepository();
        TeacherRepository teacherRepository=daoFactory.createTeacherRepository();
        ParentRepository parentRepository=daoFactory.createParentRepository();
        StudentRepository studentRepository= daoFactory.createStudentRepository();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        TeacherService teacherService=new TeacherServiceImpl(teacherRepository,new ValidUser<>(teacherRepository));
        StudentService studentService=new StudentServiceImpl(studentRepository,new ValidStudent(studentRepository));
        teacherService.register(new Teacher("Anika","Petrova","Kartselska","aa@abv.bg","anika","Anikaaa444$", Gender.FEMALE,"0894673436","rupite", LocalDate.parse("09.12.2001",dtf)));
        teacherService.register(new Teacher("Anika","Petrova","Kartselska","axa@abv.bg","janika","Anikaaa444$", Gender.FEMALE,"0894663436","rupite", LocalDate.parse("09.12.2001",dtf)));



        try {
            teacherService.showUserInfo("aa@abv.bg","anika","Anikaaa444$");
        } catch (InvalidEntityDataException e) {
            e.printStackTrace();
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
        studentService.register(new Student("Mariya","Petrova","Petrova","mppp@abv.bg","mimi","Mimmmii55$", Gender.FEMALE,"0894673336","rupite", LocalDate.parse("09.08.2009",dtf)));
                studentService.register(new Student("Gergana","Dimitrova","Dimitrova","gerryy@abv.bg","gery","Geri444$", Gender.FEMALE,"0894673999","rupite", LocalDate.parse("10.07.2010",dtf)));


    }
}

