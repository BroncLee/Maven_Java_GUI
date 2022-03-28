package com.lee.dao;

import com.lee.model.Student;
import com.lee.utils.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * com.lee.dao
 *
 * @Classname StudentDaoImp
 * @Description TODO
 * @auther Bronc
 * @Data 2022/3/14 星期一 11:35
 */


public class StudentDaoImp implements StudentDao{
    private static Connection conn = null;
    private static Statement stmt = null;
    private static PreparedStatement psmt = null;
    private static ResultSet rs= null;
    private static String sql = null;
    private static List<Student> stuList = null;

    //增
    @Override
    public int addStudent(Student student) {
        try {
            sql = "insert into stu(name, age, classes) values (?,?,?)";
            conn = JDBC.getConnection() ;
            psmt = conn.prepareStatement(sql);
            psmt.setString(1,student.getName());
            psmt.setInt(2,student.getAge());
            psmt.setString(3,student.getClasses());
            psmt.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                JDBC.free(rs,psmt,conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return 0;
    }
    //删
    @Override
    public int deleteStudent(Student s) {
        int _count = 0;
        try {
            conn = JDBC.getConnection();
            sql = "delete from stu where id = ?";
            psmt = conn.prepareStatement(sql);
            psmt.setInt(1, s.getId());
            _count = psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                JDBC.free(rs,psmt,conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return _count;
    }
    //改
    @Override
    public int updateStudent(Student s) {
        int _count = 0;
        try {
            conn = JDBC.getConnection();
            sql = "update stu set name = ? , age = ? , classes = ? where id = ?;";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1,s.getName());
            psmt.setInt(2,s.getAge());
            psmt.setString(3,s.getClasses());
            psmt.setInt(4,s.getId());
            _count = psmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                JDBC.free(rs,psmt,conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return _count;
    }
    //查
    @Override
    public List<Student> findStudent(String _name) {
        stuList = new ArrayList<Student>();
        try {
            conn = JDBC.getConnection();
            sql = "select * from stu where name = ?";
            psmt = conn.prepareStatement(sql);
            psmt.setString(1,_name);
            rs = psmt.executeQuery();
            while(rs.next()) {
                Student stud = new Student();
                stud.setId(rs.getInt(1));
                stud.setName(rs.getString(2));
                stud.setAge(rs.getInt(3));
                stud.setClasses(rs.getString(4));
                stuList.add(stud);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stuList;
    }

    @Override
    public List<Student> findAllStudent() {
        stuList = new ArrayList<Student>();
        try {
            conn = JDBC.getConnection();
            stmt = conn.createStatement();
            sql = "select * from stu";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                Student stud = new Student();
                stud.setId(rs.getInt(1));
                stud.setName(rs.getString(2));
                stud.setAge(rs.getInt(3));
                stud.setClasses(rs.getString(4));
                stuList.add(stud);
                // System.out.println(rs.getInt(1)+":"+rs.getString(2) +"--------- "+rs.getInt(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                JDBC.free(rs,stmt,conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return stuList;
    }

}



