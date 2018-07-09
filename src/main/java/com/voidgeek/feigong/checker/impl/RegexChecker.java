package com.voidgeek.feigong.checker.impl;


import com.sun.istack.NotNull;
import com.voidgeek.feigong.checker.BinaryAbstractChecker;

import java.util.regex.Pattern;

public class RegexChecker extends BinaryAbstractChecker<String,RegexChecker> {

    private String exp;
    private Pattern pattern;
    public RegexChecker(@NotNull String exp)
    {
        this.exp=exp;
        Pattern pattern=Pattern.compile(exp);
        this.pattern=pattern;
    }


    @Override
    public boolean doCheck(@NotNull String s) {

        return pattern.matcher(s).find();
    }

    @Override
    public String getDefaultId() {
        return "regex";
    }
}
