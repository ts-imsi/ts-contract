package com.trasen.tscontract;

import com.github.pagehelper.PageInfo;
import com.transen.tscontract.Application;
import com.transen.tscontract.model.ContractProduct;
import com.transen.tscontract.model.OaContractInfo;
import com.transen.tscontract.model.OaDic;
import com.transen.tscontract.model.OaProduct;
import com.transen.tscontract.service.ContractService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author luoyun
 * @ClassName: IntelliJ IDEA
 * @Description: 操作类型
 * @date 2017/9/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes= Application.class)
@Transactional
public class OaContractTest {

    @Autowired
    private ContractService contractService;

    @Test
    public void getOaContractList(){
        int page=1;
        int rows=10;
        OaContractInfo oaContractInfo=new OaContractInfo();
        oaContractInfo.setContractOwner("安慧");
        PageInfo<OaContractInfo> contractInfoPageInfo= contractService.getOaContractList(page,rows,oaContractInfo);
        if(contractInfoPageInfo!=null){
            List<OaContractInfo> contractInfoList=contractInfoPageInfo.getList();
            System.out.println(contractInfoList.get(0).getContractNo()+"======"+contractInfoList.get(0).getContractOwner());
        }

    }

    @Test
    public void getProductByContract(){

        List<ContractProduct> contractProductList= contractService.getProductByContract("B14011");
        if(contractProductList!=null){
            System.out.println(contractProductList.get(0).getContractName()+"====="+contractProductList.get(0).getDicName());
        }
    }

    @Test
    public void getProductList(){
        List<OaProduct> oaProductList=contractService.getProductList();
        if(oaProductList!=null){
            for(OaProduct oaProduct:oaProductList){
                System.out.println(oaProduct.getName()+"====="+oaProduct.getProductName());
            }
        }
    }

    @Test
    public void getProductTypeDic(){
        List<OaDic> oaDicList=contractService.getProductTypeDic();
        if(oaDicList!=null){
            for(OaDic oaDic:oaDicList){
                System.out.println(oaDic.getName()+"====="+oaDic.getId());
            }
        }
    }
}
