package com.yyq.pojo;

/**
 * Created by gao on 16-4-12.
 */
public class Student {
    //ѧ��Id
    private int id;
    //ѧ������
    private String name;
    //�༶
    private String myClass;
    //����
    private double score;

    //�ṩһ�������޲����Ĺ��췽��
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
