package com.diyiliu.servlet;

import com.diyiliu.dao.StudentDao;
import com.diyiliu.model.Student;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Description: StudentServlet
 * Author: DIYILIU
 * Update: 2016-01-04 10:28
 */

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet{

    @Resource
    private StudentDao studentDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {

        try {
            System.out.println("doPost() ...");

            List<Student> list = studentDao.findAll();

            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
}