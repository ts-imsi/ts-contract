package com.transen.tscontract.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.transen.tscontract.dao.OaContractInfoMapper;
import com.transen.tscontract.model.ContractProduct;
import com.transen.tscontract.model.OaContractInfo;
import com.transen.tscontract.model.OaDic;
import com.transen.tscontract.model.OaProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author luoyun
 * @ClassName: IntelliJ IDEA
 * @Description: 操作类型
 * @date 2017/9/21
 */
@Service
public class ContractService {

    @Autowired
    private OaContractInfoMapper oaContractInfoMapper;

    public PageInfo<OaContractInfo> getOaContractList(int page, int rows,OaContractInfo oaContractInfo){
        PageHelper.startPage(page,rows);
        List<OaContractInfo> oaContractInfoList=oaContractInfoMapper.getOaContractList(oaContractInfo);
        PageInfo<OaContractInfo> pagehelper = new PageInfo<OaContractInfo>(oaContractInfoList);
        return pagehelper;
    }

    public List<ContractProduct> getProductByContract(String contractNo){
        return oaContractInfoMapper.getProductByContract(contractNo);

    }

    public List<OaProduct> getProductList(){
        return oaContractInfoMapper.getProductList();
    }

    public List<OaDic> getProductTypeDic(){
        return oaContractInfoMapper.getProductTypeDic();
    }

}
