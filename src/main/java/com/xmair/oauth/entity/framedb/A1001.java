package com.xmair.oauth.entity.framedb;

import java.util.Date;

public class A1001 {
    private String organId;

    private String organCode;

    private String organName;

    private String layerCode;

    private String superiorOrgan;

    private String manageOrgan;

    private String nameJp;

    private String sortNo;

    private String status;

    private Date changedDate;

    private String virtualFlag;

    private String fullPath;

    public String getOrganId() {
        return organId;
    }

    public void setOrganId(String organId) {
        this.organId = organId == null ? null : organId.trim();
    }

    public String getOrganCode() {
        return organCode;
    }

    public void setOrganCode(String organCode) {
        this.organCode = organCode == null ? null : organCode.trim();
    }

    public String getOrganName() {
        return organName;
    }

    public void setOrganName(String organName) {
        this.organName = organName == null ? null : organName.trim();
    }

    public String getLayerCode() {
        return layerCode;
    }

    public void setLayerCode(String layerCode) {
        this.layerCode = layerCode == null ? null : layerCode.trim();
    }

    public String getSuperiorOrgan() {
        return superiorOrgan;
    }

    public void setSuperiorOrgan(String superiorOrgan) {
        this.superiorOrgan = superiorOrgan == null ? null : superiorOrgan.trim();
    }

    public String getManageOrgan() {
        return manageOrgan;
    }

    public void setManageOrgan(String manageOrgan) {
        this.manageOrgan = manageOrgan == null ? null : manageOrgan.trim();
    }

    public String getNameJp() {
        return nameJp;
    }

    public void setNameJp(String nameJp) {
        this.nameJp = nameJp == null ? null : nameJp.trim();
    }

    public String getSortNo() {
        return sortNo;
    }

    public void setSortNo(String sortNo) {
        this.sortNo = sortNo == null ? null : sortNo.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(Date changedDate) {
        this.changedDate = changedDate;
    }

    public String getVirtualFlag() {
        return virtualFlag;
    }

    public void setVirtualFlag(String virtualFlag) {
        this.virtualFlag = virtualFlag == null ? null : virtualFlag.trim();
    }

    public String getFullPath() {
        return fullPath;
    }

    public void setFullPath(String fullPath) {
        this.fullPath = fullPath == null ? null : fullPath.trim();
    }
}