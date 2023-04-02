package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class AddNewContactTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions () {


  }


  @Test
  public void testAddNewContact() {
    app.goTo().HomePage();
    List<ContactData> before = app.contact().list();
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
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() + 1);

    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }



}
