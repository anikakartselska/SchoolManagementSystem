package schoolproject.dao.impl;

import schoolproject.dao.GradeRepository;
import schoolproject.dao.LongIdGenerator;

public class GradeRepositoryImpl extends StudentFeedbackTempRepoImpl<Integer> implements GradeRepository {
    public GradeRepositoryImpl(LongIdGenerator idGenerator) {
        super(idGenerator);
    }
}
