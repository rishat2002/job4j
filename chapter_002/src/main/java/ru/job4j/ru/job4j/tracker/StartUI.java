package ru.job4j.ru.job4j.tracker;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.function.Consumer;

public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private final Consumer<String> output;
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }
    public void init(Input input, Tracker tracker, UserAction[] actions) {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker,output);
        }
    }

    private void showMenu(UserAction[] actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            System.out.println(index + ". " + actions[index].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),new ShowAction(),new EditAction(),new DeleteAction(),new FindByIdAction(),new FindNameAction(),new EditAction()
        };
        Consumer<String>cons=new Consumer<String>() {
            @Override
            public void accept(String s) {

            }
        };
        new StartUI(input,tracker,cons).init(input,tracker,actions);
    }

}
