package com.epam.university.java.core.task030;


import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class Task030Impl implements Task030 {
    @Override
    public int daysBetweenDates(LocalDate dateStart, LocalDate dateEnd) {
        if (dateStart == null || dateEnd == null) {
            throw new IllegalArgumentException();
        }
        int days = (int) ChronoUnit.DAYS.between(dateStart, dateEnd);
        return days;
    }

    @Override
    public LocalDate adjustDays(LocalDate dateStart, int daysToAdd) {
        return dateStart.plusDays(daysToAdd);
    }

    @Override
    public long distanceBetween(Instant instantStart, Instant instantEnd) {
        return ChronoUnit.SECONDS.between(instantStart, instantEnd);
    }

    @Override
    public DayOfWeek getDayOfWeek(LocalDate localDate) {
        DayOfWeek dayOfWeek
                = DayOfWeek.from(localDate);
        return dayOfWeek;
    }

    @Override
    public LocalDate getNextWeekend(LocalDate localDate) {
        return localDate.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
    }

    @Override
    public LocalTime getLocalTime(String timeString) {
        return LocalTime.parse(timeString, DateTimeFormatter.ofPattern("hh:mma"));
    }
}