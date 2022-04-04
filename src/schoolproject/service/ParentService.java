package schoolproject.service;

import schoolproject.dao.rolerepositories.StudentRepository;
import schoolproject.model.roles.Parent;

public interface ParentService extends UserService<Parent>{
    StudentRepository updateParentInStudentRepository(Parent parent, StudentRepository studentRepository);
}
