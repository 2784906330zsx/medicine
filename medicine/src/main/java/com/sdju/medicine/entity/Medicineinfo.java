package com.sdju.medicine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sdju.medicine.common.DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

//供应商
@Data
@TableName(value = "Medicineinfo")
public class Medicineinfo implements Serializable {
    @TableField(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //    药品名称
    private String mname;
    //药品简称
    private String mshortname;
    //药品英文名
    private String mnameeng;
    //是否为处方药
    private Boolean isprescription;
    //药品简称
    private String mcontent;
    //    供应商名称
    private String supplier;
    //    生产时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date producttime;
    // 保质期
    private String warrenty;
    //药品编码
    private String number;
    //价格
    private Float price;
    //库存
    private Integer stock;

    /**
     * 生产时间转换成年月日
     */
//    private  String producttimeStr;
    public String getProducttimeStr() {
        return DateUtil.dateConvert(producttime);
    }
}
