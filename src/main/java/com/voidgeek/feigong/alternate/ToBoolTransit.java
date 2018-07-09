package com.voidgeek.feigong.alternate;

import com.voidgeek.feigong.core.CastUtil;
import com.voidgeek.feigong.transit.ITransit;

public class ToBoolTransit implements ITransit<String,Boolean> {
    @Override
    public Boolean transit(String s) {
        return CastUtil.parseBoolean(s);
    }

    @Override
    public String getId() {
        return "toBool";
    }
}
