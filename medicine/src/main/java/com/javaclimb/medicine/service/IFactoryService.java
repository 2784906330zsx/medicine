package com.javaclimb.medicine.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.javaclimb.medicine.entity.Factory;

import java.util.List;

//供应商表的service接口
public interface IFactoryService extends IService<Factory> {
    /**
     * 分页查询数据
     * @param pageNum  第几页
     * @param pageSize  每一页的数量
     * @param param  查询参数
     * @return  返回的ipage的数据
     */
    public IPage<Factory> selectFactoryPage(int pageNum,int pageSize,String param);

    /**
     * 新增一条供应商 供应商名称
     * @param factory
     */
    public int addFactory(Factory factory);
    /**
     * 修改一条供应商
     * @param factory
     */
    public int editFactory(Factory factory);

    /**
     * 根据主键id查询一个供应商对象
     * @param id
     * @return
     */
    public Factory queryFactoryById(Integer id);

    /**
     * 根据主键id删除一个供应商对象
     * @param id
     * @return
     */
    public int delFactoryById(Integer id);

    /**
     * 查询所有供应商
     * @return
     */
    public List<Factory> queryFactoryList();
}
