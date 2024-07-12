package com.example.controller;

import com.example.common.config.TokenUtils;
import cn.hutool.core.collection.CollectionUtil;
import com.github.pagehelper.PageInfo;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.example.common.Result;
import com.example.common.enums.ResultCodeEnum;
import com.example.entity.*;
import com.example.service.*;
import com.example.exception.CustomException;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.*;

import java.util.List;

/**
*  描述：歌曲相关接口
*/
@RestController
@RequestMapping("/txtbook")
public class txtbookController {

    @Resource
    txtbookService txtbookService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody txtbook txtbook) {
		Account user = TokenUtils.getCurrentUser();
		if (ObjectUtil.isEmpty(user)) {
			throw new CustomException(ResultCodeEnum.USER_NOT_LOGIN);
		}

        txtbookService.add(txtbook);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        txtbookService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result delete(@RequestBody List<Integer> ids) {
        txtbookService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 更新
     */
    @PutMapping("/update")
    public Result update(@RequestBody txtbook txtbook) {

        txtbookService.updateById(txtbook);
        return Result.success();
    }

    /**
     * 查询单个
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        txtbook txtbook = txtbookService.selectById(id);
        return Result.success(txtbook);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(txtbook txtbook) {
        List<txtbook> list = txtbookService.selectAll(txtbook);
        return Result.success(list);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectPage")
    public Result selectPage(
            txtbook txtbook,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<txtbook> pageInfo = txtbookService.selectPage(txtbook, pageNum, pageSize);
        return Result.success(pageInfo);
    }

	/**
	 * 描述：批量删除
	 */
	@PutMapping("/batchDel")
	public Result deleteBatch(@RequestBody List<Integer> list) {
		for (Integer id : list) {
			txtbookService.deleteById(id);
		}
		return Result.success();
	}

