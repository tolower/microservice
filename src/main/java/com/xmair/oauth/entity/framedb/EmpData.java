package com.xmair.oauth.entity.framedb;

import java.util.Date;
import javax.persistence.*;

@Table(name = "TB_EMP_DATA")
public class EmpData {
    @Id
    @Column(name = "MF_ID")
    private String mfId;

    @Column(name = "EMP_TYPE")
    private String empType;

    @Column(name = "TYPEID")
    private String typeid;

    @Column(name = "E0122")
    private String e0122;

    @Column(name = "UNIT_NAME")
    private String unitName;

    @Column(name = "DEP_NAME")
    private String depName;

    @Column(name = "OFFICE_NAME")
    private String officeName;

    @Column(name = "EMP_SID")
    private Integer empSid;

    @Column(name = "ARCH_ID")
    private String archId;

    @Column(name = "CN_NAME")
    private String cnName;

    @Column(name = "SMPL_NAME")
    private String smplName;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "GENDER")
    private String gender;

    @Column(name = "NATIONALITY")
    private String nationality;

    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "AGE")
    private Short age;

    @Column(name = "STU_ORIGIN")
    private String stuOrigin;

    @Column(name = "NATIVE_PLACE")
    private String nativePlace;

    @Column(name = "HOUSE_BOOK")
    private String houseBook;

    @Column(name = "HOUSE_BOOOK_TYPE")
    private String houseBoookType;

    @Column(name = "WORK_DATE")
    private Date workDate;

    @Column(name = "ENTR_MF_DATE")
    private Date entrMfDate;

    @Column(name = "BONUS_CARD_PLACE")
    private String bonusCardPlace;

    @Column(name = "ENROLL_FROM")
    private String enrollFrom;

    @Column(name = "CATALOG_TYPE")
    private String catalogType;

    @Column(name = "JOB_WAIT_ID")
    private String jobWaitId;

    @Column(name = "ID_CARD")
    private String idCard;

    @Column(name = "QUIT_DATE")
    private Date quitDate;

    @Column(name = "SPCL_MEMO")
    private String spclMemo;

    @Column(name = "MEMO")
    private String memo;

    @Column(name = "CTRCT_TYPE")
    private String ctrctType;

    @Column(name = "CTRCT_FROM_DATE")
    private Date ctrctFromDate;

    @Column(name = "CTRCT_EXPR_DATE")
    private Date ctrctExprDate;

    @Column(name = "ABORNAL_MEMO")
    private String abornalMemo;

    @Column(name = "JOB_TYPE")
    private String jobType;

    @Column(name = "JOB_TIME")
    private String jobTime;

    @Column(name = "CTRCT_PLACE")
    private String ctrctPlace;

    @Column(name = "DIPLOMA_TYPE")
    private String diplomaType;

    @Column(name = "DEGREE")
    private String degree;

    @Column(name = "GRADUATE_DATE")
    private Date graduateDate;

    @Column(name = "SPCL_ORIENTATION")
    private String spclOrientation;

    @Column(name = "GRADUTE_SCHOOL")
    private String graduteSchool;

    @Column(name = "CERT_NO")
    private String certNo;

    @Column(name = "STUDY_TYPE")
    private String studyType;

    @Column(name = "DUTY_NAME")
    private String dutyName;

    @Column(name = "DUTY_DATE")
    private Date dutyDate;

    @Column(name = "MGMT_LEVEL")
    private String mgmtLevel;

    @Column(name = "WHEN_IN_DUTY")
    private String whenInDuty;

    @Column(name = "IN_DUTY_DOCNO")
    private String inDutyDocno;

    @Column(name = "DUTY_EXPR_DATE")
    private Date dutyExprDate;

    @Column(name = "MGMT_LEVEL_NO")
    private String mgmtLevelNo;

    @Column(name = "QA_IN_DUTY")
    private String qaInDuty;

    @Column(name = "PRFTNL_NAME")
    private String prftnlName;

    @Column(name = "PRFTNL_DATE")
    private Date prftnlDate;

    @Column(name = "PRFTNL_TYPE")
    private String prftnlType;

    @Column(name = "PRFTNL_SERIAL")
    private String prftnlSerial;

    @Column(name = "WORK_POST")
    private String workPost;

    @Column(name = "POST_TYPE")
    private String postType;

    @Column(name = "POST_ID")
    private String postId;

    @Column(name = "PARTY_TYPE")
    private String partyType;

    @Column(name = "PARTY_ENTR_DATE")
    private Date partyEntrDate;

    @Column(name = "QA_JOB_TYPE")
    private String qaJobType;

    @Column(name = "QA_JOB_LEVEL")
    private String qaJobLevel;

    @Column(name = "QA_DATE")
    private Date qaDate;

    @Column(name = "RETIRE_DATE")
    private Date retireDate;

    @Column(name = "RE_WORK_DATE")
    private Date reWorkDate;

    @Column(name = "CONTACT")
    private String contact;

    @Column(name = "RECRUIT_POST")
    private String recruitPost;

    @Column(name = "ARMS_SPCL")
    private String armsSpcl;

    @Column(name = "PLAN_RPT_DATE")
    private String planRptDate;

    @Column(name = "PLAN_RPT_CITY")
    private String planRptCity;

    @Column(name = "PLAN_RPT_FLT_NO")
    private String planRptFltNo;

    @Column(name = "PLAN_RPT_FLT_DATE")
    private Date planRptFltDate;

    @Column(name = "PLAN_ID")
    private String planId;

    @Column(name = "RECRUIT_TYPE_MEMO")
    private String recruitTypeMemo;

    @Column(name = "EKP_MAIN")
    private String ekpMain;

    @Column(name = "DORM_ADDR")
    private String dormAddr;

    @Column(name = "RPT_PROGRESS_MEMO")
    private String rptProgressMemo;

    @Column(name = "TRAINING_STATUS")
    private String trainingStatus;

    @Column(name = "POST_ALL")
    private String postAll;

    /**
     * @return MF_ID
     */
    public String getMfId() {
        return mfId;
    }

    /**
     * @param mfId
     */
    public void setMfId(String mfId) {
        this.mfId = mfId == null ? null : mfId.trim();
    }

    /**
     * @return EMP_TYPE
     */
    public String getEmpType() {
        return empType;
    }

    /**
     * @param empType
     */
    public void setEmpType(String empType) {
        this.empType = empType == null ? null : empType.trim();
    }

    /**
     * @return TYPEID
     */
    public String getTypeid() {
        return typeid;
    }

    /**
     * @param typeid
     */
    public void setTypeid(String typeid) {
        this.typeid = typeid == null ? null : typeid.trim();
    }

    /**
     * @return E0122
     */
    public String getE0122() {
        return e0122;
    }

    /**
     * @param e0122
     */
    public void setE0122(String e0122) {
        this.e0122 = e0122 == null ? null : e0122.trim();
    }

    /**
     * @return UNIT_NAME
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * @param unitName
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName == null ? null : unitName.trim();
    }

    /**
     * @return DEP_NAME
     */
    public String getDepName() {
        return depName;
    }

    /**
     * @param depName
     */
    public void setDepName(String depName) {
        this.depName = depName == null ? null : depName.trim();
    }

    /**
     * @return OFFICE_NAME
     */
    public String getOfficeName() {
        return officeName;
    }

    /**
     * @param officeName
     */
    public void setOfficeName(String officeName) {
        this.officeName = officeName == null ? null : officeName.trim();
    }

    /**
     * @return EMP_SID
     */
    public Integer getEmpSid() {
        return empSid;
    }

    /**
     * @param empSid
     */
    public void setEmpSid(Integer empSid) {
        this.empSid = empSid;
    }

    /**
     * @return ARCH_ID
     */
    public String getArchId() {
        return archId;
    }

    /**
     * @param archId
     */
    public void setArchId(String archId) {
        this.archId = archId == null ? null : archId.trim();
    }

    /**
     * @return CN_NAME
     */
    public String getCnName() {
        return cnName;
    }

    /**
     * @param cnName
     */
    public void setCnName(String cnName) {
        this.cnName = cnName == null ? null : cnName.trim();
    }

    /**
     * @return SMPL_NAME
     */
    public String getSmplName() {
        return smplName;
    }

    /**
     * @param smplName
     */
    public void setSmplName(String smplName) {
        this.smplName = smplName == null ? null : smplName.trim();
    }

    /**
     * @return FULL_NAME
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName == null ? null : fullName.trim();
    }

    /**
     * @return GENDER
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * @return NATIONALITY
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * @param nationality
     */
    public void setNationality(String nationality) {
        this.nationality = nationality == null ? null : nationality.trim();
    }

    /**
     * @return BIRTHDAY
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * @return AGE
     */
    public Short getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(Short age) {
        this.age = age;
    }

    /**
     * @return STU_ORIGIN
     */
    public String getStuOrigin() {
        return stuOrigin;
    }

    /**
     * @param stuOrigin
     */
    public void setStuOrigin(String stuOrigin) {
        this.stuOrigin = stuOrigin == null ? null : stuOrigin.trim();
    }

    /**
     * @return NATIVE_PLACE
     */
    public String getNativePlace() {
        return nativePlace;
    }

    /**
     * @param nativePlace
     */
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace == null ? null : nativePlace.trim();
    }

    /**
     * @return HOUSE_BOOK
     */
    public String getHouseBook() {
        return houseBook;
    }

    /**
     * @param houseBook
     */
    public void setHouseBook(String houseBook) {
        this.houseBook = houseBook == null ? null : houseBook.trim();
    }

    /**
     * @return HOUSE_BOOOK_TYPE
     */
    public String getHouseBoookType() {
        return houseBoookType;
    }

    /**
     * @param houseBoookType
     */
    public void setHouseBoookType(String houseBoookType) {
        this.houseBoookType = houseBoookType == null ? null : houseBoookType.trim();
    }

    /**
     * @return WORK_DATE
     */
    public Date getWorkDate() {
        return workDate;
    }

    /**
     * @param workDate
     */
    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    /**
     * @return ENTR_MF_DATE
     */
    public Date getEntrMfDate() {
        return entrMfDate;
    }

    /**
     * @param entrMfDate
     */
    public void setEntrMfDate(Date entrMfDate) {
        this.entrMfDate = entrMfDate;
    }

    /**
     * @return BONUS_CARD_PLACE
     */
    public String getBonusCardPlace() {
        return bonusCardPlace;
    }

    /**
     * @param bonusCardPlace
     */
    public void setBonusCardPlace(String bonusCardPlace) {
        this.bonusCardPlace = bonusCardPlace == null ? null : bonusCardPlace.trim();
    }

    /**
     * @return ENROLL_FROM
     */
    public String getEnrollFrom() {
        return enrollFrom;
    }

    /**
     * @param enrollFrom
     */
    public void setEnrollFrom(String enrollFrom) {
        this.enrollFrom = enrollFrom == null ? null : enrollFrom.trim();
    }

    /**
     * @return CATALOG_TYPE
     */
    public String getCatalogType() {
        return catalogType;
    }

    /**
     * @param catalogType
     */
    public void setCatalogType(String catalogType) {
        this.catalogType = catalogType == null ? null : catalogType.trim();
    }

    /**
     * @return JOB_WAIT_ID
     */
    public String getJobWaitId() {
        return jobWaitId;
    }

    /**
     * @param jobWaitId
     */
    public void setJobWaitId(String jobWaitId) {
        this.jobWaitId = jobWaitId == null ? null : jobWaitId.trim();
    }

    /**
     * @return ID_CARD
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * @param idCard
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * @return QUIT_DATE
     */
    public Date getQuitDate() {
        return quitDate;
    }

    /**
     * @param quitDate
     */
    public void setQuitDate(Date quitDate) {
        this.quitDate = quitDate;
    }

    /**
     * @return SPCL_MEMO
     */
    public String getSpclMemo() {
        return spclMemo;
    }

    /**
     * @param spclMemo
     */
    public void setSpclMemo(String spclMemo) {
        this.spclMemo = spclMemo == null ? null : spclMemo.trim();
    }

    /**
     * @return MEMO
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
    }

    /**
     * @return CTRCT_TYPE
     */
    public String getCtrctType() {
        return ctrctType;
    }

    /**
     * @param ctrctType
     */
    public void setCtrctType(String ctrctType) {
        this.ctrctType = ctrctType == null ? null : ctrctType.trim();
    }

    /**
     * @return CTRCT_FROM_DATE
     */
    public Date getCtrctFromDate() {
        return ctrctFromDate;
    }

    /**
     * @param ctrctFromDate
     */
    public void setCtrctFromDate(Date ctrctFromDate) {
        this.ctrctFromDate = ctrctFromDate;
    }

    /**
     * @return CTRCT_EXPR_DATE
     */
    public Date getCtrctExprDate() {
        return ctrctExprDate;
    }

    /**
     * @param ctrctExprDate
     */
    public void setCtrctExprDate(Date ctrctExprDate) {
        this.ctrctExprDate = ctrctExprDate;
    }

    /**
     * @return ABORNAL_MEMO
     */
    public String getAbornalMemo() {
        return abornalMemo;
    }

    /**
     * @param abornalMemo
     */
    public void setAbornalMemo(String abornalMemo) {
        this.abornalMemo = abornalMemo == null ? null : abornalMemo.trim();
    }

    /**
     * @return JOB_TYPE
     */
    public String getJobType() {
        return jobType;
    }

    /**
     * @param jobType
     */
    public void setJobType(String jobType) {
        this.jobType = jobType == null ? null : jobType.trim();
    }

    /**
     * @return JOB_TIME
     */
    public String getJobTime() {
        return jobTime;
    }

    /**
     * @param jobTime
     */
    public void setJobTime(String jobTime) {
        this.jobTime = jobTime == null ? null : jobTime.trim();
    }

    /**
     * @return CTRCT_PLACE
     */
    public String getCtrctPlace() {
        return ctrctPlace;
    }

    /**
     * @param ctrctPlace
     */
    public void setCtrctPlace(String ctrctPlace) {
        this.ctrctPlace = ctrctPlace == null ? null : ctrctPlace.trim();
    }

    /**
     * @return DIPLOMA_TYPE
     */
    public String getDiplomaType() {
        return diplomaType;
    }

    /**
     * @param diplomaType
     */
    public void setDiplomaType(String diplomaType) {
        this.diplomaType = diplomaType == null ? null : diplomaType.trim();
    }

    /**
     * @return DEGREE
     */
    public String getDegree() {
        return degree;
    }

    /**
     * @param degree
     */
    public void setDegree(String degree) {
        this.degree = degree == null ? null : degree.trim();
    }

    /**
     * @return GRADUATE_DATE
     */
    public Date getGraduateDate() {
        return graduateDate;
    }

    /**
     * @param graduateDate
     */
    public void setGraduateDate(Date graduateDate) {
        this.graduateDate = graduateDate;
    }

    /**
     * @return SPCL_ORIENTATION
     */
    public String getSpclOrientation() {
        return spclOrientation;
    }

    /**
     * @param spclOrientation
     */
    public void setSpclOrientation(String spclOrientation) {
        this.spclOrientation = spclOrientation == null ? null : spclOrientation.trim();
    }

    /**
     * @return GRADUTE_SCHOOL
     */
    public String getGraduteSchool() {
        return graduteSchool;
    }

    /**
     * @param graduteSchool
     */
    public void setGraduteSchool(String graduteSchool) {
        this.graduteSchool = graduteSchool == null ? null : graduteSchool.trim();
    }

    /**
     * @return CERT_NO
     */
    public String getCertNo() {
        return certNo;
    }

    /**
     * @param certNo
     */
    public void setCertNo(String certNo) {
        this.certNo = certNo == null ? null : certNo.trim();
    }

    /**
     * @return STUDY_TYPE
     */
    public String getStudyType() {
        return studyType;
    }

    /**
     * @param studyType
     */
    public void setStudyType(String studyType) {
        this.studyType = studyType == null ? null : studyType.trim();
    }

    /**
     * @return DUTY_NAME
     */
    public String getDutyName() {
        return dutyName;
    }

    /**
     * @param dutyName
     */
    public void setDutyName(String dutyName) {
        this.dutyName = dutyName == null ? null : dutyName.trim();
    }

    /**
     * @return DUTY_DATE
     */
    public Date getDutyDate() {
        return dutyDate;
    }

    /**
     * @param dutyDate
     */
    public void setDutyDate(Date dutyDate) {
        this.dutyDate = dutyDate;
    }

    /**
     * @return MGMT_LEVEL
     */
    public String getMgmtLevel() {
        return mgmtLevel;
    }

    /**
     * @param mgmtLevel
     */
    public void setMgmtLevel(String mgmtLevel) {
        this.mgmtLevel = mgmtLevel == null ? null : mgmtLevel.trim();
    }

    /**
     * @return WHEN_IN_DUTY
     */
    public String getWhenInDuty() {
        return whenInDuty;
    }

    /**
     * @param whenInDuty
     */
    public void setWhenInDuty(String whenInDuty) {
        this.whenInDuty = whenInDuty == null ? null : whenInDuty.trim();
    }

    /**
     * @return IN_DUTY_DOCNO
     */
    public String getInDutyDocno() {
        return inDutyDocno;
    }

    /**
     * @param inDutyDocno
     */
    public void setInDutyDocno(String inDutyDocno) {
        this.inDutyDocno = inDutyDocno == null ? null : inDutyDocno.trim();
    }

    /**
     * @return DUTY_EXPR_DATE
     */
    public Date getDutyExprDate() {
        return dutyExprDate;
    }

    /**
     * @param dutyExprDate
     */
    public void setDutyExprDate(Date dutyExprDate) {
        this.dutyExprDate = dutyExprDate;
    }

    /**
     * @return MGMT_LEVEL_NO
     */
    public String getMgmtLevelNo() {
        return mgmtLevelNo;
    }

    /**
     * @param mgmtLevelNo
     */
    public void setMgmtLevelNo(String mgmtLevelNo) {
        this.mgmtLevelNo = mgmtLevelNo == null ? null : mgmtLevelNo.trim();
    }

    /**
     * @return QA_IN_DUTY
     */
    public String getQaInDuty() {
        return qaInDuty;
    }

    /**
     * @param qaInDuty
     */
    public void setQaInDuty(String qaInDuty) {
        this.qaInDuty = qaInDuty == null ? null : qaInDuty.trim();
    }

    /**
     * @return PRFTNL_NAME
     */
    public String getPrftnlName() {
        return prftnlName;
    }

    /**
     * @param prftnlName
     */
    public void setPrftnlName(String prftnlName) {
        this.prftnlName = prftnlName == null ? null : prftnlName.trim();
    }

    /**
     * @return PRFTNL_DATE
     */
    public Date getPrftnlDate() {
        return prftnlDate;
    }

    /**
     * @param prftnlDate
     */
    public void setPrftnlDate(Date prftnlDate) {
        this.prftnlDate = prftnlDate;
    }

    /**
     * @return PRFTNL_TYPE
     */
    public String getPrftnlType() {
        return prftnlType;
    }

    /**
     * @param prftnlType
     */
    public void setPrftnlType(String prftnlType) {
        this.prftnlType = prftnlType == null ? null : prftnlType.trim();
    }

    /**
     * @return PRFTNL_SERIAL
     */
    public String getPrftnlSerial() {
        return prftnlSerial;
    }

    /**
     * @param prftnlSerial
     */
    public void setPrftnlSerial(String prftnlSerial) {
        this.prftnlSerial = prftnlSerial == null ? null : prftnlSerial.trim();
    }

    /**
     * @return WORK_POST
     */
    public String getWorkPost() {
        return workPost;
    }

    /**
     * @param workPost
     */
    public void setWorkPost(String workPost) {
        this.workPost = workPost == null ? null : workPost.trim();
    }

    /**
     * @return POST_TYPE
     */
    public String getPostType() {
        return postType;
    }

    /**
     * @param postType
     */
    public void setPostType(String postType) {
        this.postType = postType == null ? null : postType.trim();
    }

    /**
     * @return POST_ID
     */
    public String getPostId() {
        return postId;
    }

    /**
     * @param postId
     */
    public void setPostId(String postId) {
        this.postId = postId == null ? null : postId.trim();
    }

    /**
     * @return PARTY_TYPE
     */
    public String getPartyType() {
        return partyType;
    }

    /**
     * @param partyType
     */
    public void setPartyType(String partyType) {
        this.partyType = partyType == null ? null : partyType.trim();
    }

    /**
     * @return PARTY_ENTR_DATE
     */
    public Date getPartyEntrDate() {
        return partyEntrDate;
    }

    /**
     * @param partyEntrDate
     */
    public void setPartyEntrDate(Date partyEntrDate) {
        this.partyEntrDate = partyEntrDate;
    }

    /**
     * @return QA_JOB_TYPE
     */
    public String getQaJobType() {
        return qaJobType;
    }

    /**
     * @param qaJobType
     */
    public void setQaJobType(String qaJobType) {
        this.qaJobType = qaJobType == null ? null : qaJobType.trim();
    }

    /**
     * @return QA_JOB_LEVEL
     */
    public String getQaJobLevel() {
        return qaJobLevel;
    }

    /**
     * @param qaJobLevel
     */
    public void setQaJobLevel(String qaJobLevel) {
        this.qaJobLevel = qaJobLevel == null ? null : qaJobLevel.trim();
    }

    /**
     * @return QA_DATE
     */
    public Date getQaDate() {
        return qaDate;
    }

    /**
     * @param qaDate
     */
    public void setQaDate(Date qaDate) {
        this.qaDate = qaDate;
    }

    /**
     * @return RETIRE_DATE
     */
    public Date getRetireDate() {
        return retireDate;
    }

    /**
     * @param retireDate
     */
    public void setRetireDate(Date retireDate) {
        this.retireDate = retireDate;
    }

    /**
     * @return RE_WORK_DATE
     */
    public Date getReWorkDate() {
        return reWorkDate;
    }

    /**
     * @param reWorkDate
     */
    public void setReWorkDate(Date reWorkDate) {
        this.reWorkDate = reWorkDate;
    }

    /**
     * @return CONTACT
     */
    public String getContact() {
        return contact;
    }

    /**
     * @param contact
     */
    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    /**
     * @return RECRUIT_POST
     */
    public String getRecruitPost() {
        return recruitPost;
    }

    /**
     * @param recruitPost
     */
    public void setRecruitPost(String recruitPost) {
        this.recruitPost = recruitPost == null ? null : recruitPost.trim();
    }

    /**
     * @return ARMS_SPCL
     */
    public String getArmsSpcl() {
        return armsSpcl;
    }

    /**
     * @param armsSpcl
     */
    public void setArmsSpcl(String armsSpcl) {
        this.armsSpcl = armsSpcl == null ? null : armsSpcl.trim();
    }

    /**
     * @return PLAN_RPT_DATE
     */
    public String getPlanRptDate() {
        return planRptDate;
    }

    /**
     * @param planRptDate
     */
    public void setPlanRptDate(String planRptDate) {
        this.planRptDate = planRptDate == null ? null : planRptDate.trim();
    }

    /**
     * @return PLAN_RPT_CITY
     */
    public String getPlanRptCity() {
        return planRptCity;
    }

    /**
     * @param planRptCity
     */
    public void setPlanRptCity(String planRptCity) {
        this.planRptCity = planRptCity == null ? null : planRptCity.trim();
    }

    /**
     * @return PLAN_RPT_FLT_NO
     */
    public String getPlanRptFltNo() {
        return planRptFltNo;
    }

    /**
     * @param planRptFltNo
     */
    public void setPlanRptFltNo(String planRptFltNo) {
        this.planRptFltNo = planRptFltNo == null ? null : planRptFltNo.trim();
    }

    /**
     * @return PLAN_RPT_FLT_DATE
     */
    public Date getPlanRptFltDate() {
        return planRptFltDate;
    }

    /**
     * @param planRptFltDate
     */
    public void setPlanRptFltDate(Date planRptFltDate) {
        this.planRptFltDate = planRptFltDate;
    }

    /**
     * @return PLAN_ID
     */
    public String getPlanId() {
        return planId;
    }

    /**
     * @param planId
     */
    public void setPlanId(String planId) {
        this.planId = planId == null ? null : planId.trim();
    }

    /**
     * @return RECRUIT_TYPE_MEMO
     */
    public String getRecruitTypeMemo() {
        return recruitTypeMemo;
    }

    /**
     * @param recruitTypeMemo
     */
    public void setRecruitTypeMemo(String recruitTypeMemo) {
        this.recruitTypeMemo = recruitTypeMemo == null ? null : recruitTypeMemo.trim();
    }

    /**
     * @return EKP_MAIN
     */
    public String getEkpMain() {
        return ekpMain;
    }

    /**
     * @param ekpMain
     */
    public void setEkpMain(String ekpMain) {
        this.ekpMain = ekpMain == null ? null : ekpMain.trim();
    }

    /**
     * @return DORM_ADDR
     */
    public String getDormAddr() {
        return dormAddr;
    }

    /**
     * @param dormAddr
     */
    public void setDormAddr(String dormAddr) {
        this.dormAddr = dormAddr == null ? null : dormAddr.trim();
    }

    /**
     * @return RPT_PROGRESS_MEMO
     */
    public String getRptProgressMemo() {
        return rptProgressMemo;
    }

    /**
     * @param rptProgressMemo
     */
    public void setRptProgressMemo(String rptProgressMemo) {
        this.rptProgressMemo = rptProgressMemo == null ? null : rptProgressMemo.trim();
    }

    /**
     * @return TRAINING_STATUS
     */
    public String getTrainingStatus() {
        return trainingStatus;
    }

    /**
     * @param trainingStatus
     */
    public void setTrainingStatus(String trainingStatus) {
        this.trainingStatus = trainingStatus == null ? null : trainingStatus.trim();
    }

    /**
     * @return POST_ALL
     */
    public String getPostAll() {
        return postAll;
    }

    /**
     * @param postAll
     */
    public void setPostAll(String postAll) {
        this.postAll = postAll == null ? null : postAll.trim();
    }
}