package com.cloud.merchant.service.impl;

import com.cloud.merchant.entity.Tag;
import com.cloud.merchant.mapper.TagMapper;
import com.cloud.merchant.service.ITagService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 康东伟
 * @since 2021-05-13
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {

}
