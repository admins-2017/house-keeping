package com.cloud.utils.interchangeable;

import com.cloud.vo.sys.MenuVO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * 遍历三级权限菜单树
 * @author 康东伟
 * @date 2020-02-14
 */
public class ParseMenuTreeUtil {

    /**
     *  组装目录
     * @param list 数据库里面获取到的全量目录列表
     * @return 权限菜单集合
     */
    public static List<MenuVO> parseMenuTree(List<MenuVO> list){
        List<MenuVO> result = new ArrayList<>();
        //使用迭代器进行根目录获取 并将已经添加到result中菜单删除
        Iterator<MenuVO> iterator = list.iterator();
        while (iterator.hasNext()) {
            MenuVO menu = iterator.next();
            if(0 == menu.getParentId()) {
                result.add(menu);
                iterator.remove();
            }
        }
        // 2、递归获取菜单节点
        for (MenuVO parent : result) {
            parent = recursiveTree(parent, list);
        }
        // 将没有父级目录的二级菜单 添加到result中
        for (MenuVO menu : list) {
            if(1 == menu.getMenuType()) {
                result.add(menu);
            }
        }

        return result;
    }

    /**
     * 遍历二级菜单
     * @param parent 父类目录
     * @param list 权限列表
     * @return 目录及目录下菜单 对象
     */
    public static MenuVO recursiveTree(MenuVO parent, List<MenuVO> list) {
        //使用迭代器根据父级id进行递归子节点 并将以添加的目录删除
        Iterator<MenuVO> iterator = list.iterator();
        while (iterator.hasNext()) {
            MenuVO vo = iterator.next();
            if(parent.getMenuId() .equals( vo.getParentId())) {
                parent.getChildren().add(vo);
                if (vo.getMenuType()==1){
                    recursiveButton(vo,list);
                }
                iterator.remove();
            }
        }
        return parent;
    }

    /**
     * 遍历三级按钮
     * @param parent 父类菜单
     * @param list 权限列表
     * @return 菜单及菜单下按钮 对象
     */
    public static MenuVO recursiveButton(MenuVO parent, List<MenuVO> list) {
        //使用迭代器根据父级id进行递归子节点 并将以添加的目录删除
        Iterator<MenuVO> iterator = list.iterator();
        while (iterator.hasNext()) {
            MenuVO vo = iterator.next();
            if(parent.getMenuId() .equals( vo.getParentId())) {
                parent.getChildren().add(vo);
            }
        }
        return parent;
    }
}
