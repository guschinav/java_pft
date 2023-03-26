package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {

    private  int id;



    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String mobile;
    private final String email;
    private final String address2;
    private String group;




    public ContactData(String firstname, String middlename, String lastname, String mobile, String email, String address2, String group) {
        this.id = Integer.MAX_VALUE;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.mobile = mobile;
        this.email = email;
        this.address2 = address2;
        this.group = group;
    }

    public ContactData(int id, String firstname, String middlename, String lastname, String mobile, String email, String address2, String group) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.mobile = mobile;
        this.email = email;
        this.address2 = address2;
        this.group = group;
    }

    public int getId() {
        return id;
    }



    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMobile() {
        return mobile;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress2() {
        return address2;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (!Objects.equals(firstname, that.firstname)) return false;
        return Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        int result = firstname != null ? firstname.hashCode() : 0;
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    public void setId(int id) {
        this.id = id;
    }
}
