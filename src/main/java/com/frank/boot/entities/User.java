package com.frank.boot.entities;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * 说明@NotBlank: 判断字符串是否为 null 或者是空串(去掉首尾空格)。
 * 说明@NotEmpty: 判断字符串是否 null 或者是空串。
 * 说明@Length: 判断字符的长度(最大或者最小)
 * 说明@Min: 判断数值最小值
 * 说明@Max: 判断数值最大值
 * 说明@Email: 判断邮箱是否合法
 *
 * @author Guozhong Xu
 * @version 1.0
 * @date Create in 16:39 2019/9/25
 */

@Data
public class User implements Serializable {
    private Integer id;
    @NotBlank(message = "用户名填一下")
    private String name;
    @Max(message = "年龄<150", value = 150L)
    private Integer age;
}
