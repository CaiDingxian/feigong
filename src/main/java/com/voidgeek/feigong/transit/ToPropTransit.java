package com.voidgeek.feigong.transit;

import com.voidgeek.feigong.core.CheckUtil;

import java.util.Map;

public class ToPropTransit<PropType> implements ITransit<Object, PropType> {

    public ToPropTransit(String key) {
        this.key = key;
    }

    private String key;


    @Override
    public PropType transit(Object s) {

        PropType o=(PropType)CheckUtil.getProp(key,s);
        return o;
    }


    @Override
    public String getId() {
        return "toProp";
    }
}
