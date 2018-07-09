package com.voidgeek.feigong.alternate;


import com.voidgeek.feigong.checker.ParentAbstractChecker;
import com.voidgeek.feigong.core.Err;

/**
 *
 *
 * **/
public class AttrChecker<AcceptType,SubCheckersAcceptType> extends ParentAbstractChecker<AcceptType,AttrChecker<AcceptType,SubCheckersAcceptType>,SubCheckersAcceptType>
{

    public AttrChecker(String attrName) {
        this.attrName = attrName;
    }

    private String attrName;



    @Override
    public String getDefaultId() {
        return this.attrName;
    }

    @Override
    public void doCheck(Err err, AcceptType t) {

       // Object obj= CheckUtil.getAttr(attrName,t);


    }


}
