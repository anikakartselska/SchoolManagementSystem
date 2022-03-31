package schoolproject.dao.identifiiables;

import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.enums.Gender;
import schoolproject.model.enums.Status;
import schoolproject.model.roles.User;

import java.time.Instant;
import java.time.LocalDate;

public interface UserIdentifiable{
    String getFirstName();
    String getSecondName();
    String getThirdName();
    String getPassword();
    Gender getGender();
   String getPhoneNumber();
   String getAddress();
   String getEmail();
    String getUsername();

    void setFirstName(String newFirstName);

    void setSecondName(String newSecondName);

    void setThirdName(String newThirdName);

    void setPassword(String newPassword);

    void setGender(Gender newGender);

    void setPhoneNumber(String newPhoneNumber);

    void setAddress(String newAddress);

    LocalDate getBirthday();

    void setStatus(Status status);
}
