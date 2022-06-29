package com.ming.findplatform.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * @ClassName :Tag
 * @Description :
 * @Author :Mox
 * @Date :2022/6/29 17:49
 * @Version : v1.0
 **/
@TableName(value = "tag")
public class Tag {
    @TableId(type = IdType.AUTO)
    private String tagId;
    private String tagNameEn;
    private String tagNameZh;

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getTagNameEn() {
        return tagNameEn;
    }

    public void setTagNameEn(String tagNameEn) {
        this.tagNameEn = tagNameEn;
    }

    public String getTagNameZh() {
        return tagNameZh;
    }

    public void setTagNameZh(String tagNameZh) {
        this.tagNameZh = tagNameZh;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "tagId='" + tagId + '\'' +
                ", tagNameEn='" + tagNameEn + '\'' +
                ", tagNameZh='" + tagNameZh + '\'' +
                '}';
    }
}
