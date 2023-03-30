package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions (){
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
        }

    }



    @Test
    public void testGroupModification() {
        List<GroupData> before = app.getGroupHelper().getGroupList();//количество групп до модификации
        int index = before.size() -1;
        GroupData group = new GroupData(before.get(index).getId(), "test1", "test2", "test1"); //before.get(before.size() -1).getId() присваиваем модифицированной группе старй индентификатор
        app.getGroupHelper().modifyGroup(index, group);
        List<GroupData> after = app.getGroupHelper().getGroupList(); //количество групп после модификации
        Assert.assertEquals(after.size(), before.size());
        before.remove(index); ////старый список должен сождержать те же элементы, что и новый
        before.add(group);//добавляем объект в список
        Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after); //преобразование списка в множество



    }



}
