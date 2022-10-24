package com.common.web.domain;

/**
 * @author golf
 * @date 2022/10/21 17:09
 */
public class CommonResult<T> {
    /**
     * 状态码
     */
    private final Integer code;
    /**
     * 提示信息
     */
    private final String message;
    /**
     * 数据
     */
    private final T data;

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回结果
     *
     * @param data 获取的数据
     * @return 返回结果
     */
    public static <T> CommonResult<T> success(T data) {
        return new CommonResult<>(200, "操作成功", data);
    }

    /**
     * 成功返回结果-自定义消息内容
     *
     * @param data    获取的数据
     * @param message 提示信息
     * @return 返回结果
     */
    public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<>(200, message, data);
    }


    public static <T> CommonResult<T> error(Integer code, String message) {
        if (code == null) {
            return new CommonResult<>(500, message, null);
        }
        return new CommonResult<>(code, message, null);
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
