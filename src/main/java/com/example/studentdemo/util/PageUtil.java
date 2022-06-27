package com.example.studentdemo.util;

import com.example.studentdemo.bean.res.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

public class PageUtil {
    /**
     * 开始分页
     */
    public static void startPage(Integer pageNow,Integer pageSize) {
        PageHelper.startPage(pageNow,pageSize);
    }

    /**
     * 转换查询结果
     */
    public static <T> Result<List<T>> wrapPageData(List<T> queryList) {
        PageInfo<T> pageInfo = new PageInfo<>(queryList);
        return Result.buildSuccess(queryList,pageInfo.getTotal());
    }

}
