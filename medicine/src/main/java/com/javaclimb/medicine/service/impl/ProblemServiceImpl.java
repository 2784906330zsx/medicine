package com.javaclimb.medicine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.javaclimb.medicine.entity.Problem;
import com.javaclimb.medicine.mapper.ProblemMapper;
import com.javaclimb.medicine.service.IProblemService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//问题药品service实现类
@Service
public class ProblemServiceImpl extends ServiceImpl <ProblemMapper, Problem> implements IProblemService {

@Autowired
private ProblemMapper problemMapper;

    /**
     * 分页查询问题药品数据
     *
     * @param pageNum  第几页
     * @param pageSize 每一页的数量
     * @param param    查询参数 问题药品名称
     * @return 返回的ipage的数据
     */
    @Override
    public IPage<Problem> selectProblemPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Problem> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("mname",param);
        }
        Page<Problem> page = new Page<>(pageNum,pageSize);
        return problemMapper.selectPage(page,queryWrapper);

    }

    /**
     * 新增一条问题药品
     *
     * @param problem
     */
    @Override
    public int addProblem(Problem problem) {
        return problemMapper.insert(problem);
    }

    /**
     * 修改一条问题药品
     *
     * @param problem
     */
    @Override
    public int editProblem(Problem problem) {
        return problemMapper.updateById(problem);
    }

    /**
     * 根据主键id查询一个问题药品对象
     *
     * @param
     * @return
     */
    @Override
    public Problem queryProblemById(Integer id) {
       return problemMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个问题药品对象
     *
     * @param
     * @return
     */
    @Override
    public int delProblemById(Integer id) {
        return problemMapper.deleteById(id);
    }


}
