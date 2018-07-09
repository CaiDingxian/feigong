package com.voidgeek.feigong.checker.impl;

import com.voidgeek.feigong.checker.BinaryAbstractChecker;
import com.voidgeek.feigong.core.IAssert;

/**
 * 允许传入Lamda表达式来检查
 * **/
public class AssertChecker<AcceptType> extends BinaryAbstractChecker<AcceptType,AssertChecker<AcceptType>> {


    IAssert<AcceptType> iAssert;

    public AssertChecker(IAssert<AcceptType> iAssert) {
        this.iAssert = iAssert;
    }

    @Override
    public boolean doCheck(AcceptType t) {
        return iAssert.checkAssert(t);
    }

    @Override
    public String getDefaultId() {
        return null;
    }
}
