package com.voidgeek.feigong.facade;

import com.voidgeek.feigong.checker.IChecker;
import com.voidgeek.feigong.checker.TransitParentChecker;
import com.voidgeek.feigong.checker.impl.*;
import com.voidgeek.feigong.transit.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class Facades {
    public static RangeChecker max(Comparable m)
    {
        return new RangeChecker(null,m,true,true,true);
    }
    public static  RangeChecker min(Comparable m)
    {
        return new RangeChecker(m,null,true,true,true);
    }

    public static StrLengthChecker length(Integer min,Integer max)
    {
        return new StrLengthChecker(min,max);
    }

    public static InChecker in(Object ... objects)
    {
        return new InChecker(objects);
    }
    public static SizeChecker size(Integer min,Integer max)
    {
        return new SizeChecker(min,max);
    }







    public static <A,S> TransitParentChecker<A,S> as(Class<S> clazz)
    {
        TransitParentChecker transitParentChecker=new TransitParentChecker(new CastTransit(clazz));
        return transitParentChecker;
    }

    public static TransitParentChecker<Object,String> asStr(IChecker<String>...iCheckers)
    {
        return Facades.as(String.class).checkers(iCheckers);
    }


    public static TransitParentChecker<Object,? super Integer> asInt(IChecker<? super Integer>...iCheckers)
    {
        return Facades.as(Integer.class).checkers(iCheckers);
    }


    public static TransitParentChecker<Object,Boolean> asBool(IChecker<? super Boolean>...iCheckers)
    {
        return Facades.as(Boolean.class).checkers(iCheckers);
    }

    public static TransitParentChecker<Object,Double> asDouble(IChecker<? super Double>...iCheckers)
    {
        return Facades.as(Double.class).checkers(iCheckers);
    }

    public static TransitParentChecker<Object,Float> asFloat(IChecker<? super Float>...iCheckers)
    {
        return Facades.as(Float.class).checkers(iCheckers);
    }

    public static TransitParentChecker<Object,Long> asLong(IChecker<? super Long>...iCheckers)
    {
        return Facades.as(Long.class).checkers(iCheckers);
    }

    public static TransitParentChecker<Object,List> asList(IChecker<? super List>...iCheckers)
    {
        return Facades.as(List.class).checkers(iCheckers);
    }

    public static TransitParentChecker<Object,Map> asMap(IChecker<? super Map>...iCheckers)
    {
        return Facades.as(Map.class).checkers(iCheckers);
    }

    public static TransitParentChecker<Object,Date> asDate(String format)
    {
        TransitParentChecker transitParentChecker=new TransitParentChecker(new ToDateTransit(format));
        return transitParentChecker;
    }



    public static <ElemType>TransitParentChecker<List<ElemType>,ElemType> elem(int i)
    {

        TransitParentChecker<List<ElemType>,ElemType> transitParentChecker=new TransitParentChecker(new ToElemTransit(i));
        return transitParentChecker;
    }

    public static<ElemType>TransitParentChecker<Map,ElemType> val(String key)
    {
        TransitParentChecker<Map,ElemType> transitParentChecker=new TransitParentChecker(new ToValueTransit(key));
        return transitParentChecker;
    }

    public static<ElemType>TransitParentChecker<List<ElemType>,ElemType> prop(String key)
    {
        TransitParentChecker<List<ElemType>,ElemType> transitParentChecker=new TransitParentChecker(new ToPropTransit(key));
        return transitParentChecker;
    }

    public static EachChecker each()
    {
        return new EachChecker();
    }



}
