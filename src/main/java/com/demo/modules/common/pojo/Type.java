package com.demo.modules.common.pojo;

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
public class Type extends Model<Type> {

    private static final long serialVersionUID=1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 链接地址
     */
    private String url;

    /**
     * 类型：0为资源，1为在线课件，2为作业链接，3为考试链接
     */
    private Integer type;

    /**
     * 名字
     */
    private String name;

    /**
     * 超时时间
     */
    private LocalDateTime timeout;

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


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
