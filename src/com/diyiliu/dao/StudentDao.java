package com.diyiliu.dao;

import com.diyiliu.model.Student;
import org.springframework.dao.support.DaoSupport;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * Description: StudentDao
 * Author: DIYILIU
 * Update: 2016-01-04 10:49
 */
public class StudentDao extends JdbcDaoSupport{

    public List<Student> findAll(){

        String sql = "SELECT id,name,age,grade,teacher FROM student";

        List<Student> list = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Student.class));

        if (list.size() == 0){
            return null;
        }

        return list;
    }
}
