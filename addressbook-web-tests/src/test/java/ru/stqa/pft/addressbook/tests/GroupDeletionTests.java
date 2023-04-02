package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;
import java.util.Set;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions (){
    app.goTo().GroupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData().withName("test1"));
    }

  }


  @Test
  public void testGroupDeletion() {
    Set<GroupData> before = app.group().all();//количество групп до добавления
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Set<GroupData> after = app.group().all(); //количество групп после добавления
    Assert.assertEquals(after.size(), before.size() - 1 );

    before.remove(deletedGroup); //старый список должен содержать те же элементы, что и новый
    Assert.assertEquals(before, after); //сравниваем элементы с одинаковыми индексами
    }




}
