package com.voidgeek.feigong.checker.impl;

import com.voidgeek.feigong.checker.BinaryAbstractChecker;

public class InChecker<AcceptType> extends BinaryAbstractChecker<AcceptType,InChecker<AcceptType>> {

    public InChecker(AcceptType... objects) {
        this.objects = objects;
    }

    private AcceptType[] objects;

    @Override
    public boolean doCheck(AcceptType t) {
        for(AcceptType n:objects)
        {
            if(n.equals(t))return true;
        }
        return false;
    }

    @Override
    public String getDefaultId() {
        return "in";
    }
}
