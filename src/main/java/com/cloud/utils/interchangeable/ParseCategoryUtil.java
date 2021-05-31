package com.cloud.utils.interchangeable;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.vo.merchant.CategoryVO;
import java.util.Iterator;
import java.util.List;


/**
 * 遍历二级分类菜单
 * @author 康东伟
 * @date 2020-02-14
 */
public class ParseCategoryUtil {


    /**
     *  组装目录
     * @param vos 一级分类
     * @param children 二级分类
     * @return 权限菜单集合
     */
    public static Page<CategoryVO> parseCategoryTree(Page<CategoryVO> vos, List<CategoryVO> children){
        List<CategoryVO> fatherVo = vos.getRecords();
        // 2、递归获取菜单节点
        for (CategoryVO parent : fatherVo) {
            recursiveTree(parent, children);
        }
        vos.setRecords(fatherVo);
        return vos;
    }

    /**
     * 遍历二级菜单
     * @param parent 父类目录
     * @param list 权限列表
     */
    private static void recursiveTree(CategoryVO parent, List<CategoryVO> list) {
        //使用迭代器根据父级id进行递归子节点 并将以添加的目录删除
        Iterator<CategoryVO> iterator = list.iterator();
        while (iterator.hasNext()) {
            CategoryVO vo = iterator.next();
            if(parent.getCategoryId() .equals( vo.getParentId())) {
                parent.getChildren().add(vo);
                iterator.remove();
            }
        }
    }
}
