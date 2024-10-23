package com.sdju.medicine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

//药厂
@Data
@TableName(value = "factory")
public class Factory implements Serializable {
    @TableField(value = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    //药厂名称
    private String fname;
    //药厂描述
    private String fcontent;
    //创建时间
    private Date createtime;
}
