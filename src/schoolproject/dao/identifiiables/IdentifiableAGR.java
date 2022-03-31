package schoolproject.dao.identifiiables;

import schoolproject.dao.identifiiables.Identifiable;
import schoolproject.model.StudentFeedback;
import schoolproject.model.roles.Student;

import java.util.HashMap;

public interface IdentifiableAGR<K,S> extends Identifiable<K,S> {

    HashMap<Student, StudentFeedback> getFeedbacks();

     void setFeedbacks(HashMap<Student, StudentFeedback> feedbacks);

}
