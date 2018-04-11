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
   * * - @Modifying
     - @Query("update NAME ")
## 2018-3-19
 ###### 表设计： 
 * admin - 管理员权限表
   
 | 列       | 数据类型     | 可否为null | 备注   |
 | -------- | ------------ | ---------- | ------ |
 | id       | int          | NO         | 唯一键 |
 | user_name     | varchar(255) | YES        | 用户名 |
 | user_password | varchar(255) | YES        | 密码   |
 | power    | varchar(255) | YES        | 权限   |
 
 * develop - 第三方拓展表
 
  | 列       | 数据类型     | 可否为null | 备注   |
  | -------- | ------------ | ---------- | ------ |
  | id       | int          | NO         | 唯一键 |
  | dev_name | varchar(255) | YES        | 第三方名称 |
  | url      | varchar(255) | YES        | URL路径   |
  | remark   | varchar(255) | YES        | 备注   |
  
 * community - 公社表
 
 | 列       | 数据类型     | 可否为null | 备注   |
 | -------- | ------------ | ---------- | ------ |
 | id       | int          | NO         | 唯一键 |
 | name     | varchar(255) | YES        | 公社名 |
 | address  | varchar(255) | YES        | 地址   |
 | admin_id | int          | YES        | 管理员id |
 | remark   | varchar(255) | YES        | 备注   |
 
 * ${admin}_flat - ${admin}管理的公寓表
  
 | 列       | 数据类型     | 可否为null | 备注   |
 | -------- | ------------ | ---------- | ------ |
 | id       | int          | NO         | 唯一键 |
 | flat_name| varchar(255) | YES        | 公寓名 |
 | flat_user| varchar(255) | YES        | 住户姓名|
 | flat_user_id| varchar(255) | YES     | 住户身份证 |
 | flat_user_tel| varchar(255) | YES    | 住户电话 |
 | remark   | varchar(255) | YES        | 备注 - ${admin} |
 
 * serve - 公共服务表
   
 | 列       | 数据类型     | 可否为null | 备注   |
 | -------- | ------------ | ---------- | ------ |
 | id       | int          | NO         | 唯一键 |
 | flat_name| varchar(255) | YES        | 公寓名 |
 | flat_user| varchar(255) | YES        | 住户姓名|
 | flat_user_id| varchar(255) | YES     | 住户身份证 |
 | flat_user_tel| varchar(255) | YES    | 住户电话 |
 | type     | varchar(255) | YES    | 服务类型 clean(卫生)/repair(保修) |
 | money    | varchar(255) | YES    | 金额 |
 | remark   | varchar(255) | YES        | 备注 - ${admin} |
 
 ## 2018-3-24
 * 创建Model
 * 创建Interface
 * 创建Controller
 
 ## 2018-3-26
 * web service - 用户登录
 * 前台调用web service - 用户登录
 
 ## 2018-4-7 系统管理模块基础服务
 * 登录
 * 用户管理：
   * 查看用户
   * 新增用户
     * 权限设置：1 -root管理员;2 -公社管理员
   * 修改密码
     * 权限设置：1 -root管理员;2 -公社管理员
   * 注销用户（power为1的不可注销）
 * 第三方管理：
   * 增
   * 删
   * 改 
   * 查
 * 公社管理
   * 新增公社信息和公社管理人员
   * 删除公社信息和公社管理人员
   * 修改公社信息和公社管理人员
   * 查看公社信息和公社管理人员
   * 公社通知公社管理人员
 ## 2018-04-08 系统管理模块基础页面
 * 登录页面 ------- 待修改
 * 系统管理模块基础页面
   
 