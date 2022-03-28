package schoolproject.service;

import schoolproject.dao.rolerepositories.TeacherRepository;
import schoolproject.dao.rolerepositories.UserRepository;
import schoolproject.model.roles.Teacher;
import schoolproject.util.ValidUser;

public class TeacherServiceImpl extends UserServiceImpl<Teacher> implements TeacherService{

    public TeacherServiceImpl(TeacherRepository teacherRepository, ValidUser<Teacher> userValidator) {
        super(teacherRepository, userValidator);
    }


    @Override
    public void showUserInfo(String email, String username, String password) {

    }
}
