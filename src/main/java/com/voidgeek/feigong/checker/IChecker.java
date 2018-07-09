package com.voidgeek.feigong.checker;


import com.voidgeek.feigong.core.Err;

/*所有Checker的父接口，AcceptType表示Checker可验证的对象类型
* 返回一个表示错误信息的Err对象
* */
public interface IChecker<AcceptType> {

    Err check(AcceptType t);
    //18-7-5已检查

}
