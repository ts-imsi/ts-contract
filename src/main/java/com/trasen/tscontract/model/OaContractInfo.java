package com.trasen.tscontract.model;

import java.util.Date;
import javax.persistence.*;

public class OaContractInfo {

    private Integer id;

    private String contractNo; //合同编号

    private Integer contractType;//合同类型

    private String contractName;//合同名称

    private Integer contractPrice;//合同金额

    private Integer productType;//产品分类(1=软件，2=硬件，3=系统集成，4=服务，5=其他)

    private Integer buyPrice;//外购支付

    private Date signDate;//签约时间

    private String contractOwner;//合同所有者

    private String buyer;//甲方

    private String seller;//乙方

    private String buyerSigner;//甲方签约人

    private String sellerSigner;//乙方签约人

    private Integer customerId;//客户ID

    private Date createTime;//创建时间

    private Date timeLimit;//完成时限

    private Integer state;//状态(0未执行1执行中2未寄回4已结束)

    private String paymode;//付款方式

    private String remark;//备注

    private Integer createType;//创建类型，0=内控创建，1=销售创建

    private String createUserId;//创建用户

    private Date distributeDate;//分解时间

    private Date maintainLimit;//维护期限

    private String customerName;//客户名称

    private String customerNo;//客户编号

    private String hospitalGrade;//医院等级

    private String contactAddress;//医院地址

    private String contactPhone;//联系电话

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Integer getContractType() {
        return contractType;
    }

    public void setContractType(Integer contractType) {
        this.contractType = contractType;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public Integer getContractPrice() {
        return contractPrice;
    }

    public void setContractPrice(Integer contractPrice) {
        this.contractPrice = contractPrice;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    public String getContractOwner() {
        return contractOwner;
    }

    public void setContractOwner(String contractOwner) {
        this.contractOwner = contractOwner;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getBuyerSigner() {
        return buyerSigner;
    }

    public void setBuyerSigner(String buyerSigner) {
        this.buyerSigner = buyerSigner;
    }

    public String getSellerSigner() {
        return sellerSigner;
    }

    public void setSellerSigner(String sellerSigner) {
        this.sellerSigner = sellerSigner;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(Date timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getPaymode() {
        return paymode;
    }

    public void setPaymode(String paymode) {
        this.paymode = paymode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getCreateType() {
        return createType;
    }

    public void setCreateType(Integer createType) {
        this.createType = createType;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getDistributeDate() {
        return distributeDate;
    }

    public void setDistributeDate(Date distributeDate) {
        this.distributeDate = distributeDate;
    }

    public Date getMaintainLimit() {
        return maintainLimit;
    }

    public void setMaintainLimit(Date maintainLimit) {
        this.maintainLimit = maintainLimit;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getHospitalGrade() {
        return hospitalGrade;
    }

    public void setHospitalGrade(String hospitalGrade) {
        this.hospitalGrade = hospitalGrade;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}