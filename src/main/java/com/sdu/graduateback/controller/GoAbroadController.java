/*
 * Copyright (c) 2020
 * Date:2020/06/16 14:49:16
 * Author:huangshangi
 * explain:
 *
 */

package com.sdu.graduateback.controller;


import com.sdu.graduateback.dto.GoAbroad;
import com.sdu.graduateback.dto.Graduate;
import com.sdu.graduateback.dto.Result;
import com.sdu.graduateback.dto.Student;
import com.sdu.graduateback.service.GoAbroadService;
import com.sdu.graduateback.service.GraduateService;
import com.sdu.graduateback.service.StudentService;
import com.sdu.graduateback.service.UserService;
import com.sdu.graduateback.utils.ErrorUtil;
import com.sdu.graduateback.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@Controller
public class GoAbroadController {

    UserService userService;

    StudentService studentService;

    GoAbroadService goAbroadService;

    GraduateService graduateService;

    @RequestMapping(value = "/abroeval",method = RequestMethod.POST)
    @ResponseBody
    public Result abroeval(@RequestBody Graduate graduate){
        HashMap<String,Object>map=new HashMap<>();
        String token=graduate.getToken();
        String type=graduate.getT();
        String teacherId=userService.getIdByToken(token);

        if(StringUtil.isEmpty(token)||StringUtil.isEmpty(type))
            return ErrorUtil.getErrorReport("参数错误");


        if(StringUtil.graduateSelect(graduate)){
            //查询操作
            List<GoAbroad>list=goAbroadService.getGoAbroads(type,teacherId);

            Object obj=goAbroadService.convertGoAbroadJson(list);

            map.put("result",obj);

            return new Result("success",null,map);

        }else{

            //更新操作
            if(graduateService.updateGraduateByAType(graduate.getI(),type,graduate.getO())==1)
                return new Result("success",null,null);
           else
                return ErrorUtil.getErrorReport("参数错误");

        }



    }

}
