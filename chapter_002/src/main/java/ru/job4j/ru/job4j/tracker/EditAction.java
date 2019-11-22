package ru.job4j.ru.job4j.tracker;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

public class EditAction implements UserAction {


    @Override
    public String name() {
       return "=== Edit item ===" ;
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id=input.askStr("Firstly enter id");
        String nameitem=input.askStr(" then item");
        Item item=new Item(nameitem);
        if (tracker.replace(id,item)) {
            System.out.println("The replacement was successful");
        }
        else {
            System.out.println("The replacement was not successful");
        }
        return true;
    }
}
