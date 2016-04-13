package com.yyq.pojo;

/**
 * Created by gao on 16-4-12.
 */
public class Student {
    //学生Id
    private int id;
    //学生姓名
    private String name;
    //班级
    private String myClass;
    //分数
    private double score;

    //提供一个公共无参数的构造方法
    public Student(){

    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the myClass
     */
    public String getMyClass() {
        return myClass;
    }

    /**
     * @param myClass the myClass to set
     */
    public void setMyClass(String myClass) {
        this.myClass = myClass;
    }

    /**
     * @return the score
     */
    public double getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(double score) {
        this.score = score;
    }
}
