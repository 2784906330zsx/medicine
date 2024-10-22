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

//药品销售
@Data
@TableName(value = "saleinfo")
public class Saleinfo implements Serializable {
    @TableField(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    //    药品名称
    private String mname;
    //    药品编号
    private String mnumber;

    // 数量
    private Integer count;
    //金额
    private Float total;
    //操作人
    private String operator;
    //    生产时间


    //    操作时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operatetime;
//    private  String operatetimeStr;

    public String getOperatetimeStr() {
        return DateUtil.dateConvert(operatetime);
    }


}
