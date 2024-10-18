package com.javaclimb.medicine.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.javaclimb.medicine.common.ResultMapUtil;
import com.javaclimb.medicine.entity.Billinfo;
import com.javaclimb.medicine.service.IBillinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//收到账单信息相关的controller
@Controller
@RequestMapping(value = "/billinfo")
public class BillinfoController {
    @Autowired
    private IBillinfoService billinfoService;
//    转向收到账单信息页面
    @RequestMapping
public String billinfo(){
        return "/billinfo" ;
}
/**
 * 分页查询收到账单信息列表
 */
@RequestMapping(value = "/billinfoQueryPage")
@ResponseBody
public Object billinfoQueryPage(String param, @RequestParam(defaultValue = "1")int pageNum,@RequestParam(defaultValue = "10")int pageSize){
    try{
        IPage<Billinfo> iPage = billinfoService.selectBillinfoPage(pageNum,pageSize,param);
        return ResultMapUtil.getHashMapMysqlPage(iPage);
    }catch (Exception e){
        return ResultMapUtil.getHashMapException(e);
    }
}
/**
 * 转向收到账单信息新增页面
 */
@RequestMapping(value = "/billinfoPage")
    public String billinfoPage(){
    return "/billinfoPage";
}
/**
 * 添加一个收到账单信息
 */
@RequestMapping(value = "/billinfoAdd")
    @ResponseBody
    public Object billinfoAdd(Billinfo billinfo){
   try{
//       billinfo.setOperatetime(new Date());
       int i = billinfoService.addBillinfo(billinfo);
       return  ResultMapUtil.getHashMapSave(i);
   }catch (Exception e){
       return ResultMapUtil.getHashMapException(e);
   }
}
    /**
     * 转向收到账单信息编辑页面
     */
    @RequestMapping(value = "/billinfoQueryById")
    public String billinfoQueryById(@RequestParam(name ="id",required = true)Integer id, Model model){
        Billinfo billinfo = billinfoService.queryBillinfoById(id);
        model.addAttribute("obj",billinfo);
        return "/billinfoPage";
    }

    /**
     * 修改收到账单信息
     * @param billinfo
     * @return
     */
    @RequestMapping(value = "/billinfoEdit")
    @ResponseBody
    public Object billinfoEdit(Billinfo billinfo){
        try{
            int i = billinfoService.editBillinfo(billinfo);
            return  ResultMapUtil.getHashMapSave(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
    /**
     * 删除一个收到账单信息
     *
     *
     */
    @RequestMapping(value = "/billinfoDelById")
    @ResponseBody
    public Object billinfoDelById(Integer id){
        try{

            int i = billinfoService.delBillinfoById(id);
            return  ResultMapUtil.getHashMapDel(i);
        }catch (Exception e){
            return ResultMapUtil.getHashMapException(e);
        }
    }
}
