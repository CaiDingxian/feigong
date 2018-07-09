package com.voidgeek.feigong.alternate;

import com.voidgeek.feigong.core.CastUtil;
import com.voidgeek.feigong.transit.ITransit;

public class ToIntTransit implements ITransit<String,Integer> {
    @Override
    public Integer transit(String s) {
        return CastUtil.parseInt(s);
    }

    @Override
    public String getId() {
        return "toInt";
    }
}
