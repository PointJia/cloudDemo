package com.dian.kafka.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtile {

    static SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    public static String initNow(){
        return sdf.format(new Date());
    }

}
