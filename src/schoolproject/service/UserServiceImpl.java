package schoolproject.service;

import schoolproject.dao.DaoFactory;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.identifiiables.UserIdentifiable;
import schoolproject.dao.impl.DaoFactoryImpl;
import schoolproject.dao.impl.rolesrepoimpl.UserRepositoryImpl;
import schoolproject.dao.rolerepositories.ParentRepository;
import schoolproject.dao.rolerepositories.TeacherRepository;
import schoolproject.dao.rolerepositories.UserRepository;
import schoolproject.model.enums.Gender;
import schoolproject.model.roles.Parent;
import schoolproject.model.roles.Teacher;
import schoolproject.util.ValidParent;
import schoolproject.util.ValidUser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;

public class UserServiceImpl<V extends UserIdentifiable & Identifiable<Long, String>> implements UserService<V>{

    public UserServiceImpl(UserRepository<V> userRepository, ValidUser<V> userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    private final UserRepository<V> userRepository;
    private final ValidUser <V>userValidator;


    @Override
    public Collection<V> getAllUsersFromThisRole() {
        return userRepository.findAll();
    }

    @Override
    public V getUserById(Long id) throws EntityNotFoundException {
        V user = userRepository.findById(id);
        if(user == null) {
       throw new EntityNotFoundException();
        }
        return user;
    }

    @Override
    public V register(V user) {
        try{
            userValidator.validate(user);
        } catch (InvalidEntityDataException e) {
            e.printStackTrace();
        }
        return userRepository.add(user);
    }

    @Override
    public V updateUser(V user) throws EntityNotFoundException, InvalidEntityDataException {


            userValidator.validate(user);
            System.out.println("sa");
            return userRepository.update(user);

    }

    @Override
    public V deleteAccount(V user) throws EntityNotFoundException {
        return userRepository.delete(user);
    }

    @Override
    public V changeOwnFirstName(V user, String newFirstName)  {


        try {
         updateUser(userRepository.changeFirstName(user,newFirstName));

        } catch (InvalidEntityDataException | EntityNotFoundException e) {
            e.printStackTrace();

        }

        return user;
    }

    @Override
    public V changeOwnSecondName(V user, String newSecondName) {
        return null;
    }

    @Override
    public V changeOwnThirdName(V user, String newThirdName) {
        return null;
    }

    @Override
    public V changeOwnPassword(V user, String newPassword) {
        return null;
    }

    @Override
    public V changeOwnGender(V user, Gender newGender) {
        return null;
    }

    @Override
    public V changeOwnPhoneNumber(V user, String newPhoneNumber) {
        return null;
    }

    @Override
    public V changeAddress(V user, String newAddress) {
        return null;
    }

    @Override
    public V logIn(String email, String username, String password) {
        return null;
    }


    public static void main(String[] args) {
        DaoFactory daoFactory=new DaoFactoryImpl();
        UserRepository<Teacher> userRepository=daoFactory.createTeacherRepository();
        TeacherRepository teacherRepository=daoFactory.createTeacherRepository();
        ParentRepository parentRepository=daoFactory.createParentRepository();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        TeacherService teacherService=new TeacherServiceImpl(teacherRepository,new ValidUser<>(teacherRepository));
        teacherService.register(new Teacher("Anika","Petrova","Kartselska","aa@abv.bg","anika","Anikaaa444$", Gender.FEMALE,"0894673436","rupite", LocalDate.parse("09.12.2001",dtf)));
        teacherService.register(new Teacher("Anika","Petrova","Kartselska","axa@abv.bg","janika","Anikaaa444$", Gender.FEMALE,"0894663436","rupite", LocalDate.parse("09.12.2001",dtf)));
        try {
            System.out.println(teacherService.getUserById(2L));
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
        try {
            teacherService.changeOwnFirstName(teacherService.getUserById(2L),"Anikaeqka");
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(teacherService.getUserById(2L));
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }

  /*      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");

        try {
            vu.validate(new Parent("Anika","Petrova","Kartselska","aa@abv.bg","anika","Anikaaa444$", Gender.FEMALE,"0894673436","rupite", LocalDate.parse("09.12.2001",dtf),new HashMap<>(),-34));
        } catch (InvalidEntityDataException e) {
            e.printStackTrace();
        }*/

    }
}
