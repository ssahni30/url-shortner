package helper;

import org.apache.commons.lang3.time.DateUtils;

import java.util.Date;

public class DateHelper {

    public static Date addDays(int days){
        return DateUtils.addDays(new Date(), days);
    }
}
