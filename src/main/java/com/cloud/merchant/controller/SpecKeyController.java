package com.cloud.merchant.controller;


import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cloud.merchant.entity.SpecKey;
import com.cloud.merchant.service.ISpecKeyService;
import com.cloud.utils.json.JSONResult;
import com.cloud.vo.merchant.SpecKeyVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 规格名控制类
 * @author 康东伟
 * @since 2021-05-13
 */
@RestController
@RequestMapping("/key")
public class SpecKeyController {

    private final ISpecKeyService keyService;

    public SpecKeyController(ISpecKeyService keyService) {
        this.keyService = keyService;
    }

    @PostMapping
    public JSONResult addKey(@RequestBody SpecKey key){
        keyService.save(key);
        return JSONResult.ok("添加规格名称成功");
    }

    @PutMapping
    public JSONResult updateKey(@RequestBody SpecKey key){
        keyService.update(new UpdateWrapper<SpecKey>().lambda()
                .set(!"".equals(key.getKeyName()),SpecKey::getKeyName,key.getKeyName())
                .set(!"".equals(key.getKeyDescription()),SpecKey::getKeyDescription,key.getKeyDescription())
                .set(!"".equals(key.getKeyUnit()),SpecKey::getKeyUnit,key.getKeyUnit())
                .eq(SpecKey::getKeyId,key.getKeyId()));
        return JSONResult.ok("修改规格详情成功");
    }

    @GetMapping
    public JSONResult getAll(){
        List<SpecKeyVO> keys = keyService.getAllKeyAndValue();
        return JSONResult.ok(keys);
    }

}
