package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContactData;

public class AddNewContactTests extends TestBase {

  @Test
  public void testAddNewContact()  {
    app.getNavigationHelper().goToNewAddPage();
    app.getContactHelper().createContact(new ContactData("John", "Silver", "Yellow", "+791115648594", "test@mail.ru", "New Orenburg", "test1"), true);
  }


}
