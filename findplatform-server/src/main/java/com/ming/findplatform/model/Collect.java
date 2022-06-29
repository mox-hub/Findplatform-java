package com.ming.findplatform.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName :Collect
 * @Description :
 * @Author :Mox
 * @Date :2022/6/29 17:42
 * @Version : v1.0
 **/
@TableName(value = "collect")
public class Collect {
    @TableId(type = IdType.AUTO)
    private String collectId;
    private String collectUid;
    private String itemId;

    public String getCollectId() {
        return collectId;
    }

    public void setCollectId(String collectId) {
        this.collectId = collectId;
    }

    public String getCollectUid() {
        return collectUid;
    }

    public void setCollectUid(String collectUid) {
        this.collectUid = collectUid;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public String toString() {
        return "Collect{" +
                "collectId='" + collectId + '\'' +
                ", userId='" + collectUid + '\'' +
                ", itemId='" + itemId + '\'' +
                '}';
    }
}
