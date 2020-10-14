package com.iam844.adityajaiswal.curricula.Model;

public class Semester {

    private int semListImage;
    private Class semActivity;

    public Semester() {
    }

    public Semester(int semListImage, Class semActivity) {
        this.semListImage = semListImage;
        this.semActivity = semActivity;
    }

    public int getSemListImage() {
        return semListImage;
    }

    public Class getSemActivity() {
        return semActivity;
    }
}
