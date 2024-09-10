package com.example.repo;


import com.example.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
@Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void save(Student s) {

        String sql = "insert into student (rollno ,name,marks) values(?,?,?)";
       int rows= jdbcTemplate.update(sql, s.getRollno(), s.getName(), s.getMarks());
        System.out.println(rows + " rows inserted");

    }

    public List<Student> findAll() {
       String sql = "select * from student";
      RowMapper<Student> rowMapper = new BeanPropertyRowMapper<Student>(Student.class);
      return jdbcTemplate.query(sql, rowMapper);
    }

}
