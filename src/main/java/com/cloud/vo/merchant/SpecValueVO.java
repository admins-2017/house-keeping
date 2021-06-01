package com.cloud.vo.merchant;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 康东伟
 * @date 2021/6/1
 */
@Data
public class SpecValueVO {

    private Long valueId;

    @ApiModelProperty(value = "规格值名称")
    private String valueName;
}
