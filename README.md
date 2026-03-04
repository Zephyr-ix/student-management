# StudentManagementSystem(SMS)
这是我作为初学者入手的第一个简单项目，主要用来练习java语法，JDBC连接MySQL数据库的操作，算是我的编程入门作业。

## 项目介绍
这是一个基于Java开发的控制台版学生管理系统，没有复杂的界面，通过控制台输入指令就能完成学生信息的基础管理。

## 技术栈
- **开发语言**：Java
- **数据库**：MySQL
- **开发工具**：IntelliJ IDEA
- **数据库驱动**：mysql-connector-java

## 核心功能
1. 控制台输入指令交互
2. 学生信息的添加
3. 学生信息的查询
4. 学生信息的修改与删除

## 运行步骤
1. 克隆项目到本地
```bash
git clone https://github.com/Zephyr-ix/student-management.git
```
2. 用IntelliJ IDEA打开克隆后的SMS文件夹

3. 准备数据库
   - 打开本地MySQL，新建一个数据库，命名为student_db
   - 在该数据库中执行SQL创建学生表
```bash
CREATE TABLE student (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL,
    age INT,
    major VARCHAR(30)
);
```
1. 修改数据库连接信息
   - 找到项目里的DBUtil.java文件
   - 把文件里的MySQL用户名和密码，改成你自己电脑的MySQL账号和密码

2. 找到Main.java文件，右键选择Run 'Main.main()'，启动程序

## 项目结构
SMS/
├── src/
│   ├── DBUtil.java
│   ├── Main.java
│   ├── Student.java
│   └── StudentDAO.java
├── .gitignore
└── SMS.iml

## 作者
- GitHub：@Zephyr-ix