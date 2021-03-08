package edu.miu.mumsched.serviceImpl;

import edu.miu.mumsched.domain.Student;
import edu.miu.mumsched.repository.StudentRepository;
import edu.miu.mumsched.service.StudentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentServiceInterface {
@Autowired
    StudentRepository studentRepository;

    @Override
    public void save(Student student) {
        studentRepository.save(student);

    }

    @Override
    public Student getStudentByEmail(String email) {
       return studentRepository.findStudentByEmail(email);
       // return null;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findStudentById(id);
    }
}
