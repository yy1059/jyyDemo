package com.demo.modules.common.pojo;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jyy
 * @since 2020-09-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class TypeUser extends Model<TypeUser> {

    private static final long serialVersionUID=1L;

    /**
     * 唯一主键
     */
    private String id;

    /**
     * 状态，0;正常，1：审核中，2：审核完成，3：返工
     */
    private Integer status;

    /**
     * 课程ID
     */
    private String courseId;

    /**
     * 作业或者其他的ID
     */
    private String typeId;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 教师评语
     */
    private String comment;

    /**
     * 单选答案
     */
    private String raidAnswer;

    /**
     * 简单题答案
     */
    private String descAnswer;

    /**
     * 成绩，如果为其他类型，默认为0
     */
    private BigDecimal achievement;

    /**
     * 创建时间
     */
    private LocalDateTime createdTime;

    /**
     * 更新时间
     */
    private LocalDateTime updatedTime;

    /**
     * 创建人
     */
    private String createdUser;

    /**
     * 更新人
     */
    private String updatedUser;

    /**
     * 终止时间
     */
    private LocalDateTime endTime;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
