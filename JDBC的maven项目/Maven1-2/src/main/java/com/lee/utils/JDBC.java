package com.lee.utils;

import com.alibaba.druid.pool.DruidAbstractDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.lee.view.Gui;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

import static com.alibaba.druid.pool.DruidDataSourceFactory.createDataSource;

/**
 * com.lee.utils
 *
 * @Classname JDBC
 * @Description TODO
 * @auther Bronc
 * @Data 2022/3/14 ÐÇÆÚÒ» 11:31
 */

public class JDBC {
    public static void free(ResultSet rs, Statement stmt, Connection conn) throws SQLException {
        rs.close();
        stmt.close();
        conn.close();
    }
    public static void free( ResultSet rs,PreparedStatement psmt, Connection conn) throws SQLException {
        rs.close();
        psmt.close();
        conn.close();
    }
    public static void free( PreparedStatement psmt, Connection conn) throws SQLException {
        psmt.close();
        conn.close();
    }
    public static Connection getConnection() throws Exception {
        Properties pro = new Properties();
        //InputStream is = JDBC.class.getClassLoader().getResourceAsStream("druid.properties");
        InputStream is = JDBC.class.getResourceAsStream("/druid.properties");
        pro.load(is);
        DataSource datasource = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = datasource.getConnection();
        return conn;
    }
}
