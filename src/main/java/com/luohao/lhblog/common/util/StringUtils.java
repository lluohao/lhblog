package com.luohao.lhblog.common.util;

/**
 * Created by luohao on 2017/8/6.
 */
public class StringUtils {
    public static boolean isEmpty(String string){
        return string==null||string.length()==0;
    }

    public static boolean notEmpty(String string){
        return !isEmpty(string);
    }
}
