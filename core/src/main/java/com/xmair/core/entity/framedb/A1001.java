package com.xmair.core.entity.framedb;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

public class A1001 {
    @Column(name = "ORGAN_ID")
    private String organId;

    @Id
    @Column(name = "ORGAN_CODE")
    private String organCode;

    @Column(name = "ORGAN_NAME")
    private String organName;

    @Column(name = "LAYER_CODE")
    private String layerCode;

    @Column(name = "SUPERIOR_ORGAN")
    private String superiorOrgan;

    @Column(name = "MANAGE_ORGAN")
    private String manageOrgan;

    @Column(name = "NAME_JP")
    private String nameJp;

    @Column(name = "SORT_NO")
    private String sortNo;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CHANGED_DATE")
    private Date changedDate;

    @Column(name = "VIRTUAL_FLAG")
    private String virtualFlag;

    @Column(name = "FULL_PATH")
    private String fullPath;


    public List<TbEmpData> getEmpDataList() {
        return empDataList;
    }

    public void setEmpDataList(List<TbEmpData> empDataList) {
        this.empDataList = empDataList;
    }

    private List<TbEmpData> empDataList;
    /**
     * @return ORGAN_ID
     */
    public String getOrganId() {
        return organId;
    }

    /**
     * @param organId
     */
    public void setOrganId(String organId) {
        this.organId = organId == null ? null : organId.trim();
    }

    /**
     * @return ORGAN_CODE
     */
    public String getOrganCode() {
        return organCode;
    }

    /**
     * @param organCode
     */
    public void setOrganCode(String organCode) {
        this.organCode = organCode == null ? null : organCode.trim();
    }

    /**
     * @return ORGAN_NAME
     */
    public String getOrganName() {
        return organName;
    }

    /**
     * @param organName
     */
    public void setOrganName(String organName) {
        this.organName = organName == null ? null : organName.trim();
    }

    /**
     * @return LAYER_CODE
     */
    public String getLayerCode() {
        return layerCode;
    }

    /**
     * @param layerCode
     */
    public void setLayerCode(String layerCode) {
        this.layerCode = layerCode == null ? null : layerCode.trim();
    }

    /**
     * @return SUPERIOR_ORGAN
     */
    public String getSuperiorOrgan() {
        return superiorOrgan;
    }

    /**
     * @param superiorOrgan
     */
    public void setSuperiorOrgan(String superiorOrgan) {
        this.superiorOrgan = superiorOrgan == null ? null : superiorOrgan.trim();
    }

    /**
     * @return MANAGE_ORGAN
     */
    public String getManageOrgan() {
        return manageOrgan;
    }

    /**
     * @param manageOrgan
     */
    public void setManageOrgan(String manageOrgan) {
        this.manageOrgan = manageOrgan == null ? null : manageOrgan.trim();
    }

    /**
     * @return NAME_JP
     */
    public String getNameJp() {
        return nameJp;
    }

    /**
     * @param nameJp
     */
    public void setNameJp(String nameJp) {
        this.nameJp = nameJp == null ? null : nameJp.trim();
    }

    /**
     * @return SORT_NO
     */
    public String getSortNo() {
        return sortNo;
    }

    /**
     * @param sortNo
     */
    public void setSortNo(String sortNo) {
        this.sortNo = sortNo == null ? null : sortNo.trim();
    }

    /**
     * @return STATUS
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return CHANGED_DATE
     */
    public Date getChangedDate() {
        return changedDate;
    }

    /**
     * @param changedDate
     */
    public void setChangedDate(Date changedDate) {
        this.changedDate = changedDate;
    }

    /**
     * @return VIRTUAL_FLAG
     */
    public String getVirtualFlag() {
        return virtualFlag;
    }

    /**
     * @param virtualFlag
     */
    public void setVirtualFlag(String virtualFlag) {
        this.virtualFlag = virtualFlag == null ? null : virtualFlag.trim();
    }

    /**
     * @return FULL_PATH
     */
    public String getFullPath() {
        return fullPath;
    }

    /**
     * @param fullPath
     */
    public void setFullPath(String fullPath) {
        this.fullPath = fullPath == null ? null : fullPath.trim();
    }
}