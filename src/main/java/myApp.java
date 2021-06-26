import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import domain.Student;


public class myApp {

	public static void main(String[] args) throws IOException {
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
		String sqlID="dao.studenDAO" + "." + "selectStudents";
		//7. ִ��sql��䣬ͨ��SqlId�ҵ����
       List<Student> studentList = sqlsession.selectList(sqlID);
       //8.������
       studentList.forEach(stu->System.out.println(stu));
       //9.�ر�sqlsession����
       sqlsession.close();
	}

}
