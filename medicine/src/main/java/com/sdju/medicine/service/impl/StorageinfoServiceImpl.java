package com.sdju.medicine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdju.medicine.entity.Storageinfo;
import com.sdju.medicine.mapper.StorageinfoMapper;
import com.sdju.medicine.service.IOwinfoService;
import com.sdju.medicine.service.IStorageinfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//药品出入库service实现类
@Service
public class StorageinfoServiceImpl extends ServiceImpl <StorageinfoMapper, Storageinfo> implements IStorageinfoService {

@Autowired
private StorageinfoMapper storageinfoMapper;

    /**
     * 分页查询药品出入库数据
     *
     * @param pageNum  第几页
     * @param pageSize 每一页的数量
     * @param param    查询参数 药品出入库名称
     * @return 返回的ipage的数据
     */
    @Override
    public IPage<Storageinfo> selectStorageinfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Storageinfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("mname",param);
        }
        Page<Storageinfo> page = new Page<>(pageNum,pageSize);
        return storageinfoMapper.selectPage(page,queryWrapper);

    }

    /**
     * 新增一条药品出入库
     *
     * @param storageinfo
     */
    @Override
    public int addStorageinfo(Storageinfo storageinfo) {
        return storageinfoMapper.insert(storageinfo);
    }

    /**
     * 修改一条药品出入库
     *
     * @param storageinfo
     */
    @Override
    public int editStorageinfo(Storageinfo storageinfo) {
        return storageinfoMapper.updateById(storageinfo);
    }

    /**
     * 根据主键id查询一个药品出入库对象
     *
     * @param
     * @return
     */
    @Override
    public Storageinfo queryStorageinfoById(Integer id) {
       return storageinfoMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个药品出入库对象
     *
     * @param
     * @return
     */
    @Override
    public int delStorageinfoById(Integer id) {
        return storageinfoMapper.deleteById(id);
    }


}
