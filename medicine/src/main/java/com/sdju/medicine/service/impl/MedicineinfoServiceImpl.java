package com.sdju.medicine.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sdju.medicine.entity.Medicineinfo;
import com.sdju.medicine.mapper.MedicineinfoMapper;
import com.sdju.medicine.service.IMedicineinfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


//药品service实现类
@Service
public class MedicineinfoServiceImpl extends ServiceImpl <MedicineinfoMapper, Medicineinfo> implements IMedicineinfoService {

@Autowired
private MedicineinfoMapper medicineinfoMapper;

    /**
     * 分页查询药品数据
     *
     * @param pageNum  第几页
     * @param pageSize 每一页的数量
     * @param param    查询参数 药品名称
     * @return 返回的ipage的数据
     */
    @Override
    public IPage<Medicineinfo> selectMedicineinfoPage(int pageNum, int pageSize, String param) {
        QueryWrapper<Medicineinfo> queryWrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(param)){
            queryWrapper.like("mname",param);
        }
        Page<Medicineinfo> page = new Page<>(pageNum,pageSize);
        return medicineinfoMapper.selectPage(page,queryWrapper);

    }

    /**
     * 新增一条药品
     *
     * @param medicineinfo
     */
    @Override
    public int addMedicineinfo(Medicineinfo medicineinfo) {
        return medicineinfoMapper.insert(medicineinfo);
    }

    /**
     * 修改一条药品
     *
     * @param medicineinfo
     */
    @Override
    public int editMedicineinfo(Medicineinfo medicineinfo) {
        return medicineinfoMapper.updateById(medicineinfo);
    }

    /**
     * 根据主键id查询一个药品对象
     *
     * @param
     * @return
     */
    @Override
    public Medicineinfo queryMedicineinfoById(Integer id) {
       return medicineinfoMapper.selectById(id);
    }

    /**
     * 根据主键id删除一个药品对象
     *
     * @param
     * @return
     */
    @Override
    public int delMedicineinfoById(Integer id) {
        return medicineinfoMapper.deleteById(id);
    }

    /**
     * 查询所有药品
     *
     * @return
     */
    @Override
    public List<Medicineinfo> queryMedicineinfoList() {
        return medicineinfoMapper.selectList(null);
    }
}
