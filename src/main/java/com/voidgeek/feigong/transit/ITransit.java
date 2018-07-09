package com.voidgeek.feigong.transit;


import com.sun.istack.Nullable;

/**
 * 从SourceType对象转换为TargetType
 *
 * 输入SourceType参数，返回TargetType 对象
 * 转换失败将返回null
 * Checker通过getId取得错误id
 * **/
public interface ITransit<SourceType,TargetType> {

    @Nullable TargetType transit(SourceType s);

    String getId();
}
