package ru.job4j.tracker;

import java.sql.SQLException;
import java.util.function.Consumer;

public class EditAction implements UserAction {


    @Override
    public String info() {
        return null;
    }

    @Override
    public int key() {
        return 0;
    }

    @Override
    public String name() {
       return "=== Edit item ===" ;
    }

    @Override
    public boolean execute(Input input, ITracker tracker, Consumer<String> output) {
        String id=input.askStr("Firstly enter id");
        String nameitem=input.askStr(" then item");
        Item item=new Item(nameitem);
        try {
            if (tracker.replace(id,item)) {
                output.accept("The replacement was successful");
            }
            else {
                output.accept("The replacement was not successful");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
