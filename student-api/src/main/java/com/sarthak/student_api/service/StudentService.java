package com.sarthak.student_api.service;


import com.sarthak.student_api.model.Student;
import com.sarthak.student_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public Optional<Student> getStudentById(long id){
        return studentRepository.findById(id);
    }
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id,Student updatedStudent){
        Student existing = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found of Id: "+id));

        existing.setName(updatedStudent.getName());
        existing.setEmail(updatedStudent.getEmail());
        existing.setBranch(updatedStudent.getBranch());

        return studentRepository.save(existing);
    }

    public String deleteStudent(Long id){
        studentRepository.deleteById(id);
        return "Student with id "+id+" deleted successfully";
    }

}
