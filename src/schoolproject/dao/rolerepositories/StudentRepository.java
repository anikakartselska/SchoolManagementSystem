package schoolproject.dao.rolerepositories;
import schoolproject.dao.AGRHelper;
import schoolproject.dao.Repository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.model.SchoolClass;
import schoolproject.model.Subject;
import schoolproject.model.roles.Parent;
import schoolproject.model.roles.Student;
import java.util.Collection;
import java.util.Comparator;

public interface StudentRepository extends UserRepository<Student>, Repository<Long,String,Student> {
    Student changeNumberInClass(Student student,int newNumber) throws EntityNotFoundException;
    Student changeSchoolClass(Student student, SchoolClass schoolClass) throws EntityNotFoundException;
    Student changeAverageGrade(Student student) throws EntityNotFoundException;
        Student addParent(Student student, Parent parent) throws EntityNotFoundException;
       Student addSubject(Student student, Subject subject)throws EntityNotFoundException;
     Student removeParent(Student student, Parent parent) throws EntityNotFoundException;
    Student removeSubject(Student student, Subject subject) throws EntityNotFoundException;
     Student updateParent(Student student,Parent parent) throws EntityNotFoundException;
    Student updateSubject(Student student, Subject subject) throws EntityNotFoundException;
    Collection<Student> findAllSorted(Comparator<Student> comparator);

}
