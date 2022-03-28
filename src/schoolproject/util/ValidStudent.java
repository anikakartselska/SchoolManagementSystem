package schoolproject.util;
import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.rolerepositories.UserRepository;
import schoolproject.model.roles.Student;

public class ValidStudent extends ValidUser<Student>{
    public ValidStudent(UserRepository<Student> userRepository) {
        super(userRepository);
    }




    public void validateStudent(Student student) throws InvalidEntityDataException {
        super.validate(student);

        if(student.getAverageGrade()<2 || student.getAverageGrade()>6)
        {
            throw  new InvalidEntityDataException(student.getClass().getName()+ " averageGrade "+student.getAverageGrade()+
                    " Grade should be between 2 and 6 ");
        }
        if(student.getNumberInClass()<0)
        {
            throw  new InvalidEntityDataException(student.getClass().getName()+ " numberInClass "+student.getNumberInClass()+
                    " Number shouldn't be negative ");
        }
    }
}
