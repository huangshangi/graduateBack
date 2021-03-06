/*
 * Copyright (c) 2020
 * Date:2020/06/16 12:57:16
 * Author:huangshangi
 * explain:
 *
 */

package com.sdu.graduateback.controller;

import com.sdu.graduateback.dto.Graduate;
import com.sdu.graduateback.dto.Result;
import com.sdu.graduateback.dto.Student;
import com.sdu.graduateback.dto.Thesis;
import com.sdu.graduateback.service.GraduateService;
import com.sdu.graduateback.service.ThesisService;
import com.sdu.graduateback.service.UserService;
import com.sdu.graduateback.utils.ErrorUtil;
import com.sdu.graduateback.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import java.util.HashMap;
import java.util.List;

@Controller
public class GraduateController {

    @Autowired
    UserService userService;
    @Autowired
    ThesisService thesisService;
    @Autowired
    GraduateService graduateService;

    @RequestMapping(value = "/gradeval",method = RequestMethod.POST)
    @ResponseBody
    public Result gradeval(@RequestBody Graduate graduate){
        HashMap<String,Object>map=new HashMap<>();

        String token=graduate.getToken();
        String type=graduate.getT();
        if(StringUtil.isEmpty(token)&&StringUtil.isEmpty(type))
            return ErrorUtil.getErrorReport("参数错误");

        String teacherId=userService.getIdByToken(token);

        if(StringUtil.graduateSelect(graduate)){
            //查询
            Object obj = null;
            //毕业申请审核
            if(type.equals("0")){
                List<Student>list=graduateService.getStudentsApp(teacherId);
                obj=graduateService.convertStudentsJson(list);

            }else if(type.equals("1")){
                List<Thesis> list=thesisService.getThesisWai(teacherId);
                obj=graduateService.convertThesissJson(list);
            }else if(type.equals("2")){
                List<Thesis> list=thesisService.getThesisBi(teacherId);
                obj=graduateService.convertThesissJson(list);
            }

            map.put("result",obj);
            return new Result("success",null,obj);


        }else{
            String o=graduate.getO();
            String i=graduate.getI();


            if(graduateService.updateGraduateByGType(i,type,o)==1)
                return new Result("success",null,null);
            else
                return ErrorUtil.getErrorReport("参数错误");
        }



    }
}
