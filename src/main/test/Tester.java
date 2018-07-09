import com.sun.istack.internal.NotNull;
import com.voidgeek.feigong.checker.IChecker;
import com.voidgeek.feigong.checker.impl.AssertChecker;
import com.voidgeek.feigong.checker.impl.InChecker;
import com.voidgeek.feigong.checker.impl.RangeChecker;
import com.voidgeek.feigong.checker.impl.StrLengthChecker;
import com.voidgeek.feigong.core.Err;
import static com.voidgeek.feigong.facade.Facades.*;
import org.junit.Test;

import java.util.*;
import static com.voidgeek.feigong.facade.Facades.*;
public class Tester<T> {


    public static void main(String...args)
    {
        String s=null;
        go(s);
        System.out.println("OK");
    }

    public static void go(@NotNull String s)
    {

    }

    @Test
    public void doTest()
    {




        Map map=new HashMap();
        String[] tags={"生活","人文","社会"};
        map.put("num",31415);
        map.put("title","标题");
        map.put("tags",tags);



        IChecker iChecker= asMap(
                val("num").checkers(asInt(min(1000),max(9999))),
                val("title").checkers(asStr(length(3,10))),
                val("tags").checkers(asList(
                            each().checkers(in("生活","科技")),
                            size(0,10)
                ))
        );






        Err e=iChecker.check(map);
        System.out.println(e.isOk());
        
//        AttrChecker obj=new AttrChecker<Integer>("");
//        AttrChecker obj2=new AttrChecker<Double>("");
//        Type genType = obj.getClass().getGenericSuperclass();
//        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
//        //Class clazz= (Class<T>) type.getActualTypeArguments()[0];
//
//        System.out.println(params[0]);
////        System.out.println(clazz.isInstance(obj));
////        System.out.println(clazz.isInstance(obj2));

//new At("").asInt().checkers(getAsserter(x->x>0));


//        StrLengthChecker strLengthChecker=new StrLengthChecker(10,25);
//
//        Err err=strLengthChecker.setId("lengthNotMatch").check("111111");
//
//        System.out.println(err.hasError());
//
//
//        System.out.println(Integer[].class);
//
//        System.out.printf("%9.10f",CastUtil.stringToDouble("-456123789.5594464"));

//        Collection collection=new LinkedHashSet();
//        collection.add(123);
//        collection.add(456);
//        collection.add(789);
//        List list=CastUtil.listLikeObjectTolist(collection);
//
//        System.out.println(CastUtil.parseDecimal("456456445644564464646"));
    }
//
//    public  <S> AttrChecker<S> as(Class<S> t)
//    {
//        return new AttrChecker<>("",t);
//    }
//
//
//
//    <S> AssertChecker<S> getAsserter(IAssert<S> iAssert)
//    {
//        return new AssertChecker(iAssert);
//
//    }

    public static <S> AssertChecker<S> getAsserter()
    {
        return null;

    }

}
