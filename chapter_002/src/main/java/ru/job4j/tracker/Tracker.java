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
        for (int i=0;i<items.length;i++) {
            if(items[i]!=null && this.items[i].getId().equals(id)) {
                this.items[i]=item;
                result=true;
                break;
            }
        }
        return result;
    }
    public boolean delete(String id) {
        boolean result=false;
        int n=0;
        Item []newitems= new Item[items.length+1];
        System.arraycopy(items, 0, newitems, 0,items.length);
        for (int i=0;i<position;i++) {
            if (this.items[i].equals(id)) {
                this.items[i]=null;
                n=i;
                break;
            }
        }
        for (int i=n;i<items.length;i++) {
            items[i]=newitems[i+1];
        }
        return result;
    }
    public Item[] findAll() {
     Item []newitems=new Item[position];
     System.arraycopy(items, 0, newitems, 0, position);
     return newitems;
    }
    public Item[] findByName(String key) {
        Item[] newitem=new Item[items.length];
        int newitemindex=0;
        for (int i=0;i<items.length;i++) {
            if(items[i]!=null && key.equals(items[i].getName())) {
                newitem[newitemindex]=items[i];
                newitemindex++;
            }
        }
        Item[] resultitem=new Item[newitemindex];
        System.arraycopy(newitem,0,resultitem,0,resultitem.length);
        return resultitem;
    }
    public Item findById(String id) {
        Item iditem=new Item(null);
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
