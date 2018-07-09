package com.voidgeek.feigong.checker.impl;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import com.voidgeek.feigong.checker.BinaryAbstractChecker;

/**
 * BinaryAbstractChecker<String,StrLengthChecker>第一个参数String
 * 主要决定了IChecker的AcceptType参数，以约束该类对象能作为哪些Checker的subCheckers
 * **/
public class StrLengthChecker extends BinaryAbstractChecker<String,StrLengthChecker> {

    public StrLengthChecker(@Nullable Integer min, @Nullable Integer max) {
        this.min = min;
        this.max = max;
    }

    private Integer min,max;

    @Override
    public boolean doCheck(@NotNull String s) {
        if(null!=min&&min > s.length())return false;
        return null == max || max >= s.length();
    }

    @Override
    public String getDefaultId() {
        return "length";
    }
}
