package com.voidgeek.feigong.transit;

import com.voidgeek.feigong.core.CastUtil;

import java.util.List;
import java.util.Map;

public class ToMapTransit implements ITransit<Object,Map> {

    @Override
    public Map transit(Object s) {
        if(s instanceof Map)
        return (Map)s;
        else return null;
    }

    @Override
    public String getId() {
        return "toMap";
    }
}
