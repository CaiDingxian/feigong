package com.voidgeek.feigong.alternate;

import com.voidgeek.feigong.transit.ITransit;

import java.util.Map;

public class ToValueTransit<ValueType> implements ITransit<Map<String, ValueType>, ValueType> {

    public ToValueTransit(String key) {
        this.key = key;
    }

    private String key;


    @Override
    public ValueType transit(Map<String, ValueType> s) {
        ValueType value=s.get(key);
        return value;
    }

    @Override
    public String getId() {
        return "toVal";
    }
}
