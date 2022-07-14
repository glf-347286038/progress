package com.util.traceid.pojo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @Author: golf
 * @Date: 2022/7/14 13:19
 */
@Data
public class MessageDTO {
    /**
     * 描述
     */
    @NotBlank(message = "描述不能为空")
    private String description;
    /**
     * 数字
     */
    @Min(value = 10, message = "数字不能小于10")
    private Integer num;
}
