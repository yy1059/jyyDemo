package com.demo.modules.sys.service;

import com.demo.modules.sys.vo.StatisticsVO;

import java.util.List;

public interface StatisticsService {

    /**
     * 统计
     * @param classId 课程名字
     * @return
     */
    List<StatisticsVO> list(String classId);
}
