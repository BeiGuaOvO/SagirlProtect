package com.beigua.sagirlprotect.Exception;

public class ConfigDataNotFoundException extends Exception {
    public ConfigDataNotFoundException(){
        super("未能找到此数据");
    }

    public ConfigDataNotFoundException(String str){
        super(str);
    }
}
