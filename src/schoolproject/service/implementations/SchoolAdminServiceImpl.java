package schoolproject.service.implementations;
import schoolproject.dao.rolerepositories.SchoolAdminRepository;
import schoolproject.model.roles.SchoolAdmin;
import schoolproject.service.SchoolAdminService;
import schoolproject.util.ValidUser;

public class SchoolAdminServiceImpl extends UserServiceImpl<SchoolAdmin> implements SchoolAdminService {
    public SchoolAdminServiceImpl(SchoolAdminRepository schoolAdminRepository, ValidUser<SchoolAdmin> userValidator) {
        super(schoolAdminRepository, userValidator);
    }

    @Override
    public void showUserInfo(String email, String username, String password) {

    }
}
