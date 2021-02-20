package com.jackeyj.sms.common.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author jiyaofei
 */
public class UploadUtils {

    public final static String IMG_PATH_PREFIX = "/upload/portrait";

    /**
     * 创建路径
     * @return
     */
    public static File getImgDirFile(){
        // 构建上传文件的存放 "文件夹" 路径
        String fileDirPath = new String("src/main/resources/static" + IMG_PATH_PREFIX);

        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            // 递归生成文件夹
            fileDir.mkdirs();
        }
        return fileDir;
    }

    public static Result upload(MultipartFile photo){
        if (photo.isEmpty()){
            return Result.fail("上传失败，请选择文件");
        }

        String originalFilename = photo.getOriginalFilename();
        String uuid = UUID.randomUUID().toString();
        String replace = uuid.replaceAll("-", "");
        String newFilename = replace + "_" + originalFilename;

        File imgDirFile = UploadUtils.getImgDirFile();

        try {
            // 构建真实的文件路径
            File newFile = new File(imgDirFile.getAbsolutePath() + File.separator + newFilename);

            // 上传图片到 -》 “绝对路径”
            photo.transferTo(newFile);

            return Result.success("上传成功").put("portraitPath", IMG_PATH_PREFIX + "/" + newFilename);
        } catch (IOException e) {
            e.printStackTrace();
            return Result.fail("上传失败");
        }
    }

    public static Result deletePortrait(String portraitPath){
        File file = new File("src/main/resources/static" + portraitPath);
        if (file.exists()){
            boolean delete = file.delete();
            if (delete){
                return Result.success("删除成功");
            }else {
                return Result.fail("删除失败");
            }
        }else {
            return Result.fail("文件不存在");
        }
    }

}
