package schoolproject.service.implementations;

import schoolproject.dao.rolerepositories.ParentRepository;
import schoolproject.model.roles.Parent;
import schoolproject.service.ParentService;
import schoolproject.util.ValidParent;


public class ParentServiceImpl extends UserServiceImpl<Parent> implements ParentService {
    public ParentServiceImpl(ParentRepository parentRepository, ValidParent parentValidator) {
        super(parentRepository, parentValidator);
    }

    @Override
    public void showUserInfo(String email, String username, String password) {

    }
}
