package com.sdju.medicine.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sdju.medicine.entity.Storageinfo;

//药品出入库出入库的service接口
public interface IStorageinfoService extends IService<Storageinfo> {
    /**
     * 分页查询药品出入库出入库数据
     *
     * @param pageNum  第几页
     * @param pageSize 每一页的数量
     * @param param    查询参数
     * @return 返回的ipage的数据
     */
    public IPage<Storageinfo> selectStorageinfoPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条 药品出入库名称
     */
    public int addStorageinfo(Storageinfo storageinfo);

    /**
     * 修改一条药品出入库
     */
    public int editStorageinfo(Storageinfo storageinfo);

    /**
     * 根据主键id查询一个药品出入库对象
     */
    public Storageinfo queryStorageinfoById(Integer id);

    /**
     * 根据主键id删除一个药品出入库对象
     */
    public int delStorageinfoById(Integer id);

}
