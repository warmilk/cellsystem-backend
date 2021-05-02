package com.kueen.cellsystem.controller;


import com.kueen.cellsystem.service.DepartmentService;
import com.kueen.cellsystem.util.api.CommonResult;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller //@Controller 表示在tomcat启动的时候，把这个类作为一个控制器加载到Spring的Bean工厂，@Controller就是一个注解，当tomcat启动，我们会看到一些JAVA类挥舞着印有@Controller的旗子大喊：" Hey，SpringMVC，I'm  here,please take me to your bean factory!"
@RequestMapping("/department")
public class DepartmentController {

    @Autowired //当spring妈妈看到了这个注解，就知道要Autowired（自动装载）下面的玩意儿啦。
    private DepartmentService departmentService;



    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody //spring妈妈看到 @ResponseBody 这个注解的时候，会把这个方法返回的东西会通过IO流的方式写入到浏览器。
    public CommonResult getAll() {
        return CommonResult.success(departmentService.getAll());
    }


}
