package com.voidgeek.feigong.transit;

import com.voidgeek.feigong.core.CastUtil;

import java.util.List;

public class ToListTransit implements ITransit<Object,List> {

    @Override
    public List transit(Object s) {
        return CastUtil.listLikeObjectTolist(s);
    }

    @Override
    public String getId() {
        return "toList";
    }
}
