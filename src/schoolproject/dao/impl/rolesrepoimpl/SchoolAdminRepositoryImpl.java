package schoolproject.dao.impl.rolesrepoimpl;

import schoolproject.dao.LongIdGenerator;
import schoolproject.dao.rolerepositories.SchoolAdminRepository;
import schoolproject.model.roles.SchoolAdmin;

public class SchoolAdminRepositoryImpl extends UserRepositoryImpl<SchoolAdmin> implements SchoolAdminRepository {

    public SchoolAdminRepositoryImpl(LongIdGenerator idGenerator, String dbFileName) {
        super(idGenerator, dbFileName);
    }
}
