package schoolproject.dao.impl;

import schoolproject.dao.LongIdGenerator;
import schoolproject.dao.RemarkRepository;

public class RemarkRepositoryImpl extends StudentFeedbackTempRepoImpl<String> implements RemarkRepository {

    public RemarkRepositoryImpl(LongIdGenerator idGenerator, String dbFileName) {
        super(idGenerator, dbFileName);
    }
}
