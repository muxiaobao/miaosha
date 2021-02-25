package com.miaoshaproject.response;

/**
 * 定义通用的返回类型 （指明响应状态：成功/失败， 和响应内容）
 */
public class CommonReturnType {
    // 表明对应请求的返回处理结果：success / fail
    private String status;

    // 若status=success，则data内返回前端需要的json数据
    // 若status=fail，则data内使用通用的错误码格式
    private Object data;

    // 定义一个通用的创建方法
    public static CommonReturnType create(Object data) {
        return CommonReturnType.create(data,"success");
    }

    public static CommonReturnType create(Object data, String status) {
        CommonReturnType type = new CommonReturnType();
        type.setData(data);
        type.setStatus(status);
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
