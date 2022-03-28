package schoolproject.service.implementations;

import schoolproject.dao.DaoFactory;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.identifiiables.UserIdentifiable;
import schoolproject.dao.impl.DaoFactoryImpl;
import schoolproject.dao.rolerepositories.ParentRepository;
import schoolproject.dao.rolerepositories.TeacherRepository;
import schoolproject.dao.rolerepositories.UserRepository;
import schoolproject.model.enums.Gender;
import schoolproject.model.roles.Teacher;
import schoolproject.service.TeacherService;
import schoolproject.service.UserService;
import schoolproject.service.implementations.TeacherServiceImpl;
import schoolproject.util.ValidUser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class UserServiceImpl<V extends UserIdentifiable & Identifiable<Long, String>> implements UserService<V> {
    private final UserRepository<V> userRepository;
    private final ValidUser<V> userValidator;

    public UserServiceImpl(UserRepository<V> userRepository, ValidUser<V> userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }




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
            return userRepository.update(user);

    }

    @Override
    public V deleteAccount(V user) throws EntityNotFoundException {
        return userRepository.delete(user);
    }

    @Override
    public V changeOwnFirstName(V user, String newFirstName) throws InvalidEntityDataException, EntityNotFoundException {

        var firstNameLen = newFirstName.trim().length();
        if(firstNameLen < 2 || firstNameLen > 20){

            throw  new InvalidEntityDataException(user.getClass().getName()+ " firstName "+ newFirstName+
                    " First name should be between 1 and 20 characters");
        }
        userRepository.changeFirstName(user,newFirstName);
        return user;
    }

    @Override
    public V changeOwnSecondName(V user, String newSecondName) throws InvalidEntityDataException, EntityNotFoundException {
        var secondNameLen = newSecondName.trim().length();
        if(secondNameLen < 2 || secondNameLen > 20){

            throw  new InvalidEntityDataException(user.getClass().getName()+ " firstName "+ newSecondName+
                    " Second name should be between 1 and 20 characters");
        }
        userRepository.changeSecondName(user,newSecondName);
        return user;
    }

    @Override
    public V changeOwnThirdName(V user, String newThirdName) throws InvalidEntityDataException, EntityNotFoundException {
        var thirdNameLen = newThirdName.trim().length();
        if(thirdNameLen < 2 || thirdNameLen > 20){

            throw  new InvalidEntityDataException(user.getClass().getName()+ " firstName "+ newThirdName+
                    " Second name should be between 1 and 20 characters");
        }
        userRepository.changeThirdName(user,newThirdName);
        return user;
    }

    @Override
    public V changeOwnPassword(V user, String newPassword) throws InvalidEntityDataException, EntityNotFoundException {
       Pattern pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
       Matcher matcher = pattern.matcher(newPassword);

            if (!matcher.matches()) {
                throw  new InvalidEntityDataException(user.getClass().getName() + "password:"+
                        " The password must contain at least one digit, one capital letter, and one sign different than letter or digit");
            }
            else if(user.getPassword().equals(newPassword))
            {
                throw  new InvalidEntityDataException(user.getClass().getName() + "password:"+
                        " You have entered you old password");
            }
            userRepository.changePassword(user,newPassword);
            return user;
    }

    @Override
    public V changeOwnGender(V user, Gender newGender) throws EntityNotFoundException {
        return userRepository.changeGender(user,newGender);
    }

    @Override
    public V changeOwnPhoneNumber(V user, String newPhoneNumber) throws InvalidEntityDataException, EntityNotFoundException {
       Pattern pattern = Pattern.compile("^[0-9]{10}$");
       Matcher matcher = pattern.matcher(newPhoneNumber);

        if (!matcher.matches() || userRepository.findByPhoneNumber(newPhoneNumber)!=null) {
            throw  new InvalidEntityDataException(user.getClass().getName()+" phone number "+newPhoneNumber+
                    " Phone number should be 10 digits or is already used.");
        }
        return userRepository.changePhoneNumber(user,newPhoneNumber);
    }

    @Override
    public V changeAddress(V user, String newAddress) throws EntityNotFoundException {
        return userRepository.changeAddress(user,newAddress);
    }

    @Override
    public V logIn(String email, String username, String password) throws InvalidEntityDataException, EntityNotFoundException {
        V log=userRepository.findByEmail(email);
        if(log!=null)
        {
            if(!username.equals(log.getUsername())|| !password.equals(log.getPassword()))
            {throw new InvalidEntityDataException("Invalid username or password");
        } }
        else {throw new EntityNotFoundException("User with this email doesn't exist");}


        return log;}


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
            teacherService.changeOwnFirstName(teacherService.getUserById(2L),"Raya");
            teacherService.changeOwnPassword(teacherService.getUserById(2L),"Anikaaa445$");
            teacherService.changeOwnGender(teacherService.getUserById(2L),Gender.MALE);
        } catch (EntityNotFoundException | InvalidEntityDataException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(teacherService.getUserById(2L));
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }


        try {
            teacherService.logIn("aa@abv.bg","anika","kk");
        } catch (InvalidEntityDataException e) {
            e.printStackTrace();
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
