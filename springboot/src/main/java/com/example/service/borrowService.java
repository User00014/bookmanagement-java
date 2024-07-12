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
public class borrowService {

    @Resource
    private borrowMapper borrowMapper;

    /**
     * 新增
     */
    public void add(borrow borrow) {
        borrowMapper.insert(borrow);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        borrowMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            borrowMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(borrow borrow) {
        borrowMapper.updateById(borrow);
    }

    /**
     * 根据ID查询
     */
    public borrow selectById(Integer id) {
        return borrowMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<borrow> selectAll(borrow borrow) {
        return borrowMapper.selectAll(borrow);
    }

    /**
     * 分页查询
     */
    public PageInfo<borrow> selectPage(borrow borrow, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<borrow> list = this.selectAll(borrow);

        return PageInfo.of(list);
    }

}