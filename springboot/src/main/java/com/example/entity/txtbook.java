package com.example.entity;

import cn.hutool.core.annotation.Alias;
import java.util.List;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 书籍
 */
@Data
@TableName("txtbook")
public class txtbook  {

    /** id */
    @TableId(type = IdType.AUTO)
    private Integer id;
	/** 单本编号 */
	@Alias("单本编号")
	private Integer trackno;
	/** 单本名称 */
	@Alias("单本名称")
	private String trackname;
	/** 页码 */
	@Alias("页码")
	private Double time;
	/** 页码 */
	private String pages;
	/** 作者账号 */
	@TableField(exist = false)
	private String owneraccount;
	/** 作者Id */
	private Integer writerId;



}
