package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {


  @Test
  public void testGroupDeletion() {
    app.getNavigationHelper().goToGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList();//количество групп до добавления
    app.getGroupHelper().selectGroup(before.size() -1); //выбор индекса элемента, отсчет с 0
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList(); //количество групп после добавления
    Assert.assertEquals(after.size(), before.size() - 1 );

    before.remove(before.size() - 1); //старый список должен сождержать те же элементы, что и нвоый
    Assert.assertEquals(before, after); //сравниваем элементы с одинаковыми индексами
    }


}
