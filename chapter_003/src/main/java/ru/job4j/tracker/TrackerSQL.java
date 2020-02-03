package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TrackerSQL implements ITracker, AutoCloseable {
    private String tableName;
    private Connection connection;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private List<Item> itemlist = new ArrayList<Item>();

    public TrackerSQL(String tableName) {
        this.tableName = tableName;
    }

    public boolean init() {
        try (InputStream in = TrackerSQL.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            this.connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            try {
                pr = connection.prepareStatement(String.format("create table if not exists %s ( Id serial primary key, Id_item varchar(100), Name varchar(30));"
                        , tableName));
                rs = pr.executeQuery();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            throw new IllegalStateException(e);
        }
        return this.connection != null;
    }

    @Override
    public void close() throws Exception {
        connection.close();
    }

    @Override
    public Item add(Item item) {
        try {
            this.init();
            pr = connection.prepareStatement(String.format("insert into %s (name,id_item) values ('%s','%s');",
                    tableName, item.getName(), item.getId()));
            rs = pr.executeQuery();
            rs.close();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pr.close();
                this.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return item;
    }

    @Override
    public boolean replace(String id, Item item) {
        try {
            this.init();
            pr = connection.prepareStatement(String.format("UPDATE %s SET name='%s',Id_item='%s'  WHERE id_item='%s';",
                    tableName, item.getName(), item.getId(), id));
            rs = pr.executeQuery();
            rs.close();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.close();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        try {
            this.init();
            PreparedStatement pr = connection.prepareStatement(String.format("DELETE FROM %s WHERE id_item='%s';", tableName, id));
            ResultSet rs = pr.executeQuery();
            rs.close();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.close();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Item> findall() {
        try {
            this.init();
            PreparedStatement pr = connection.prepareStatement(String.format("select * from %s", tableName));
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString("name"));
                item.setId(rs.getString("id_item"));
                itemlist.add(item);
            }
            rs.close();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return itemlist;
    }

    @Override
    public List<Item> findByName(String key) {
        ArrayList<Item> list = new ArrayList<>();
        try {
            this.init();
            PreparedStatement pr = connection.prepareStatement(String.format("select * from %s where name='%s'", tableName, key));
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                Item item = new Item(rs.getString("name"));
                item.setId(rs.getString("id_item"));
                list.add(item);
            }
            rs.close();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public Item findById(String id) {
        Item item = null;
        try {
            this.init();
            PreparedStatement pr = connection.prepareStatement(String.format("select * from %s where id_item='%s'", tableName, id));
            ResultSet rs = pr.executeQuery();
            rs.next();
            item = new Item(rs.getString("name"));
            item.setId(rs.getString("id_item"));
            rs.close();
            pr.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                this.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return item;
    }

    public static void main(String[] args) throws SQLException {
        TrackerSQL s1 = new TrackerSQL("items");
        Item i1 = new Item("gera");
        i1.setId("100500");
        System.out.println(s1.findById("500").getName());

    }
}
