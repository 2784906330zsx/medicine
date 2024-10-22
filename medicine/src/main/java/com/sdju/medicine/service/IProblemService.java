package com.sdju.medicine.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.sdju.medicine.entity.Problem;

//问题药品出入库的service接口
public interface IProblemService extends IService<Problem> {
    /**
     * 分页查询问题药品出入库数据
     * @param pageNum  第几页
     * @param pageSize  每一页的数量
     * @param param  查询参数
     * @return  返回的ipage的数据
     */
    public IPage<Problem> selectProblemPage(int pageNum,int pageSize,String param);

    /**
     * 新增一条 问题药品名称
     * @param problem
     */
    public int addProblem(Problem problem);
    /**
     * 修改一条问题药品
     * @param problem
     */
    public int editProblem(Problem problem);

    /**
     * 根据主键id查询一个问题药品对象
     * @param id
     * @return
     */
    public Problem queryProblemById(Integer id);

    /**
     * 根据主键id删除一个问题药品对象
     * @param id
     * @return
     */
    public int delProblemById(Integer id);

}
