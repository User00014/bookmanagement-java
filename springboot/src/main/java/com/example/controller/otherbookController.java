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
*  描述：其他书籍相关接口
*/
@RestController
@RequestMapping("/otherbook")
public class otherbookController {

    @Resource
    otherbookService otherbookService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody otherbook otherbook) {

        otherbookService.add(otherbook);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        otherbookService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result delete(@RequestBody List<Integer> ids) {
        otherbookService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 更新
     */
    @PutMapping("/update")
    public Result update(@RequestBody otherbook otherbook) {

        otherbookService.updateById(otherbook);
        return Result.success();
    }

    /**
     * 查询单个
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        otherbook otherbook = otherbookService.selectById(id);
        return Result.success(otherbook);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(otherbook otherbook) {
        List<otherbook> list = otherbookService.selectAll(otherbook);
        return Result.success(list);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectPage")
    public Result selectPage(
            otherbook otherbook,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<otherbook> pageInfo = otherbookService.selectPage(otherbook, pageNum, pageSize);
        return Result.success(pageInfo);
    }

	/**
	 * 描述：批量删除
	 */
	@PutMapping("/batchDel")
	public Result deleteBatch(@RequestBody List<Integer> list) {
		for (Integer id : list) {
			otherbookService.deleteById(id);
		}
		return Result.success();
	}

	/**
	 * 描述：批量导出到excel
	 */
	@GetMapping("/export")
	public void export(HttpServletResponse response) throws IOException {
		List<otherbook> all = otherbookService.selectAll(new otherbook());
		List<Map<String, Object>> list = new ArrayList<>(all.size());
		if (CollectionUtil.isEmpty(all)) {
			Map<String, Object> row = new LinkedHashMap<>();
			row.put("其他书籍编号", null);
			row.put("其他书籍名称", null);
			row.put("出版日期", null);
			row.put("作者", null);
			row.put("价格", null);
			row.put("售出单号", null);
			row.put("包含书籍编号", null);
			list.add(row);
		} else {
			for (otherbook otherbook : all) {
				Map<String, Object> row = new LinkedHashMap<>();
				row.put("其他书籍编号", otherbook.getotherbookno());
				row.put("其他书籍名称", otherbook.getotherbookname());
				row.put("出版日期", otherbook.getReleasedate());
				row.put("作者", otherbook.getAuthor());
				row.put("价格", otherbook.getPrice());
				row.put("售出单号", otherbook.getASaletableno());
				row.put("包含书籍编号", otherbook.getAbookno());
				list.add(row);
			}
		}
		ExcelWriter writer = ExcelUtil.getWriter(true);
		writer.write(list, true);
		response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=utf-8");
		response.setHeader("Content-Disposition","attachment;filename=otherbookInfoExcel.xlsx");
		ServletOutputStream out = response.getOutputStream();
		writer.flush(out, true);
		writer.close();
		IoUtil.close(System.out);
	}
