package schoolproject.dao.impl.rolesrepoimpl;

import schoolproject.dao.impl.helperrepositories.LongIdGenerator;
import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.dao.identifiiables.UserIdentifiable;
import schoolproject.dao.impl.helperrepositories.PersistableRepositoryFileImpl;
import schoolproject.dao.rolerepositories.UserRepository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.enums.Gender;
import schoolproject.model.enums.Status;

public class UserRepositoryImpl<V extends UserIdentifiable & Identifiable<Long, String>> extends PersistableRepositoryFileImpl<Long,String, V> implements UserRepository<V> {


    public UserRepositoryImpl(LongIdGenerator idGenerator, String dbFileName) {
        super(idGenerator, dbFileName);
    }

    @Override
    public V changeFirstName(V user, String newFirstName) throws EntityNotFoundException {

       user.setFirstName(newFirstName);
       return update(user);

    }

    @Override
    public V changeSecondName(V user, String newSecondName) throws EntityNotFoundException {

        user.setSecondName(newSecondName);
        return update(user);
    }

    @Override
    public V changeThirdName(V user, String newThirdName) throws EntityNotFoundException {

        user.setThirdName(newThirdName);
        return update(user);
    }

    @Override
    public V changePassword(V user, String newPassword) throws EntityNotFoundException {

        user.setPassword(newPassword);
        return update(user);
    }

    @Override
    public V changeGender(V user, Gender newGender) throws EntityNotFoundException {

        user.setGender(newGender);
        return update(user);
    }

    @Override
    public V changePhoneNumber(V user, String newPhoneNumber) throws EntityNotFoundException {

        user.setPhoneNumber(newPhoneNumber);
        return update(user);
    }

    @Override
    public V changeAddress(V user, String newAddress) throws EntityNotFoundException {

        user.setAddress(newAddress);
        return update(user);
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

    @Override
    public V changeStatus(V user, Status status) throws EntityNotFoundException {
        user.setStatus(status);
        return update(user);
    }
}
