package schoolproject.dao;

import schoolproject.dao.rolerepositories.*;
import schoolproject.model.Lesson;
import schoolproject.model.roles.User;

public interface DaoFactory {
    HeadTeacherRepository createHeadTeacherRepository();
    ParentRepository createParentRepository();
    SchoolAdminRepository createSchoolAdminRepository();
    StudentRepository createStudentRepository();
    TeacherRepository createTeacherRepository();
    UserRepository<User> createUserRepository();
    AbsenceRepository createAbsenceRepository();
    GradeRepository createGradeRepository();
    RemarkRepository createRemarkRepository();
    SchoolClassRepo createSchoolClassRepository();
    SubjectRepository createSubjectRepository();
    LessonRepository createLessonRepository();
}
