package com.cloud.vo.merchant;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @author 康东伟
 * @date 2021/6/1
 */
@Data
public class SpecKeyVO {

    private Long keyId;

    @ApiModelProperty(value = "规格名称")
    private String keyName;

    @ApiModelProperty(value = "规格单位")
    private String keyUnit;

    @ApiModelProperty(value = "规格描述")
    private String keyDescription;

    private List<SpecValueVO> values;
}
