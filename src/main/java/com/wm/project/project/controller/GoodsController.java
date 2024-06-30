package com.wm.project.project.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wm.project.project.entity.Goods;
import com.wm.project.project.entity.Users;
import com.wm.project.project.service.GoodsService;

import com.wm.project.project.util.CommonUtil;
import com.wm.project.project.util.PageResult;
import com.wm.project.project.util.Result;
import com.wm.project.project.util.page.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Goods)表控制层
 *
 * @author zyf
 * @since 2022-03-18 13:13:08
 */
@RestController
@RequestMapping("goods")
public class GoodsController {
    /**
     * 服务对象
     */
    @Resource
    private GoodsService goodsService;

    /**
     * 分页查询
     * @param models
     * @return
     */
    @PostMapping("selectPageByGoods")
    public PageResult selectPageByGoods(@RequestBody Map<String, Object> models) {
        PageRequest pageRequest = JSON.parseObject(JSON.toJSONString(models.get("pageRequest")), PageRequest.class);
        PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());
        List<Goods> goods = goodsService.selectPageByGoods(models);
        return new PageResult(new PageInfo<>(goods));
    }

    /**
     * 商品的上架与下架操作
     * @param goodsId
     * @return
     */
    @GetMapping("commit")
    public Result<Object> commit(String goodsId) {
        int commit = goodsService.commit(goodsId);
        if(commit==1){
            return CommonUtil.successResult();
        }else {
            return  CommonUtil.errorResult("操作失败");
        }
    }

    /**
     * 删除
     * @param goodsId
     * @return
     */
    @GetMapping("deleteById")
    public Result<Object> deleteById(String goodsId) {
        boolean b = goodsService.deleteById(goodsId);
        if(b){
            return CommonUtil.successResult();
        }else {
            return  CommonUtil.errorResult("删除失败");
        }
    }

    /**
     * 增加或者修改的操作
     * @param goods
     * @return
     */
    @PostMapping("insertOrUpdate")
    public Result<Object> insertOrUpdate(@RequestBody Goods goods) {
        int i = goodsService.insertOrUpdate(goods);
        if(i==1){
            return CommonUtil.successResult();
        }else {
            return  CommonUtil.errorResult("操作失败");
        }
    }

    /**
     * 申请操作
     * @param goodsId
     * @return
     */
    @GetMapping("isApplyedByGoodsId")
    public Result<Object> isApplyedByGoodsId(String goodsId) {
        int applyedByGoodsId = goodsService.isApplyedByGoodsId(goodsId);
        if(applyedByGoodsId==1){
            return CommonUtil.successResult();
        }else {
            return  CommonUtil.errorResult("删除失败");
        }
    }

    @PostMapping("selectAll")
    public Result<Object> selectAll() {
        List<Goods> goods = goodsService.selectAll();
        if(goods.size()!=0){
            return CommonUtil.successResult(goods);
        }else {
            return  CommonUtil.errorResult();
        }
    }

    /**
     * 微信接口查询分类得商品信息
     * @param goodsCategoryId
     * @return
     */
    @GetMapping("WxSelectByGoodsCategoryId")
    public Result<Object> WxSelectByGoodsCategoryId(String goodsCategoryId) {
        List<Goods> goods = goodsService.WxSelectByGoodsCategoryId(goodsCategoryId);
        if(goods.size()!=0){
            return CommonUtil.successResult(goods);
        }else {
            return  CommonUtil.errorResult();
        }
    }

    /**
     * 查询单条数据
     * @param goodsId
     * @return
     */
    @GetMapping("WxSelectByGoodsId")
    public Result<Object> WxSelectByGoodsId(String goodsId) {
        Goods goods = goodsService.WxSelectByGoodsId(goodsId);
        if(goods!=null){
            return CommonUtil.successResult(goods);
        }else {
            return  CommonUtil.errorResult();
        }
    }

}
