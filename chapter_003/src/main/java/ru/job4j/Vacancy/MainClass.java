package ru.job4j.Vacancy;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class MainClass implements Grabb {
    @Override
    public void init(Parse parse, Store store,String link) throws IOException, SchedulerException {
        class HelloJob implements Job {
            @Override
            public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
                List<Vacancy> vacancyList= null;
                try {
                    vacancyList = parse.list(link);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                for (Vacancy t:vacancyList) {
                    try {
                        System.out.println("1");
                        store.save(t);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        File file=new File("src/main/java/ru/job4j/Vacancy/vacancy.properties");
        Properties config = new Properties();
        FileInputStream fis = new FileInputStream(file);
        config.load(fis);
        int time= Integer.parseInt(config.getProperty("time"));
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobDetail job = newJob(HelloJob.class)
                .build();
        SimpleTrigger trigger = newTrigger()
                .startNow()
                .withSchedule(simpleSchedule().withIntervalInHours(time)
                        .repeatForever())
                .build();
        scheduler.scheduleJob(job, trigger);
        scheduler.start();
    }
    public static void main(String[] args) throws SQLException {
    MainClass m=new MainClass();
    StoreforSqlru store=new StoreforSqlru();
        try {
            m.init(new ParseSqlRu(),store,"https://www.sql.ru/forum/job/7");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        store.close();
    }

}
