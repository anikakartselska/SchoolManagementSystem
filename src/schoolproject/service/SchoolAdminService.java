package schoolproject.service;

import schoolproject.model.roles.SchoolAdmin;
import schoolproject.model.roles.Student;

import java.util.Collection;
import java.util.HashMap;

public interface SchoolAdminService extends UserService<SchoolAdmin>{
    Collection<Student> sortStudentsByGrade();
}
