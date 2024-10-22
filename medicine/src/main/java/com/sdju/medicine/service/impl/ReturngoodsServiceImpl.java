package com.sdju.medicine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdju.medicine.entity.Returngoods;
import com.sdju.medicine.mapper.ReturngoodsMapper;
import com.sdju.medicine.service.IReturngoodsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


//收到退货service实现类
@Service
public class ReturngoodsServiceImpl extends ServiceImpl <ReturngoodsMapper, Returngoods> implements IReturngoodsService {

@Autowired
private ReturngoodsMapper returngoodsMapper;

    /**
     * 分页查询收到退货数据
     *
     * @param pageNum  第几页
     * @param pageSize 每一页的数量
     * @param param    查询参数 收到退货名称
     * @return 返回的ipage的数据
     */
    @Override
    public IPage<Returngoods> selectReturngoodsPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Returngoods> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("mname",param);
        }
        Page<Returngoods> page = new Page<>(pageNum,pageSize);
        return returngoodsMapper.selectPage(page,queryWrapper);

    }

    /**
     * 新增一条收到退货
     *
     * @param returngoods
     */
    @Override
    public int addReturngoods(Returngoods returngoods) {
        return returngoodsMapper.insert(returngoods);
    }

    /**
     * 修改一条收到退货
     *
     * @param returngoods
     */
    @Override
    public int editReturngoods(Returngoods returngoods) {
        return returngoodsMapper.updateById(returngoods);
    }

    /**
     * 根据主键id查询一个收到退货对象
     *
     * @param
     * @return
     */
    @Override
    public Returngoods queryReturngoodsById(Integer id) {
       return returngoodsMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个收到退货对象
     *
     * @param
     * @return
     */
    @Override
    public int delReturngoodsById(Integer id) {
        return returngoodsMapper.deleteById(id);
    }


}
