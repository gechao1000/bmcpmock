package com.budata.mock.model;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * BaseParam class
 *
 * @author gexc
 * @date 2019/05/24
 */
@Data
public class BaseParam {

    @NotNull(message = "JLBH不能为空")
    private Integer jlbh;
}
