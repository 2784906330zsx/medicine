package com.sdju.medicine.service.impl;
import java.lang.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdju.medicine.entity.Supplier;
import com.sdju.medicine.mapper.SupplierMapper;
import com.sdju.medicine.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.apache.commons.lang.StringUtils;

import javax.annotation.Resource;


//供应商service实现类
@Service
public class SupplierServiceImpl extends ServiceImpl <SupplierMapper, Supplier> implements ISupplierService{

@Resource
private SupplierMapper supplierMapper;

    /**
     * 分页查询供应商数据
     *
     * @param pageNum  第几页
     * @param pageSize 每一页的数量
     * @param param    查询参数 供应商名称
     * @return 返回的ipage的数据
     */
    @Override
    public IPage<Supplier> selectSupplierPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Supplier> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("name",param);
        }
        Page<Supplier> page = new Page<>(pageNum,pageSize);
        return supplierMapper.selectPage(page,queryWrapper);

    }

    /**
     * 新增一条供应商
     *
     * @param supplier
     */
    @Override
    public int addSupplier(Supplier supplier) {
        return supplierMapper.insert(supplier);
    }

    /**
     * 修改一条供应商
     *
     * @param supplier
     */
    @Override
    public int editSupplier(Supplier supplier) {
        return supplierMapper.updateById(supplier);
    }

    /**
     * 根据主键id查询一个供应商对象
     *
     * @param
     * @return
     */
    @Override
    public Supplier querySupplierById(Integer id) {
       return supplierMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个供应商对象
     *
     * @param
     * @return
     */
    @Override
    public int delSupplierById(Integer id) {
        return supplierMapper.deleteById(id);
    }

    /**
     * 查询所有供应商
     *
     * @return
     */
    @Override
    public List<Supplier> querySupplierList() {
        return supplierMapper.selectList(null);
    }
}
