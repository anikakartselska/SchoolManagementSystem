package schoolproject.dao.impl.rolesrepoimpl;

import schoolproject.dao.LongIdGenerator;
import schoolproject.dao.rolerepositories.HeadTeacherRepository;
import schoolproject.model.roles.HeadTeacher;
import schoolproject.model.roles.Student;

import java.util.HashMap;

public class HeadTeacherRepositoryImpl extends UserRepositoryImpl<HeadTeacher> implements HeadTeacherRepository {


    public HeadTeacherRepositoryImpl(LongIdGenerator idGenerator) {
        super(idGenerator);
    }
}
