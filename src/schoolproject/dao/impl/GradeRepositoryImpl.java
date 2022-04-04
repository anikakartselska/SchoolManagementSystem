package schoolproject.dao.impl;

import schoolproject.dao.GradeRepository;
import schoolproject.dao.impl.helperrepositories.LongIdGenerator;

public class GradeRepositoryImpl extends StudentFeedbackTempRepoImpl<Integer> implements GradeRepository {

    public GradeRepositoryImpl(LongIdGenerator idGenerator, String dbFileName) {
        super(idGenerator, dbFileName);
    }
}
