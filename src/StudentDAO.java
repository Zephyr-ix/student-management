import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// 这个类用来操作数据库里的学生表
public class StudentDAO {

    //添加学生到数据库
    public boolean addStudent(Student student) {
        //获取数据库连接
        Connection conn = DBUtil.getConnection();
        //?是占位符，后面会替换成具体的值
        String sql = "INSERT INTO student(name, age, gender, major) VALUES (?, ?, ?, ?)";
        try {
            //创建一个预编译的SQL语句对象，防止SQL注入
            PreparedStatement ps = conn.prepareStatement(sql);
            //把学生对象的属性设置到SQL语句里
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getGender());
            ps.setString(4, student.getMajor());
            //执行返回受影响的行数
            int result = ps.executeUpdate();
            //如果行数 > 0，说明添加成功
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.close(conn);
        }
    }

    //查询所有学生
    public List<Student> findAllStudents() {
        List<Student> students = new ArrayList<>();
        Connection conn = DBUtil.getConnection();
        String sql = "SELECT * FROM student";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            //执行查询，返回一个结果集
            ResultSet rs = ps.executeQuery();
            //遍历结果集，把每一行数据都封装成一个Student对象
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setAge(rs.getInt("age"));
                s.setGender(rs.getString("gender"));
                s.setMajor(rs.getString("major"));
                //把学生对象添加到列表里
                students.add(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        //返回学生列表
        return students;
    }

    //根据ID删除学生
    public boolean deleteStudent(int id) {
        Connection conn = DBUtil.getConnection();
        String sql = "DELETE FROM student WHERE id = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.close(conn);
        }
    }

    //更新学生信息
    public boolean updateStudent(Student student) {
        Connection conn = DBUtil.getConnection();
        String sql = "UPDATE student SET name=?, age=?, gender=?, major=? WHERE id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getGender());
            ps.setString(4, student.getMajor());
            ps.setInt(5, student.getId());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            DBUtil.close(conn);
        }
    }
}