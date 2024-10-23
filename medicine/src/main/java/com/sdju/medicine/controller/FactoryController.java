package com.sdju.medicine.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sdju.medicine.common.ResultMapUtil;
import com.sdju.medicine.entity.Factory;
import com.sdju.medicine.service.IFactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

//供应商相关的controller
@Controller
@RequestMapping(value = "/factory")
public class FactoryController {

    @Autowired
    private IFactoryService factoryService;

    //    转向供应商页面
    @RequestMapping
    public String factory() {
        return "/factory";
    }

    /**
     * 分页查询供应商列表
     */
    @RequestMapping(value = "/factoryQueryPage")
    @ResponseBody
    public Object factoryQueryPage(String param, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            IPage<Factory> iPage = factoryService.selectFactoryPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向供应商新增页面
     */
    @RequestMapping(value = "/factoryPage")
    public String factoryPage() {
        return "/factoryPage";
    }

    /**
     * 添加一个供应商
     */
    @RequestMapping(value = "/factoryAdd")
    @ResponseBody
    public Object factoryAdd(Factory factory) {
        try {
            factory.setCreatetime(new Date());
            int i = factoryService.addFactory(factory);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向供应商编辑页面
     */
    @RequestMapping(value = "/factoryQueryById")
    public String factoryQueryById(@RequestParam(name = "id") Integer id, Model model) {
        Factory factory = factoryService.queryFactoryById(id);
        model.addAttribute("obj", factory);
        return "/factoryPage";
    }

    /**
     * 修改供应商
     *
     * @return
     */
    @RequestMapping(value = "/factoryEdit")
    @ResponseBody
    public Object factoryEdit(Factory factory) {
        try {
            int i = factoryService.editFactory(factory);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个供应商
     */
    @RequestMapping(value = "/factoryDelById")
    @ResponseBody
    public Object factoryDelById(Integer id) {
        try {
            int i = factoryService.delFactoryById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 获取所有供应商
     */
    @RequestMapping(value = "/factoryList")
    @ResponseBody
    public Object factoryList() {
        List<Factory> factoryList = factoryService.queryFactoryList();
        return ResultMapUtil.getHashMapList(factoryList);
    }
}
