package schoolproject;
import schoolproject.dao.DaoFactory;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.impl.DaoFactoryImpl;
import schoolproject.dao.rolerepositories.*;
import schoolproject.model.roles.SchoolAdmin;
import schoolproject.model.roles.Teacher;
import schoolproject.service.SchoolAdminService;
import schoolproject.service.TeacherService;
import schoolproject.service.implementations.SchoolAdminServiceImpl;
import schoolproject.service.implementations.TeacherServiceImpl;
import schoolproject.util.ValidUser;
import java.time.format.DateTimeFormatter;



public class Main {


    public static void main(String[] args)  {



        DaoFactory daoFactory=new DaoFactoryImpl();

        TeacherRepository teacherRepository=daoFactory.createTeacherRepository("teacher.db");
        SchoolAdminRepository schoolAdminRepository=daoFactory.createSchoolAdminRepository("schooladmins.db");

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        TeacherService teacherService=new TeacherServiceImpl(teacherRepository,new ValidUser<>(teacherRepository));
        SchoolAdminService<Teacher> schoolAdminService=new SchoolAdminServiceImpl<Teacher>(schoolAdminRepository,new ValidUser<SchoolAdmin>(schoolAdminRepository));
       // teacherService.register(new Teacher("Raya","Petrva","Kartselska","raya@abv.bg","raya","Anikaaa444$", Gender.FEMALE,"0894673536","rupite", LocalDate.parse("09.12.2001",dtf)));
        teacherRepository.load();
        //teacherService.register(new Teacher("Anika","Petrova","Kartselska","anika@abv.bg","janikaa","Anikaaa444$", Gender.FEMALE,"0894563436","rupite", LocalDate.parse("09.12.2001",dtf)));
        try {
            schoolAdminService.changeSecondName(teacherRepository.findById(2L),teacherRepository,"");
        } catch (InvalidEntityDataException | EntityNotFoundException e) {
            e.printStackTrace();
        }
        //  teacherService.changeOwnPassword(teacherRepository.findById(2L),"Anikaa33#");
     //  teacherService.delete(teacherService.getUserById(1L));
       for(Teacher t:teacherRepository.findAll())
       {
           System.out.println(t);
       }


    }
}

