package com.wm.project.project.controller;

import com.wm.project.project.entity.Goods;
import com.wm.project.project.entity.GoodsCategory;
import com.wm.project.project.service.GoodsCategoryService;

import com.wm.project.project.util.CommonUtil;
import com.wm.project.project.util.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (GoodsCategory)表控制层
 *
 * @author makejava
 * @since 2022-03-30 16:07:05
 */
@RestController
@RequestMapping("goodsCategory")
public class GoodsCategoryController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsCategoryService goodsCategoryService;

    @PostMapping("selectAll")
    public Result<Object> selectAll() {
        List<GoodsCategory> goods = goodsCategoryService.selectAll();
        if(goods.size()!=0){
            return CommonUtil.successResult(goods);
        }else {
            return  CommonUtil.errorResult();
        }
    }
}

