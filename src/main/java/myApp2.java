import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.*;
import domain.Student;
import utils.MyBatisUtils;

public class myApp2 {

	public static void main(String[] args) throws IOException {
		//1.重要，获取SqlSession对象，从Sqlsession对象中获取SqlSession
		SqlSession sqlsession = MyBatisUtils.getSqlSession();
		//2. 重要，指定要执行的sql语句的标识。sql映射文件中的namesapce+"."+标签的id值
		String sqlID="dao.studenDAO" + "." + "selectStudents";
		//3. 执行sql语句，通过SqlId找到语句
       List<Student> studentList = sqlsession.selectList(sqlID);
       //4.输出结果
       studentList.forEach(stu->System.out.println(stu));
       //5.关闭sqlsession对象
       sqlsession.close();
	}
}