package com.sdju.medicine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdju.medicine.entity.Factory;
import com.sdju.medicine.mapper.FactoryMapper;
import com.sdju.medicine.service.IFactoryService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


//供应商service实现类
@Service
public class FactoryServiceImpl extends ServiceImpl<FactoryMapper, Factory> implements IFactoryService {

    @Resource
    private FactoryMapper factoryMapper;

    /**
     * 分页查询供应商数据
     *
     * @param pageNum  第几页
     * @param pageSize 每一页的数量
     * @param param    查询参数 供应商名称
     * @return 返回的ipage的数据
     */
    @Override
    public IPage<Factory> selectFactoryPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Factory> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotEmpty(param)) {
            queryWrapper.like("name", param);
        }
        Page<Factory> page = new Page<>(pageNum, pageSize);
        return factoryMapper.selectPage(page, queryWrapper);

    }

    /**
     * 新增一条供应商
     *
     * @param factory
     */
    @Override
    public int addFactory(Factory factory) {
        return factoryMapper.insert(factory);
    }

    /**
     * 修改一条供应商
     *
     * @param factory
     */
    @Override
    public int editFactory(Factory factory) {
        return factoryMapper.updateById(factory);
    }

    /**
     * 根据主键id查询一个供应商对象
     *
     * @param
     * @return
     */
    @Override
    public Factory queryFactoryById(Integer id) {
        return factoryMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个供应商对象
     *
     * @param
     * @return
     */
    @Override
    public int delFactoryById(Integer id) {
        return factoryMapper.deleteById(id);
    }

    /**
     * 查询所有供应商
     *
     * @return
     */
    @Override
    public List<Factory> queryFactoryList() {
        return factoryMapper.selectList(null);
    }
}
