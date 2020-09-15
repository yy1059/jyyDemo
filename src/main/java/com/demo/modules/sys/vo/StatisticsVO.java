package com.demo.modules.sys.vo;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/*
 * @Description:
 * @Author: JYY
 * @Date: 2020/9/15 10:40
 **/
@Data
@Accessors(chain = true)
public class StatisticsVO {

    /**
     * 学生ID
     */
    private String id;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 学号
     */
    private String num;

    /**
     * 分数
     */
    private Double achievement;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 观看视频次数
     */
    private Integer viewVideoNum;

    /**
     * 课件下载次数
     */
    private Integer downloadCoursewareNum;

}
