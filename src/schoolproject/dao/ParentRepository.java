package schoolproject.dao;

import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.roles.Parent;
import schoolproject.model.roles.Student;

public interface ParentRepository extends UserRepository<Parent>{

    Parent changeMonthIncome(Parent user, Double income) throws EntityNotFoundException;
    Parent addStudent(Parent user, Student student) throws EntityNotFoundException;
    Parent removeStudent(Parent user, Student student) throws EntityNotFoundException;
    Parent updateStudent(Parent user, Student student) throws EntityNotFoundException;
}
