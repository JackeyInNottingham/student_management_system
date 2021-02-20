package com.jackeyj.sms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jackeyj.sms.common.utils.Result;
import com.jackeyj.sms.entity.StudentEntity;
import com.jackeyj.sms.entity.vo.StudentVo;
import com.jackeyj.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jiyaofei
 */
@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/selectStudentListByPage/{pageNum}/{pageSize}")
    public Result selectStudentListByPage(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<StudentVo> students = studentService.selectList();
            PageInfo<StudentVo> studentVos = new PageInfo<>(students);
            return Result.success().put("studentList", studentVos.getList()).put("totalNum", studentVos.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

    @GetMapping("/filtrateStudentListByPage/{pageNum}/{pageSize}")
    public Result filtrateStudent(String studentName, String clazzName, @PathVariable Integer pageNum, @PathVariable Integer pageSize){
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<StudentVo> students = studentService.filtrateStudent(studentName, clazzName);
            PageInfo<StudentVo> studentVos = new PageInfo<>(students);
            return Result.success().put("studentList", studentVos.getList()).put("totalNum", studentVos.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable("id") Integer id){
        try {
            int i = studentService.deleteById(id);
            if(i > 0){
                return Result.success("删除成功");
            }else {
                return Result.fail("当前学生不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody StudentEntity studentInfo){
        System.out.println(studentInfo);
        try {
            studentService.insert(studentInfo);
            return Result.success("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("保存失败");
        }
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable("id") Integer id){
        try {
            StudentVo studentVo = studentService.selectById(id);
            if (studentVo != null){
                return Result.success().put("studentInfo", studentVo);
            }else {
                return Result.fail("该学生信息不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

    @PostMapping("/updateInfo")
    public Result updateInfo(@RequestBody StudentVo studentInfo){
        try {
            int i = studentService.updateInfo(studentInfo);
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
