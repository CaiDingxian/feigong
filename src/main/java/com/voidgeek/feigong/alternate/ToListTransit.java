package com.voidgeek.feigong.alternate;

import com.voidgeek.feigong.core.CastUtil;
import com.voidgeek.feigong.transit.ITransit;

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
