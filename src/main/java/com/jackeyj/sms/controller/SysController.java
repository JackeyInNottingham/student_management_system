package com.jackeyj.sms.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.util.StringUtil;
import com.jackeyj.sms.common.utils.JWTUtils;
import com.jackeyj.sms.common.utils.UploadUtils;
import com.jackeyj.sms.common.utils.VerifyCodeUtil;
import com.jackeyj.sms.common.utils.Result;
import com.jackeyj.sms.entity.*;
import com.jackeyj.sms.entity.vo.AdminVo;
import com.jackeyj.sms.entity.vo.StudentVo;
import com.jackeyj.sms.entity.vo.TeacherVo;
import com.jackeyj.sms.service.AdminService;
import com.jackeyj.sms.service.StudentService;
import com.jackeyj.sms.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author jiyaofei
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/sys")
public class SysController {

    private BufferedImage buffImg;

    private final String ADMIN = "admin";

    private final String STUDENT = "student";

    private final String TEACHER = "teacher";

    private final String SUCCESS = "success";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private AdminService adminService;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private StudentService studentService;

    @GetMapping("/createVerifyCodeImg")
    public Result createVerifyCodeImg(HttpServletRequest request, HttpServletResponse response) {
        try {
            VerifyCodeUtil verifyCodeUtil = new VerifyCodeUtil();
            String key = UUID.randomUUID().toString();
            String verifyCode = verifyCodeUtil.getCode();
            this.buffImg = verifyCodeUtil.getBuffImg();

            redisTemplate.opsForValue().set(key, verifyCode, 60 * 3, TimeUnit.SECONDS);

            return Result.success().put("key", key);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

    @RequestMapping("/verifyCodeImg")
    public void verifyCodeImg(HttpServletResponse response) {
        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            ImageIO.write(buffImg, "JPEG", outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @PostMapping("/login/{verifyKey}")
    public Result login(@RequestBody LoginForm loginForm, @PathVariable String verifyKey) {
        String code = redisTemplate.opsForValue().get(verifyKey);
        if (StringUtil.isEmpty(code)) {
            return Result.fail("验证码已失效");
        } else if (!loginForm.getVerifyCode().equalsIgnoreCase(code)) {
            return Result.fail("验证码输入错误！请重新输入！");
        } else {
            String type = loginForm.getType();
            String username = loginForm.getUsername();
            String password = loginForm.getPassword();
            Map<String, String> UserInfo = new HashMap<>();
            if (ADMIN.equals(type)){
                try {
                    AdminVo adminVo = adminService.selectByUsernameAndPassword(username, password);
                    if (adminVo != null) {
                        UserInfo.put("username", username);
                        UserInfo.put("portraitPath", adminVo.getPortraitPath());
                        UserInfo.put("type", type);
                        String token = JWTUtils.getToken(UserInfo);
                        return Result.success().put("token", token).put("portraitPath", adminVo.getPortraitPath()).put("id", adminVo.getId());
                    } else {
                        return Result.fail("用户名或密码错误");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return Result.fail("服务器异常");
                }
            }else if (TEACHER.equals(type)){
                try {
                    TeacherVo teacherVo = teacherService.selectByUsernameAndPassword(username, password);
                    if (teacherVo != null) {
                        UserInfo.put("username", username);
                        UserInfo.put("portraitPath", teacherVo.getPortraitPath());
                        UserInfo.put("type", type);
                        String token = JWTUtils.getToken(UserInfo);
                        return Result.success().put("token", token).put("portraitPath", teacherVo.getPortraitPath()).put("id", teacherVo.getId());
                    } else {
                        return Result.fail("用户名或密码错误");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return Result.fail("服务器异常");
                }
            }else if (STUDENT.equals(type)){
                try {
                    StudentVo studentVo = studentService.selectByUsernameAndPassword(username, password);
                    if (studentVo != null) {
                        UserInfo.put("username", username);
                        UserInfo.put("portraitPath", studentVo.getPortraitPath());
                        UserInfo.put("type", type);
                        String token = JWTUtils.getToken(UserInfo);
                        return Result.success().put("token", token).put("portraitPath", studentVo.getPortraitPath()).put("id", studentVo.getId());
                    } else {
                        return Result.fail("用户名或密码错误");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return Result.fail("服务器异常");
                }
            }else {
                return Result.fail("请选择有效类型！");
            }
        }
    }

    @PostMapping("/upload")
    public Result upload(MultipartFile file){
        return UploadUtils.upload(file);
    }

    @DeleteMapping("/deletePortrait")
    public Result deletePortrait(String portraitPath){
        try {
            return UploadUtils.deletePortrait(portraitPath);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常，请重试");
        }

    }

    @PostMapping("/changePassword/{role}/{id}")
    public Result changePassword(@PathVariable String role, @PathVariable Integer id, @RequestBody PasswordChangeForm passwordChangeForm){
        try {
            String oldPassword = passwordChangeForm.getOldPassword();
            if (StringUtils.isEmpty(oldPassword)){
                return Result.fail("请输入原密码");
            }
            String newPassword = passwordChangeForm.getNewPassword();
            if (StringUtils.isEmpty(newPassword)){
                return Result.fail("请输入新密码");
            }

            String result;
            if (ADMIN.equals(role)){
                result = adminService.changePassword(id, oldPassword, newPassword);
            }else if (TEACHER.equals(role)){
                result = teacherService.changePassword(id, oldPassword, newPassword);
            }else if (STUDENT.equals(role)){
                result = studentService.changePassword(id, oldPassword, newPassword);
            }else {
                return Result.fail("类型出错");
            }
            if (SUCCESS.equals(result)){
                return Result.success("修改成功");
            }else {
                return Result.fail(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }
    }

    @PostMapping("/changePortrait/{role}/{id}")
    public Result changePortrait(@PathVariable String role, @PathVariable Integer id, @RequestBody NewPortraitPath newPortraitPath){
        System.out.println(newPortraitPath);
        try {
            String newPortraitPathString = newPortraitPath.getNewPortraitPath();
            if (StringUtil.isEmpty(newPortraitPathString)){
                return Result.fail("请重新上传文件");
            }

            String result;
            if (ADMIN.equals(role)){
                result = adminService.changePortrait(id, newPortraitPathString);
            }else if (TEACHER.equals(role)){
                result = teacherService.changePortrait(id, newPortraitPathString);
            }else if (STUDENT.equals(role)){
                result = studentService.changePortrait(id, newPortraitPathString);
            }else {
                return Result.fail("类型出错");
            }

            if (SUCCESS.equals(result)){
                return Result.success("修改成功");
            }else {
                return Result.fail(result);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("服务器异常");
        }

    }

}
