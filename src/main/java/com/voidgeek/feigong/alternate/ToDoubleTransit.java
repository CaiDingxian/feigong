package com.voidgeek.feigong.alternate;

import com.voidgeek.feigong.core.CastUtil;
import com.voidgeek.feigong.transit.ITransit;

public class ToDoubleTransit implements ITransit<String,Double> {
    @Override
    public Double transit(String s) {
        return CastUtil.parseDouble(s);
    }

    @Override
    public String getId() {
        return "toDouble";
    }
}
