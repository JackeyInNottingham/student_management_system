package com.jackeyj.sms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jackeyj.sms.common.utils.Result;
import com.jackeyj.sms.entity.TeacherEntity;
import com.jackeyj.sms.entity.vo.TeacherPojo;
import com.jackeyj.sms.entity.vo.TeacherVo;
import com.jackeyj.sms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jiyaofei
 */
@RestController
@CrossOrigin
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/getTeacherNames")
    public Result getClazzNames(){
        List<TeacherPojo> teacherPojos = teacherService.selectTeacherNames();
        return Result.success().put("teacherNames", teacherPojos);
    }

    @GetMapping("/selectTeacherListByPage/{pageNum}/{pageSize}")
    public Result selectTeacherListByPage(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<TeacherVo> teachers = teacherService.selectList();
            PageInfo<TeacherVo> teacherVos = new PageInfo<>(teachers);
            return Result.success().put("teacherList", teacherVos.getList()).put("totalNum", teacherVos.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

    @GetMapping("/filtrateTeacherListByPage/{pageNum}/{pageSize}")
    public Result filtrateTeacher(String teacherName, String clazzName, @PathVariable Integer pageNum, @PathVariable Integer pageSize){
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<TeacherVo> teachers = teacherService.filtrateTeacher(teacherName, clazzName);
            PageInfo<TeacherVo> teacherVos = new PageInfo<>(teachers);
            return Result.success().put("teacherList", teacherVos.getList()).put("totalNum", teacherVos.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable("id") Integer id){
        try {
            int i = teacherService.deleteById(id);
            if(i > 0){
                return Result.success("删除成功");
            }else {
                return Result.fail("当前教师不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody TeacherEntity teacherInfo){
        System.out.println(teacherInfo);
        try {
            teacherService.insert(teacherInfo);
            return Result.success("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("保存失败");
        }
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable("id") Integer id){
        try {
            TeacherVo teacherVo = teacherService.selectById(id);
            if (teacherVo != null){
                return Result.success().put("teacherInfo", teacherVo);
            }else {
                return Result.fail("该教师信息不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

    @PostMapping("/updateInfo")
    public Result updateInfo(@RequestBody TeacherVo teacherInfo){
        try {
            int i = teacherService.updateInfo(teacherInfo);
            if (i > 0){
                return Result.success("修改成功！");
            }else {
                return Result.fail("修改失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

}
