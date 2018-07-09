package com.voidgeek.feigong.transit;

import com.voidgeek.feigong.transit.ITransit;

import java.util.List;

public class ToElemTransit<ElemType> implements ITransit<List<ElemType>,ElemType> {

    public ToElemTransit(int index) {
        this.index = index;
    }

    int index;

    @Override
    public ElemType transit(List<ElemType> s) {
        if(s.size()-1<index)return null;
        return s.get(index);
    }

    @Override
    public String getId() {
        return "toElem";
    }
}
