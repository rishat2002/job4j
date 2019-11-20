package ru.job4j.tracker;
import java.util.Random;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;
    public Item add(Item item) {
        item.setId(this.generateId());
        items[this.position++] = item;
        return item;
    }
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
    public boolean replace(String id, Item item) {
        boolean result=false;
        for (int i=0;i<position;i++) {
            if(items[i].getId().equals(id)) {
                String oldid=items[i].getId();
                items[i]=item;
               items[i].setId(oldid);
                result=true;
                break;
            }
        }
        return result;
    }
    public boolean delete(String id) {
        boolean result=false;
        int n=0;
        for (int i=0;i<position;i++) {
            if (items[i].equals(id)) {
                n=i;
                result=true;
                break;
            }
        }
        items[n]=null;
        for (int i=n;i<items.length-1;i++) {
            items[i]=items[i+1];
        }
        items[items.length-1]=null;
        return result;
    }
    public Item[] findAll() {
     Item []newitems=new Item[position];
     System.arraycopy(items, 0, newitems, 0, position);
     return newitems;
    }
    public Item[] findByName(String key) {
        int newitemindex=0;
        for (int i=0;i<position;i++) {
            if(key.equals(items[i].getName())) {
                newitemindex++;
            }
        }
        Item[] newitem=new Item[newitemindex];
        newitemindex=0;
        for (int i=0;i<position;i++) {
            if(key.equals(items[i].getName())) {
                newitem[newitemindex]=items[i];
                newitemindex++;
            }
        }
        return newitem;
    }
    public Item findById(String id) {
        Item iditem=null;
        for (int i=0;i<items.length;i++) {
            if(id.equals(this.items[i].getId())) {
            iditem=this.items[i];
            break;
            }
        }
     return iditem;
    }

    public static void main(String[] args) {
        Item item1=new Item("vasya");
        Item item2=new Item("pit");
        Item item3=new Item("slava");
        Item item4=new Item("spot");
        Tracker tracker1=new Tracker();
        tracker1.add(item1);
        tracker1.add(item2);
        tracker1.add(item3);
        Item []newmas=tracker1.findAll();
        System.out.println(newmas.length);
       for (int i=0;i<newmas.length;i++) {
           System.out.println(newmas[i].getId());
       }
        for (int i=0;i<newmas.length;i++) {
            System.out.println(newmas[i].getName());
        }
        tracker1.delete(item2.getId());
        newmas=tracker1.findAll();
        System.out.println(newmas.length);
        for (int i=0;i<newmas.length;i++) {
            System.out.println(newmas[i].getName());
        }

    }
}
