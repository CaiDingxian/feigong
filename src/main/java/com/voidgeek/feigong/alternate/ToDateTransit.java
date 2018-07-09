package com.voidgeek.feigong.alternate;

import com.voidgeek.feigong.core.CastUtil;
import com.voidgeek.feigong.transit.ITransit;

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
