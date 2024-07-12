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
public class otherbookService {

    @Resource
    private otherbookMapper otherbookMapper;

    /**
     * 新增
     */
    public void add(otherbook otherbook) {
        otherbookMapper.insert(otherbook);
    }

    /**
     * 删除
     */
    public void deleteById(Integer id) {
        otherbookMapper.deleteById(id);
    }

    /**
     * 批量删除
     */
    public void deleteBatch(List<Integer> ids) {
        for (Integer id : ids) {
            otherbookMapper.deleteById(id);
        }
    }

    /**
     * 修改
     */
    public void updateById(otherbook otherbook) {
        otherbookMapper.updateById(otherbook);
    }

    /**
     * 根据ID查询
     */
    public otherbook selectById(Integer id) {
        return otherbookMapper.selectById(id);
    }

    /**
     * 查询所有
     */
    public List<otherbook> selectAll(otherbook otherbook) {
        return otherbookMapper.selectAll(otherbook);
    }

    /**
     * 分页查询
     */
    public PageInfo<otherbook> selectPage(otherbook otherbook, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<otherbook> list = this.selectAll(otherbook);

        return PageInfo.of(list);
    }

}