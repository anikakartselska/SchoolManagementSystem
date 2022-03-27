package schoolproject.util;

import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.identifiiables.UserIdentifiable;
import schoolproject.dao.rolerepositories.UserRepository;
import schoolproject.model.roles.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidUser<V extends UserIdentifiable & Identifiable<Long, String>> {
    private UserRepository<V> userRepository;

    public ValidUser(UserRepository<V> userRepository) {
        this.userRepository = userRepository;
    }

    public void validate(V user) throws InvalidEntityDataException {

        var firstNameLen = user.getFirstName().trim().length();
        if(firstNameLen < 2 || firstNameLen > 20){

                   throw  new InvalidEntityDataException(user.getClass().getName()+ " firstName "+ user.getFirstName()+
                            " First name should be between 1 and 20 characters");
        }
        var secondNameLen = user.getSecondName().trim().length();
        if(secondNameLen < 1 || secondNameLen > 20){

            throw  new InvalidEntityDataException(user.getClass().getName()+" secondName "+ user.getSecondName()+
                            " Second name should be between 1 and 20 characters");
        }
        var thirdNameLen = user.getThirdName().trim().length();
        if(thirdNameLen < 1 || thirdNameLen > 20){
            throw  new InvalidEntityDataException(user.getClass().getName()+ " thirdName "+ user.getThirdName()+
                            " Third name should be between 1 and 20 characters");
        }
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(user.getEmail());

        if (!matcher.matches() || (user.getId()==null && userRepository.findByEmail(user.getEmail())!=null)) {
            throw  new InvalidEntityDataException(user.getClass().getName()+ " email "+ user.getEmail()+
                            " Invalid or already used email.");
        }
        if (userRepository.findByUsername(user.getUsername())!=null) {
            throw  new InvalidEntityDataException(user.getClass().getName()+" username "+ user.getUsername()+
                            " This username is already used.");
        }
        //^[0-9]{10}$
        pattern = Pattern.compile("^[0-9]{10}$");
        matcher = pattern.matcher(user.getPhoneNumber());

        if (!matcher.matches() || userRepository.findByPhoneNumber(user.getPhoneNumber())!=null) {
            throw  new InvalidEntityDataException(user.getClass().getName()+" phone number "+user.getPhoneNumber()+
                            " Phone number should be 10 digits or is already used.");
        }
        pattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
        matcher = pattern.matcher(user.getPassword());
        if (!matcher.matches()) {
            if (!matcher.matches() || userRepository.findByPhoneNumber(user.getPhoneNumber())!=null) {
                throw  new InvalidEntityDataException(user.getClass().getName() + "password:"+
                                " The password must contain at least one digit, one capital letter, and one sign different than letter or digit");
         }
            if(user.getBirthday().isAfter(LocalDate.now()))
                throw  new InvalidEntityDataException(user.getClass().getName()+" birthDate "+user.getBirthday()+
                        " Birth date should be in the past.");

    }


}
}
