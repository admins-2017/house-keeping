package com.cloud.utils.interchangeable;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 时间操作工具类
 * @author 康东伟
 * @date 2021/5/25
 */
public class LocalDateTimeUtil {

    /**
     * 将LocalDateTime转为自定义的时间格式的字符串
     * @param localDateTime 时间
     * @param format 格式化的格式
     * @return 时间字符串
     */
    public static String getDateTimeAsString(LocalDateTime localDateTime, String format) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDateTime.format(formatter);
    }

    /**
     * 将LocalDateTime转为 CRON 格式的字符串
     * @param localDateTime 时间
     * @return cron格式的字符串
     */
    public static String getDateTimeAsCron(LocalDateTime localDateTime) {
        String format = "ss mm HH dd MM ? yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDateTime.format(formatter);
    }

    /**
     * 将long类型的timestamp转为LocalDateTime
     * @param timestamp 时间戳
     * @return LocalDateTime 时间
     */
    public static LocalDateTime getDateTimeOfTimestamp(long timestamp) {
        Instant instant = Instant.ofEpochMilli(timestamp);
        ZoneId zone = ZoneId.systemDefault();
        return LocalDateTime.ofInstant(instant, zone);
    }

    /**
     * 将LocalDateTime转为long类型的timestamp 时间戳
     * @param localDateTime 日期
     * @return 时间戳
     */
    public static long getTimestampOfDateTime(LocalDateTime localDateTime) {
        ZoneId zone = ZoneId.systemDefault();
        Instant instant = localDateTime.atZone(zone).toInstant();
        return instant.toEpochMilli();
    }

    /**
     * 将某时间字符串转为自定义时间格式的LocalDateTime
     * @param time 时间
     * @param format 格式
     * @return LocalDateTime
     */
    public static LocalDateTime parseStringToDateTime(String time, String format) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(format);
        return LocalDateTime.parse(time, df);
    }

}
