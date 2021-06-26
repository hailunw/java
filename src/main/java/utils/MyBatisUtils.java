package utils;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	private static SqlSessionFactory factory =null;
	static {
		String config="mybatis.xml";//需要和项目中的名字一样
		try {
			InputStream in = Resources.getResourceAsStream(config);
			factory =new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static SqlSession getSqlSession() {
		SqlSession sqlsession = null;
		if(factory != null) {
			sqlsession= factory.openSession();//非自动提交事务

		}
		return sqlsession;
	}	
}
