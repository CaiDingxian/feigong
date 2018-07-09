package com.voidgeek.feigong.checker;

import com.sun.istack.NotNull;
import com.voidgeek.feigong.core.Err;

public abstract class BinaryAbstractChecker<AcceptType,SpecificType extends BinaryAbstractChecker> extends AbstractChecker<AcceptType,SpecificType> {


    /**
     *  AbstractChecker的check方法调用doCheck()方法时
     *  创建了一个Err对象并设置了id,然后传给err
     * **/
    @Override
    public void doCheck(@NotNull Err err, @NotNull AcceptType accept) {

        err.setError(!doCheck(accept));//决定是否对err设置为错误状态
    }


    public abstract boolean doCheck(@NotNull AcceptType accept);

}
