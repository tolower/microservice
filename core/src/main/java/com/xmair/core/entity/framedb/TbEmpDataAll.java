package com.xmair.core.entity.framedb;
import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.util.Date;


import java.math.BigDecimal;

/**
 * <p>
 * 
 *${remark}
 *
 * </p>
 * 
 * @author wuzuquan
 * @date 2018-03-06 10:39:43
 * @version
 */
@Table(name = "TB_EMP_DATA_ALL")
public class TbEmpDataAll implements Serializable {



    @Length(max=10,message="PLAN_RPT_FLT_NO 长度不能超过10")
    @Column(name = "PLAN_RPT_FLT_NO")
	private String planRptFltNo;
	


    @Length(max=50,message="CONTACT 长度不能超过50")
    @Column(name = "CONTACT")
	private String contact;
	


    @Column(name = "DUTY_EXPR_DATE")
	private Date dutyExprDate;
	


    @Length(max=32,message="PRFTNL_TYPE 长度不能超过32")
    @Column(name = "PRFTNL_TYPE")
	private String prftnlType;
	


    @Length(max=20,message="PLAN_RPT_DATE 长度不能超过20")
    @Column(name = "PLAN_RPT_DATE")
	private String planRptDate;
	


    @Length(max=100,message="IN_DUTY_DOCNO 长度不能超过100")
    @Column(name = "IN_DUTY_DOCNO")
	private String inDutyDocno;
	


    @Length(max=10,message="JOB_TIME 长度不能超过10")
    @Column(name = "JOB_TIME")
	private String jobTime;
	


    @Column(name = "PARTY_ENTR_DATE")
	private Date partyEntrDate;
	


    @Length(max=20,message="SPCL_MEMO 长度不能超过20")
    @Column(name = "SPCL_MEMO")
	private String spclMemo;
	


    @Column(name = "ENTR_MF_DATE")
	private Date entrMfDate;
	


    @Length(max=20,message="HOUSE_BOOK 长度不能超过20")
    @Column(name = "HOUSE_BOOK")
	private String houseBook;
	


    @Column(name = "RE_WORK_DATE")
	private Date reWorkDate;
	


    @Length(max=6,message="ARCH_ID 长度不能超过6")
    @Column(name = "ARCH_ID")
	private String archId;
	


    @NotNull(message = "EMP_SID not allow null")
    @Id
    @Column(name = "EMP_SID")
	private BigDecimal empSid;
	


    @Length(max=20,message="NATIVE_PLACE 长度不能超过20")
    @Column(name = "NATIVE_PLACE")
	private String nativePlace;
	


    @Length(max=20,message="CERT_NO 长度不能超过20")
    @Column(name = "CERT_NO")
	private String certNo;
	


    @Length(max=20,message="CTRCT_PLACE 长度不能超过20")
    @Column(name = "CTRCT_PLACE")
	private String ctrctPlace;
	


    @Length(max=80,message="DEP_NAME 长度不能超过80")
    @Column(name = "DEP_NAME")
	private String depName;
	


    @Column(name = "BIRTHDAY")
	private Date birthday;
	


    @Length(max=500,message="MEMO 长度不能超过500")
    @Column(name = "MEMO")
	private String memo;
	


    @Length(max=32,message="DIPLOMA_TYPE 长度不能超过32")
    @Column(name = "DIPLOMA_TYPE")
	private String diplomaType;
	


    @Length(max=20,message="E0122 长度不能超过20")
    @Column(name = "E0122")
	private String e0122;
	


    @Length(max=20,message="MGMT_LEVEL 长度不能超过20")
    @Column(name = "MGMT_LEVEL")
	private String mgmtLevel;
	


    @Length(max=50,message="EMP_TYPE 长度不能超过50")
    @Column(name = "EMP_TYPE")
	private String empType;
	


    @Length(max=12,message="WHEN_IN_DUTY 长度不能超过12")
    @Column(name = "WHEN_IN_DUTY")
	private String whenInDuty;
	


    @Length(max=4,message="PLAN_ID 长度不能超过4")
    @Column(name = "PLAN_ID")
	private String planId;
	


    @Length(max=20,message="DORM_ADDR 长度不能超过20")
    @Column(name = "DORM_ADDR")
	private String dormAddr;
	


    @Length(max=20,message="MGMT_LEVEL_NO 长度不能超过20")
    @Column(name = "MGMT_LEVEL_NO")
	private String mgmtLevelNo;
	


    @Length(max=8,message="TYPEID 长度不能超过8")
    @Column(name = "TYPEID")
	private String typeid;
	


    @Length(max=50,message="SPCL_ORIENTATION 长度不能超过50")
    @Column(name = "SPCL_ORIENTATION")
	private String spclOrientation;
	


    @Length(max=100,message="SMPL_NAME 长度不能超过100")
    @Column(name = "SMPL_NAME")
	private String smplName;
	


    @Length(max=16,message="CATALOG_TYPE 长度不能超过16")
    @Column(name = "CATALOG_TYPE")
	private String catalogType;
	


    @Length(max=20,message="JOB_TYPE 长度不能超过20")
    @Column(name = "JOB_TYPE")
	private String jobType;
	


    @Length(max=32,message="DEGREE 长度不能超过32")
    @Column(name = "DEGREE")
	private String degree;
	


    @Length(max=100,message="RPT_PROGRESS_MEMO 长度不能超过100")
    @Column(name = "RPT_PROGRESS_MEMO")
	private String rptProgressMemo;
	


    @Length(max=18,message="ID_CARD 长度不能超过18")
    @Column(name = "ID_CARD")
	private String idCard;
	


    @Length(max=16,message="NATIONALITY 长度不能超过16")
    @Column(name = "NATIONALITY")
	private String nationality;
	


    @Length(max=10,message="QA_JOB_LEVEL 长度不能超过10")
    @Column(name = "QA_JOB_LEVEL")
	private String qaJobLevel;
	


    @Length(max=20,message="PLAN_RPT_CITY 长度不能超过20")
    @Column(name = "PLAN_RPT_CITY")
	private String planRptCity;
	


    @Column(name = "CTRCT_FROM_DATE")
	private Date ctrctFromDate;
	


    @Column(name = "DUTY_DATE")
	private Date dutyDate;
	


    @Length(max=20,message="ABORNAL_MEMO 长度不能超过20")
    @Column(name = "ABORNAL_MEMO")
	private String abornalMemo;
	


    @Length(max=100,message="TRAINING_STATUS 长度不能超过100")
    @Column(name = "TRAINING_STATUS")
	private String trainingStatus;
	


    @Length(max=40,message="POST_TYPE 长度不能超过40")
    @Column(name = "POST_TYPE")
	private String postType;
	


    @Length(max=40,message="QA_IN_DUTY 长度不能超过40")
    @Column(name = "QA_IN_DUTY")
	private String qaInDuty;
	


    @Length(max=20,message="JOB_WAIT_ID 长度不能超过20")
    @Column(name = "JOB_WAIT_ID")
	private String jobWaitId;
	


    @Length(max=40,message="RECRUIT_TYPE_MEMO 长度不能超过40")
    @Column(name = "RECRUIT_TYPE_MEMO")
	private String recruitTypeMemo;
	


    @Column(name = "WORK_DATE")
	private Date workDate;
	


    @Length(max=40,message="PRFTNL_NAME 长度不能超过40")
    @Column(name = "PRFTNL_NAME")
	private String prftnlName;
	


    @Length(max=8,message="PARTY_TYPE 长度不能超过8")
    @Column(name = "PARTY_TYPE")
	private String partyType;
	


    @Length(max=800,message="UNIT_NAME 长度不能超过800")
    @Column(name = "UNIT_NAME")
	private String unitName;
	


    @Length(max=4000,message="WORK_POST 长度不能超过4000")
    @Column(name = "WORK_POST")
	private String workPost;
	


    @Length(max=200,message="FULL_NAME 长度不能超过200")
    @Column(name = "FULL_NAME")
	private String fullName;
	


    @Column(name = "PLAN_RPT_FLT_DATE")
	private Date planRptFltDate;
	


    @Length(max=8,message="GENDER 长度不能超过8")
    @Column(name = "GENDER")
	private String gender;
	


    @Length(max=70,message="GRADUTE_SCHOOL 长度不能超过70")
    @Column(name = "GRADUTE_SCHOOL")
	private String graduteSchool;
	


    @Length(max=16,message="BONUS_CARD_PLACE 长度不能超过16")
    @Column(name = "BONUS_CARD_PLACE")
	private String bonusCardPlace;
	


    @Column(name = "RETIRE_DATE")
	private Date retireDate;
	


    @Length(max=200,message="OFFICE_NAME 长度不能超过200")
    @Column(name = "OFFICE_NAME")
	private String officeName;
	


    @Length(max=20,message="STU_ORIGIN 长度不能超过20")
    @Column(name = "STU_ORIGIN")
	private String stuOrigin;
	


    @Column(name = "QUIT_DATE")
	private Date quitDate;
	


    @Length(max=5,message="MF_ID 长度不能超过5")
    @Column(name = "MF_ID")
	private String mfId;
	


    @Column(name = "AGE")
	private BigDecimal age;
	


    @Length(max=8,message="POST_ID 长度不能超过8")
    @Column(name = "POST_ID")
	private String postId;
	


    @Length(max=32,message="STUDY_TYPE 长度不能超过32")
    @Column(name = "STUDY_TYPE")
	private String studyType;
	


    @Column(name = "CTRCT_EXPR_DATE")
	private Date ctrctExprDate;
	


    @Column(name = "QA_DATE")
	private Date qaDate;
	


    @Length(max=100,message="CN_NAME 长度不能超过100")
    @Column(name = "CN_NAME")
	private String cnName;
	


    @Length(max=20,message="QA_JOB_TYPE 长度不能超过20")
    @Column(name = "QA_JOB_TYPE")
	private String qaJobType;
	


    @Length(max=100,message="EKP_MAIN 长度不能超过100")
    @Column(name = "EKP_MAIN")
	private String ekpMain;
	


    @Length(max=16,message="ARMS_SPCL 长度不能超过16")
    @Column(name = "ARMS_SPCL")
	private String armsSpcl;
	


    @Length(max=20,message="CTRCT_TYPE 长度不能超过20")
    @Column(name = "CTRCT_TYPE")
	private String ctrctType;
	


    @Length(max=80,message="DUTY_NAME 长度不能超过80")
    @Column(name = "DUTY_NAME")
	private String dutyName;
	


    @Length(max=20,message="RECRUIT_POST 长度不能超过20")
    @Column(name = "RECRUIT_POST")
	private String recruitPost;
	


    @Length(max=20,message="ENROLL_FROM 长度不能超过20")
    @Column(name = "ENROLL_FROM")
	private String enrollFrom;
	


    @Length(max=16,message="HOUSE_BOOOK_TYPE 长度不能超过16")
    @Column(name = "HOUSE_BOOOK_TYPE")
	private String houseBoookType;
	


    @Length(max=10,message="PRFTNL_SERIAL 长度不能超过10")
    @Column(name = "PRFTNL_SERIAL")
	private String prftnlSerial;
	


    @Column(name = "PRFTNL_DATE")
	private Date prftnlDate;
	


    @Column(name = "GRADUATE_DATE")
	private Date graduateDate;
	
		
	public String getPlanRptFltNo() {
        return planRptFltNo;
    }

	public void setPlanRptFltNo(String planRptFltNo) {
    	 this.planRptFltNo = planRptFltNo;
	}
		
	public String getContact() {
        return contact;
    }

	public void setContact(String contact) {
    	 this.contact = contact;
	}
		
	public Date getDutyExprDate() {
        return dutyExprDate;
    }

	public void setDutyExprDate(Date dutyExprDate) {
    	 this.dutyExprDate = dutyExprDate;
	}
		
	public String getPrftnlType() {
        return prftnlType;
    }

	public void setPrftnlType(String prftnlType) {
    	 this.prftnlType = prftnlType;
	}
		
	public String getPlanRptDate() {
        return planRptDate;
    }

	public void setPlanRptDate(String planRptDate) {
    	 this.planRptDate = planRptDate;
	}
		
	public String getInDutyDocno() {
        return inDutyDocno;
    }

	public void setInDutyDocno(String inDutyDocno) {
    	 this.inDutyDocno = inDutyDocno;
	}
		
	public String getJobTime() {
        return jobTime;
    }

	public void setJobTime(String jobTime) {
    	 this.jobTime = jobTime;
	}
		
	public Date getPartyEntrDate() {
        return partyEntrDate;
    }

	public void setPartyEntrDate(Date partyEntrDate) {
    	 this.partyEntrDate = partyEntrDate;
	}
		
	public String getSpclMemo() {
        return spclMemo;
    }

	public void setSpclMemo(String spclMemo) {
    	 this.spclMemo = spclMemo;
	}
		
	public Date getEntrMfDate() {
        return entrMfDate;
    }

	public void setEntrMfDate(Date entrMfDate) {
    	 this.entrMfDate = entrMfDate;
	}
		
	public String getHouseBook() {
        return houseBook;
    }

	public void setHouseBook(String houseBook) {
    	 this.houseBook = houseBook;
	}
		
	public Date getReWorkDate() {
        return reWorkDate;
    }

	public void setReWorkDate(Date reWorkDate) {
    	 this.reWorkDate = reWorkDate;
	}
		
	public String getArchId() {
        return archId;
    }

	public void setArchId(String archId) {
    	 this.archId = archId;
	}
		
	public BigDecimal getEmpSid() {
        return empSid;
    }

	public void setEmpSid(BigDecimal empSid) {
    	 this.empSid = empSid;
	}
		
	public String getNativePlace() {
        return nativePlace;
    }

	public void setNativePlace(String nativePlace) {
    	 this.nativePlace = nativePlace;
	}
		
	public String getCertNo() {
        return certNo;
    }

	public void setCertNo(String certNo) {
    	 this.certNo = certNo;
	}
		
	public String getCtrctPlace() {
        return ctrctPlace;
    }

	public void setCtrctPlace(String ctrctPlace) {
    	 this.ctrctPlace = ctrctPlace;
	}
		
	public String getDepName() {
        return depName;
    }

	public void setDepName(String depName) {
    	 this.depName = depName;
	}
		
	public Date getBirthday() {
        return birthday;
    }

	public void setBirthday(Date birthday) {
    	 this.birthday = birthday;
	}
		
	public String getMemo() {
        return memo;
    }

	public void setMemo(String memo) {
    	 this.memo = memo;
	}
		
	public String getDiplomaType() {
        return diplomaType;
    }

	public void setDiplomaType(String diplomaType) {
    	 this.diplomaType = diplomaType;
	}
		
	public String getE0122() {
        return e0122;
    }

	public void setE0122(String e0122) {
    	 this.e0122 = e0122;
	}
		
	public String getMgmtLevel() {
        return mgmtLevel;
    }

	public void setMgmtLevel(String mgmtLevel) {
    	 this.mgmtLevel = mgmtLevel;
	}
		
	public String getEmpType() {
        return empType;
    }

	public void setEmpType(String empType) {
    	 this.empType = empType;
	}
		
	public String getWhenInDuty() {
        return whenInDuty;
    }

	public void setWhenInDuty(String whenInDuty) {
    	 this.whenInDuty = whenInDuty;
	}
		
	public String getPlanId() {
        return planId;
    }

	public void setPlanId(String planId) {
    	 this.planId = planId;
	}
		
	public String getDormAddr() {
        return dormAddr;
    }

	public void setDormAddr(String dormAddr) {
    	 this.dormAddr = dormAddr;
	}
		
	public String getMgmtLevelNo() {
        return mgmtLevelNo;
    }

	public void setMgmtLevelNo(String mgmtLevelNo) {
    	 this.mgmtLevelNo = mgmtLevelNo;
	}
		
	public String getTypeid() {
        return typeid;
    }

	public void setTypeid(String typeid) {
    	 this.typeid = typeid;
	}
		
	public String getSpclOrientation() {
        return spclOrientation;
    }

	public void setSpclOrientation(String spclOrientation) {
    	 this.spclOrientation = spclOrientation;
	}
		
	public String getSmplName() {
        return smplName;
    }

	public void setSmplName(String smplName) {
    	 this.smplName = smplName;
	}
		
	public String getCatalogType() {
        return catalogType;
    }

	public void setCatalogType(String catalogType) {
    	 this.catalogType = catalogType;
	}
		
	public String getJobType() {
        return jobType;
    }

	public void setJobType(String jobType) {
    	 this.jobType = jobType;
	}
		
	public String getDegree() {
        return degree;
    }

	public void setDegree(String degree) {
    	 this.degree = degree;
	}
		
	public String getRptProgressMemo() {
        return rptProgressMemo;
    }

	public void setRptProgressMemo(String rptProgressMemo) {
    	 this.rptProgressMemo = rptProgressMemo;
	}
		
	public String getIdCard() {
        return idCard;
    }

	public void setIdCard(String idCard) {
    	 this.idCard = idCard;
	}
		
	public String getNationality() {
        return nationality;
    }

	public void setNationality(String nationality) {
    	 this.nationality = nationality;
	}
		
	public String getQaJobLevel() {
        return qaJobLevel;
    }

	public void setQaJobLevel(String qaJobLevel) {
    	 this.qaJobLevel = qaJobLevel;
	}
		
	public String getPlanRptCity() {
        return planRptCity;
    }

	public void setPlanRptCity(String planRptCity) {
    	 this.planRptCity = planRptCity;
	}
		
	public Date getCtrctFromDate() {
        return ctrctFromDate;
    }

	public void setCtrctFromDate(Date ctrctFromDate) {
    	 this.ctrctFromDate = ctrctFromDate;
	}
		
	public Date getDutyDate() {
        return dutyDate;
    }

	public void setDutyDate(Date dutyDate) {
    	 this.dutyDate = dutyDate;
	}
		
	public String getAbornalMemo() {
        return abornalMemo;
    }

	public void setAbornalMemo(String abornalMemo) {
    	 this.abornalMemo = abornalMemo;
	}
		
	public String getTrainingStatus() {
        return trainingStatus;
    }

	public void setTrainingStatus(String trainingStatus) {
    	 this.trainingStatus = trainingStatus;
	}
		
	public String getPostType() {
        return postType;
    }

	public void setPostType(String postType) {
    	 this.postType = postType;
	}
		
	public String getQaInDuty() {
        return qaInDuty;
    }

	public void setQaInDuty(String qaInDuty) {
    	 this.qaInDuty = qaInDuty;
	}
		
	public String getJobWaitId() {
        return jobWaitId;
    }

	public void setJobWaitId(String jobWaitId) {
    	 this.jobWaitId = jobWaitId;
	}
		
	public String getRecruitTypeMemo() {
        return recruitTypeMemo;
    }

	public void setRecruitTypeMemo(String recruitTypeMemo) {
    	 this.recruitTypeMemo = recruitTypeMemo;
	}
		
	public Date getWorkDate() {
        return workDate;
    }

	public void setWorkDate(Date workDate) {
    	 this.workDate = workDate;
	}
		
	public String getPrftnlName() {
        return prftnlName;
    }

	public void setPrftnlName(String prftnlName) {
    	 this.prftnlName = prftnlName;
	}
		
	public String getPartyType() {
        return partyType;
    }

	public void setPartyType(String partyType) {
    	 this.partyType = partyType;
	}
		
	public String getUnitName() {
        return unitName;
    }

	public void setUnitName(String unitName) {
    	 this.unitName = unitName;
	}
		
	public String getWorkPost() {
        return workPost;
    }

	public void setWorkPost(String workPost) {
    	 this.workPost = workPost;
	}
		
	public String getFullName() {
        return fullName;
    }

	public void setFullName(String fullName) {
    	 this.fullName = fullName;
	}
		
	public Date getPlanRptFltDate() {
        return planRptFltDate;
    }

	public void setPlanRptFltDate(Date planRptFltDate) {
    	 this.planRptFltDate = planRptFltDate;
	}
		
	public String getGender() {
        return gender;
    }

	public void setGender(String gender) {
    	 this.gender = gender;
	}
		
	public String getGraduteSchool() {
        return graduteSchool;
    }

	public void setGraduteSchool(String graduteSchool) {
    	 this.graduteSchool = graduteSchool;
	}
		
	public String getBonusCardPlace() {
        return bonusCardPlace;
    }

	public void setBonusCardPlace(String bonusCardPlace) {
    	 this.bonusCardPlace = bonusCardPlace;
	}
		
	public Date getRetireDate() {
        return retireDate;
    }

	public void setRetireDate(Date retireDate) {
    	 this.retireDate = retireDate;
	}
		
	public String getOfficeName() {
        return officeName;
    }

	public void setOfficeName(String officeName) {
    	 this.officeName = officeName;
	}
		
	public String getStuOrigin() {
        return stuOrigin;
    }

	public void setStuOrigin(String stuOrigin) {
    	 this.stuOrigin = stuOrigin;
	}
		
	public Date getQuitDate() {
        return quitDate;
    }

	public void setQuitDate(Date quitDate) {
    	 this.quitDate = quitDate;
	}
		
	public String getMfId() {
        return mfId;
    }

	public void setMfId(String mfId) {
    	 this.mfId = mfId;
	}
		
	public BigDecimal getAge() {
        return age;
    }

	public void setAge(BigDecimal age) {
    	 this.age = age;
	}
		
	public String getPostId() {
        return postId;
    }

	public void setPostId(String postId) {
    	 this.postId = postId;
	}
		
	public String getStudyType() {
        return studyType;
    }

	public void setStudyType(String studyType) {
    	 this.studyType = studyType;
	}
		
	public Date getCtrctExprDate() {
        return ctrctExprDate;
    }

	public void setCtrctExprDate(Date ctrctExprDate) {
    	 this.ctrctExprDate = ctrctExprDate;
	}
		
	public Date getQaDate() {
        return qaDate;
    }

	public void setQaDate(Date qaDate) {
    	 this.qaDate = qaDate;
	}
		
	public String getCnName() {
        return cnName;
    }

	public void setCnName(String cnName) {
    	 this.cnName = cnName;
	}
		
	public String getQaJobType() {
        return qaJobType;
    }

	public void setQaJobType(String qaJobType) {
    	 this.qaJobType = qaJobType;
	}
		
	public String getEkpMain() {
        return ekpMain;
    }

	public void setEkpMain(String ekpMain) {
    	 this.ekpMain = ekpMain;
	}
		
	public String getArmsSpcl() {
        return armsSpcl;
    }

	public void setArmsSpcl(String armsSpcl) {
    	 this.armsSpcl = armsSpcl;
	}
		
	public String getCtrctType() {
        return ctrctType;
    }

	public void setCtrctType(String ctrctType) {
    	 this.ctrctType = ctrctType;
	}
		
	public String getDutyName() {
        return dutyName;
    }

	public void setDutyName(String dutyName) {
    	 this.dutyName = dutyName;
	}
		
	public String getRecruitPost() {
        return recruitPost;
    }

	public void setRecruitPost(String recruitPost) {
    	 this.recruitPost = recruitPost;
	}
		
	public String getEnrollFrom() {
        return enrollFrom;
    }

	public void setEnrollFrom(String enrollFrom) {
    	 this.enrollFrom = enrollFrom;
	}
		
	public String getHouseBoookType() {
        return houseBoookType;
    }

	public void setHouseBoookType(String houseBoookType) {
    	 this.houseBoookType = houseBoookType;
	}
		
	public String getPrftnlSerial() {
        return prftnlSerial;
    }

	public void setPrftnlSerial(String prftnlSerial) {
    	 this.prftnlSerial = prftnlSerial;
	}
		
	public Date getPrftnlDate() {
        return prftnlDate;
    }

	public void setPrftnlDate(Date prftnlDate) {
    	 this.prftnlDate = prftnlDate;
	}
		
	public Date getGraduateDate() {
        return graduateDate;
    }

	public void setGraduateDate(Date graduateDate) {
    	 this.graduateDate = graduateDate;
	}
	}