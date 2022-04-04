package schoolproject.dao.impl.rolesrepoimpl;

import schoolproject.dao.impl.helperrepositories.LongIdGenerator;
import schoolproject.dao.rolerepositories.HeadTeacherRepository;
import schoolproject.model.roles.HeadTeacher;

public class HeadTeacherRepositoryImpl extends UserRepositoryImpl<HeadTeacher> implements HeadTeacherRepository {


    public HeadTeacherRepositoryImpl(LongIdGenerator idGenerator, String dbFileName) {
        super(idGenerator, dbFileName);
    }
}
