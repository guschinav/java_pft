package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation()  {
    app.getNavigationHelper().goToGroupPage();
    int before = app.getGroupHelper().getGroupCount(); //количество групп до добавления
    app.getGroupHelper().createGroup(new GroupData("test99", null, null));
    int after = app.getGroupHelper().getGroupCount(); //количество групп после добавления
    Assert.assertEquals(after, before + 1);
  }


}
