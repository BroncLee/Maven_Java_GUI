package com.lee.dao;

import com.lee.model.Student;

import java.util.List;
import java.util.Set;

/**
 * com.lee.dao
 *
 * @Classname StudentDao
 * @Description TODO
 * @auther Bronc
 * @Data 2022/3/14 ÐÇÆÚÒ» 11:35
 */


public interface StudentDao {
    public int addStudent(Student student);
    public int deleteStudent(Student student);
    public int updateStudent(Student student);
    public List<Student> findStudent(String name);
    public List<Student> findAllStudent();
}
