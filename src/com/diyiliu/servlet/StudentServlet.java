package com.diyiliu.servlet;

import com.diyiliu.dao.StudentDao;
import com.diyiliu.model.Student;
import com.diyiliu.model.TableData;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
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

public class StudentServlet extends HttpServlet{

    private StudentDao studentDao;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)  {

        System.out.println("doPost() ...");

        int draw = Integer.valueOf(req.getParameter("draw"));
        int start = Integer.valueOf(req.getParameter("start"));
        int length = Integer.valueOf(req.getParameter("length"));

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            int total = studentDao.findCount();
            List<Student> list = studentDao.findAll(start, length);
            TableData tableData = new TableData();
            tableData.setData(list);
            tableData.setDraw(draw);
            tableData.setRecordsTotal(total);
            tableData.setRecordsFiltered(total);

            //objectMapper.writeValue(resp.getWriter(), list);
            String result = objectMapper.writeValueAsString(tableData);
            System.out.println(result);

            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

}
