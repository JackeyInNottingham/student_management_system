# student_management_system
通过springboot和vue将原有项目进行了重构

前端：vue+elementUI
后端：springboot+mybatis+redis+jwt

##目前还存在的问题：
1. 后端没对权限进行有效控制
2. 读取头像的部分出错，应该使用字节输出流进行头像的传输，目前由于使用的是路径读取头像，所以没有经过编译的头像就不会被前端获取到