package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification() {
        app.getNavigationHelper().goToGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup(new GroupData("test1", "test2", "test3"));
        }
        List<GroupData> before = app.getGroupHelper().getGroupList();//количество групп до добавления
        app.getGroupHelper().selectGroup(before.size() -1);//выбор индекса элемента, отсчет с 0
        app.getGroupHelper().initGroupModification();
        GroupData group = new GroupData(before.get(before.size() -1).getId(), "test1", "test2", "test1"); //before.get(before.size() -1).getId() присваиваем модифицированной группе старй индентификатор
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();
        List<GroupData> after = app.getGroupHelper().getGroupList(); //количество групп после добавления
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() -1); ////старый список должен сождержать те же элементы, что и новый
        before.add(group);//добавляем объект в список

        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after)); //преобразование списка в множество



    }

}
