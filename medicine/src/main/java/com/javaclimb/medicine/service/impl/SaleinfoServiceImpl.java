package com.javaclimb.medicine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.medicine.entity.Saleinfo;
import com.javaclimb.medicine.mapper.SaleinfoMapper;
import com.javaclimb.medicine.service.ISaleinfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//销售记录service实现类
@Service
public class SaleinfoServiceImpl extends ServiceImpl <SaleinfoMapper, Saleinfo> implements ISaleinfoService {

@Autowired
private SaleinfoMapper saleinfoMapper;

    /**
     * 分页查询销售记录数据
     *
     * @param pageNum  第几页
     * @param pageSize 每一页的数量
     * @param param    查询参数 销售记录名称
     * @return 返回的ipage的数据
     */
    @Override
    public IPage<Saleinfo> selectSaleinfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Saleinfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("mname",param);
        }
        Page<Saleinfo> page = new Page<>(pageNum,pageSize);
        return saleinfoMapper.selectPage(page,queryWrapper);

    }

    /**
     * 新增一条销售记录
     *
     * @param saleinfo
     */
    @Override
    public int addSaleinfo(Saleinfo saleinfo) {
        return saleinfoMapper.insert(saleinfo);
    }

    /**
     * 修改一条销售记录
     *
     * @param saleinfo
     */
    @Override
    public int editSaleinfo(Saleinfo saleinfo) {
        return saleinfoMapper.updateById(saleinfo);
    }

    /**
     * 根据主键id查询一个销售记录对象
     *
     * @param
     * @return
     */
    @Override
    public Saleinfo querySaleinfoById(Integer id) {
       return saleinfoMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个销售记录对象
     *
     * @param
     * @return
     */
    @Override
    public int delSaleinfoById(Integer id) {
        return saleinfoMapper.deleteById(id);
    }


}
