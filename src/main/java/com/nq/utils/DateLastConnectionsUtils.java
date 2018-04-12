package com.nq.utils;

import com.nq.devicetracker.model.device.TrackedDevice;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class DateLastConnectionsUtils {

    static public Timestamp minusDaysFromNow(int days){
        Timestamp timestamp = new Timestamp(new Date().getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTime(timestamp);
        cal.add(Calendar.DAY_OF_WEEK, -days);
        return new Timestamp(cal.getTime().getTime());
    }

    static public boolean isLastConnectionLessEqualsThan7Days(TrackedDevice trackedDevice){
        if(trackedDevice.getLastConnection().compareTo(minusDaysFromNow(7)) >= 0){
            return true;
        }
        return false;
    }

    static public boolean isLastConnectionMoreThan7Days(TrackedDevice trackedDevice){
        if(trackedDevice.getLastConnection().compareTo(minusDaysFromNow(7)) < 0){
            return true;
        }
        return false;
    }

    static public boolean isLastConnectionMoreThan14Days(TrackedDevice trackedDevice){
        if(trackedDevice.getLastConnection().compareTo(minusDaysFromNow(14)) < 0){
            return true;
        }
        return false;
    }
}
