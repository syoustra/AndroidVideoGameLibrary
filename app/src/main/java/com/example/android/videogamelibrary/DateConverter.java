package com.example.android.videogamelibrary;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class DateConverter {

    @TypeConverter
    public static Date fromTimeStamp(Long value) {

        return value == null ? null : new Date(value);      //ternary ... if null, leave null; otherwise, new Date
    }

    @TypeConverter
    public static Long dateToTimestamp (Date date) {
        return date == null ? null : date.getTime();        // if date is null, leave null; else return date's value
    }

}
