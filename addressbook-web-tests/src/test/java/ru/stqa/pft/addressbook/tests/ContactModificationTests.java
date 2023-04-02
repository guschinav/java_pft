package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions (){
        app.goTo().HomePage();
        if (!app.contact().isThereAContact()) {
            app.goTo().GroupPage();
            if (!app.group().isThereAGroup()) {
                app.group().create(new GroupData().withName("test1").withHeader("test2").withFooter("test3"));
            }
            app.goTo().goToNewAddPage();
            String CurrentGroup = app.wd.findElement(By.xpath("//div[@id='content']/form/select[5]/option[2]")).getText();
            app.contact().contact(new ContactData()
                    .withFirstname("John").withMiddlename("Silver").withLastname("Yellow").withMobile("+791115648594").withEmail("test@mail.ru").withAddress2("New Orenburg").withGroup(CurrentGroup));
            app.goTo().HomePage();
        }
    }




    @Test

    public void testContactModification () {
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Pupka").withMiddlename("Black").withLastname("Braun").withMobile("+19565067219").withEmail("test@mail.ru").withAddress2("New Orenburg");
        app.contact().modifyContact(contact);
        app.goTo().HomePage();
        Contacts after = app.contact().all();
        assertEquals(after.size(), before.size() );
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));



    }

}




