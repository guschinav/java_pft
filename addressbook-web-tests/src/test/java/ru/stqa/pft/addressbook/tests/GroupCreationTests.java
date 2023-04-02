package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation()  {
    app.goTo().GroupPage();
    Set<GroupData> before = app.group().all();//количество групп до добавления
    GroupData group = new GroupData().withName("test2");
    app.group().create(group);
    Set<GroupData> after = app.group().all(); //количество групп после добавления
    Assert.assertEquals(after.size(), before.size() + 1);

    group.withId(after.stream().mapToInt((g) ->g.getId()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before, after); //преобразование списка в множество
    MatcherAssert.assertThat(after, CoreMatchers.equalTo(before));
  }


}
