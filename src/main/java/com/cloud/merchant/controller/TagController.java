package com.cloud.merchant.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cloud.merchant.entity.Tag;
import com.cloud.merchant.service.ITagProjectService;
import com.cloud.merchant.service.ITagService;
import com.cloud.utils.json.JSONResult;
import com.cloud.vo.merchant.ProjectByTagVO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
@RestController
@RequestMapping("/tag")
public class TagController {

    private final ITagService service;

    public TagController(ITagService tagService) {
        this.service = tagService;
    }

    @PostMapping
    public JSONResult addTag(@RequestBody Tag tag){
        service.save(tag);
        return JSONResult.ok("标签保存成功");
    }

    @PutMapping
    public JSONResult updateTag(@RequestBody Tag tag){
        service.update(new UpdateWrapper<Tag>().lambda()
        .set(!"".equals(tag.getTagName()),Tag::getTagName,tag.getTagName())
        .set(!"".equals(tag.getTagDescription()),Tag::getTagDescription,tag.getTagDescription())
        .set(tag.getTagIsHighight()!=null,Tag::getTagIsHighight,tag.getTagIsHighight())
        .eq(Tag::getTagId,tag.getTagId()));
        return JSONResult.ok();
    }

    @DeleteMapping("/{id}")
    public JSONResult delTag(@PathVariable Long id){
        service.deleteTag(id);
        return JSONResult.ok("删除标签成功");
    }

    @GetMapping
    public JSONResult getAllTag(){
        List<Tag> tags = this.service.list(new QueryWrapper<Tag>().lambda().eq(Tag::getTagStatus, 1));
        return JSONResult.ok(tags);
    }

    @GetMapping("/{id}")
    public JSONResult getProjectByTag(@PathVariable Long id){
        List<ProjectByTagVO> vos = this.service.getProject(id);
        return JSONResult.ok(vos);
    }

}
