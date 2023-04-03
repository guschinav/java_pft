package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void addNewContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void fillNewContact(ContactData contactData, boolean creation) {
        type(By.name("firstname"),contactData.getFirstname());
        type(By.name("middlename"),contactData.getMiddlename());
        type(By.name("lastname"),contactData.getLastname());
        type(By.name("mobile"),contactData.getMobile());
        type(By.name("email"),contactData.getEmail());
        type(By.name("address2"), contactData.getAddress2());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }


    }


    public void initContactModification(int index) {
        wd.findElements(By.xpath("//img[@alt='Edit']")).get(index).click(); //выбор элемента по индексу
    }

    public void editContactById(int id){
        wd.findElement(By.xpath("//input[@value='" + id + "']/../..//td/a/img[@alt='Edit']")).click();
    }

    public void updateContactModification() {
        click(By.name("update"));
    }

    public void choiceAllContacts() {
        click(By.xpath("//div[@id='content']/form[2]/input[2]"));
    }

    public void deleateContact() {
        click(By.xpath("//input[@value='Delete']"));
        wd.switchTo().alert().accept();
        wd.findElement(By.cssSelector("div.msgbox")); // ждем появления окна о удалении
    }

    public void choiceContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }
    public void choiceContactById (int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "'")).click();
    }


    public void contact(ContactData contactData) {
        fillNewContact(contactData,true);
        addNewContact();
        contactCache = null;
        returnToHomePage();
    }

    public  void modifyContact(ContactData contact) {
        editContactById(contact.getId());
        fillNewContact(contact, false);
        updateContactModification();
        contactCache = null;
    }



    public void delete(ContactData contact) {
        choiceContactById(contact.getId());
        deleateContact();
        contactCache = null;

    }

    public boolean isThereAContact() {
        return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
    }


    public int count() {
       return wd.findElements(By.name("selected[]")).size();
    }

    public Contacts contactCache = null;





    public Contacts all() {
        if (contactCache != null){
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String lastName = element.findElement(By.xpath(".//td[2]")).getText();
            String firstName = element.findElement(By.xpath(".//td[3]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withId(id).withFirstname(firstName).withLastname(lastName);
            contactCache.add(contact);
        }
        return contactCache;
    }


}
