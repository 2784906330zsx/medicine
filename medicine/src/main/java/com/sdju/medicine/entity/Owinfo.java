package com.sdju.medicine.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

//药品出入库
@Data
@TableName(value = "owinfo")
public class Owinfo implements Serializable {
    @TableField(value = "id")
    @TableId(value = "id", type = IdType.AUTO)

    private Integer id;
    private String mname;       //药品名称
    private Integer count;      //数量
    private String operator;    //操作人
    private Date createtime;    //操作时间
}
