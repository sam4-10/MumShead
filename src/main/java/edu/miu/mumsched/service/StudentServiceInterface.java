package edu.miu.mumsched.service;

import edu.miu.mumsched.domain.Student;

public interface StudentServiceInterface {
    public void save(Student student);
    public Student getStudentByEmail(String email);
    public Student getStudentById(Long id);
}
