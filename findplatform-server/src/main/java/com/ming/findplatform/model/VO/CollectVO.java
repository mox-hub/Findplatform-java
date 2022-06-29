package com.ming.findplatform.model.VO;

import java.sql.Date;

/**
 * @ClassName :CollectVO
 * @Description :
 * @Author :Mox
 * @Date :2022/6/29 20:24
 * @Version : v1.0
 **/

public class CollectVO {
    private String collectId;
    private String collectUid;
    private String itemId;
    private String imgUrl;
    private String tagId;
    private int state;
    private String pickLocation;
    private String placement;
    private Date pickTime;
    private String userId;
    private String itemName;
    private String itemInfo;

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
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

    public void setItemInfo(String itemInfo) {
        this.itemInfo = itemInfo;
    }

    @Override
    public String toString() {
        return "CollectVO{" +
                "collectId='" + collectId + '\'' +
                ", collectUid='" + collectUid + '\'' +
                ", itemId='" + itemId + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", tagId='" + tagId + '\'' +
                ", state=" + state +
                ", pickLocation='" + pickLocation + '\'' +
                ", placement='" + placement + '\'' +
                ", pickTime=" + pickTime +
                ", userId='" + userId + '\'' +
                ", itemName='" + itemName + '\'' +
                ", itemInfo='" + itemInfo + '\'' +
                '}';
    }
}
