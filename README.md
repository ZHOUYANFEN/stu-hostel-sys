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
 ## 2018-04-16 页面
 * 嵌套页面的切换和方法调用
 * 后台映射key值到前台
 
 ## 2018-04-24 表设计变更
 * community管理公寓和管理员，flat是community的detail。
   * 在community里增删改查公社公寓信息，每个公寓对应一个admin_id和一个admin_name;
   * 在flat里增删改查公寓住户信息，每个公寓住户信息对应一个admin_id和一个admin_name,flat里不可见，且不能修改admin;
   * 在flat里，查询需要根据admin_id，获取数据；
   * 在flat里，增/改需要根据admin_id在community里选择公寓，自动查出地址；
 * 修改community表设计
   * community - 公社公寓表
 
 | 列       | 数据类型     | 可否为null | 备注   |
 | -------- | ------------ | ---------- | ------ |
 | id       | int          | NO         | 唯一键 |
 | community_name| varchar(255) | YES   | 公社名 |
 | flat_name| varchar(255) | YES        | 公寓名 |
 | address  | varchar(255) | YES        | 地址   |
 | admin_id | int          | YES        | 管理员id |
 | admin_name | varchar(255) | YES     | 管理员名称 |
 | remark   | varchar(255) | YES        | 备注   |
 
 * 修改flat表设计
   * flat - 公寓详情表
  
 | 列       | 数据类型     | 可否为null | 备注   |
 | -------- | ------------ | ---------- | ------ |
 | id       | int          | NO         | 唯一键 |
 | admin_id | int          | YES        | 管理员id |
 | admin_name | varchar(255) | YES     | 管理员名称 |
 | flat_name| varchar(255) | YES        | 公寓名 |
 | flat_user| varchar(255) | YES        | 住户姓名|
 | flat_user_id| varchar(255) | YES     | 住户身份证 |
 | flat_user_tel| varchar(255) | YES    | 住户电话 |
 | remark   | varchar(255) | YES        | 备注 - ${admin} |
  
## 2018-05-03 需求变更
 * serve - 公共服务表变更：
   * 只作为服务登记使用；
   * 记录需要服务的公寓及地址，用户、电话，所需何种服务；
   * 记录来服务的服务者、电话、服务时间；
   * 与管理员无关。
   
 | 列       | 数据类型     | 可否为null | 备注   |
 | -------- | ------------ | ---------- | ------ |
 | id       | int          | NO         | 唯一键 |
 | flat_name| varchar(255) | YES        | 公寓名 |
 | flat_address| varchar(255) | YES     | 公寓地址 |
 | flat_user| varchar(255) | YES        | 住户姓名|
 | flat_user_tel| varchar(255) | YES    | 住户电话 |
 | type     | varchar(255) | YES    | 服务类型 clean(卫生)/repair(保修) |
 | time    | varchar(255) | YES    | 服务时间 |
 | serve    | varchar(255) | YES    | 服务者 |
 | serve_id | varchar(255) | YES    | 服务者ID |
 | serve_tel| varchar(255) | YES    | 服务者电话 |
 | remark   | varchar(255) | YES        | 备注 - ${admin} |
 
 * flat - 公寓管理表变更：
   * 增加 type - 类型字段，自住|待租|已租 ；
   * 用Tab展示管理员ID、公寓ID下的房间信息；
   * 增加房间号，以房间号排序，方便分组变更，让一个房间的住户统一管理；
   
  | 列       | 数据类型     | 可否为null | 备注   |
  | -------- | ------------ | ---------- | ------ |
  | id       | int          | NO         | 唯一键 |
  | admin_id | int          | YES        | 管理员id |
  | admin_name | varchar(255) | YES     | 管理员名称 |
  | flat_name| varchar(255) | YES        | 公寓名 |
  | flat_num | varchar(255) | YES        | 房间号 |
  | flat_user| varchar(255) | YES        | 住户姓名|
  | flat_user_id| varchar(255) | YES     | 住户身份证 |
  | flat_user_tel| varchar(255) | YES    | 住户电话 |
  | type     | varchar(255) | YES    | 类型 p(自住)/o(已租)/l（待租）|
  | remark   | varchar(255) | YES        | 备注 - ${admin} |
   
 # 2018-05-07 
  * 按需求：房型字段单间、两房、三方  
  ###### flat表变更记录：
    | 列       | 数据类型     | 可否为null | 备注   |
    | -------- | ------------ | ---------- | ------ |
    | id       | int          | NO         | 唯一键 |
    | admin_id | int          | YES        | 管理员id |
    | admin_name | varchar(255) | YES     | 管理员名称 |
    | flat_name| varchar(255) | YES        | 公寓名 |
    | flat_num | varchar(255) | YES        | 房间号 |
    | flat_user| varchar(255) | YES        | 住户姓名|
    | flat_user_id| varchar(255) | YES     | 住户身份证 |
    | flat_user_tel| varchar(255) | YES    | 住户电话 |
    | type     | varchar(255) | YES    | 类型 p(自住)/o(已租)/l（待租）|
    | size     | varchar(255) | YES    | 大小 1(单间)/2(两房)/3(三房) |
    | remark   | varchar(255) | YES        | 备注 - ${admin} |

  * 访客登记：单独一个模块；
  ###### interview表  
    | 列       | 数据类型     | 可否为null | 备注   |
    | -------- | ------------ | ---------- | ------ |
    | id       | int          | NO         | 唯一键 |
    | visit    | varchar(255) | YES        | 访客姓名 |
    | visit_id | varchar(255) | YES        | 访客身份证 |
    | visit_tel| varchar(255) | YES        | 访客电话 |
    | flat_name| varchar(255) | YES        | 住户姓名 |
    | flat_tel | varchar(255) | YES        | 住户电话 |
    | flat_num | varchar(255) | YES        | 住户房间 |
    | time     | varchar(255) | YES        | 访客时间 |
    
  * 服务管理：操作是修改删除，服务状态，服务者字段去除；
  ###### serve表变更记录：     
    | 列       | 数据类型     | 可否为null | 备注   |
    | -------- | ------------ | ---------- | ------ |
    | id       | int          | NO         | 唯一键 |
    | flat_name| varchar(255) | YES        | 公寓名 |
    | flat_address| varchar(255) | YES     | 公寓地址 |
    | flat_user| varchar(255) | YES        | 住户姓名|
    | flat_user_tel| varchar(255) | YES    | 住户电话 |
    | type     | varchar(255) | YES    | 服务类型 clean(卫生)/repair(报修) |
    | time     | varchar(255) | YES    | 服务时间 |
    | status   | varchar(255) | YES    | 服务状态 |
    | remark   | varchar(255) | YES        | 备注 |
    
  * 图书登记：增记录--姓名、身份证号、电话、书名、借阅时间、归还时间，修改电话、还书时间；
  ###### library表
    | 列       | 数据类型     | 可否为null | 备注   |
    | -------- | ------------ | ---------- | ------ |
    | id       | int          | NO         | 唯一键 |
    | user_name| varchar(255) | YES        | 姓名   |
    | user_id  | varchar(255) | YES        | 身份证号 |
    | user_tel | varchar(255) | YES        | 电话   |
    | book_name| varchar(255) | YES    | 书名 |
    | borrow_time | varchar(255) | YES    | 借阅时间 |
    | back_time| varchar(255) | YES    | 归还时间 |
  
  * 医疗登记：新增、修改 -- 个人信息等等等、是否就医；
  ###### medical表
    | 列       | 数据类型     | 可否为null | 备注   |
    | -------- | ------------ | ---------- | ------ |
    | id       | int          | NO         | 唯一键 |
    | user_name| varchar(255) | YES        | 姓名   |
    | user_id  | varchar(255) | YES        | 身份证号 |
    | user_tel | varchar(255) | YES        | 电话   |
    | allergy  | varchar(255) | YES        | 过敏史 |
    | me_history | varchar(255) | YES      | 是否急救过 |
  
  * 公社行政通知：后台增删改查通知，前台接收查看，发布时间；
  ###### advice表
    | 列       | 数据类型     | 可否为null | 备注   |
    | -------- | ------------ | ---------- | ------ |
    | id       | int          | NO         | 唯一键 |
    | title    | varchar(255) | YES        | 标题   |
    | time     | varchar(255) | YES        | 时间   |
    | content  | varchar(255) | YES        | 内容   |
  
  * 第三方服务；
  * 去掉所有的id；
  
  # 2018-05-09 版本记录
  * 修复flat 
  * 修复serve
  * 去除table 的id
  * 新加访客
  * 第三方服务
  * 公社行政通知
  * 医疗和图书
  
  #2018-05-10
  * bug记录
    * sys的公社管理修改时公社名总是null
    * sys公社管理重复
    * hostel的行政显示为列表，不要表格
    * 住户管理修改时两个select清除逻辑有问题，会把选过的清空
    
  # 2018-05-13
  * 修改sys公社管理重复的bug
  * bug: sys的公社管理修改时公社名总是null 无法复现
  * 修改住户管理修改时两个select清除逻辑有问题，会把选过的清空的bug
  
  # 2018-05-17
  * hostel的行政显示为bootstrap的card组件
  * 修复了sys行政的校验提示信息
    
  