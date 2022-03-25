package schoolproject.dao;

import schoolproject.model.StudentFeedback;

import java.util.HashMap;

public interface IdentifiableAGR<K,S> extends Identifiable<K,S>{

    HashMap<Long, StudentFeedback.Absence> getAbsences();
    HashMap<Long, StudentFeedback.Remark> getRemarks();
    HashMap<Long, StudentFeedback.Grade> getGrades();
    void setRemarks(HashMap<Long, StudentFeedback.Remark> remarks);
    void setAbsences(HashMap<Long, StudentFeedback.Absence> absences);
    void setGrades(HashMap<Long, StudentFeedback.Grade> grades);
}
