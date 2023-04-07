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
        type(By.name("nickname"),contactData.getNickname());
        type(By.name("company"),contactData.getCompany());
        type(By.name("address"),contactData.getAddress());
        type(By.name("mobile"),contactData.getMobile());
        type(By.name("work"), contactData.getWorkPhone());
        type(By.name("email"),contactData.getEmail());
        type(By.name("email2"),contactData.getEmail2());
        type(By.name("email3"),contactData.getEmail3());
        attach(By.name("photo"),contactData.getPhoto());

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
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            String address = cells.get(3).getText();
            String allPhones = cells.get(5).getText();
            String allEmails = cells.get(4).getText();
            ContactData contact = new ContactData().withId(id).withFirstname(firstname).withMiddlename(null).withLastname(lastname)
                    .withNickname(null).withCompany(null).withAddress(null)
                    .withAllPhones(allPhones).withGroup(null)
                    .withNickname(null).withCompany(null).withAddress(address).withAllEmails(allEmails).withGroup(null);
            contactCache.add(contact);
        }
        return new Contacts(contactCache);
    }


    public ContactData infoFromEditForm(ContactData contact) {
        editContactById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();

        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname).withMiddlename(middlename).withAddress(address)
                .withHomePhone(home).withMobile(mobile).withWorkPhone(work)
                .withEmail(email).withEmail2(email2).withEmail3(email3);
    }

}

