package com.voidgeek.feigong.transit;

import com.voidgeek.feigong.core.CastUtil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDateTransit implements ITransit<String,Date> {

    public ToDateTransit(String format) {
        this.format = format;
    }

    private String format;

    @Override
    public Date transit(String s) {
        Date date=CastUtil.parseDate(s,format);
        return date;
    }

    @Override
    public String getId() {
        return "toDate";
    }
}
