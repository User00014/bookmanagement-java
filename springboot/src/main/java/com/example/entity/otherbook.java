package com.example.entity;

import cn.hutool.core.annotation.Alias;
import java.util.List;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 *  图书
 */
@Data
@TableName("otherbook")
public class otherbook  {

    /** id */
    @TableId(type = IdType.AUTO)
    private Integer id;
	/** 图书编号 */
	@Alias("图书编号")
	private Integer otherbookno;
	/** 图书名称 */
	@Alias("图书名称")
	private String otherbookname;
	/** 发行日期 */
	@Alias("发行日期")
	private String releasedate;
	/** 作者 */
	@Alias("作者")
	private String author;
	/** 价格 */
	@Alias("价格")
	private Double price;



}
