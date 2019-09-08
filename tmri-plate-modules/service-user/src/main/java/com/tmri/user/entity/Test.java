package com.tmri.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Timestamp;

@Data
@Accessors(chain = true)
public class Test {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("updateTime")
    private Timestamp updateTime;

}