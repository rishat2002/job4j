import org.junit.Assert;
import org.junit.Test;
import ru.job4j.tracker.ConnectionRollback;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.TrackerSQL;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;


public class TrackerSQLTest {
    public Connection init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }

    }

   @Test
   public void createItem() throws Exception {
    try (TrackerSQL tracker = new TrackerSQL("item",ConnectionRollback.create(this.init()))) {
           Item i=new Item("tail");
         i.setId("hor");
          tracker.add(i);
         Assert.assertEquals(tracker.findall().size(),1);
          Assert.assertEquals(tracker.findall().get(0).getName(),"tail");
}
}
}
