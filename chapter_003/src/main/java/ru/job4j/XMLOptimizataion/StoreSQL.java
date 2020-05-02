package ru.job4j.XMLOptimizataion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class StoreSQL implements AutoCloseable {
    private final Config config;
    private Connection connect;
    private List<XmlUsage.Field> fall = new ArrayList<>();

    public StoreSQL(Config config) {
        this.config = config;
    }

    public void createNewDatabase() throws SQLException, ClassNotFoundException {
        this.connect = DriverManager.getConnection(
                config.getValues().getProperty("url"),
                config.getValues().getProperty("username"),
                config.getValues().getProperty("password")
        );
        if (connect != null) {
            DatabaseMetaData meta = connect.getMetaData();
        }
    }

    public void generate(int size) throws SQLException, ClassNotFoundException {
        Integer k = size;
        PreparedStatement pr = null;
        try (Connection conn=connect) {
            conn.setAutoCommit(false);
            pr = conn.prepareStatement("create table if not exists entry ( Id serial primary key, field Integer);");
            pr = conn.prepareStatement("delete from entry");
            for (int i = 1; i <= size; i++) {
                fall.add(new XmlUsage.Field(i));
                pr = conn.prepareStatement(String.format("insert into entry(field) values (?);"));
                pr.setInt(1,i);
                pr.addBatch();
            }
            pr.close();
            pr.executeBatch();
            conn.commit();
        } catch (SQLException e) {
            connect.rollback();
            e.printStackTrace();
        }
    }

    public List<XmlUsage.Field> load() {
        return fall;
    }

    @Override
    public void close() throws Exception {
        if (connect != null) {
            connect.close();
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

    }
}
