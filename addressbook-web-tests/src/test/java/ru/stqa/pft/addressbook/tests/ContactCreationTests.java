package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        String groupName = "test1";
        app.goTo().goToNewAddPage();
        if (!app.group().checkGroup()) {
            app.goTo().GroupPage();
            app.group().create(new GroupData().withName(groupName).withHeader("test2").withFooter("test3"));
            app.goTo().goToNewAddPage();
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))){
            String xml = "";
            String line = reader.readLine();
            while (line != null) {
                xml += line;
                line = reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(ContactData.class);
            xstream.allowTypes(new Class[]{ContactData.class});
            xstream.processAnnotations(ContactData.class);
            List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
            return contacts.stream().map((c) -> new Object[]{c}).collect(Collectors.toList()).iterator();
        }

    }




    @Test (dataProvider = "validContacts")
    public void testAddNewContact(ContactData contact) {
        app.goTo().HomePage();
        Contacts before = app.contact().all();
        app.goTo().goToNewAddPage();
        //String CurrentGroup = app.wd.findElement(By.xpath("//div[@id='content']/form/select[5]/option[2]")).getText();
       // File photo = new File("src/test/resources/test.png");
        //ContactData contact = new ContactData().withFirstname("Anton").withMiddlename("Ivanocih").withLastname("Test")
                //.withNickname("Omut").withCompany("TestCp").withAddress("test test test").withMobile("+79211111111")
               // .withWorkPhone("+7864578").withGroup(CurrentGroup); //.withPhoto(photo)
        app.contact().create(contact);
        app.goTo().HomePage();
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) ->c.getId()).max().getAsInt()))));
    }






}