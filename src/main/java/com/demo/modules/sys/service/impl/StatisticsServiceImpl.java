package com.demo.modules.sys.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.demo.modules.common.dao.StatisticsDao;
import com.demo.modules.sys.TypeEnum;
import com.demo.modules.sys.service.StatisticsService;
import com.demo.modules.sys.vo.StatisticsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsDao statisticsDao;

    @Override
    public List<StatisticsVO> list(String classId) {
        //获取数据库信息
        List<StatisticsVO> list = statisticsDao.list(classId);
        List<StatisticsVO> result=new ArrayList<>();

        //通过Stream流进行ID分组
        Map<String, List<StatisticsVO>> collect = list.stream().collect(Collectors.groupingBy(vo -> vo.getId()));
        //统计下载次数以及观看次数
        for (Map.Entry<String, List<StatisticsVO>> m : collect.entrySet()) {
            StatisticsVO statisticsVO=new StatisticsVO();
            int downloadCoursewareNum=0;
            int viewVideoNum=0;
            for (StatisticsVO vo:m.getValue()) {
                if (vo.getType().equals(TypeEnum.RESOURCE.getCode())){
                    downloadCoursewareNum++;
                }else if(vo.getType().equals(TypeEnum.VIDEO.getCode())){
                    viewVideoNum++;
                }else if(vo.getType().equals(TypeEnum.TEST.getCode())){
                    BeanUtil.copyProperties(vo,statisticsVO);
                }
                if (StringUtils.isEmpty(statisticsVO.getAchievement())||Math.abs(vo.getAchievement()-statisticsVO.getAchievement())<0.001){
                    BeanUtil.copyProperties(vo,statisticsVO);
                }

            }
            statisticsVO.setDownloadCoursewareNum(downloadCoursewareNum).setViewVideoNum(viewVideoNum);
            result.add(statisticsVO);
        }

        return result;
    }
}
