package com.demo.modules.sys.controller;

import com.demo.modules.sys.service.StatisticsService;
import com.demo.modules.sys.vo.StatisticsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    /**
     * @Description: 统计
     * @Author: JYY
     * @Date: 2020/9/15 10:46
     * @param classId:  课程名称
     * @return: java.util.List<com.demo.modules.sys.vo.StatisticsVO>
     **/
    @GetMapping
    public List<StatisticsVO> list(String classId){
        return statisticsService.list(classId);
    }
}
