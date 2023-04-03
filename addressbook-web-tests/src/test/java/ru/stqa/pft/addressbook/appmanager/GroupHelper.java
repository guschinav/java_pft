package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupCreation() {
      click(By.name("submit"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void deleteSelectedGroups() {
        click(By.name("delete"));
    }


    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "'")).click();
    }

    public void initGroupModification() {
        click(By.name("edit"));
    }

    public void submitGroupModification() {
        click(By.name("update"));
    }


    public void deleateGroup() {
        click(By.name("delete"));
    }

    public void create(GroupData group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupCache = null;
        returnToGroupPage();

    }

    public  void modify(GroupData group) {
        selectGroupById(group.getId());//выбор индекса элемента, отсчет с 0
        initGroupModification();
        fillGroupForm(group);
        submitGroupModification();
        groupCache = null;
        returnToGroupPage();
    }


    public void delete(GroupData group) {
        selectGroupById(group.getId()); //выбор индекса элемента, отсчет с 0
        deleteSelectedGroups();
        groupCache = null;
        returnToGroupPage();

    }


    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public boolean checkGroup() {
        return isElementPresent(By.xpath("//div[@id='content']/form/select[5]/option[2]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public Groups groupCache = null;

    public Groups all() {
        if (groupCache != null){
            return new Groups(groupCache);
        }

        groupCache = new Groups(); //множество элементов типа GroupData
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group")); //найти все эелементы, которые имеют тег span и класс group
        for (WebElement element : elements) { //переменная element пробегает по списку elements
            String name = element.getText(); // получаем текст (имя группы)
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value")); // Integer.parseInt преообразование строки в число
            groupCache.add(new GroupData().withId(id).withName(name)); // добавляем собственный объект в список
        }
        return new Groups(groupCache);
    }


}
