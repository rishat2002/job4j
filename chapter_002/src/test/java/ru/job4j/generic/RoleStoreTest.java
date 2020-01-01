package ru.job4j.generic;
import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class RoleStoreTest {
    RoleStore rol=new RoleStore(4);
 @Before
 public void start() {
     rol.add(new Role("12"));
     rol.add(new Role("34"));
     rol.add(new Role("56"));
 }
 @Test
 public void replaceTest() {
     rol.replace("34",new Role("78"));
     assertThat(new Role("78").getId(),is(rol.findById("78").getId()));
}
    @Test
    public void deleteTest() {
        rol.delete("34");
        assertNull(rol.findById("34"));
    }
}