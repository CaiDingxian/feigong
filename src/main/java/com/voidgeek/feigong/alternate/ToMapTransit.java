package com.voidgeek.feigong.alternate;

import com.voidgeek.feigong.transit.ITransit;

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
