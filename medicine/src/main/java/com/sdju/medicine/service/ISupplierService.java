package com.sdju.medicine.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sdju.medicine.entity.Supplier;
import com.sdju.medicine.entity.User;

import java.util.List;

//供应商表的service接口
public interface ISupplierService extends IService<Supplier> {
    /**
     * 分页查询数据
     * @param pageNum  第几页
     * @param pageSize  每一页的数量
     * @param param  查询参数
     * @return  返回的ipage的数据
     */
    public IPage<Supplier> selectSupplierPage(int pageNum,int pageSize,String param);

    /**
     * 新增一条供应商 供应商名称
     * @param supplier
     */
    public int addSupplier(Supplier supplier);
    /**
     * 修改一条供应商
     * @param supplier
     */
    public int editSupplier(Supplier supplier);

    /**
     * 根据主键id查询一个供应商对象
     * @param id
     * @return
     */
    public Supplier querySupplierById(Integer id);

    /**
     * 根据主键id删除一个供应商对象
     * @param id
     * @return
     */
    public int delSupplierById(Integer id);

    /**
     * 查询所有供应商
     * @return
     */
    public List<Supplier> querySupplierList();
}
