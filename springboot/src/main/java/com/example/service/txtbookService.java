package com.example.service;

import cn.hutool.core.util.ObjectUtil;
import com.example.common.config.TokenUtils;
import com.example.mapper.*;
import com.example.entity.*;
import com.example.exception.CustomException;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class txtbookService {

    @Resource
    private txtbookMapper txtbookMapper;

    /**
     * 新增
     */
    public void add(txtbook txtbook) {
        txtbookMapper.insert(txtbook);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        txtbookMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            txtbookMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(txtbook txtbook) {
        txtbookMapper.updateById(txtbook);
    }

    /**
     * 根据ID查询
     */
    public txtbook selectById(Integer id) {
        return txtbookMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<txtbook> selectAll(txtbook txtbook) {
        return txtbookMapper.selectAll(txtbook);
    }

    /**
     * 分页查询
     */
    public PageInfo<txtbook> selectPage(txtbook txtbook, Integer pageNum, Integer pageSize) {
		Account currentUser = TokenUtils.getCurrentUser();
		if ("writer".equals(currentUser.getRole())) {
			txtbook.setwriterId(currentUser.getId());
		}

        PageHelper.startPage(pageNum, pageSize);
        List<txtbook> list = this.selectAll(txtbook);

        return PageInfo.of(list);
    }

}