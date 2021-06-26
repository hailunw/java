import java.io.IOException;
import java.util.List;
import org.apache.ibatis.session.*;
import domain.Student;
import utils.MyBatisUtils;

public class myApp2 {

	public static void main(String[] args) throws IOException {
		//1.��Ҫ����ȡSqlSession���󣬴�Sqlsession�����л�ȡSqlSession
		SqlSession sqlsession = MyBatisUtils.getSqlSession();
		//2. ��Ҫ��ָ��Ҫִ�е�sql���ı�ʶ��sqlӳ���ļ��е�namesapce+"."+��ǩ��idֵ
		String sqlID="dao.studenDAO" + "." + "selectStudents";
		//3. ִ��sql��䣬ͨ��SqlId�ҵ����
       List<Student> studentList = sqlsession.selectList(sqlID);
       //4.������
       studentList.forEach(stu->System.out.println(stu));
       //5.�ر�sqlsession����
       sqlsession.close();
	}
}