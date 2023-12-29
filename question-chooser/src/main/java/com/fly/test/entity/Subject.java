package com.fly.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2023-12-29
 */
@Getter
@Setter
@TableName("subject")
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 父元素ID
     */
    @TableField("parentId")
    private Integer parentId;

    /**
     * 主题
     */
    @TableField("subject")
    private String subject;

    /**
     * 问题
     */
    @TableField("question")
    private String question;

    /**
     * 答案
     */
    @TableField("answer")
    private String answer;

    /**
     * 权重
     */
    @TableField("weight")
    private Object weight;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;
}
