package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

    @Test

    public void testContactModification () {

        app.getContactHelper().goToHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillNewContact(new ContactData("Tom", "Gold", "Yellow", "+111111111111", "test@mail.ru", "New Orenburg", null), false);
        app.getContactHelper().updateContactModification();



    }

}
