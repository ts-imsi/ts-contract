package com.transen.tscontract.dao;

import com.transen.tscontract.model.ContractProduct;
import com.transen.tscontract.model.OaContractInfo;
import com.transen.tscontract.model.OaDic;
import com.transen.tscontract.model.OaProduct;
import com.transen.tscontract.util.MyMapper;

import java.util.List;

public interface OaContractInfoMapper extends MyMapper<OaContractInfo> {
     List<OaContractInfo> getOaContractList(OaContractInfo oaContractInfo);
     List<ContractProduct> getProductByContract(String contractNo);
     List<OaProduct> getProductList();
     List<OaDic> getProductTypeDic();
}