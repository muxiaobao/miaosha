package com.miaoshaproject.error;

public enum EmBusinessError implements CommonError {
    // 通用错误类型00001
    PARAMETER_VALIDATION_ERROR(00001, "参数不合法"),

    // 10000开头为用户信息相关错误定义
    USER_NOT_EXIST(10001, "用户不存在")
    ;

    private EmBusinessError(int errCode, String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private int errCode;
    private String errMsg;

    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }


    // 通用错误类型在不同场景下，“参数”有不同的含义，它可以是用户名/邮箱/..., 因此需要该函数来修改errMsg
    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
