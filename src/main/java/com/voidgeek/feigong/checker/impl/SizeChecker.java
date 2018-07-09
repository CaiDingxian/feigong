package com.voidgeek.feigong.checker.impl;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import com.voidgeek.feigong.checker.BinaryAbstractChecker;

import java.util.List;

public class SizeChecker extends BinaryAbstractChecker<List,SizeChecker> {

    Integer min,max;

    public SizeChecker(@Nullable Integer min,@Nullable Integer max)
    {
        this.min=min;
        this.max=max;
    }

    @Override
    public boolean doCheck(@NotNull List l) {
        if(null!=min&&min > l.size())return false;
        return null == max || max >= l.size();
    }

    @Override
    public String getDefaultId() {
        return "size";
    }
}
