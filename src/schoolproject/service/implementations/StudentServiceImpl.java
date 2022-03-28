package schoolproject.service.implementations;
import schoolproject.dao.rolerepositories.StudentRepository;
import schoolproject.model.roles.Student;
import schoolproject.service.StudentService;
import schoolproject.util.ValidStudent;


public class StudentServiceImpl extends UserServiceImpl<Student>implements StudentService {

    public StudentServiceImpl(StudentRepository studentRepository, ValidStudent validStudent) {
        super(studentRepository, validStudent);
    }

    @Override
    public void showUserInfo(String email, String username, String password) {

    }
}
