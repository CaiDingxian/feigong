package com.voidgeek.feigong.alternate;

import com.voidgeek.feigong.transit.ITransit;

public class ToStringTransit implements ITransit<Object,String> {


    @Override
    public String transit( Object s) {
        return s.toString();
    }

    @Override
    public String getId() {
        return "toStr";
    }
}
