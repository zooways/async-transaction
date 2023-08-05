package cn.zoowayss.async.tran.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_user")
public class User {
    /**
     *  
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @TableField(value = "`name`")
    private String name;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";
}