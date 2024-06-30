package com.wm.project.project.entity;

import java.io.Serializable;

/**
 * (Schooldatabase)实体类
 *
 * @author zyf
 * @since 2022-03-15 16:22:23
 */
public class Schooldatabase implements Serializable {
    private static final long serialVersionUID = -91000426537908991L;
    /**
     * 学校数据库id
     */
    private String id;
    /**
     * 学号
     */
    private String studentNumber;
    /**
     * 姓名
     */
    private String studentName;
    /**
     * 班级
     */
    private String studentClass;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

}
