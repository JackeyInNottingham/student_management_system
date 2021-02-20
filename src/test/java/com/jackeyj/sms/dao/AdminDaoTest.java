package com.jackeyj.sms.dao;

import com.jackeyj.sms.entity.AdminEntity;
import com.jackeyj.sms.entity.ClazzEntity;
import com.jackeyj.sms.entity.StudentEntity;
import com.jackeyj.sms.entity.TeacherEntity;
import com.jackeyj.sms.service.AdminService;
import com.jackeyj.sms.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.List;
import java.util.UUID;

@SpringBootTest
public class AdminDaoTest{

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    private AdminService adminService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private ClazzDao clazzDao;

    @Test
    public void runTest(){
        List<AdminEntity> all = adminService.findAll(new AdminEntity());
        for (AdminEntity adminEntity : all) {
            System.out.println(adminEntity);
        }
    }

    @Test
    void insertTest() {
        StudentEntity studentEntity = new StudentEntity();
        studentEntity.setName("test").setPassword("12345").setGender("男").setEmail("test").setAddress("test").setClazzName("test").setIntroduction("test").setTelephone("test");
        for (int i = 1; i <= 100; i++) {
            studentEntity.setSno(1002 + i + "").setName("test" + i);
            studentService.insert(studentEntity);
        }
    }

    @Test
    void name() {
        TeacherEntity teacherEntity = new TeacherEntity();
        for (int i = 0; i < 30; i++) {
            teacherEntity.setTno("test" + i).setName("test" + i).setAddress("test" + i).setClazzName("test" + i).
                    setEmail("test" + i).setGender("男").setTelephone("test").setPortraitPath("/src/resources/upload/portrait/default_teacher_portrait.png");
            teacherDao.insert(teacherEntity);
        }
    }

    @Test
    void testClazzName() {
        ClazzEntity clazzEntity = clazzDao.selectById(68);
        System.out.println(clazzEntity);
    }

    @Test
    void path() {
        System.out.println("file:" + System.getProperty("user.dir") + "/src/main/resources/static/upload/");
    }
}