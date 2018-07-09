package com.voidgeek.feigong.alternate;

import com.voidgeek.feigong.core.CastUtil;
import com.voidgeek.feigong.transit.ITransit;

public class ToFloatTransit implements ITransit<String,Float> {


    private String format;

    @Override
    public Float transit(String s) {

        return CastUtil.parseFloat(s);
    }

    @Override
    public String getId() {
        return "toFloat";
    }
}
