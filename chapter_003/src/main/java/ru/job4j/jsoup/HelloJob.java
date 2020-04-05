package ru.job4j.jsoup;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.io.File;
import java.sql.SQLException;

public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        DataBaseForVacancy data=new DataBaseForVacancy();
        try {
            data.add();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
