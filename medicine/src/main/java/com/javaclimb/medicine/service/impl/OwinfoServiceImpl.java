package com.javaclimb.medicine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.medicine.entity.Owinfo;
import com.javaclimb.medicine.mapper.OwinfoMapper;
import com.javaclimb.medicine.service.IOwinfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//药品出入库service实现类
@Service
public class OwinfoServiceImpl extends ServiceImpl <OwinfoMapper, Owinfo> implements IOwinfoService {

@Autowired
private OwinfoMapper owinfoMapper;

    /**
     * 分页查询药品出入库数据
     *
     * @param pageNum  第几页
     * @param pageSize 每一页的数量
     * @param param    查询参数 药品出入库名称
     * @return 返回的ipage的数据
     */
    @Override
    public IPage<Owinfo> selectOwinfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Owinfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("mname",param);
        }
        Page<Owinfo> page = new Page<>(pageNum,pageSize);
        return owinfoMapper.selectPage(page,queryWrapper);

    }

    /**
     * 新增一条药品出入库
     *
     * @param owinfo
     */
    @Override
    public int addOwinfo(Owinfo owinfo) {
        return owinfoMapper.insert(owinfo);
    }

    /**
     * 修改一条药品出入库
     *
     * @param owinfo
     */
    @Override
    public int editOwinfo(Owinfo owinfo) {
        return owinfoMapper.updateById(owinfo);
    }

    /**
     * 根据主键id查询一个药品出入库对象
     *
     * @param
     * @return
     */
    @Override
    public Owinfo queryOwinfoById(Integer id) {
       return owinfoMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个药品出入库对象
     *
     * @param
     * @return
     */
    @Override
    public int delOwinfoById(Integer id) {
        return owinfoMapper.deleteById(id);
    }


}
