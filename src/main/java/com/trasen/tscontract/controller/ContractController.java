package com.trasen.tscontract.controller;

import com.github.pagehelper.PageInfo;
import com.trasen.tscontract.model.ContractProduct;
import com.trasen.tscontract.model.OaContractInfo;
import com.trasen.tscontract.model.OaDic;
import com.trasen.tscontract.model.OaProduct;
import com.trasen.tscontract.service.ContractService;
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
        if(params.get("selectName")!=null&&params.get("selectName")!=""){
            oaContractInfo.setContractNo(params.get("selectName"));
            oaContractInfo.setContractName(params.get("selectName"));
            oaContractInfo.setCustomerName(params.get("selectName"));
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

    @RequestMapping(value="/getOaContractListByOwner",method = RequestMethod.POST)
    public Map<String,Object> getOaContractListByOwner(@RequestBody Map<String,String> params){
        Map<String,Object> param=new HashMap<String,Object>();
        OaContractInfo oaContractInfo=new OaContractInfo();
        try {
            if (params.get("contractOwner") != null) {
                oaContractInfo.setContractOwner(params.get("contractOwner"));
            } else {
                param.put("messges", "参数错误，合同所有者为空");
                param.put("success", false);
                return param;
            }
            List<OaContractInfo> oaContractInfoList = contractService.getOaContractListByOwner(oaContractInfo);
            param.put("list", oaContractInfoList);
            param.put("success", true);
            return param;
        }catch (Exception e){
            logger.error("获取合同数据异常" + e.getMessage(), e);
            param.put("message","数据查询失败");
            param.put("success", false);
            return param;
        }
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
