package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions (){
    app.goTo().GroupPage();
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData("test1", "test2", "test3"));
    }

  }


  @Test
  public void testGroupDeletion() {
    List<GroupData> before = app.group().list();//количество групп до добавления
    int index = before.size() -1;
    app.group().delete(index);
    List<GroupData> after = app.group().list(); //количество групп после добавления
    Assert.assertEquals(after.size(), before.size() - 1 );

    before.remove(index); //старый список должен сождержать те же элементы, что и новый
    Assert.assertEquals(before, after); //сравниваем элементы с одинаковыми индексами
    }




}
