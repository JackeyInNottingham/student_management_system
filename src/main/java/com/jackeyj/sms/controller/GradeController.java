package com.jackeyj.sms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jackeyj.sms.common.utils.Result;
import com.jackeyj.sms.entity.GradeEntity;
import com.jackeyj.sms.entity.vo.GradePojo;
import com.jackeyj.sms.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jiyaofei
 */
@RestController
@RequestMapping("/grade")
@CrossOrigin
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @GetMapping("/getGradeNames")
    public Result getGradeNames(){
        List<GradePojo> gradePojos = gradeService.selectGradeNames();
        return Result.success().put("gradeNames", gradePojos);
    }

    @GetMapping("/selectGradeListByPage/{pageNum}/{pageSize}")
    public Result selectGradeListByPage(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<GradeEntity> grades = gradeService.selectList();
            PageInfo<GradeEntity> gradeVos = new PageInfo<>(grades);
            return Result.success().put("gradeList", gradeVos.getList()).put("totalNum", gradeVos.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable("id") Integer id){
        try {
            int i = gradeService.deleteById(id);
            if(i > 0){
                return Result.success("删除成功");
            }else {
                return Result.fail("当前年级不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody GradeEntity gradeInfo){
        try {
            int i = gradeService.insert(gradeInfo);
            if (i > 0){
                return Result.success("保存成功");
            }else {
                return Result.fail("保存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("保存失败");
        }
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable("id") Integer id){
        try {
            GradeEntity gradeEntity = gradeService.selectById(id);
            if (gradeEntity != null){
                return Result.success().put("gradeInfo", gradeEntity);
            }else {
                return Result.fail("该年级信息不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

    @PostMapping("/updateInfo")
    public Result updateInfo(@RequestBody GradeEntity gradeInfo){
        try {
            int i = gradeService.updateInfo(gradeInfo);
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
