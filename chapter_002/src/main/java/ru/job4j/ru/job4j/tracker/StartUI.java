package ru.job4j.ru.job4j.tracker;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
            }
             else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item [] show=tracker.findAll();
                for (int i=0;i<show.length;i++) {
                    System.out.println(show[i].getName());
                }
            }
             else if (select==2) {
                System.out.println("=== Edit item ===");
                System.out.print("Firstly enter id then item");
                String id=scanner.nextLine();
                String nameitem=scanner.nextLine();
                Item item=new Item(nameitem);
                tracker.replace(id,item);
            }
             else if (select==3) {
                System.out.println("=== Delete item ===");
                System.out.println("Enter id");
                String id=scanner.nextLine();
                tracker.delete(id);
            }
             else if (select==4) {
                System.out.println("=== Find item by Id ===");
                System.out.println("Enter id");
                String id=scanner.nextLine();
                tracker.findById(id);
            }
             else if (select==5) {
                System.out.println("=== Find items by name ===");
                System.out.println("Enter name");
                String name=scanner.nextLine();
                tracker.findByName(name);
            }
             else if (select==6) {
                System.out.println("You finished the programm");
                break;
            }

        }
    }

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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }

}
