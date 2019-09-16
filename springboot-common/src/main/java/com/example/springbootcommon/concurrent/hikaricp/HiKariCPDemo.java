package com.example.springbootcommon.concurrent.hikaricp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/7/16
 * Time  : 9:14 AM
 */
public class HiKariCPDemo {
    public static void main(String[] args) {
        HikariConfig config = new HikariConfig();
        config.setMinimumIdle(1);;
        config.setMaximumPoolSize(2);
        config.setConnectionTestQuery("Select 1");

//        config.setDataSourceClassName("org.h2.jdbcx.JdbcDataSource");
        config.addDataSourceProperty("jdbcUrl", "jdbc:mysql://127.0.0.1:3306/test");
        config.addDataSourceProperty("username", "root");
        config.addDataSourceProperty("password", "root");

        DataSource ds = new HikariDataSource(config);
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = ds.getConnection();
            stmt = conn.createStatement();
            rs =  stmt.executeQuery("select * from test");
            while (rs.next()) {
                System.out.println(rs);
            }
        } catch (Exception e) {
            close(rs);
            close(stmt);
            close(conn);
        }
    }

    public static void close (AutoCloseable rs) {
        if (rs != null) {
            try {
                rs.close();
            }catch (Exception e) {

            }
        }
    }
}
