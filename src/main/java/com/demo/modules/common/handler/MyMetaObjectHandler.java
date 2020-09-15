package com.demo.modules.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.demo.modules.common.utils.SessionUtil;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {

        // 获取到需要被填充的字段值
        Object updatedAt = getFieldValByName("updatedTime", metaObject);
        Object createdAt = getFieldValByName("createdTime", metaObject);
        Object creatorId = getFieldValByName("createdUser", metaObject);
        Object editorId = getFieldValByName("updatedUser", metaObject);

        if (updatedAt == null) {
            setInsertFieldValByName("updatedTime", LocalDateTime.now(), metaObject);
        }

        if (createdAt == null) {
            setInsertFieldValByName("createdTime", LocalDateTime.now(), metaObject);
        }

        if (creatorId == null) {
                setInsertFieldValByName("createdUser", SessionUtil.getCurrentUser().getId(), metaObject);
        }

        if (editorId == null) {
                setInsertFieldValByName("updatedUser", SessionUtil.getCurrentUser().getId(), metaObject);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        setUpdateFieldValByName("updatedTime", LocalDateTime.now(), metaObject);
        setInsertFieldValByName("updatedUser", SessionUtil.getCurrentUser().getId(), metaObject);
    }
}
