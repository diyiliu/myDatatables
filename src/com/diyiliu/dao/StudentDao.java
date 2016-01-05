package com.diyiliu.dao;

import com.diyiliu.model.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * Description: StudentDao
 * Author: DIYILIU
 * Update: 2016-01-04 10:49
 */
public class StudentDao extends JdbcDaoSupport{

    public List<Student> findAll(int index, int size){

        String sql = "SELECT id,name,age,grade,teacher FROM student limit ?,?";

        List<Student> list = getJdbcTemplate().query(sql, new BeanPropertyRowMapper(Student.class), new Object[]{index, size});

        if (list.size() == 0){
            return null;
        }

        return list;
    }

    public int findCount(){

        String sql = "SELECT count(1) FROM student";

        return getJdbcTemplate().queryForObject(sql, Integer.class);
    }
}
