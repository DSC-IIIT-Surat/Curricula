package com.iam844.adityajaiswal.curricula.Model;

public class Subject {

    private String subListName;
    private String subCodeListName;
    private int subListImage;
    private Class subActivity;

    public Subject(String subListName, String subCodeListName, int subListImage, Class subActivity) {
        this.subListName = subListName;
        this.subCodeListName = subCodeListName;
        this.subListImage = subListImage;
        this.subActivity = subActivity;
    }

    public String getSubListName() {
        return subListName;
    }

    public String getSubCodeListName() {
        return subCodeListName;
    }

    public int getSubListImage() {
        return subListImage;
    }

    public Class getSubActivity() {
        return subActivity;
    }
}
