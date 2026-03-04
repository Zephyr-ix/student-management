import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    //读取输入
    Scanner sc = new Scanner(System.in);
    //new一个对象，操作数据库
    StudentDAO dao = new StudentDAO();

    while (true) {
      System.out.println("\n===== 学生信息管理系统 =====");
      System.out.println("1.添加学生");
      System.out.println("2.查询所有学生");
      System.out.println("3.删除学生");
      System.out.println("4.更新学生信息");
      System.out.println("5.退出");
      System.out.print("请选择：");
      //读取数字
      int choice = sc.nextInt();

      switch (choice) {
        case 1:
          //添加学生
          System.out.print("姓名：");
          String name = sc.next();
          System.out.print("年龄：");
          int age = sc.nextInt();
          System.out.print("性别：");
          String gender = sc.next();
          System.out.print("专业：");
          String major = sc.next();
          //创建一个学生对象
          Student s = new Student(name, age, gender, major);
          // 调用DAO添加学生
          if (dao.addStudent(s)) {
            System.out.println("添加成功");
          } else {
            System.out.println("添加失败");
          }
          break;
        case 2:
          //查询所有学生
          List<Student> students = dao.findAllStudents();
          if (students.isEmpty()) {
            System.out.println("暂无学生信息");
          } else {
            for (Student stu : students) {
              System.out.println(stu);
            }
          }
          break;
        case 3:
          //删除学生
          System.out.print("要删除的学生ID：");
          int delId = sc.nextInt();
          if (dao.deleteStudent(delId)) {
            System.out.println("删除成功");
          } else {
            System.out.println("删除失败");
          }
          break;
        case 4:
          //更新学生信息
          System.out.print("要更新的学生ID：");
          int updateId = sc.nextInt();
          System.out.print("新姓名：");
          String newName = sc.next();
          System.out.print("新年龄：");
          int newAge = sc.nextInt();
          System.out.print("新性别：");
          String newGender = sc.next();
          System.out.print("新专业：");
          String newMajor = sc.next();
          //创建一个新的学生对象，ID是要更新的那个学生的ID
          Student updateStu = new Student(newName, newAge, newGender, newMajor);
          updateStu.setId(updateId);
          if (dao.updateStudent(updateStu)) {
            System.out.println("更新成功");
          } else {
            System.out.println("更新失败");
          }
          break;
        case 5:
          //退出系统
          System.out.println("退出系统");
          return;
        default:
          //输入错误
          System.out.println("输入有误，请重新选择");
      }
    }
  }
}