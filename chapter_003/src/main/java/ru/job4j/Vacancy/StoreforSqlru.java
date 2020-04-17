package ru.job4j.Vacancy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.Predicate;

public class StoreforSqlru implements Store  {
    private Connection conn;
    public StoreforSqlru() {
        try {
            this.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private boolean init() throws SQLException {
        File file=new File("src/main/java/ru/job4j/Vacancy/vacancy.properties");
        try (FileInputStream fis = new FileInputStream(file)) {
            Properties config = new Properties();
            config.load(fis);
            Class.forName(config.getProperty("driver-class-name"));
            this.conn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            PreparedStatement pr = conn.prepareStatement(String.format
                    ("create table if not exists vacancy ( Id serial primary key,  name varchar(120) unique , link varchar(120),text varchar(500));"));
            pr.close();
        }
        catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.conn != null;
    }
    @Override
    public void save(Vacancy post) throws SQLException {
        PreparedStatement pr = this.conn.prepareStatement
                ("insert into vacancy (name , link ,text ) values (?,?,?)");
        pr.setString(1,post.getName());
        pr.setString(2,post.getLink());
        pr.setString(3,post.getText());
       pr.close();
    }

    @Override
    public List<Vacancy> get(Predicate<Vacancy> filter) throws SQLException {
        List<Vacancy>vacancyList=new ArrayList<Vacancy>();
        PreparedStatement pr = this.conn.prepareStatement
                ("select * from vacancy");
        ResultSet t=pr.executeQuery();
        while (t.next()) {
            Vacancy vacancyBeforeFilter=new Vacancy(t.getString("name"),t.getString("link"),t.getString("text"));
            if (filter.test(vacancyBeforeFilter)) {
            vacancyList.add(vacancyBeforeFilter);}
        }
        pr.close();
        return vacancyList;
    }
    public void close() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) throws SQLException, IOException {

    }

}
