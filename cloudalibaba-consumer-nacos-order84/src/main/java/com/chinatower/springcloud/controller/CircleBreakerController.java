package com.chinatower.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.chinatower.springcloud.entities.CommonResult;
import com.chinatower.springcloud.entities.Payment;
import com.chinatower.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author yunxl
 * @date 2020/4/7 19:18
 */
@RestController
@Slf4j
public class CircleBreakerController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @RequestMapping("/consumer/fallback/{id}")
//    @SentinelResource(value = "fallback")   //没有配置，页面返回报错，不友好
//    @SentinelResource(value = "fallback",fallback = "handlerFallback")  //fallback只负责业务异常，比如空指针
//    @SentinelResource(value = "fallback",blockHandler = "blockHandler")  //blockHandler只负责sentinel控制台配置违规
//    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler")  //两者一起配置，在不违背sentinel控制台配置得规则下，走fallback,一旦违背，走blockHandler
    @SentinelResource(value = "fallback",fallback = "handlerFallback",blockHandler = "blockHandler",
            exceptionsToIgnore = {IllegalArgumentException.class})    //假如有此IllegalArgumentException异常，不再有fallback方法兜底，只会给前台报错，再违背sentinel控制台配置得规则后，走走blockHandler
    public CommonResult<Payment> fallback(@PathVariable Long id){
        CommonResult<Payment> result = restTemplate.getForObject(serverUrl + "/paymentSQL/" + id, CommonResult.class, id);
        if(id==4){
            throw new IllegalArgumentException("IllegalArgumentException   非法参数异常。。");
        }else if(result.getData() == null ){
            throw new NullPointerException("NullPointerException,该id没有对应记录，空指针异常");
        }
        return result;
    }

    //本侧是fallback
    public CommonResult<Payment> handlerFallback(@PathVariable Long id,Throwable e){
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(444,"兜底异常handlerFallback，exception内容  ："+e.getMessage(),payment);
    }

    //本侧是blockHandler
    public CommonResult<Payment> blockHandler(@PathVariable Long id, BlockException blockException){
        Payment payment = new Payment(id, "null");
        return new CommonResult<>(445,"blockHandler-sentinel限流，无此流水，blockException  ："+blockException.getMessage(),payment);
    }


    //===================openFeign
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSql(@PathVariable("id") Long id){
        return paymentFeignService.paymentSql(id);
    }
}
