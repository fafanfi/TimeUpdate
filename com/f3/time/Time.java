package com.f3.time;

import javax.swing.*;
import java.time.LocalTime;

public class Time implements Runnable{
    private final JLabel label;

    public Time(JLabel label){
        this.label = label;
    }

    public void run(){
        // update waktu
        while(true){
            LocalTime now = LocalTime.now(); // dapatkan waktu sekarang
            int hour = now.getHour();
            int minute = now.getMinute();
            int second = now.getSecond();

            String hourZeroLead;
            String minuteZeroLead;
            String secondZeroLead;

            if(hour < 10)
                hourZeroLead = "0" + hour;
            else
                hourZeroLead = String.valueOf(hour);
            if(minute < 10)
                minuteZeroLead = "0" + minute;
            else
                minuteZeroLead = String.valueOf(minute);
            if(second < 10)
                secondZeroLead = "0" + second;
            else
                secondZeroLead = String.valueOf(second);

            label.setText(hourZeroLead + ":" + minuteZeroLead + ":" + secondZeroLead);
        }
    }
}
