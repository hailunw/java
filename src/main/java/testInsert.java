import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import domain.Student;

public class testInsert {	
	@Test
	public void testinsert() throws IOException{
	//访问mybatis读取student数据
	//1.定义mybatis主配置文件的名称，从类路径的跟开始
	String config="mybatis.xml";
	//2.读取这个config表示的文件
	InputStream in = Resources.getResourceAsStream(config);
	//3.创建了SqlSessionFactoryBuilder对象
	SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
	//4.创建SqlsessionFactory对象
	SqlSessionFactory factory = builder.build(in);
	//5.重要，获取SqlSession对象，从Sqlsession对象中获取SqlSession
	SqlSession sqlsession = factory.openSession();
	//6. 重要，指定要执行的sql语句的标识。sql映射文件中的namesapce+"."+标签的id值
	String sqlID="dao.studenDAO" + "." + "insertStudent";
	//7. 执行sql语句，插入数据
	Student student = new Student();
	student.setId(1003);
	student.setName("Zhangfei");
	student.setEmail("Zhangfei@hotmail.com");
	student.setAge(20);
	int nums = sqlsession.insert(sqlID,student);
    
   //8.提交事务，然后输出结果
	sqlsession.commit();
	System.out.println(nums);
   //9.关闭sqlsession对象
   sqlsession.close();}

}
