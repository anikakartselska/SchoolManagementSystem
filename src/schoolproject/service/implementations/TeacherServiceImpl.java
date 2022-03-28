package schoolproject.service.implementations;

import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.rolerepositories.TeacherRepository;
import schoolproject.model.roles.Teacher;
import schoolproject.service.TeacherService;
import schoolproject.util.ValidUser;

public class TeacherServiceImpl extends UserServiceImpl<Teacher> implements TeacherService {

    public TeacherServiceImpl(TeacherRepository teacherRepository, ValidUser<Teacher> userValidator) {
        super(teacherRepository, userValidator);
    }



}
