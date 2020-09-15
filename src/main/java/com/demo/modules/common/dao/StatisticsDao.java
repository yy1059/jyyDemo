package com.demo.modules.common.dao;

import com.demo.modules.sys.vo.StatisticsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StatisticsDao {

    /*
     * @Description: 统计
     * @Author: JYY
     * @Date: 2020/9/15 10:49
     * @param name: 课程名称
     * @return: java.util.List<com.demo.modules.sys.vo.StatisticsVO>
     **/
    List<StatisticsVO> list(@Param("classId") String classId);
}
