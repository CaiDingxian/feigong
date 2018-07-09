package com.voidgeek.feigong.checker.impl;

import com.voidgeek.feigong.checker.ParentAbstractChecker;
import com.voidgeek.feigong.core.Err;

import java.util.List;

public class EachChecker<SubCheckerType> extends ParentAbstractChecker<List<SubCheckerType>,EachChecker<SubCheckerType>,SubCheckerType> {



    @Override
    public String getDefaultId() {
        return "elem";
    }

    @Override
    public void doCheck(Err err, List<SubCheckerType> list) {


        for(SubCheckerType n:list)
        {

        }

    }
}
