package unitTest;

import static org.junit.Assert.*;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import mappers.BookMapper_annotation;
import models.Book;

public class MybatisTest_annotation {
	
	private static SqlSessionFactory sqlSessionFactory;
	private static SqlSession sqlSession;
	private static BookMapper_annotation bookMapper_annotation;
	
	
	@BeforeClass
	public static void init(){
		try{
			Reader reader=Resources.getResourceAsReader("mybatisConfig.xml");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			System.out.printf("%-5s\t%-30s\t%-8s\t%-4s\n",
					"no","bookName","author","price");
			sqlSession=getSqlSession();
			bookMapper_annotation=sqlSession.getMapper(BookMapper_annotation.class);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static SqlSession getSqlSession(){
		return sqlSessionFactory.openSession();
	}

	

	@Test
	public void testSelectAll() {
		System.out.println("testSelectAll()");
		List<Book> bookList=bookMapper_annotation.selectAll();
		assertNotNull(bookList);
		printBookList(bookList);
	}
	
	@Test
	public void testSelectByPrice(){
		System.out.println("testSelectByPrice()");
		List<Book> bookList=bookMapper_annotation.selectByPrice(100);
		assertNotNull(bookList);
		printBookList(bookList);
	}
	
	@Test
	public void testInsert(){
		//System.out.println("testInsert()");
		Book book=new Book(1100,"深入理解JVM","sfyaf",66);

		int result=bookMapper_annotation.insert(book);
		sqlSession.commit();
		assertEquals(1, result);
	}
	
	@Test
	public void testDelete(){
		int result=bookMapper_annotation.delectByNo(1111);
		sqlSession.commit();
		assertEquals(1, result);
		
	}
	
	@Test
	public void testUpdate(){
		int result=bookMapper_annotation.updatePriceByNo(1024, 124);
		sqlSession.commit();
		assertEquals(1, result);
	}
	
	
	
	
	private void printBookList(List<Book> books){
		
		for(Book book:books)
			System.out.printf("%-5d\t%-30s\t%-8s\t%-4d\n",
					book.getNo(),book.getBookName(),book.getAuthor(),book.getPrice());
		System.out.println("\n");
	}
	
	
	
	@AfterClass
	public static void  destory(){
		sqlSession.close();
		
	}

}
