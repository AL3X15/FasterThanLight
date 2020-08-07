package com.spring.henallux.javawebproject;

import com.spring.henallux.javawebproject.utility.AddDays;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Calendar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavawebprojectApplicationTests {

    @Test
    public void addDaysWithoutWeekend() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 7, 18);
        calendar.setTime(AddDays.addDays(calendar.getTime(), 3));
        Assert.assertEquals(21, calendar.get(Calendar.DATE));
    }

    @Test
    public void addDaysWithWeekend() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 7, 23);
        calendar.setTime(AddDays.addDays(calendar.getTime(), 3));
        Assert.assertEquals(28, calendar.get(Calendar.DATE));
    }

}
