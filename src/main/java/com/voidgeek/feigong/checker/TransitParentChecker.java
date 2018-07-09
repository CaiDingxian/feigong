package com.voidgeek.feigong.checker;

import com.sun.istack.NotNull;
import com.voidgeek.feigong.core.CheckUtil;
import com.voidgeek.feigong.core.Err;
import com.voidgeek.feigong.transit.ITransit;

import java.util.List;

public  class TransitParentChecker<AcceptType,SubCheckersAcceptType>
        extends ParentAbstractChecker<
        AcceptType,
        TransitParentChecker<AcceptType,SubCheckersAcceptType>,
        SubCheckersAcceptType>
{

    final ITransit<AcceptType,SubCheckersAcceptType> iTransit;


    /*
    * 将过渡处理委托给iTransit接口的实现对象
    * 它的作用是从一种AcceptType转化为另一张AcceptType
    * */
    public TransitParentChecker(@NotNull ITransit<AcceptType,SubCheckersAcceptType> iTransit)
    {
        this.iTransit=iTransit;
    }

    @Override
    public String getDefaultId() {
        return null;
    }


    public String getTid() {
        return null==tid?tid:iTransit.getId();
    }

    public TransitParentChecker setTid(String tid) {
        this.tid = tid;
        return this;
    }

    private String tid;


    /*
    * tid和subErr的id都只能附加在id后面，即id.tid id.subErrId
    *
    * */

    @Override
    public void doCheck(@NotNull Err err,@NotNull AcceptType t) {
        SubCheckersAcceptType target=iTransit.transit(t);
        if(null==target){ //返回null表示转换失败
            err.setError(true);
            err.putSubErr(getTid());//如果转换本身有问题，将其id设置为ITransit的id
        }
        else {

            List<Err> errs = CheckUtil.multiCheck(target, false, getCheckers());
            //取出的都是有错的err对象，将作为err的子节点
            for (Err n : errs) err.putSubErr(n);
        }
    }
}
