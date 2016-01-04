package com.diyiliu.dao;

import com.diyiliu.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: StudentDao
 * Author: DIYILIU
 * Update: 2016-01-04 10:49
 */
public class StudentDao{

    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<Student> findAll(){

        String sql = "SELECT id,name,age,grade,teacher FROM student";

        List<Student> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(Student.class));

        if (list.size() == 0){
            return null;
        }

        return list;
    }
}
