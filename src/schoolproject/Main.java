package schoolproject;

import schoolproject.dao.AbsenceRepository;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.impl.AbsenceRepositoryImpl;
import schoolproject.dao.impl.rolesrepoimpl.StudentRepositoryImpl;
import schoolproject.model.StudentFeedback;
import schoolproject.model.Subject;
import schoolproject.model.roles.Student;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        AbsenceRepository absenceRepository=new AbsenceRepositoryImpl();
        StudentFeedback sf=new StudentFeedback();
        absenceRepository.add(sf.new Absence(LocalDateTime.now(),new Subject(),new Student(),0.5));
        absenceRepository.add(sf.new Absence(LocalDateTime.now(),new Subject(),new Student(),1.0));


        try {
            absenceRepository.changeValue(absenceRepository.findById(2L),1.11) ;
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
        for(StudentFeedback.Template<Double> absence:absenceRepository.findAll())
        {
            System.out.println(absence);
        }
        StudentRepositoryImpl studentRepository=new StudentRepositoryImpl();
       studentRepository.add(new Student());
        System.out.println(studentRepository.findById(1L));



    }
}

