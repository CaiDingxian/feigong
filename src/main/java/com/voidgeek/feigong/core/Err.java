package com.voidgeek.feigong.core;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 *
 *
 *
 * **/
public class Err {

    private String id="unknown";//默认id为unknown
    private boolean errFlag=false;//错位标记为false，表示无错误

    private List<Err> subErrs=new ArrayList<>();
    Map<String,Object> msgParam;//添加参数以供未来映射错误消息的模版插值用


    public String getId() {
        return id;
    }

    public Err setId(String id) {
        this.id = id;
        return this;
    }

    public boolean isOk()
    {
        return !hasError();
    }

    public boolean hasError() {
        if(hasSubErr())return true;
        /*!!!有子错误时，无论标记如何，总是返回错误，因此Err无错的对象必定无子节点*/
        return errFlag;
    }

    public Err setError(boolean ok) {
        errFlag = ok;
        return this;
    }

    public void putSubErr(@NotNull Err err){
        if(null==err)return;
        //对id为null的Err对象，视为可以越过，直接将其所有子节点作为其父节点的子节点
        //!!! 一颗Err树中，只有根节点id可能为null
        if(null==err.getId())
        {
            //末端的id为空的Err将被忽略
            if(err.hasError())subErrs.addAll(err.getSubErrs());
        }
        else {

            subErrs.add(err);
        }
    }


    public boolean hasSubErr()
    {
        return !subErrs.isEmpty();
    }

    public @NotNull List<Err> getSubErrs() {
        return subErrs;
    }


    public Err putSubErr(@NotNull String errId)
    {
        this.putSubErr(new Err().setId(errId).setError(true));
        return this;
    }


    public Err putSubErrIf(@NotNull String err, boolean flag)
    {
        if(flag)this.putSubErr(err);
        return this;
    }

    public Err putSubErrIf(@NotNull Err err, boolean flag)
    {
        if(flag)putSubErr(err);
        return this;
    }

}
