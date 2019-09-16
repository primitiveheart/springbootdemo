package com.example.springbootapi.controller;

import com.example.springbootapi.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Author: zhouguanbao
 * Email : zhouguanbao@meituan.com
 * Date  : 2019/8/5
 * Time  : 2:05 PM
 */
@Controller
@RequestMapping("/api")
@Api(value = "api接口", description="用户相关操作")
public class ApiController {

    @RequestMapping(value = "/user", method = {RequestMethod.GET})
    @ApiOperation(value = "用户查询服务", notes = "根据传过来的user_id来查询用户")
    public String getUserById(@ApiParam(value = "用户id") String user_id, ModelMap map){
        User user = new User();
        map.put("user", user);
        return "success";
    }

}
