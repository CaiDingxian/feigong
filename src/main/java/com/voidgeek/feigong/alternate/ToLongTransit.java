package com.voidgeek.feigong.alternate;

import com.voidgeek.feigong.core.CastUtil;
import com.voidgeek.feigong.transit.ITransit;

public class ToLongTransit implements ITransit<String,Long> {
    @Override
    public Long transit(String s) {
        return CastUtil.parseLong(s);
    }

    @Override
    public String getId() {
        return "toLong";
    }
}
