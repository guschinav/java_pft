package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions (){
        app.getNavigationHelper().goToHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getNavigationHelper().goToGroupPage();
            if (!app.getGroupHelper().isThereAGroup()) {
                app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
            }
            app.getNavigationHelper().goToNewAddPage();
            String CurrentGroup = app.wd.findElement(By.xpath("//div[@id='content']/form/select[5]/option[2]")).getText();
            app.getContactHelper().createContact(new ContactData("John", "Silver", "Yellow", "+791115648594", "test@mail.ru", "New Orenburg", CurrentGroup));
            app.getNavigationHelper().goToHomePage();
        }
    }




    @Test

    public void testContactModification () {
        List<ContactData> before = app.getContactHelper().getContactList();
        int index = before.size() -1;
        ContactData contact = new ContactData(before.get(index).getId(),"Pupka", "Hello", "First", "+111111111111", "test@mail.ru", "New Orenburg", null);
        app.getContactHelper().modifyContact(index, contact);
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size() );

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);



    }

}




