package com.javaclimb.medicine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.medicine.entity.Billinfo;
import com.javaclimb.medicine.mapper.BillinfoMapper;
import com.javaclimb.medicine.service.IBillinfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//账单信息service实现类
@Service
public class BillinfoServiceImpl extends ServiceImpl <BillinfoMapper, Billinfo> implements IBillinfoService {

@Autowired
private BillinfoMapper billinfoMapper;

    /**
     * 分页查询账单信息数据
     *
     * @param pageNum  第几页
     * @param pageSize 每一页的数量
     * @param param    查询参数 账单信息名称
     * @return 返回的ipage的数据
     */
    @Override
    public IPage<Billinfo> selectBillinfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Billinfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.eq("sname",param);
        }
        Page<Billinfo> page = new Page<>(pageNum,pageSize);
        return billinfoMapper.selectPage(page,queryWrapper);

    }

    /**
     * 新增一条账单信息
     *
     * @param billinfo
     */
    @Override
    public int addBillinfo(Billinfo billinfo) {
        return billinfoMapper.insert(billinfo);
    }

    /**
     * 修改一条账单信息
     *
     * @param billinfo
     */
    @Override
    public int editBillinfo(Billinfo billinfo) {
        return billinfoMapper.updateById(billinfo);
    }

    /**
     * 根据主键id查询一个账单信息对象
     *
     * @param
     * @return
     */
    @Override
    public Billinfo queryBillinfoById(Integer id) {
       return billinfoMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个账单信息对象
     *
     * @param
     * @return
     */
    @Override
    public int delBillinfoById(Integer id) {
        return billinfoMapper.deleteById(id);
    }


}
