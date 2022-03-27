package schoolproject;

import schoolproject.dao.AbsenceRepository;
import schoolproject.dao.SubjectRepository;
import schoolproject.dao.exceptions.BusyClassException;
import schoolproject.dao.exceptions.EntityNotFoundException;
import schoolproject.dao.impl.AbsenceRepositoryImpl;
import schoolproject.dao.impl.SubjectRepositoryImpl;
import schoolproject.dao.impl.rolesrepoimpl.StudentRepositoryImpl;
import schoolproject.dao.impl.rolesrepoimpl.TeacherRepositoryImpl;
import schoolproject.dao.rolerepositories.TeacherRepository;
import schoolproject.model.StudentFeedback;
import schoolproject.model.Subject;
import schoolproject.model.roles.Student;
import schoolproject.model.roles.Teacher;

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
        SubjectRepository sr=new SubjectRepositoryImpl();
        sr.add(new Subject());
        TeacherRepository tr=new TeacherRepositoryImpl();
        tr.add(new Teacher());
        try {
            tr.addSubjectToProgram(tr.findById(1L),3,3,sr.findById(1L));
            tr.addSubjectToProgram(tr.findById(1L),4,3,sr.findById(1L));
        } catch (BusyClassException e) {
            e.printStackTrace();
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(tr.findById(1L));
       /* try {
            tr.removeSubjectFromWholeProgram(tr.findById(1L),sr.findById(1L));
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(tr.findById(1L));*/
        sr.findById(1L).setSubName("Anika");
        try {
            tr.updateSubjectInWholeProgram(tr.findById(1L),sr.findById(1L));
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(tr.findById(1L));


    }
}

