package com.sdju.medicine.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sdju.medicine.entity.Saleinfo;

//销售记录出入库的service接口
public interface ISaleinfoService extends IService<Saleinfo> {
    /**
     * 分页查询销售记录出入库数据
     * @param pageNum  第几页
     * @param pageSize  每一页的数量
     * @param param  查询参数
     * @return  返回的ipage的数据
     */
    public IPage<Saleinfo> selectSaleinfoPage(int pageNum,int pageSize,String param);

    /**
     * 新增一条 销售记录名称
     * @param saleinfo
     */
    public int addSaleinfo(Saleinfo saleinfo);
    /**
     * 修改一条销售记录
     * @param saleinfo
     */
    public int editSaleinfo(Saleinfo saleinfo);

    /**
     * 根据主键id查询一个销售记录对象
     * @param id
     * @return
     */
    public Saleinfo querySaleinfoById(Integer id);

    /**
     * 根据主键id删除一个销售记录对象
     * @param id
     * @return
     */
    public int delSaleinfoById(Integer id);

}
