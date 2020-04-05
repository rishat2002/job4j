package ru.job4j.jsoup;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class MainClass {
    public void task() throws SchedulerException, IOException {
        File file=new File("C:\\projects\\job4j\\chapter_003\\src\\main\\java\\ru\\job4j\\jsoup\\vacancy.properties");
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
                .withSchedule(simpleSchedule()
                .withIntervalInHours(time)
                .repeatForever())
                .build();
        scheduler.scheduleJob(job, trigger);
        scheduler.start();
    }

    public static void main(String[] args) {
    MainClass m=new MainClass();
        try {
            m.task();
        } catch (SchedulerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
