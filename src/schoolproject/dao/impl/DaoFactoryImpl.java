package schoolproject.dao.impl;

import schoolproject.dao.*;
import schoolproject.dao.impl.rolesrepoimpl.*;
import schoolproject.dao.rolerepositories.*;
import schoolproject.model.roles.User;

public class DaoFactoryImpl implements DaoFactory {
    @Override
    public HeadTeacherRepository createHeadTeacherRepository() {
       return new HeadTeacherRepositoryImpl(new LongIdGenerator());
    }

    @Override
    public ParentRepository createParentRepository() {
        return new ParentRepositoryImpl(new LongIdGenerator());
    }

    @Override
    public SchoolAdminRepository createSchoolAdminRepository() {
        return new SchoolAdminRepositoryImpl(new LongIdGenerator());
    }

    @Override
    public StudentRepository createStudentRepository() {
        return new StudentRepositoryImpl(new LongIdGenerator());
    }

    @Override
    public TeacherRepository createTeacherRepository() {
        return new TeacherRepositoryImpl(new LongIdGenerator());
    }

    @Override
    public UserRepository<User> createUserRepository() {
        return new UserRepositoryImpl<>(new LongIdGenerator());
    }

    @Override
    public AbsenceRepository createAbsenceRepository() {
        return new AbsenceRepositoryImpl(new LongIdGenerator());
    }

    @Override
    public GradeRepository createGradeRepository() {
        return new GradeRepositoryImpl(new LongIdGenerator());
    }

    @Override
    public RemarkRepository createRemarkRepository() {
        return new RemarkRepositoryImpl(new LongIdGenerator());
    }

    @Override
    public SchoolClassRepo createSchoolClassRepository() {
       return new SchoolClassRepoImpl(new LongIdGenerator());
    }

    @Override
    public SubjectRepository createSubjectRepository() {

        return new SubjectRepositoryImpl(new LongIdGenerator());
    }

    @Override
    public LessonRepository createLessonRepository() {
        return new LessonRepositoryImpl(new LongIdGenerator());
    }
}
