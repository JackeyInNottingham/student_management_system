package com.jackeyj.sms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jackeyj.sms.common.utils.Result;
import com.jackeyj.sms.entity.ClazzEntity;
import com.jackeyj.sms.entity.vo.ClazzPojo;
import com.jackeyj.sms.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jiyaofei
 */
@RestController
@RequestMapping("/clazz")
@CrossOrigin
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @GetMapping("/getClazzNames")
    public Result getClazzNames(){
        List<ClazzPojo> clazzPojos = clazzService.selectClazzNames();
        return Result.success().put("clazzNames", clazzPojos);
    }

    @GetMapping("/selectClazzListByPage/{pageNum}/{pageSize}")
    public Result selectClazzListByPage(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<ClazzEntity> clazzs = clazzService.selectList();
            PageInfo<ClazzEntity> clazzVos = new PageInfo<>(clazzs);
            return Result.success().put("clazzList", clazzVos.getList()).put("totalNum", clazzVos.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

    @GetMapping("/filtrateClazzListByPage/{pageNum}/{pageSize}")
    public Result filtrateClazz(String gradeName, String coordinator, @PathVariable Integer pageNum, @PathVariable Integer pageSize){
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<ClazzEntity> clazzs = clazzService.filtrateClazz(gradeName, coordinator);
            PageInfo<ClazzEntity> clazzVos = new PageInfo<>(clazzs);
            return Result.success().put("clazzList", clazzVos.getList()).put("totalNum", clazzVos.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable("id") Integer id){
        try {
            int i = clazzService.deleteById(id);
            if(i > 0){
                return Result.success("删除成功");
            }else {
                return Result.fail("当前班级不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody ClazzEntity clazzInfo){
        try {
            clazzService.insert(clazzInfo);
            return Result.success("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("保存失败");
        }
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable("id") Integer id){
        try {
            ClazzEntity clazzEntity = clazzService.selectById(id);
            if (clazzEntity != null){
                return Result.success().put("clazzInfo", clazzEntity);
            }else {
                return Result.fail("该班级信息不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

    @PostMapping("/updateInfo")
    public Result updateInfo(@RequestBody ClazzEntity clazzInfo){
        try {
            int i = clazzService.updateInfo(clazzInfo);
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
