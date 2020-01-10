package ru.job4j.LearnList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
public class AnalizeTest {

    @Test
    public void diffWhenadd1delete2chang1() {
        Analize a=new Analize();
        List<Analize.User>previous=new ArrayList<>();
        previous.add(new Analize.User(134,"semen"));
        previous.add(new Analize.User(234,"igor"));
        previous.add(new Analize.User(456,"tor"));
        previous.add(new Analize.User(135,"erema"));
        previous.add(new Analize.User(864,"anna"));
        List<Analize.User>current=new ArrayList<>();
        current.add(new Analize.User(134,"semen"));
        current.add(new Analize.User(24,"igor"));
        current.add(new Analize.User(135,"vanya"));
        current.add(new Analize.User(864,"anna"));
        assertThat(1,is(a.diff(previous,current).getAdded()));
        assertThat(1,is(a.diff(previous,current).getChanged()));
        assertThat(2,is(a.diff(previous,current).getDeleted()));
    }
    @Test
    public void diffWhenadd2() {
        Analize a=new Analize();
        List<Analize.User>previous=new ArrayList<>();
        previous.add(new Analize.User(134,"semen"));
        previous.add(new Analize.User(24,"igor"));
        List<Analize.User>current=new ArrayList<>();
        current.add(new Analize.User(134,"semen"));
        current.add(new Analize.User(24,"igor"));
        current.add(new Analize.User(135,"vanya"));
        current.add(new Analize.User(145,"erema"));
        assertThat(2,is(a.diff(previous,current).getAdded()));
        assertThat(0,is(a.diff(previous,current).getChanged()));
        assertThat(0,is(a.diff(previous,current).getDeleted()));
    }
    @Test
    public void diffWhendelete1() {
        Analize a=new Analize();
        List<Analize.User>previous=new ArrayList<>();
        previous.add(new Analize.User(134,"semen"));
        previous.add(new Analize.User(24,"igor"));
        previous.add(new Analize.User(44,"ira"));
        List<Analize.User>current=new ArrayList<>();
        current.add(new Analize.User(134,"semen"));
        current.add(new Analize.User(24,"igor"));
        assertThat(0,is(a.diff(previous,current).getAdded()));
        assertThat(0,is(a.diff(previous,current).getChanged()));
        assertThat(1,is(a.diff(previous,current).getDeleted()));
    }
    @Test
    public void diffWhenchange1() {
        Analize a=new Analize();
        List<Analize.User>previous=new ArrayList<>();
        previous.add(new Analize.User(134,"semen"));
        previous.add(new Analize.User(24,"igor"));
        previous.add(new Analize.User(44,"ira"));
        List<Analize.User>current=new ArrayList<>();
        current.add(new Analize.User(134,"semen"));
        current.add(new Analize.User(24,"igor"));
        current.add(new Analize.User(64,"ira"));
        assertThat(0,is(a.diff(previous,current).getAdded()));
        assertThat(1,is(a.diff(previous,current).getChanged()));
        assertThat(0,is(a.diff(previous,current).getDeleted()));
    }
}