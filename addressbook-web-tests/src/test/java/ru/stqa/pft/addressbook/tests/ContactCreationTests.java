package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {




    @Test
    public void testAddNewContact() {
        app.goTo().HomePage();
        Contacts before = app.contact().all();
        app.goTo().goToNewAddPage();
        if (!app.group().checkGroup()) {
            app.goTo().GroupPage();
            app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
            app.goTo().goToNewAddPage();
        }
        String CurrentGroup = app.wd.findElement(By.xpath("//div[@id='content']/form/select[5]/option[2]")).getText();
        File photo = new File("src/test/resources/test.png");
        ContactData contact = new ContactData().withFirstname("Anton").withMiddlename("Ivanocih").withLastname("Test")
                .withNickname("Omut").withCompany("TestCp").withAddress("test test test").withMobile("+79211111111")
                .withWorkPhone("+7864578").withGroup(CurrentGroup). withPhoto(photo);
        app.contact().contact(contact);
        app.goTo().HomePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) ->c.getId()).max().getAsInt()))));
    }






}

