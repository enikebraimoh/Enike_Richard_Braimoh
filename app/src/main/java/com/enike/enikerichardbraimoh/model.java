package com.enike.enikerichardbraimoh;

public class model {
    String firstname;
    String lastname;
    String email;
    String country;
    String car_model;
    String car_model_year;
    String car_color;
    String gender;
    String job_title;
    String bio;

    public model(String firstname, String lastname, String email, String country, String car_model, String car_model_year, String car_color, String gender, String job_title, String bio) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.country = country;
        this.car_model = car_model;
        this.car_model_year = car_model_year;
        this.car_color = car_color;
        this.gender = gender;
        this.job_title = job_title;
        this.bio = bio;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCar_model() {
        return car_model;
    }

    public void setCar_model(String car_model) {
        this.car_model = car_model;
    }

    public String getCar_model_year() {
        return car_model_year;
    }

    public void setCar_model_year(String car_model_year) {
        this.car_model_year = car_model_year;
    }

    public String getCar_color() {
        return car_color;
    }

    public void setCar_color(String car_color) {
        this.car_color = car_color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
