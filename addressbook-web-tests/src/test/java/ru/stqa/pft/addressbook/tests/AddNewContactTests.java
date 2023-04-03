package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddNewContactTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions () {


  }


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
    ContactData contact = new ContactData().withFirstname("Obra").withMiddlename("Hello").withLastname("First").withMobile("+111111111111").withEmail("test@mail.ru").withAddress2("New Orenburg").withGroup(CurrentGroup);
    app.contact().contact(contact);
    app.goTo().HomePage();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) ->c.getId()).max().getAsInt()))));
  }



}
