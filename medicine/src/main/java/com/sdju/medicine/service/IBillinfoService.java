package com.sdju.medicine.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sdju.medicine.entity.Billinfo;

//账单信息 的service接口
public interface IBillinfoService extends IService<Billinfo> {
    /**
     * 分页查询账单信息 数据
     *
     * @param pageNum  第几页
     * @param pageSize 每一页的数量
     * @param param    查询参数
     * @return 返回的ipage的数据
     */
    public IPage<Billinfo> selectBillinfoPage(int pageNum, int pageSize, String param);

    /**
     * 新增一条 账单信息名称
     *
     * @param billinfo
     */
    public int addBillinfo(Billinfo billinfo);

    /**
     * 修改一条账单信息
     *
     * @param billinfo
     */
    public int editBillinfo(Billinfo billinfo);

    /**
     * 根据主键id查询一个账单信息对象
     *
     * @param id
     * @return
     */
    public Billinfo queryBillinfoById(Integer id);

    /**
     * 根据主键id删除一个账单信息对象
     *
     * @param id
     * @return
     */
    public int delBillinfoById(Integer id);

}
