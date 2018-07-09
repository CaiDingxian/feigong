package com.voidgeek.feigong.alternate;

import com.voidgeek.feigong.checker.ParentAbstractChecker;
import com.voidgeek.feigong.core.Err;

import java.util.List;

public class ElemChecker<SubCheckerType> extends ParentAbstractChecker<List<SubCheckerType>,ElemChecker<SubCheckerType>,SubCheckerType> {


    int index;

    public ElemChecker(int index)
    {
        this.index=index;
    }

    @Override
    public String getDefaultId() {
        return "elem";
    }

    @Override
    public void doCheck(Err err, List<SubCheckerType> l) {


        if(l.size()<index+1)
        {

        }
        else {
            SubCheckerType s=l.get(index);

        }

    }
}
