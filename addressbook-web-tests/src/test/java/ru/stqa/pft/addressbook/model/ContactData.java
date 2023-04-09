package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@Entity
@Table(name = "addressbook")
@XStreamAlias("contact")
public class ContactData {

    @XStreamOmitField
    @Id
    @Column(name = "id")
    private  int id= Integer.MAX_VALUE;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "middlename")
    private String middlename;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "nickname")
    private String nickname;
    @Column(name = "company")
    private String company;
    @Column(name = "address")
    @Type(type = "text")
    private String address;
    @Column(name = "mobile")
    @Type(type = "text")
    private String mobile;
    @Column(name = "work")
    @Type(type = "text")
    private String workphone;
    @Transient
    private String group;
    @Column(name = "home")
    @Type(type = "text")
    private String homephone;
    @Transient
    private String allPhones;
    @Column(name = "email")
    @Type(type = "text")
    private String email;
    @Column(name = "email2")
    @Type(type = "text")
    private String email2;
    @Column(name = "email3")
    @Type(type = "text")
    private String email3;
    @Transient
    private String allEmails;
    @Column(name="photo")
    @Type(type = "text")
    private String photo;


    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }


    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withHomePhone(String homephone) {
        this.homephone = homephone;
        return this;
    }

    public ContactData withWorkPhone(String workphone) {
        this.workphone = workphone;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }


    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }



    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }
    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (!Objects.equals(firstname, that.firstname)) return false;
        return Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
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
    public String getWorkPhone() {
        return workphone;
    }

    public String getAddress() {
        return address;
    }

    public String getGroup() {
        return group;
    }
    public File getPhoto() {
        return new File(photo);
    }




    public void setId(int id) {
        this.id = id;
    }


    public String getHomephone() {
        return homephone;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCompany() {
        return company;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getAllEmails() {
        return allEmails;
    }



}
