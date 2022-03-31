package schoolproject.service.implementations;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.identifiiables.UserIdentifiable;
import schoolproject.dao.rolerepositories.UserRepository;
import schoolproject.service.UserService;
import schoolproject.util.ValidUser;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserServiceImpl<V extends UserIdentifiable & Identifiable<Long, String>> implements UserService<V> {
    private final UserRepository<V> userRepository;
    private final ValidUser<V> userValidator;

    public UserServiceImpl(UserRepository<V> userRepository, ValidUser<V> userValidator) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
    }

    public UserRepository<V> getUserRepository() {
        return userRepository;
    }

    public ValidUser<V> getUserValidator() {
        return userValidator;
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
    public V logIn(String email, String username, String password) throws InvalidEntityDataException, EntityNotFoundException {
        V log=userRepository.findByEmail(email);
        if(log!=null)
        {
            if(!username.equals(log.getUsername())|| !password.equals(log.getPassword()))
            {throw new InvalidEntityDataException("Invalid username or password");
            } }
        else {throw new EntityNotFoundException("User with this email doesn't exist");}


        return log;}

    @Override
    public void showUserPersonalInfo(V user) {

        System.out.println(user);

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
    public V getUserById(Long id) throws EntityNotFoundException {
        V user = userRepository.findById(id);
        if(user == null) {
            throw new EntityNotFoundException();
        }
        return user;
    }






}
