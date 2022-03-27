package schoolproject.dao.impl;

import schoolproject.dao.*;
import schoolproject.dao.impl.rolesrepoimpl.*;
import schoolproject.dao.rolerepositories.*;
import schoolproject.model.roles.User;

public class DaoFactoryImpl implements DaoFactory {
    @Override
    public HeadTeacherRepository createHeadTeacherRepository() {
       return new HeadTeacherRepositoryImpl();
    }

    @Override
    public ParentRepository createParentRepository() {
        return new ParentRepositoryImpl();
    }

    @Override
    public SchoolAdminRepository createSchoolAdminRepository() {
        return new SchoolAdminRepositoryImpl();
    }

    @Override
    public StudentRepository createStudentRepository() {
        return new StudentRepositoryImpl();
    }

    @Override
    public TeacherRepository createTeacherRepository() {
        return new TeacherRepositoryImpl();
    }

    @Override
    public UserRepository<User> createUserRepository() {
        return new UserRepositoryImpl<User>();
    }

    @Override
    public AbsenceRepository createAbsenceRepository() {
        return new AbsenceRepositoryImpl();
    }

    @Override
    public GradeRepository createGradeRepository() {
        return new GradeRepositoryImpl();
    }

    @Override
    public RemarkRepository createRemarkRepository() {
        return new RemarkRepositoryImpl();
    }

    @Override
    public SchoolClassRepo createSchoolClassRepository() {
        return new SchoolClassRepoImpl();
    }

    @Override
    public SubjectRepository createSubjectRepository() {
        return new SubjectRepositoryImpl();
    }

    @Override
    public LessonRepository createLessonRepository() {
        return new LessonRepositoryImpl();
    }
}
