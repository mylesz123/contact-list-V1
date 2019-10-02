package com.example.contactlist;

import android.text.format.Time;

import java.util.Calendar;

public class Contact {

    private int contactID;
    private boolean bff;
    private String contactName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String cellNumber;
    private String eMail;
    private Calendar birthday;

    public Contact() {
        contactID = -1;
        birthday = Calendar.getInstance();
    }

    public int getContactID() {
        return contactID;
    }

    public void setContactID(int i) {
        this.contactID = i;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String s) {
        this.contactName = s;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar c) { this.birthday = c; }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String s) {
        this.streetAddress = s;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String s) {
        this.city = s;
    }

    public String getState() {
        return state;
    }

    public void setState(String s) {
        this.state = s;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String s) {
        this.zipCode = s;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String s) {
        this.phoneNumber = s;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(String s) {
        this.cellNumber = s;
    }

    public void setEMail(String s) {
        this.eMail = s;
    }

    public String getEMail() {
        return eMail;
    }

    public boolean getBff() { return bff; }

    public void setBff(boolean bff) {
        this.bff = bff;
    }

}
