package dao;
import java.util.List;

import domain.Student;
public interface studenDAO {
  // ��ѯstudent������е�����
	public List<Student> selectStudents();
	public int insertStudent(Student student);
}