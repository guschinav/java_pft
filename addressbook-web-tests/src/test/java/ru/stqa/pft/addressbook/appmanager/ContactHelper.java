package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {


    public ContactHelper(FirefoxDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void addNewContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillNewContact(ContactData contactData) {
        type(By.name("firstname"),contactData.getFirstname());
        type(By.name("middlename"),contactData.getMiddlename());
        type(By.name("lastname"),contactData.getLastname());
        type(By.name("mobile"),contactData.getMobile());
        type(By.name("email"),contactData.getEmail());
        type(By.name("address2"), contactData.getAddress2());
    }

    public void goToHomePage() {
        click(By.linkText("home"));
    }


    public void initContactModification() {
        click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    }

    public void updateContactModification() {
        click(By.name("update"));
    }

    public void choiceContact() {
        click(By.xpath("//input[@id='19']"));
    }

    public void deleateContact() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
    }
}
