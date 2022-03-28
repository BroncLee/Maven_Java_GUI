package com.lee.service;

import com.lee.model.Student;

import java.util.List;
import java.util.Set;

/**
 * com.lee.service
 *
 * @Classname StudentService
 * @Description TODO
 * @auther Bronc
 * @Data 2022/3/14 ÐÇÆÚÒ» 17:35
 */


public interface StudentService {
    public int add(Student stu);
    public int delete(Student stu);
    public int update(Student stu);
    public List<Student> find(String name);
    public List<Student> findAll();
}
