package com.monkey_bankee.model;

import java.sql.Timestamp;

public class Client {

    private int id;
    private String name;
    private String firstname;
    private String birthdate;
    private String email;
    private String tel;
    private String family_situation;
    private String current_account;
    private String regular_income;
    private String regular_spending;
    private String subscription;
    private String address_number;
    private String additional_address;
    private String street_address;
    private String postal_code;
    private String city_address;
    private Timestamp created_at;
    private Timestamp modified_at;

    public Client() {

    }

    public Client(int id, String name, String firstname, String birthdate, String email, String tel, String family_situation, String current_account, String regular_income, String regular_spending, String subscription, String address_number, String additional_address, String street_address, String postal_code, String city_address) {

        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.birthdate = birthdate;
        this.email = email;
        this.tel = tel;
        this.family_situation = family_situation;
        this.current_account = current_account;
        this.regular_income = regular_income;
        this.regular_spending = regular_spending;
        this.subscription = subscription;
        this.address_number = address_number;
        this.additional_address = additional_address;
        this.street_address = street_address;
        this.postal_code = postal_code;
        this.city_address = city_address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFamily_situation() {
        return family_situation;
    }

    public void setFamily_situation(String family_situation) {
        this.family_situation = family_situation;
    }

    public String getCurrent_account() {
        return current_account;
    }

    public void setCurrent_account(String current_account) {
        this.current_account = current_account;
    }

    public String getRegular_income() {
        return regular_income;
    }

    public void setRegular_income(String regular_income) {
        this.regular_income = regular_income;
    }

    public String getRegular_spending() {
        return regular_spending;
    }

    public void setRegular_spending(String regular_spending) {
        this.regular_spending = regular_spending;
    }

    public String getSubscription() {
        return subscription;
    }

    public void setSubscription(String subscription) {
        this.subscription = subscription;
    }

    public String getAddress_number() {
        return address_number;
    }

    public void setAddress_number(String address_number) {
        this.address_number = address_number;
    }

    public String getAdditional_address() {
        return additional_address;
    }

    public void setAdditional_address(String additional_address) {
        this.additional_address = additional_address;
    }

    public String getStreet_address() {
        return street_address;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getCity_address() {
        return city_address;
    }

    public void setCity_address(String city_address) {
        this.city_address = city_address;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getModified_at() {
        return modified_at;
    }

    public void setModified_at(Timestamp modified_at) {
        this.modified_at = modified_at;
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstname='" + firstname + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                ", family_situation='" + family_situation + '\'' +
                ", current_account='" + current_account + '\'' +
                ", regular_income='" + regular_income + '\'' +
                ", regular_spending='" + regular_spending + '\'' +
                ", subscription='" + subscription + '\'' +
                ", address_number='" + address_number + '\'' +
                ", additional_address='" + additional_address + '\'' +
                ", street_address='" + street_address + '\'' +
                ", postal_code='" + postal_code + '\'' +
                ", city_address='" + city_address + '\'' +
                ", created_at=" + created_at +
                ", modified_at=" + modified_at +
                '}';
    }
}

