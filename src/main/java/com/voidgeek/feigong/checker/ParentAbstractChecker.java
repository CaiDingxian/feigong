package com.voidgeek.feigong.checker;

import com.sun.istack.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*
 * SubCheckersAcceptType规定的类型将用于约束IChecker
 * IChecker<? super SubCheckersAcceptType>保证了IChecker的check方法接受SubCheckersAcceptType的父类型
 * 例如Integer类型可以被 IChecker<Number> 处理
 * 因为Integer是Number的子类
 * */
public abstract class
ParentAbstractChecker<AcceptType,SpecificType extends ParentAbstractChecker, SubCheckersAcceptType>
        extends AbstractChecker<AcceptType,SpecificType> {

    public @NotNull List<IChecker<? super SubCheckersAcceptType>> getCheckers() {
        return checkerList;
    }

    /***
     * 添加checker
     *
     * ***/
    public SpecificType checkers(@NotNull IChecker<? super SubCheckersAcceptType>...checkers) {
        this.checkerList.addAll(Arrays.asList(checkers));
        return (SpecificType)this;
    }

    List<IChecker<? super SubCheckersAcceptType>> checkerList=new ArrayList<>();



}
