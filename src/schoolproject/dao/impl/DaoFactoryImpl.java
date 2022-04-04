package schoolproject.dao.impl;

import schoolproject.dao.*;
import schoolproject.dao.impl.rolesrepoimpl.*;
import schoolproject.dao.rolerepositories.*;
import schoolproject.model.roles.User;

public class DaoFactoryImpl implements DaoFactory {
    @Override
    public HeadTeacherRepository createHeadTeacherRepository(String fileName) {
       return new HeadTeacherRepositoryImpl(new LongIdGenerator(),fileName);
    }

    @Override
    public ParentRepository createParentRepository(String fileName) {
        return new ParentRepositoryImpl(new LongIdGenerator(),fileName);
    }

    @Override
    public SchoolAdminRepository createSchoolAdminRepository(String fileName) {
        return new SchoolAdminRepositoryImpl(new LongIdGenerator(),fileName);
    }

    @Override
    public StudentRepository createStudentRepository(String fileName) {
        return new StudentRepositoryImpl(new LongIdGenerator(),fileName);
    }

    @Override
    public TeacherRepository createTeacherRepository(String fileName) {
        return new TeacherRepositoryImpl(new LongIdGenerator(),fileName);
    }

    @Override
    public UserRepository<User> createUserRepository(String fileName) {
        return new UserRepositoryImpl<>(new LongIdGenerator(),fileName);
    }

    @Override
    public AbsenceRepository createAbsenceRepository(String fileName) {
        return new AbsenceRepositoryImpl(new LongIdGenerator(),fileName);
    }

    @Override
    public GradeRepository createGradeRepository(String fileName) {
        return new GradeRepositoryImpl(new LongIdGenerator(),fileName);
    }

    @Override
    public RemarkRepository createRemarkRepository(String fileName) {
        return new RemarkRepositoryImpl(new LongIdGenerator(),fileName);
    }

    @Override
    public SchoolClassRepo createSchoolClassRepository(String fileName) {
       return new SchoolClassRepoImpl(new LongIdGenerator(),fileName);
    }

    @Override
    public SubjectRepository createSubjectRepository(String fileName) {

        return new SubjectRepositoryImpl(new LongIdGenerator(),fileName);
    }

    @Override
    public LessonRepository createLessonRepository(String fileName) {
        return new LessonRepositoryImpl(new LongIdGenerator(),fileName);
    }
}
