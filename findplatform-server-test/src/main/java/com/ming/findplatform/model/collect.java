package com.ming.findplatform.model;

import java.sql.Date;

/**
 * @ClassName :collect
 * @Description :collect_list对应实体类
 * @Author :Mox
 * @Date :2021/11/19 10:02
 * @Version : v1.0
 **/

public class collect {
    private String itemId;
    private String imgUrl;
    private String tag;
    private int state;
    private String pickLocation;
    private String placement;
    private Date pickTime;
    private String userId;
    private String item_name;
    private String item_info;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getPickLocation() {
        return pickLocation;
    }

    public void setPickLocation(String pickLocation) {
        this.pickLocation = pickLocation;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public Date getPickTime() {
        return pickTime;
    }

    public void setPickTime(Date pickTime) {
        this.pickTime = pickTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_info() {
        return item_info;
    }

    public void setItem_info(String item_info) { this.item_info = item_info; }

    @Override
    public String toString() {
        return "Item{" +
                "itemId='" + itemId + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", tag='" + tag + '\'' +
                ", state=" + state +
                ", pickLocation='" + pickLocation + '\'' +
                ", placement='" + placement + '\'' +
                ", pickTime=" + pickTime +
                ", userId='" + userId + '\'' +
                ", item_name='" + item_name + '\'' +
                ", item_info='" + item_info + '\'' +
                '}';
    }
}
