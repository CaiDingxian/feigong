package com.voidgeek.feigong.checker;


import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import com.voidgeek.feigong.core.Err;

/*
* 实现IChecker的抽象类
*
* AcceptType继承自IChecker
* SpecificType 表示继承了该抽象类的子类类型，用于链式方法能返回叶子类的对象而不是返回抽象类
*
* */
public abstract class AbstractChecker<AcceptType,SpecificType extends AbstractChecker> implements IChecker<AcceptType> {


    private final String  DEFAULT_NULL_ID="null";


    private String id=null;

    public abstract String getDefaultId();

    public String getId() {
        if(null==id)return getDefaultId();
        //注意，id为null时调用getDefaultId()可能也取得null,但这是不是异常，null表示该Checker节点
        return id;
    }

    public SpecificType setId(@Nullable String id) {
        this.id = id;
        return (SpecificType)this;
    }



    public boolean isAllowNull() {
        return allowNullFlag;
    }
    public SpecificType allowNull() {
        this.allowNullFlag = true;
        return (SpecificType)this;
    }
    boolean allowNullFlag=false;

    public String getNullId() {
        return nullId;
    }

    public SpecificType setNullId(@NotNull String nullId) {
        this.nullId = nullId;
        return (SpecificType)this;
    }

    String nullId=DEFAULT_NULL_ID;


    /**
     * @param accept
     * 被检查参数accept为空的情况并不是异常
     * 仅仅是被验证对象不合法，这属于正常逻辑，并将返回错误信息
     *
     * @return  Err 返回的Err总是不为空
     * **/
    @Override
    public @NotNull Err check(@Nullable AcceptType accept) {
        if(null==accept)
        {
            if(allowNullFlag)
            {
                return new Err().setId(this.getId());//保证返回的Err不能为空，程序员调用时不必验证
            }
            else {

                return new Err().setId(this.getId()).putSubErr(this.getNullId());
            }
        }
        else {
            Err err = new Err().setId(this.getId());//创建一个 错误信息 对象，以本CheckerId为id,默认为没有错误
            doCheck(err, accept);//将操作委托给docheck，使验证方法对程序员实现更友好

            return err;
        }
    }

    /**
     * 此方法由check方法调用
     * @param err 由check()方法创建并传入，总是不为空
     * @param accept check()方法检测到accept为空时不会调用此方法，所以
     * 此参数总不为空
     * **/
    public abstract void doCheck(@NotNull Err err, @NotNull AcceptType accept);



}
