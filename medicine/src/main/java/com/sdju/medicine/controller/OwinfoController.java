package com.sdju.medicine.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.sdju.medicine.common.ResultMapUtil;
import com.sdju.medicine.entity.Owinfo;
import com.sdju.medicine.service.IOwinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

//药品出库相关的controller
@Controller
@RequestMapping(value = "/owinfo")
public class OwinfoController {
    @Autowired
    private IOwinfoService owinfoService;

    //    转向药品出库页面
    @RequestMapping
    public String owinfo() {
        return "/owinfo";
    }

    /**
     * 分页查询药品出库列表
     */
    @RequestMapping(value = "/owinfoQueryPage")
    @ResponseBody
    public Object owinfoQueryPage(String param, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            IPage<Owinfo> iPage = owinfoService.selectOwinfoPage(pageNum, pageSize, param);
            return ResultMapUtil.getHashMapMysqlPage(iPage);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向药品出库新增页面
     */
    @RequestMapping(value = "/owinfoPage")
    public String owinfoPage() {
        return "/owinfoPage";
    }

    /**
     * 添加一个药品出库
     */
    @RequestMapping(value = "/owinfoAdd")
    @ResponseBody
    public Object owinfoAdd(Owinfo owinfo) {
        try {
            owinfo.setCreatetime(new Date());
            int i = owinfoService.addOwinfo(owinfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 转向药品出库编辑页面
     */
    @RequestMapping(value = "/owinfoQueryById")
    public String owinfoQueryById(@RequestParam(name = "id", required = true) Integer id, Model model) {
        Owinfo owinfo = owinfoService.queryOwinfoById(id);
        model.addAttribute("obj", owinfo);
        return "/owinfoPage";
    }

    /**
     * 修改药品出库
     *
     * @return
     */
    @RequestMapping(value = "/owinfoEdit")
    @ResponseBody
    public Object owinfoEdit(Owinfo owinfo) {
        try {
            int i = owinfoService.editOwinfo(owinfo);
            return ResultMapUtil.getHashMapSave(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }

    /**
     * 删除一个药品出库
     */
    @RequestMapping(value = "/owinfoDelById")
    @ResponseBody
    public Object owinfoDelById(Integer id) {
        try {

            int i = owinfoService.delOwinfoById(id);
            return ResultMapUtil.getHashMapDel(i);
        } catch (Exception e) {
            return ResultMapUtil.getHashMapException(e);
        }
    }
}
