package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions (){
    app.getNavigationHelper().goToGroupPage();
    if (! app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
    }

  }


  @Test
  public void testGroupDeletion() {
    List<GroupData> before = app.getGroupHelper().getGroupList();//количество групп до добавления
    app.getGroupHelper().selectGroup(before.size() -1); //выбор индекса элемента, отсчет с 0
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    List<GroupData> after = app.getGroupHelper().getGroupList(); //количество групп после добавления
    Assert.assertEquals(after.size(), before.size() - 1 );

    before.remove(before.size() - 1); //старый список должен сождержать те же элементы, что и новый
    Assert.assertEquals(before, after); //сравниваем элементы с одинаковыми индексами
    }


}
