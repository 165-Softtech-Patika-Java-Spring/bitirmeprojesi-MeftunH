package com.FinalProject.FinalProject.general.util;

import com.FinalProject.FinalProject.general.enums.GenErrorMessage;
import com.FinalProject.FinalProject.general.exceptions.GenBusinessException;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

    public static LocalDate convertToLocalDate(Date dateToConvert) {

        validateDate(dateToConvert);

        LocalDate localDate = Instant.ofEpochMilli(dateToConvert.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();

        return localDate;
    }

    public static LocalDateTime convertToLocalDateTime(Date dateToConvert) {

        validateDate(dateToConvert);

        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    public static Date convertToDate(LocalDate dateToConvert) {

        validateDate(dateToConvert);

        return java.util.Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }

    private static void validateDate(Date dateToConvert) {
        if (dateToConvert == null){
            throw new GenBusinessException(GenErrorMessage.DATE_COULD_NOT_BE_CONVERTED);
        }
    }

    private static void validateDate(LocalDate dateToConvert) {
        if (dateToConvert == null){
            throw new GenBusinessException(GenErrorMessage.DATE_COULD_NOT_BE_CONVERTED);
        }
    }
}
