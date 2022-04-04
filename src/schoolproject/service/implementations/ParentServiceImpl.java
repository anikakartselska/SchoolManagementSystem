package schoolproject.service.implementations;

import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.rolerepositories.ParentRepository;
import schoolproject.dao.rolerepositories.StudentRepository;
import schoolproject.model.roles.Parent;
import schoolproject.service.ParentService;
import schoolproject.util.ValidParent;


public class ParentServiceImpl extends UserServiceImpl<Parent> implements ParentService {
    public ParentServiceImpl(ParentRepository parentRepository, ValidParent parentValidator) {
        super(parentRepository, parentValidator);
    }


    @Override
    public StudentRepository updateParentInStudentRepository(Parent parent, StudentRepository studentRepository) {

        studentRepository.findAll().stream().forEach(v -> {
            if (v.getParents().containsKey(parent.getId())) {
                try {
                    studentRepository.updateParent(v, parent);
                } catch (EntityNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        return studentRepository;
    }
}
