package com.cloud.merchant.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cloud.merchant.entity.SpecValue;
import com.cloud.merchant.service.ISpecValueService;
import com.cloud.utils.json.JSONResult;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
@RestController
@RequestMapping("/value")
public class SpecValueController {

    private final ISpecValueService valueService;

    public SpecValueController(ISpecValueService valueService) {
        this.valueService = valueService;
    }

    @PostMapping
    public JSONResult addValue(@RequestBody SpecValue value){
        valueService.save(value);
        return JSONResult.ok("新增规格值成功");
    }

    @PutMapping JSONResult updValue(@RequestBody SpecValue value){
        valueService.update(new UpdateWrapper<SpecValue>().lambda()
        .set(!"".equals(value.getValueName()),SpecValue::getValueName,value.getValueName())
        .set(null!=value.getKeyId(),SpecValue::getKeyId,value.getKeyId())
        .eq(SpecValue::getValueId,value.getValueId()));
        return JSONResult.ok("修改规格详情成功");
    }
}
