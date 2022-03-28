package schoolproject.dao.impl.rolesrepoimpl;

import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.identifiiables.UserIdentifiable;
import schoolproject.dao.rolerepositories.UserRepository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.impl.helperrepositories.RepositoryImpl;
import schoolproject.model.enums.Gender;

public class UserRepositoryImpl<V extends UserIdentifiable & Identifiable<Long, String>> extends RepositoryImpl<Long,String, V> implements UserRepository<V> {

    @Override
    public V changeFirstName(V user, String newFirstName) throws EntityNotFoundException {

       user.setFirstName(newFirstName);
       return user;

    }

    @Override
    public V changeSecondName(V user, String newSecondName) throws EntityNotFoundException {
        V updatedUser=user;
        updatedUser.setSecondName(newSecondName);
        return update(updatedUser);
    }

    @Override
    public V changeThirdName(V user, String newThirdName) throws EntityNotFoundException {
        V updatedUser=user;
        updatedUser.setThirdName(newThirdName);
        return update(updatedUser);
    }

    @Override
    public V changePassword(V user, String newPassword) throws EntityNotFoundException {

        V updatedUser=user;
        updatedUser.setPassword(newPassword);
        return update(updatedUser);
    }

    @Override
    public V changeGender(V user, Gender newGender) throws EntityNotFoundException {
        V updatedUser=user;
        updatedUser.setGender(newGender);
        return update(updatedUser);
    }

    @Override
    public V changePhoneNumber(V user, String newPhoneNumber) throws EntityNotFoundException {
        V updatedUser=user;
        updatedUser.setPhoneNumber(newPhoneNumber);
        return update(updatedUser);
    }

    @Override
    public V changeAddress(V user, String newAddress) throws EntityNotFoundException {
        V updatedUser=user;
        updatedUser.setAddress(newAddress);
        return update(updatedUser);
    }

    @Override
    public V findByEmail(String email) {

        for(V user: findAll())
            if(user.getEmail().equals(email))
                return user;
            return null;
    }

    @Override
    public V findByUsername(String userName) {
        for(V user: findAll())
            if(user.getUsername().equals(userName))
                return user;
        return null;
    }

    @Override
    public V findByPhoneNumber(String phoneNumber) {
        for(V user: findAll())
            if(user.getPhoneNumber().equals(phoneNumber))
                return user;

        return null;
    }
}
