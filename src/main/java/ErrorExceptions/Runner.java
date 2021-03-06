package ErrorExceptions;

import ErrorExceptions.Exceptions.*;
import ErrorExceptions.University.*;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args){
        University university = initializeUniversity();

        System.out.println("Enter second name student, whose average mark of subject you want to get(Sopot, Nichiporovich, Mironchick, Sushko, Kot) ");
        Scanner scanner = new Scanner(System.in);
        String enteredName = scanner.nextLine();

        try {
            Student enteredStudent = university.getStudent(enteredName);
            System.out.println("Average mark of all subjects for " + enteredStudent.getName() + " - " + enteredStudent.tryToGetAverageMarkOfAllSubjectsForStudent());
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Enter group, in with you want to get average mark of subject (871502, 871501, 871303, 871304) ");
        String enteredGroup = scanner.nextLine();
        Subject subjectMath = null;
        try {
            subjectMath = Subject.getSubject("math");
        } catch (SubjectDoesntExistException e) {
            System.out.println(e.getMessage());
        }

        Subject subjectEnglish = null;
        try {
            subjectEnglish = Subject.getSubject("english");
        } catch (SubjectDoesntExistException e) {
            System.out.println(e.getMessage());
        }

        Subject subjectPsychology = null;
        try {
            subjectPsychology = Subject.getSubject("psychology");
        } catch (SubjectDoesntExistException e) {
            System.out.println(e.getMessage());
        }

        try {
            Group group = university.getGroup(enteredGroup);
            System.out.println("Average mark of " + subjectMath.getNameSubject() + " in " + group.getName() + " - " + group.getAverageMarkOfSubjectInParticularGroup(subjectMath));
        }catch (LackOfStudentsException e){
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Enter faculty, in with you want to get average mark of subject (ief, ksis, fkp) ");
        String enteredFaculty = scanner.nextLine();
        try{
            Faculty faculty = university.getFaculty(enteredFaculty);
            System.out.println("Average mark of " + subjectEnglish.getNameSubject() + " in " + faculty.getName() + " - " + faculty.getAverageMarkOfSubjectForParticularFaculty(subjectEnglish));
        } catch (LackOfGroupsException e) {
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } catch (FacultyDoesntExistException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Average mark of " + subjectPsychology.getNameSubject() + " in " + university.getName() + " - " + university.getAverageMarkOfSubjectForUniversity(subjectPsychology));
        } catch (LackOfFacultiesException e) {
            System.out.println(e.getMessage());
        }

    }

    public static University initializeUniversity(){
        University university = new University("Belarusian State University of Informatics and Radioelectronics");
        Faculty ief = new Faculty("IEF");
        Faculty fkp = new Faculty("FKP");
        Faculty ksis = new Faculty("KSIS");
        university.addFacultyIntoList(ief);
        university.addFacultyIntoList(fkp);
        university.addFacultyIntoList(ksis);

        Group group871502 = new Group("871502");
        ief.addGroupIntoList(group871502);
        Group group871501 = new Group("871501");
        ief.addGroupIntoList(group871501);
        Group group871304 = new Group("871304");
        fkp.addGroupIntoList(group871304);
        Group group871303 = new Group("871303");
        fkp.addGroupIntoList(group871303);

        Student sopot = new Student("Sopot");
        group871502.addStudentIntoList(sopot);
        Student mironchick = new Student("Mironchick");
        group871502.addStudentIntoList(mironchick);
        Student kot = new Student("Kot");
        group871501.addStudentIntoList(kot);
        Student sushko = new Student("Sushko");
        group871501.addStudentIntoList(sushko);
        Student nichiporovich = new Student("Nichiporovich");
        group871304.addStudentIntoList(nichiporovich);

        Subject math = new Subject("Math");
        math.addSubjectIntoList(math);
        Subject psychology = new Subject("Psychology");
        psychology.addSubjectIntoList(psychology);
        Subject english = new Subject("English");
        english.addSubjectIntoList(english);

        sopot.tryToAddMarkAndSubject(math, 9);
        sopot.tryToAddMarkAndSubject(psychology, 8);
        sopot.tryToAddMarkAndSubject(english, 6);
        mironchick.tryToAddMarkAndSubject(math, 8);
        nichiporovich.tryToAddMarkAndSubject(math, 7);
        sushko.tryToAddMarkAndSubject(math, 7);
        kot.tryToAddMarkAndSubject(math, 10);

        return university;
    }
}
