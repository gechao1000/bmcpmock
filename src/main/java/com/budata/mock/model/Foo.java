package com.budata.mock.model;

import lombok.Data;

import javax.validation.constraints.Min;

/**
 * 分组校验
 *
 * @author gexc
 * @date 2019/05/27
 */
@Data
public class Foo {

    @Min(value = 18, groups = {})
    private Integer age;

    public interface Adult {}

    public interface Minor {}
}
