package com.voidgeek.feigong.core;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import com.voidgeek.feigong.core.Err;
import com.voidgeek.feigong.checker.IChecker;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CheckUtil {

    /*
    * 约束AcceptType和SubChecker的AcceptType一样
    * 功能：执行一系列checker，收集其中有错的Err，仅此而已
    * */
    public static @NotNull <AcceptType>  List<Err> multiCheck(@NotNull AcceptType accept, boolean isFull,@NotNull List<IChecker<? super AcceptType>> iCheckers)
    {
        List errs=new ArrayList();
        for(IChecker n:iCheckers)
        {
            if(null==iCheckers)continue;
            Err tempErr=n.check(accept);
            if(tempErr.hasError())//仅仅收集有错误的Err
            {
                errs.add(tempErr);
                if(!isFull)break;
                //Mutex模式，将会在第一个错误出现后不再继续检查，而Full模式将继续检查
            }

        }
        return errs;
    }



    public static @Nullable Object getProp(@NotNull String attrName,@NotNull Object bean)
    {
        Object prop=null;
            try {
                PropertyDescriptor propDesc=new PropertyDescriptor(attrName,bean.getClass());
                Method m=propDesc.getReadMethod();
                prop=m.invoke(bean);
            } catch (Exception e) {
                //throw new RuntimeException("BEAN_VISIT_FAIL",e);
                return null;
            }

        return prop;
    }



}
