package com.javaclimb.medicine.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.medicine.common.ResultMapUtil;
import com.javaclimb.medicine.entity.Storageinfo;
import com.javaclimb.medicine.service.IStorageinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

//药品出库相关的controller
@Controller
@RequestMapping(value = "/storageinfo")
public class StorageinfoController {
    @Autowired
    private IStorageinfoService storageinfoService;
//    转向药品出库页面
    @RequestMapping
public String storageinfo(){
        return "/storageinfo" ;
}
/**
 * 分页查询药品出库列表
 */
@RequestMapping(value = "/storageinfoQueryPage")
@ResponseBody
public Object storageinfoQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
    try{
        IPage<Storageinfo> iPage = storageinfoService.selectStorageinfoPage(pageNum,pageSize,param);
        return ResultMapUtil.getHashMapMysqlPage(iPage);
    }catch (Exception e){
        return ResultMapUtil.getHashMapException(e);
    }
}
/**
 * 转向药品出库新增页面
 */
@RequestMapping(value = "/storageinfoPage")
    public String storageinfoPage(){
    return "/storageinfoPage";
}
/**
 * 添加一个药品出库
 */
@RequestMapping(value = "/storageinfoAdd")
    @ResponseBody
    public Object storageinfoAdd(Storageinfo storageinfo){
   try{
       storageinfo.setCreatetime(new Date());
       int i = storageinfoService.addStorageinfo(storageinfo);
       return  ResultMapUtil.getHashMapSave(i);
   }catch (Exception e){
       return ResultMapUtil.getHashMapException(e);
   }
}
    /**
     * 转向药品出库编辑页面
     */
    @RequestMapping(value = "/storageinfoQueryById")
    public String storageinfoQueryById(@RequestParam(name ="id",required = true)Integer id, Model model){
        Storageinfo storageinfo = storageinfoService.queryStorageinfoById(id);
        model.addAttribute("obj",storageinfo);
        return "/storageinfoPage";
    }

    /**
     * 修改药品出库
     * @param storageinfo
     * @return
     */
    @RequestMapping(value = "/storageinfoEdit")
    @ResponseBody
    public Object storageinfoEdit(Storageinfo storageinfo){
        try{
            int i = storageinfoService.editStorageinfo(storageinfo);
            return  ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 删除一个药品出库
     *
     *
     */
    @RequestMapping(value = "/storageinfoDelById")
    @ResponseBody
    public Object storageinfoDelById(Integer id){
        try{

            int i = storageinfoService.delStorageinfoById(id);
            return  ResultMapUtil.getHashMapDel(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
}
