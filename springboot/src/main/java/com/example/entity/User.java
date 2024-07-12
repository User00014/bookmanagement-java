package com.example.entity;

import cn.hutool.core.annotation.Alias;
import java.util.List;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 用户
 */
@Data
@TableName("user")
public class User extends Account {

    /** id */
    @TableId(type = IdType.AUTO)
    private Integer id;
	/** 账号 */
	@Alias("账号")
	private String username;
	/** 密码 */
	private String password;
	/** 名称 */
	@Alias("名称")
	private String name;
	/** 头像 */
	private String avatar;
	/** 手机 */
	@Alias("手机")
	private String phone;
	/** 借阅图书单号 */
	@TableField(exist = false)
	private String uBuytableno;
	/** 借阅书籍编号 */
	@TableField(exist = false)
	private String ubookno;
	/** 作者Id */
	private Integer writerId;
	/** 书籍Id */
	private Integer bookId;


}
