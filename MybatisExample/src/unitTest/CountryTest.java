package unitTest;


import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mybatis.models.Country;

public class CountryTest {
	
private static SqlSessionFactory sqlSessionFactory;
	
	@BeforeClass
	public static void init(){
		try{
			Reader reader=Resources.getResourceAsReader("mybatisConfig.xml");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testSelectAll(){
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try{
			List<Country> countryList=sqlSession.selectList("selectAll");
			printCountryList(countryList);
		}finally {
			sqlSession.close();
		}
	}
	
	private void printCountryList(List<Country> countryList) {
		System.out.println("print result");
		if(countryList.size()==0)
			System.out.println("no item");
		for(Country country:countryList){
			System.out.printf("%-4d%4s%4s\n", 
					country.getId(),country.getCountryname(),country.getCountrycode());
		}
	}
//	public static void main(String[] args){
//		CountryTest test=new CountryTest();
//		test.init();
//		test.testSelectAll();
//	}
//	

}
