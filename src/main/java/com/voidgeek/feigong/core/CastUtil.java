package com.voidgeek.feigong.core;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CastUtil {


    public static List listLikeObjectTolist(Object object)
    {
        List list=null;
        if(object.getClass().isArray())
        {

            Object[] arr=(Object[]) object;
            list= Arrays.asList(arr);
        }
        if(object instanceof Iterable)
        {
            list=new ArrayList();
            Iterable iterable=(Iterable)object;
            for(Object n:iterable)
            {
                list.add(n);
            }
        }
        return list;

    }

    /*
    以下方法由JDK的parseXXX方法改写
    为了避免了异常对性能的影响，对不合法的输入一律直接返回null
    */

    public static Long parseLong(String s)
    {
        int radix=10;
        if (s == null) {
            return null;
        }

        if (radix < Character.MIN_RADIX) {
            return null;
        }
        if (radix > Character.MAX_RADIX) {
            return null;
        }

        long result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        long limit = -Long.MAX_VALUE;
        long multmin;
        int digit;

        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Long.MIN_VALUE;
                } else if (firstChar != '+')
                    return null;

                if (len == 1) // Cannot have lone "+" or "-"
                    return null;
                i++;
            }
            multmin = limit / radix;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(s.charAt(i++),radix);
                if (digit < 0) {
                    return null;
                }
                if (result < multmin) {
                    return null;
                }
                result *= radix;
                if (result < limit + digit) {
                    return null;
                }
                result -= digit;
            }
        } else {
            return null;
        }
        return negative ? result : -result;
    }


    public static Integer parseInt(String s)
    {
        int radix=10;
        if (s == null||radix < Character.MIN_RADIX||radix > Character.MAX_RADIX) {
            return null;
        }
        int result = 0;
        boolean negative = false;
        int i = 0, len = s.length();
        int limit = -Integer.MAX_VALUE;
        int multmin;
        int digit;

        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+')
                    return null;

                if (len == 1) // Cannot have lone "+" or "-"
                    return null;
                i++;
            }
            multmin = limit / radix;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(s.charAt(i++),radix);
                if (digit < 0) {
                    return null;
                }
                if (result < multmin) {
                    return null;
                }
                result *= radix;
                if (result < limit + digit) {
                    return null;
                }
                result -= digit;
            }
        } else {
            return null;
        }
        return negative ? result : -result;
    }




    public static Boolean parseBoolean(String s) {
        if(null==s)return null;
        if(s.equalsIgnoreCase("true")||s.equals("1"))return true;
        else if(s.equalsIgnoreCase("false")||s.equals("0"))return false;
        return null;
    }


    public static Double parseDouble(String str)
    {
        if(null==str)return null;
        BigDecimal bigDecimal=parseDecimal(str);
        if(null==bigDecimal)return null;
        else if(bigDecimal.compareTo(new BigDecimal(Double.MAX_VALUE))>0
                ||bigDecimal.compareTo(new BigDecimal(Double.MIN_VALUE))<0)return null;
        else {
            return bigDecimal.doubleValue();
        }
    }

    public static Float parseFloat(String str)
    {
        if(null==str)return null;
        BigDecimal bigDecimal=parseDecimal(str);
        if(null==bigDecimal)return null;
        else if(bigDecimal.compareTo(new BigDecimal(Float.MAX_VALUE))>0
                ||bigDecimal.compareTo(new BigDecimal(Float.MIN_VALUE))<0)return null;
        else {
            return bigDecimal.floatValue();
        }
    }

    public static BigDecimal parseDecimal(String str)
    {
        if(null==str)return null;
        int dotNum=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)=='+'||str.charAt(i)=='-')
            {
                if(i!=0)return null;
            }
            else if(str.charAt(i)=='.')
            {
                if(dotNum>0)return null;
                dotNum++;
            }
            else if('0'<=str.charAt(i)&&'9'>=str.charAt(i))
            {
                continue;
            }
            else {
                return null;
            }
        }

        BigDecimal bigDecimal=new BigDecimal(str);

        return bigDecimal;
    }


    /*Date的解析暂用JDK原版解析*/
    public static Date parseDate(String s,String format) {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        try {
            Date date=simpleDateFormat.parse(s);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }











}
