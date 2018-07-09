package com.voidgeek.feigong.checker.impl;

import com.voidgeek.feigong.checker.ParentAbstractChecker;
import com.voidgeek.feigong.core.CheckUtil;
import com.voidgeek.feigong.core.Err;

import java.util.List;

public class MutexChecker<AcceptType> extends ParentAbstractChecker<AcceptType,MutexChecker<AcceptType>,AcceptType> {
    @Override
    public String getDefaultId() {
        return null;
    }

    @Override
    public void doCheck(Err err, AcceptType t) {
        List<Err> errs=CheckUtil.multiCheck(t,false,getCheckers());
        for(Err n:errs)err.putSubErr(n);

    }
}
