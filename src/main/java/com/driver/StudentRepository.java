package com.driver;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {

    private static HashMap<String, Student> StudentDb;
    private static HashMap<String, Teacher> TeacherDb;
    private static HashMap<String, List<String>> StudentTeacherDb;

    public StudentRepository() {
        this.StudentDb = new HashMap<String, Student>();
        this.TeacherDb = new HashMap<String, Teacher>();
        this.StudentTeacherDb = new HashMap<String, List<String>> ();
    }

    //Adding the student to database
    public static void addStudentToDatabsae(Student student){
        StudentDb.put(student.getName(),student);
    }

    //Adding the teacher to database
    public static void addTeacherToDatabase(Teacher teacher){
        TeacherDb.put(teacher.getName(),teacher);
    }

    //Add student teacher pair to database
    public static void  addStudentTeacherPairToDatabase(String student, String teacher){
        List<String> studentsList = new ArrayList<>();
        if(StudentDb.containsKey(student) && TeacherDb.containsKey(teacher)){

            if(StudentTeacherDb.containsKey(teacher)){
                studentsList = StudentTeacherDb.get(teacher);

            }
            studentsList.add(student);
            StudentTeacherDb.put(teacher,studentsList);
        }
    }

    //Getting Student by student name from database
    public static Student getStudentByNameFromDatabase(String name){

        Student student = null;
        if(StudentDb.containsKey(name)){
            student = StudentDb.get(name);
        }
        return student;
    }

    //Getting Teacher by name from database
    public static Teacher getTeacherByNameFromDatabase(String name){
        Teacher teacher = null;
        if(TeacherDb.containsKey(name)){
            teacher=TeacherDb.get(name);
        }
        return teacher;
    }

    //Getting Students from database by teacher name
    public static List<String> getStudentsByTeacherNameFromDatabase(String name){

        List<String> students = new ArrayList<>();
        if(StudentTeacherDb.containsKey(name)){
            students = StudentTeacherDb.get(name);
        }
        return students;
    }

    //Getting list of all Students  from database
    public static List<String> getAllStudentsAddedFromDatabase(){
        List<String> students=new ArrayList<>();
        for(String student: StudentDb.keySet()){
            students.add(student);
        }
        return students;
    }

    //Delete teacher by  name from database
    public static void deleteTeacherByNameFromDatabase(String teacherName){
        List<String> students = new ArrayList<>();
        if(StudentTeacherDb.containsKey(teacherName)) {
            students = StudentTeacherDb.get(teacherName);

            for(String student : students){
                if(StudentDb.containsKey(student)){
                    StudentDb.remove(student);
                }
            }
            StudentTeacherDb.remove(teacherName);
        }
        if(TeacherDb.containsKey(teacherName)){
            TeacherDb.remove(teacherName);
        }
    }


    //Delete all teachers from database
    public static void deleteAllTeachersFromDatabase(){

        TeacherDb = new HashMap<>();

        for(String teachers : StudentTeacherDb.keySet()){
            List<String> students = new ArrayList<>();
            for(String student : StudentTeacherDb.get(teachers)) {
                students.add(student);
            }
            for(String name: students){
                if(StudentDb.containsKey(name)){
                    StudentDb.remove(name);
                }
            }
        }
        StudentTeacherDb=new HashMap<>();
    }
}
