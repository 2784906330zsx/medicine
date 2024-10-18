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
@TableName(value = "returngoods")
public class Returngoods implements Serializable {
    @TableField(value = "id")
    @TableId(value = "id",type= IdType.AUTO)
    private Integer id;

//    药品名称
    private String mname;

// 数量
    private Integer count;
    //原因
    private  String reason;
    //总金额
    private Float total;
//操作时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operatetime;
    public String getOperatetimeStr(){
        return DateUtil.dateConvert(operatetime);
    }


}
