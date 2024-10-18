package com.javaclimb.medicine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.javaclimb.medicine.common.DateUtil;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

//收到退货
@Data
@TableName(value = "billinfo")
public class Billinfo implements Serializable {
    @TableField(value = "id")
    @TableId(value = "id",type= IdType.AUTO)
    private Integer id;

//    供应商名称
    private String sname;
    //    药品名称
    private String mname;
// 数量
    private Integer count;
    //总金额
    private Float total;
//操作时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date buytime;
    public String getBuytimeStr(){
        return DateUtil.dateConvert(buytime);
    }


}
