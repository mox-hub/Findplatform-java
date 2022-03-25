package com.ming.findplatform.model;

import java.sql.Date;

/**
 * @ClassName :Item
 * @Description :item_list对应实体类
 * @Author :Mox
 * @Date :2021/11/19 10:02
 * @Version : v1.0
 **/

public class Item {
    private String itemId;
    private String imgUrl;
    private String tag;
    private int state;
    private String pickLocation;
    private String placement;
    private Date pickTime;
    private String userId;
    private String itemName;
    private String itemInfo;

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

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemInfo() {
        return itemInfo;
    }

    public void setItemInfo(String itemInfo) { this.itemInfo = itemInfo; }

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
                ", item_name='" + itemName + '\'' +
                ", item_info='" + itemInfo + '\'' +
                '}';
    }
}
