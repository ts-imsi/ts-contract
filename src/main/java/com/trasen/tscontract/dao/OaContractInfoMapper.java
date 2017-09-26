package com.trasen.tscontract.dao;

import com.trasen.tscontract.model.ContractProduct;
import com.trasen.tscontract.model.OaContractInfo;
import com.trasen.tscontract.model.OaDic;
import com.trasen.tscontract.model.OaProduct;
import com.trasen.tscontract.util.MyMapper;

import java.util.List;

public interface OaContractInfoMapper extends MyMapper<OaContractInfo> {
     List<OaContractInfo> getOaContractList(OaContractInfo oaContractInfo);
     List<ContractProduct> getProductByContract(String contractNo);
     List<OaProduct> getProductList();
     List<OaDic> getProductTypeDic();
}