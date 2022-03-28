package schoolproject.service.implementations;
import schoolproject.dao.rolerepositories.SchoolAdminRepository;
import schoolproject.dao.rolerepositories.StudentRepository;
import schoolproject.dao.rolerepositories.UserRepository;
import schoolproject.model.roles.SchoolAdmin;
import schoolproject.model.roles.Student;
import schoolproject.service.SchoolAdminService;
import schoolproject.util.ValidUser;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SchoolAdminServiceImpl extends UserServiceImpl<SchoolAdmin> implements SchoolAdminService {
    private final StudentRepository studentRepository;

    public SchoolAdminServiceImpl(SchoolAdminRepository schoolAdminRepository, ValidUser<SchoolAdmin> userValidator, StudentRepository studentRepository) {
        super(schoolAdminRepository, userValidator);
        this.studentRepository = studentRepository;
    }

    @Override
    public Collection<Student> sortStudentsByGrade() {
        return studentRepository.findAllSorted(Comparator.comparing(Student::getAverageGrade));

    }
}
