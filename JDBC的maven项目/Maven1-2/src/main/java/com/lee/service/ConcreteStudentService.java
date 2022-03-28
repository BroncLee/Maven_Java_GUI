package com.lee.service;

import com.lee.model.Student;
import com.lee.dao.StudentDaoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * com.lee.service
 *
 * @Classname ConcreteStudentService
 * @Description TODO
 * @auther Bronc
 * @Data 2022/3/14 ÐÇÆÚÒ» 17:39
 */


public class ConcreteStudentService implements StudentService{
    private static Connection conn;
    private static Statement stmt;
    private static PreparedStatement psmt;
    private static ResultSet rs;
    private static String sql;
    StudentDaoImp sdi = new StudentDaoImp();

    @Override
    public int add(Student stu) {
        return sdi.addStudent(stu);
    }

    @Override
    public int delete(Student stu) {
        return sdi.deleteStudent(stu);
    }

    @Override
    public int update(Student stu) {
        return sdi.updateStudent(stu);
    }

    @Override
    public List<Student> find(String name) {
        return sdi.findStudent(name);
    }

    @Override
    public List<Student> findAll() {
        return sdi.findAllStudent();
    }
}
