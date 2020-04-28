package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tracker implements ITracker {
    private final List<Item>itemlist= new ArrayList<Item>();

    public Item add(Item item) {
        item.setId(this.generateId());
        itemlist.add(item);
        return item;
    }
    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }
    public boolean replace(String id, Item item) {
        boolean result=false;
        for (int i=0;i<itemlist.size();i++) {
            if(itemlist.get(i).getId().equals(id)) {
                String oldid=itemlist.get(i).getId();
                itemlist.set(i,item);
                result=true;
                break;
            }
        }
        return result;
    }
    public List<Item> findall() {
        ArrayList<Item>copy= new ArrayList<Item>(itemlist);
        return copy;
    }

    public boolean delete(String id) {
        boolean result=false;
        int n=0;
        for (int i=0;i<itemlist.size();i++) {
            if (itemlist.get(i).getId().equals(id)) {
                itemlist.remove(i);
                result=true;
                break;
            }
        }
        return result;
    }


    public List<Item> findByName(String key) {
        List<Item>newlist=new ArrayList<Item>();
        for (int i=0;i<itemlist.size();i++) {
            if(key.equals(itemlist.get(i).getName())) {
                newlist.add(itemlist.get(i));
            }
        }
        return newlist;
    }
    public Item findById(String id) {
        Item iditem=null;
        for (int i=0;i<itemlist.size();i++) {
            if(id.equals(itemlist.get(i).getId())) {
            iditem=itemlist.get(i);
            break;
            }
        }
     return iditem;
    }

    public static void main(String[] args) {

    }
}
