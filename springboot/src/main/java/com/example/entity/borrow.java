package com.example.entity;

import cn.hutool.core.annotation.Alias;
import java.util.List;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 借阅
 */
@Data
@TableName("borrow")
public class borrow  {

    /** id */
    @TableId(type = IdType.AUTO)
    private Integer id;
	/** 借阅编号 */
	@Alias("借阅编号")
	private Integer collectionno;
	/** 日期 */
	@Alias("日期")
	private String date;
	/** 名称 */
	@Alias("名称")
	private String name;
	/** 包含图书编号 */
	@TableField(exist = false)
	private String fbookno;
	/** 图书Id */
	private Integer bookId;



}
