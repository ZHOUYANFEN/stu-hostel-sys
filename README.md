# stu-hostel-sys

## 2018-3-11 Mozzie 
 * 搭建 Spring boot环境
 * 连接 SQL Server 数据库
 * 搭建 JPA 环境
 * 添加 banner.txt
   * 修改运行字符图标为 stu-hostel-sys Jingye Tan
   * 字符图画修改地址：
     * http://patorjk.com/software/taag/#p=display&f=Graffiti&t=Stu-hostel-sys%0AJingye%20Tan
## 2018-3-13
 * 用 JPA 管理数据
 * 需求变更：
   * 
 * 测试数据调试 
   * save()
   * delete()
   * - @Modifying
     - @Query("update NAME ")
## 2018-3-19
 * 表设计：
 | admin    | 管理员权限表 |            |        |
 | -------- | ------------ | ---------- | ------ |
 | 列       | 数据类型     | 可否为null | 备注   |
 | id       | int          | NO         | 唯一键 |
 | name     | varchar(255) | YES        | 用户名 |
 | password | varchar(255) | YES        | 密码   |
 | power    | varchar(255) | YES        | 权限   |
 