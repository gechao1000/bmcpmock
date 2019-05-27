package com.budata.mock.util;

import java.util.HashMap;

/**
 * R class
 *
 * @author gexc
 * @date 2019/05/24
 */
public class R extends HashMap<String, Object> {

    /////////////////////// 默认的键 ///////////////////////

    public static final String KEY_OPER = "oper";
    public static final String KEY_SUCC = "succ";
    public static final String KEY_CODE = "code";
    public static final String KEY_MSG = "msg";
    public static final String KEY_DATA = "data";

    /////////////////////// 默认的值 ///////////////////////

    public static final String DEFAULT_OPER_VAL = "default";
    public static final int DEFAULT_SUCC_CODE = 1;
    public static final int DEFAULT_FAIL_CODE = -1;
    public static final String DEFAULT_SUCC_MSG = "ok";
    public static final String DEFAULT_FAIL_MSG = "fail";


    /////////////////////// 最通用的两个构造函数 ///////////////////////

    /**
     * 无参构造：操作成功返回的响应信息
     */
    public R() {
        this.put(KEY_OPER,DEFAULT_OPER_VAL);
        this.put(KEY_SUCC,true);
        this.put(KEY_CODE,DEFAULT_SUCC_CODE);
        this.put(KEY_MSG,DEFAULT_SUCC_MSG);
    }

    /**
     * 操作成功返回的响应信息
     */
    public R(String oper) {
        this.put(KEY_OPER,oper);
        this.put(KEY_SUCC,true);
        this.put(KEY_CODE,DEFAULT_SUCC_CODE);
        this.put(KEY_MSG,DEFAULT_SUCC_MSG);
    }

    /**
     * 全参构造
     * @param operate
     * @param success
     * @param code
     * @param msg
     * @param data
     */
    public R(String operate, boolean success, int code, String msg, Object data) {
        this.put(KEY_OPER,operate);
        this.put(KEY_SUCC,success);
        this.put(KEY_CODE,code);
        this.put(KEY_MSG,msg);
        if (data!=null){
            this.put(KEY_DATA,data);
        }
    }

    /////////////////////// 各种简便的静态工厂方法 ///////////////////////

    ////// 操作成功的：

    public static R succ() {
        return new R();
    }

    public static R succ(String operate) {
        return new R(operate,true, DEFAULT_SUCC_CODE, DEFAULT_SUCC_MSG,null);
    }

    public static R succ(String operate, String message) {
        return new R(operate,true, DEFAULT_SUCC_CODE, message,null);
    }

    public static R succ(String operate, Object data) {
        return new R(operate,true, DEFAULT_SUCC_CODE, DEFAULT_SUCC_MSG,data);
    }

    public static R succ(String operate, String dataKey, Object dataVal) {
        return new R(operate,true, DEFAULT_SUCC_CODE, DEFAULT_SUCC_MSG,null)
                .data(dataKey,dataVal);
    }

    ////// 操作失败的：

    public static R fail() {
        return new R(DEFAULT_OPER_VAL,false,DEFAULT_FAIL_CODE,DEFAULT_FAIL_MSG,null);
    }

    public static R fail(String operate) {
        return new R(operate,false, DEFAULT_FAIL_CODE, DEFAULT_FAIL_MSG,null);
    }

    public static R fail(String operate, String message) {
        return new R(operate,false, DEFAULT_FAIL_CODE, message,null);
    }

    public static R fail(String operate, Object data) {
        return new R(operate,false, DEFAULT_FAIL_CODE, DEFAULT_FAIL_MSG,data);
    }

    public static R fail(String operate, String dataKey, Object dataVal) {
        return new R(operate,false, DEFAULT_FAIL_CODE, DEFAULT_FAIL_MSG,null)
                .data(dataKey,dataVal);
    }

    ////// 操作动态判定成功或失败的：

    public static R result(String operate, boolean success) {
        return new R(
                operate,
                success,
                (success?DEFAULT_SUCC_CODE:DEFAULT_FAIL_CODE),
                (success?DEFAULT_SUCC_MSG:DEFAULT_FAIL_MSG),
                null);
    }

    public static R result(String operate, boolean success, Object data) {
        return new R(
                operate,
                success,
                (success?DEFAULT_SUCC_CODE:DEFAULT_FAIL_CODE),
                (success?DEFAULT_SUCC_MSG:DEFAULT_FAIL_MSG),
                data);
    }

    public static R result(String operate, boolean success, String dataKey, Object dataVal) {
        return new R(
                operate,
                success,
                (success?DEFAULT_SUCC_CODE:DEFAULT_FAIL_CODE),
                (success?DEFAULT_SUCC_MSG:DEFAULT_FAIL_MSG),
                null)
                .data(dataKey,dataVal);
    }

    /////////////////////// 各种链式调用方法 ///////////////////////

    /** 设置操作名称 */
    public R oper(String operate){
        this.put(KEY_OPER,operate);
        return this;
    }

    /** 设置操作结果是否成功的标记 */
    public R succ(boolean success){
        this.put(KEY_SUCC,success);
        return this;
    }

    /** 设置操作结果的代码 */
    public R code(int code){
        this.put(KEY_CODE,code);
        return this;
    }

    /** 设置操作结果的信息 */
    public R msg(String message){
        this.put(KEY_MSG,message);
        return this;
    }

    /** 设置操作返回的数据 */
    public R data(Object dataVal){
        this.put(KEY_DATA,dataVal);
        return this;
    }

    /** 设置操作返回的数据，数据使用自定义的key存储 */
    public R data(String dataKey, Object dataVal){
        this.put(dataKey,dataVal);
        return this;
    }

}