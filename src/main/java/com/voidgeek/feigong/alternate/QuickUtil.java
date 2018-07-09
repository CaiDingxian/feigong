package com.voidgeek.feigong.alternate;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Map;

public class QuickUtil {

    public static Object getAttr(String attrName,Object value)
    {
        Object obj=null;

        if(value instanceof Map)
        {
            Map m=(Map)value;
            obj=m.get(attrName);
        }
        else//通过内省访问属性
        {
            try {
                PropertyDescriptor propDesc=new PropertyDescriptor(attrName,value.getClass());
                Method m=propDesc.getReadMethod();
                obj=m.invoke(value);
            } catch (Exception e) {
                throw new RuntimeException("BEAN_VISIT_FAIL",e);
            }
        }
        return obj;
    }

    public static Double stringToDouble(String str)
    {
        double num=0;
        int decimalDigits=0;
        boolean hasDecimal=false;
        boolean sign=true;
        for(int i=0;i<str.length();i++) {

            char c=str.charAt(i);
            if(c=='-')
            {
                sign=false;
                continue;
            }
            else if(c=='+')
            {
                continue;
            }
            else if(c>='0'&&c<='9')
            {
                if(decimalDigits>0)
                {
                    double d=(c-48);
                    num+=(d/(Math.pow(10,decimalDigits)));
                }
                else {
                    num *= 10;
                    num += (c - 48);
                }
            }
            else if(c=='.')
            {
                hasDecimal=true;
            }
            else {
                return null;
            }
            if(hasDecimal)decimalDigits++;


        }
        if(false==sign)num=-num;
        return num;

    }



}
