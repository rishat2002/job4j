package ru.job4j.ru.job4j.tracker;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        System.out.print("Enter name: ");
        String name = input.askStr("");
        Item item = new Item(name);
        tracker.add(item);
    }
    public static void showItems(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item [] show=tracker.findAll();
        for (int i=0;i<show.length;i++) {
            System.out.println(show[i].getName());
        }
    }
    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        System.out.print("Firstly enter id then item");
        String id=input.askStr("");
        String nameitem=input.askStr("");
        Item item=new Item(nameitem);
        if (tracker.replace(id,item)) {
            System.out.println("The replacement was successful");
        }
        else {
            System.out.println("The replacement was not successful");
        }
    }
    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        String id=input.askStr("Enter id");
        if (tracker.delete(id)) {
            System.out.println("Item with id"+id+"deleted");
        }
        else {
            System.out.println("Item cant deleted");
        }
    }
    public static void findByIdItem(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        String id=input.askStr("Enter id");
        Item findid=tracker.findById(id);
        if (findid!=null) {
            System.out.println("Found "+findid.getName());
        }
        else {
            System.out.println("Item not found");
        }

    }
    public static void findByNameItem(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        String name=input.askStr("Enter name");
        Item[] findid=tracker.findByName(name);
        if (findid.length!=0) {
            for (int i=0;i<findid.length;i++)
            System.out.println(findid[i].getId());
        }
        else {
            System.out.println("Item not found");
        }
    }
    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("");
            if (select == 0) {
                StartUI.createItem(input, tracker);}
            else if (select == 1) {
                StartUI.showItems(input,tracker);
            }
            else if (select==2) {
               StartUI.editItem(input, tracker);
            }
            else if (select==3) {
               StartUI.deleteItem(input, tracker);
            }
            else if (select==4) {
            StartUI.findByIdItem(input, tracker);
            }
            else if (select==5) {
                StartUI.findByNameItem(input, tracker);
            }
            else if (select==6) {
                System.out.println("You finished the programm");
                break;
            }
//
        }}



    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item\n" +
                "1. Show all items\n" +
                "2. Edit item\n" +
                "3. Delete item\n" +
                "4. Find item by Id\n" +
                "5. Find items by name\n" +
                "6. Exit Program\n" +
                "Select:");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

}
