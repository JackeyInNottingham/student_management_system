package com.jackeyj.sms.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jackeyj.sms.common.utils.Result;
import com.jackeyj.sms.entity.AdminEntity;
import com.jackeyj.sms.entity.vo.AdminVo;
import com.jackeyj.sms.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jiyaofei
 */
@RequestMapping("/admin")
@RestController
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;


    @GetMapping("/selectAdminListByPage/{pageNum}/{pageSize}")
    public Result selectAdminListByPage(@PathVariable Integer pageNum, @PathVariable Integer pageSize){
        try {
            PageHelper.startPage(pageNum, pageSize);
            List<AdminVo> admins = adminService.selectList();
            PageInfo<AdminVo> adminVos = new PageInfo<>(admins);
            return Result.success().put("adminList", adminVos.getList()).put("totalNum", adminVos.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable("id") Integer id){
        try {
            int i = adminService.deleteById(id);
            if(i > 0){
                return Result.success("删除成功");
            }else {
                return Result.fail("当前管理员不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

    @PostMapping("/insert")
    public Result insert(@RequestBody AdminEntity adminInfo){
        System.out.println(adminInfo);
        try {
            adminService.insert(adminInfo);
            return Result.success("保存成功");
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("保存失败");
        }
    }

    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable("id") Integer id){
        try {
            AdminVo adminVo = adminService.selectById(id);
            if (adminVo != null){
                return Result.success().put("adminInfo", adminVo);
            }else {
                return Result.fail("该管理员信息不存在");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

    @PostMapping("/updateInfo")
    public Result updateInfo(@RequestBody AdminVo adminInfo){
        try {
            int i = adminService.updateInfo(adminInfo);
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
