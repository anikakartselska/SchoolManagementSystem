package schoolproject.service;

import schoolproject.dao.rolerepositories.UserRepository;
import schoolproject.model.roles.Teacher;
import schoolproject.util.ValidUser;

public class TeacherServiceImpl extends UserServiceImpl<Teacher> implements TeacherService{
    public TeacherServiceImpl(UserRepository<Teacher> userRepository, ValidUser<Teacher> userValidator) {
        super(userRepository, userValidator);
    }
}
