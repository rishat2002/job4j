package ru.job4j.jsoup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class DataBaseForVacancy {
    private Connection conn;
    public DataBaseForVacancy() {
        try {
            this.init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean init() throws SQLException {
        File file=new File("C:\\projects\\job4j\\chapter_003\\src\\main\\java\\ru\\job4j\\jsoup\\vacancy.properties");
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
        }
        catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return this.conn != null;
    }
    public void add() throws SQLException {
        try {List<Vacancy> v=new Parse().ParsePage();
            for (Vacancy vacance:v) {
            PreparedStatement pr = this.conn.prepareStatement
                    ("insert into vacancy (name , link ,text ) values (?,?,?);");
            pr.setString(1, vacance.getName());
            pr.setString(2, vacance.getLink());
            pr.setString(3, vacance.getText());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException, IOException {
    }
}
