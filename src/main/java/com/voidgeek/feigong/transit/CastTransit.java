package com.voidgeek.feigong.transit;

import com.voidgeek.feigong.core.CastUtil;

import java.util.List;

public class CastTransit implements ITransit{

    public CastTransit(Class targetClass) {
        this.targetClass = targetClass;
    }

    private Class targetClass;


    @Override
    public Object transit(Object s) {

        if(s.getClass().equals(String.class))
        {
            if(targetClass.equals(Integer.class))      {
                this.setId("toInt");
                return CastUtil.parseInt((String) s);
            }
            else if(targetClass.equals(Long.class))    {
                this.setId("toLong");
                return CastUtil.parseLong((String)s);
            }
            else if(targetClass.equals(Boolean.class)) {
                this.setId("toBool");
                return CastUtil.parseBoolean((String)s);
            }
            else if(targetClass.equals(Double.class))  {
                this.setId("toDouble");
                return CastUtil.parseDouble((String)s);
            }
            else if(targetClass.equals(Float.class))   {
                this.setId("toFloat");
                return CastUtil.parseFloat((String)s);
            }
        }
        if(targetClass.equals(String.class))
        {
            return s.toString();
        }
        else if(targetClass.equals(List.class))
        {
            return CastUtil.listLikeObjectTolist(s);
        }
        else if(targetClass.isInstance(s))
        {
            return s;
        }


        return null;
    }

    String id="cast";
    public CastTransit setId(String id)
    {
        this.id=id;
        return this;
    }

    @Override
    public String getId() {
        return id;
    }
}
