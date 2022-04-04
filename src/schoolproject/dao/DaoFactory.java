package schoolproject.dao;

import schoolproject.dao.rolerepositories.*;
import schoolproject.model.Lesson;
import schoolproject.model.roles.User;

public interface DaoFactory {
    HeadTeacherRepository createHeadTeacherRepository(String fileName);
    ParentRepository createParentRepository(String fileName);
    SchoolAdminRepository createSchoolAdminRepository(String fileName);
    StudentRepository createStudentRepository(String fileName);
    TeacherRepository createTeacherRepository(String fileName);
    UserRepository<User> createUserRepository(String fileName);
    AbsenceRepository createAbsenceRepository(String fileName);
    GradeRepository createGradeRepository(String fileName);
    RemarkRepository createRemarkRepository(String fileName);
    SchoolClassRepo createSchoolClassRepository(String fileName);
    SubjectRepository createSubjectRepository(String fileName);
    LessonRepository createLessonRepository(String fileName);
}
