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
public class User extends Model<User> {

    private static final long serialVersionUID=1L;

    /**
     * 唯一ID
     */
    private String id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户登录账号
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 盐值，加密使用
     */
    private String solt;

    /**
     * 学号或者编号
     */
    private String num;

    /**
     * 职称（教师），或者学生的班委职称都可以
     */
    private String title;

    /**
     * 类型，0为学生，1为老师
     */
    private Integer type;

    /**
     * 电话
     */
    private String phone;

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
