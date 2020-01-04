package ru.job4j.LearhMap;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import java.sql.SQLOutput;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
public class MyMapTest {
    MyMap<String,Integer> newmap=new MyMap();
    @Before
    public void start() {
        newmap.insert("green",1);
        newmap.insert("pink",2);
        newmap.insert("blue",3);

    }
 @Test
    public void insertTest() {
        assertThat(false,is(newmap.insert("pink",6)));
 }
 @Test
    public void get() {
    assertThat(3,is(newmap.get("blue").intValue()));
 }
 @Test
    public void deleteTest() {
        assertThat(true,is(newmap.delete("green")));
        assertThat(null,is(newmap.get("green")));
        assertThat(false,is(newmap.delete("yellow")));
 }
 @Test
    public void iteratorHasnextTest() {
        Iterator iter=newmap.iterator();
        assertThat(true,is(iter.hasNext()));
        assertThat(true,is(iter.hasNext()));
        assertThat(true,is(iter.hasNext()));
        assertThat(false,is(iter.hasNext()));
 }
    @Test (expected = NoSuchElementException.class)
    public void iteratorTest() {
        Iterator iter=newmap.iterator();
        for (int i=0;i<4;i++){
            Entry1 n= (Entry1) iter.next();
            System.out.println(n.getKey()+" "+n.getValue());
        }
    }
    @Test (expected = ConcurrentModificationException.class)
    public void iteratorTest1() {
        Iterator iter=newmap.iterator();
        for (int i=0;i<4;i++){
            Entry1 n= (Entry1) iter.next();
            newmap.insert("uuu",9);
            System.out.println(n.getKey()+" "+n.getValue());
        }
    }
}