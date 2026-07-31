package com.sarthak.student_api.service;


import com.sarthak.student_api.exception.StudentNotFoundException;
import com.sarthak.student_api.model.Student;
import com.sarthak.student_api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }
    public Student getStudentById(long id){
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }
    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public Student updateStudent(Long id,Student updatedStudent){
        Student existing = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));

        existing.setName(updatedStudent.getName());
        existing.setEmail(updatedStudent.getEmail());
        existing.setBranch(updatedStudent.getBranch());

        return studentRepository.save(existing);
    }

    public String deleteStudent(Long id){
        if (!studentRepository.existsById(id)){
            throw new StudentNotFoundException(id);
        }
        studentRepository.deleteById(id);
        return "Student with id "+id+" deleted successfully";
    }

}
