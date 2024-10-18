package com.javaclimb.medicine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

//药品出入库
@Data
@TableName(value = "storageinfo")
public class Storageinfo implements Serializable {
    @TableField(value = "id")
    @TableId(value = "id",type= IdType.AUTO)
    private Integer id;

//    药品名称
    private String mname;

// 数量
    private Integer count;
    //操作人
    private String operator;

    //    操作时间
    private Date createtime;

}
