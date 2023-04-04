package ru.stqa.pft.addressbook.tests;


import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;


import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactMailTests extends TestBase {

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
                    .withFirstname("Anton").withMiddlename("Ivanocih").withLastname("Testovich")
                    .withNickname("Omut").withCompany("TestCp").withAddress("test test test").withMobile("+79211111111")
                    .withWorkPhone("+7864578").withEmail("test@test.ru").withEmail2("test2@test.ru").withEmail3("test3@test.ru").withGroup(CurrentGroup));
            app.goTo().HomePage();
        }
    }



    @Test
    public void testContactMails() {
        app.goTo().HomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
        assertThat(cleaned(contact.getAddress()), equalTo(cleaned(contactInfoFromEditForm.getAddress())));
        assertThat(contact.getAllEmails(), equalTo(poEmails(contactInfoFromEditForm)));

    }

    private String poEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactPhoneTests::cleaned)
                .collect(Collectors.joining("\n"));
    }

    public static String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }

}

