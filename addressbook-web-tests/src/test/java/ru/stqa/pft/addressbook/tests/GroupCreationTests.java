package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation()  {
    app.getNavigationHelper().goToGroupPage();
    List<GroupData> before = app.getGroupHelper().getGroupList();//количество групп до добавления
    GroupData group = new GroupData("test99", null, null);
    app.getGroupHelper().createGroup(group);
    List<GroupData> after = app.getGroupHelper().getGroupList(); //количество групп после добавления
    Assert.assertEquals(after.size(), before.size() + 1);


    int max =0;
    for (GroupData g: after) {
      if (g.getId() > max) {
        max = g.getId();
      }
    }
    
    group.setId(max);
    before.add(group);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after)); //преобразование списка в множество
  }


}
