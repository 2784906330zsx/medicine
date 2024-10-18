package com.javaclimb.medicine.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.medicine.common.ResultMapUtil;
import com.javaclimb.medicine.entity.Medicineinfo;
import com.javaclimb.medicine.entity.Supplier;
import com.javaclimb.medicine.service.IMedicineinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

//药品相关的controller
@Controller
@RequestMapping(value = "/medicineinfo")
public class MedicineinfoController {
    @Autowired
    private IMedicineinfoService medicineinfoService;
//    转向药品页面
    @RequestMapping
public String medicineinfo(){
        return "/medicineinfo" ;
}
/**
 * 分页查询药品列表
 */
@RequestMapping(value = "/medicineinfoQueryPage")
@ResponseBody
public Object medicineinfoQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
    try{
        IPage<Medicineinfo> iPage = medicineinfoService.selectMedicineinfoPage(pageNum,pageSize,param);
        return ResultMapUtil.getHashMapMysqlPage(iPage);
    }catch (Exception e){
        return ResultMapUtil.getHashMapException(e);
    }
}
/**
 * 转向药品新增页面
 */
@RequestMapping(value = "/medicineinfoPage")
    public String medicineinfoPage(){
    return "/medicineinfoPage";
}
/**
 * 添加一个药品
 */
@RequestMapping(value = "/medicineinfoAdd")
    @ResponseBody
    public Object medicineinfoAdd(Medicineinfo medicineinfo){
   try{
       int i = medicineinfoService.addMedicineinfo(medicineinfo);
       return  ResultMapUtil.getHashMapSave(i);
   }catch (Exception e){
       return ResultMapUtil.getHashMapException(e);
   }
}
    /**
     * 转向药品编辑页面
     */
    @RequestMapping(value = "/medicineinfoQueryById")
    public String medicineinfoQueryById(@RequestParam(name ="id",required = true)Integer id, Model model){
        Medicineinfo medicineinfo = medicineinfoService.queryMedicineinfoById(id);
        model.addAttribute("obj",medicineinfo);
        return "/medicineinfoPage";
    }

    /**
     * 修改药品
     * @param medicineinfo
     * @return
     */
    @RequestMapping(value = "/medicineinfoEdit")
    @ResponseBody
    public Object medicineinfoEdit(Medicineinfo medicineinfo){
        try{
            int i = medicineinfoService.editMedicineinfo(medicineinfo);
            return  ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 删除一个药品
     *
     *
     */
    @RequestMapping(value = "/medicineinfoDelById")
    @ResponseBody
    public Object medicineinfoDelById(Integer id){
        try{
            int i = medicineinfoService.delMedicineinfoById(id);
            return  ResultMapUtil.getHashMapDel(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 获取所有药品
     */
    @RequestMapping(value = "/medicineinfoList")
    @ResponseBody
    public Object medicineinfoList(){
        List<Medicineinfo> medicineinfoList = medicineinfoService.queryMedicineinfoList();
        return ResultMapUtil.getHashMapList(medicineinfoList);
    }
/**
 * 转向药品保质期检查页面
 */
    @RequestMapping(value = "/warrenty")
    public String warrenty(){
        return "/warrenty";
    }
}
