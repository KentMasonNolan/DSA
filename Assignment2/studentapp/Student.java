/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment2.studentapp;


/**
 *
 * @author xhu
 */
public class Student {
    
    public String name;
    public Float score;

    public String getName() {
        return name;
    }


    public Student(){
        this.name = "default";
        this.score = null;
        this.comments = null;
    }
    public Student(String name, Float score) {
        this.name = name;
        this.score = score;
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, Float score, String comments) {
        this.name = name;
        this.score = score;
        this.comments = comments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String comments;

    @Override
    public String toString() {
        return this.name + "\n" + this.score + "\n" + this.comments;
    }
}
