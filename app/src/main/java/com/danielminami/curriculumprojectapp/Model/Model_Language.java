package com.danielminami.curriculumprojectapp.Model;

import com.google.gson.annotations.SerializedName;

public class Model_Language {

    @SerializedName("createdAt")
    private String createdAt;
    @SerializedName("updatedAt")
    private String updatedAt;
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("cefr")
    private String cefr;
    @SerializedName("test_taken")
    private String test_taken;
    @SerializedName("year")
    private String year;

    public Model_Language(String createdAt, String updatedAt, Integer id, String name, String cefr, String test_taken, String year) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.id = id;
        this.name = name;
        this.cefr = cefr;
        this.test_taken = test_taken;
        this.year = year;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCefr() {
        return cefr;
    }

    public void setCefr(String cefr) {
        this.cefr = cefr;
    }

    public String getTest_taken() {
        return test_taken;
    }

    public void setTest_taken(String test_taken) {
        this.test_taken = test_taken;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
