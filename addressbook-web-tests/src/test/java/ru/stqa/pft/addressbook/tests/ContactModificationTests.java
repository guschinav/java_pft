package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

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
        List<ContactData> before = app.contact().list();
        int index = before.size() -1;
        ContactData contact = new ContactData().withFirstname("Pupka").withMiddlename("Black").withLastname("Braun").withMobile("+19565067219").withEmail("test@mail.ru").withAddress2("New Orenburg");
        app.contact().modifyContact(index, contact);
        app.goTo().HomePage();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() );

        before.remove(index);
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(before, after);



    }

}




