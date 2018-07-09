package com.voidgeek.feigong.checker.impl;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import com.voidgeek.feigong.checker.BinaryAbstractChecker;

public class RangeChecker extends BinaryAbstractChecker<Comparable,RangeChecker> {

    Comparable left =null;
    Comparable right =null;
    boolean isLeftClosed;
    boolean isRightClosed;
    boolean isBetween;

    public RangeChecker(@Nullable Comparable left,@Nullable Comparable right, boolean isLeftClosed, boolean isRightClosed, boolean isBetween)
    {
        this.left =left;
        this.right =right;
        this.isLeftClosed=isLeftClosed;
        this.isRightClosed=isRightClosed;
        this.isBetween=isBetween;
    }

    @Override
    public boolean doCheck(@NotNull Comparable accept) {
        boolean isOk=true;
        if(isBetween) {
            if (null != left) {
                if (isLeftClosed) isOk &= (left.compareTo(accept) <= 0);
                else isOk &= (left.compareTo(accept) < 0);
            }
            if (null != right) {
                if (isRightClosed) isOk &= (right.compareTo(accept) >= 0);
                else isOk &= (right.compareTo(accept) > 0);
            }
        }
        else{
            if (null != left) {
                if (isLeftClosed) isOk &= (left.compareTo(accept) >= 0);
                else isOk &= (left.compareTo(accept) > 0);
            }
            if (null != right) {
                if (isRightClosed) isOk &= (right.compareTo(accept) <= 0);
                else isOk &= (right.compareTo(accept) < 0);
            }

        }
        return isOk;
    }

    @Override
    public String getDefaultId() {
        return "range";
    }
}
