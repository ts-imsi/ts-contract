package com.transen.tscontract.controller;

import com.github.pagehelper.PageInfo;
import com.transen.tscontract.model.ContractProduct;
import com.transen.tscontract.model.OaContractInfo;
import com.transen.tscontract.model.OaDic;
import com.transen.tscontract.model.OaProduct;
import com.transen.tscontract.service.ContractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luoyun
 * @ClassName: IntelliJ IDEA
 * @Description: 操作类型
 * @date 2017/9/21
 */
@RestController
@RequestMapping(value="/ts-contract/contract")
public class ContractController {
    private final static Logger logger = LoggerFactory.getLogger(ContractController.class);

    @Autowired
    private ContractService contractService;

    /*
    * 获取合同
    * */
    @RequestMapping(value="/getOaContractList",method = RequestMethod.POST)
    public Map<String,Object> getOaContractList(@RequestBody Map<String,String> params){
        Map<String,Object> param=new HashMap<String,Object>();
        if(params.get("page")==null||params.get("rows")==null){
            param.put("messges","参数错误");
            param.put("success",false);
            return param;
        }
        OaContractInfo oaContractInfo=new OaContractInfo();
        if(params.get("contractNo")!=null){
            oaContractInfo.setContractNo(params.get("contractNo"));
        }
        if(params.get("contractOwner")!=null){
            oaContractInfo.setContractOwner(params.get("contractOwner"));
        }

        PageInfo<OaContractInfo> contractInfoPageInfo= contractService.getOaContractList(Integer.valueOf(params.get("page")),Integer.valueOf(params.get("rows")),oaContractInfo);
        logger.info("数据查询条数"+contractInfoPageInfo.getList().size());
        param.put("totalPages",contractInfoPageInfo.getPages());
        param.put("pageNo",contractInfoPageInfo.getPageNum());
        param.put("totalCount",contractInfoPageInfo.getTotal());
        param.put("pageSize",contractInfoPageInfo.getPageSize());
        param.put("list",contractInfoPageInfo.getList());
        param.put("success",true);
        return param;

    }

    /*
    * 合同对应的产品
    * */
    @RequestMapping(value="/getProductByContract",method = RequestMethod.POST)
    public Map<String,Object> getProductByContract(@RequestBody Map<String,String> params){
        Map<String,Object> param=new HashMap<String,Object>();
        if(params.get("contractNo")==null){
            param.put("messge","contractNo参数错误");
            param.put("success",false);
            return param;
        }else{
            List<ContractProduct> contractProductList=contractService.getProductByContract(params.get("contractNo"));
            param.put("list",contractProductList);
            param.put("success",true);
        }
        return param;
    }

    /*
    * 获取产品
    * */
    @RequestMapping(value="/getProductList",method = RequestMethod.POST)
    public Map<String,Object> getProductList(){
        Map<String,Object> param=new HashMap<String,Object>();

        List<OaProduct> oaProductList=contractService.getProductList();
        param.put("list",oaProductList);
        param.put("success",true);
        return param;
    }

    /*
    * 获取产品数据字典
    * */
    @RequestMapping(value="/getProductTypeDic",method = RequestMethod.POST)
    public Map<String,Object> getProductTypeDic(){
        Map<String,Object> param=new HashMap<String,Object>();
        List<OaDic> oaDicList=contractService.getProductTypeDic();
        param.put("list",oaDicList);
        param.put("success",true);
        return param;
    }
}
