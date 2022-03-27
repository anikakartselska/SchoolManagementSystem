package schoolproject.util;

import schoolproject.dao.exceptions.InvalidEntityDataException;
import schoolproject.dao.rolerepositories.UserRepository;
import schoolproject.model.roles.Parent;
import schoolproject.model.roles.Student;

public class ValidStudent {
    private UserRepository userRepository;

    public ValidStudent(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validate(Student student) throws InvalidEntityDataException {
        new ValidUser(userRepository).validate(student);

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
