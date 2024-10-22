package com.sdju.medicine.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sdju.medicine.entity.Medicineinfo;

import java.util.List;

//表的service接口
public interface IMedicineinfoService extends IService<Medicineinfo> {
    /**
     * 分页查询数据
     * @param pageNum  第几页
     * @param pageSize  每一页的数量
     * @param param  查询参数
     * @return  返回的ipage的数据
     */
    public IPage<Medicineinfo> selectMedicineinfoPage(int pageNum,int pageSize,String param);

    /**
     * 新增一条药品 药品名称
     * @param medicineinfo
     */
    public int addMedicineinfo(Medicineinfo medicineinfo);
    /**
     * 修改一条药品
     * @param medicineinfo
     */
    public int editMedicineinfo(Medicineinfo medicineinfo);

    /**
     * 根据主键id查询一个药品对象
     * @param id
     * @return
     */
    public Medicineinfo queryMedicineinfoById(Integer id);

    /**
     * 根据主键id删除一个药品对象
     * @param id
     * @return
     */
    public int delMedicineinfoById(Integer id);

    /**
     * 查询所有药品
     * @return
     */
    public List<Medicineinfo> queryMedicineinfoList();
}
