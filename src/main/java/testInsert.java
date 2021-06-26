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
	//����mybatis��ȡstudent����
	//1.����mybatis�������ļ������ƣ�����·���ĸ���ʼ
	String config="mybatis.xml";
	//2.��ȡ���config��ʾ���ļ�
	InputStream in = Resources.getResourceAsStream(config);
	//3.������SqlSessionFactoryBuilder����
	SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
	//4.����SqlsessionFactory����
	SqlSessionFactory factory = builder.build(in);
	//5.��Ҫ����ȡSqlSession���󣬴�Sqlsession�����л�ȡSqlSession
	SqlSession sqlsession = factory.openSession();
	//6. ��Ҫ��ָ��Ҫִ�е�sql���ı�ʶ��sqlӳ���ļ��е�namesapce+"."+��ǩ��idֵ
	String sqlID="dao.studenDAO" + "." + "insertStudent";
	//7. ִ��sql��䣬��������
	Student student = new Student();
	student.setId(1003);
	student.setName("Zhangfei");
	student.setEmail("Zhangfei@hotmail.com");
	student.setAge(20);
	int nums = sqlsession.insert(sqlID,student);
    
   //8.�ύ����Ȼ��������
	sqlsession.commit();
	System.out.println(nums);
   //9.�ر�sqlsession����
   sqlsession.close();}

}
