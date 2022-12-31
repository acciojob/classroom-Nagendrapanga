package com.driver;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentService {
    @Autowired
    StudentRepository studentrepository;
    //adding student at service layer
    public static void addStudentService(Student student){
        StudentRepository.addStudentToDatabsae(student);
    }

    //Adding teacher at service layer
    public static void addTeacherService(Teacher teacher){
        StudentRepository.addTeacherToDatabase(teacher);
    }

    //Adding student and teacher pair at service layer
    public static void addStudentTeacherPair(String student, String teacher){

        StudentRepository.addStudentTeacherPairToDatabase(student,teacher);
    }

    //Getting the  student by name at service layer
    public static Student getStudentByName(String name){

        Student student=StudentRepository.getStudentByNameFromDatabase(name);
        return student;
    }

    //getting the teacher by name at service layer
    public static Teacher getTeacherBYName(String name){
        Teacher teacher= StudentRepository.getTeacherByNameFromDatabase(name);
        return teacher;
    }

    //geting the  Students by teacher name
    public static List<String> getstudentbyTeachername(String name){
        return StudentRepository.getStudentsByTeacherNameFromDatabase(name);
    }

    //geting the  all students add at service layer
    public static List<String> getAllStudents(){
        return StudentRepository.getAllStudentsAddedFromDatabase();
    }

    //Deleting the teacher by name at service layer
    public static void deleteTeacherbyName(String name){
        StudentRepository.deleteTeacherByNameFromDatabase(name);
    }

    //Deleteing the  All Teachers
    public static void deleteAllTeahers(){
        StudentRepository.deleteAllTeachersFromDatabase();
    }

}
