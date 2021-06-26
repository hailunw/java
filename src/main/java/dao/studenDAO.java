package dao;
import java.util.List;

import domain.Student;
public interface studenDAO {
  // 查询student表的所有的数据
	public List<Student> selectStudents();
	public int insertStudent(Student student);
}