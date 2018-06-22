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

import mappers.BookMapper;
import models.Book;

public class MybatisTest {
	
	private static SqlSessionFactory sqlSessionFactory;
	private static BookMapper bookMapper;
	private static SqlSession sqlSession;
	
	@BeforeClass
	public static void init(){
		try{
			Reader reader=Resources.getResourceAsReader("mybatisConfig.xml");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
			reader.close();
			System.out.printf("%-5s\t%-30s\t%-8s\t%-4s\n\n",
					"no","bookName","author","price");
			sqlSession=getSqlSession();
			bookMapper=sqlSession.getMapper(BookMapper.class);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static SqlSession getSqlSession(){
		return sqlSessionFactory.openSession();
	}

	@Test
	public void testSelectByAuthor(){
		System.out.println("selectByAutor:");
		//SqlSession sqlSession=getSqlSession();
		try{
			//BookMapper bookMapper=sqlSession.getMapper(BookMapper.class);
			List<Book> books=bookMapper.selectByAuthor("shad");
			assertNotNull(books);
			printBookList(books);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSelectAll() {
		
		try{
			List<Book> bookList=bookMapper.selectAll();
			assertNotNull(bookList);
			System.out.println("selectAll:");
			printBookList(bookList);

		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testSelectByNo(){
		System.out.println("selectByNo:");
		try{
			Book book=bookMapper.selectByNo(1006);
			assertNotNull(book);
			System.out.printf("%-5d\t%-30s\t%-8s\t%-4d\n",
					book.getNo(),book.getBookName(),book.getAuthor(),book.getPrice());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Test 
	public void testInsert(){
//		try{
//			Book book=new Book(1016,"数据库原理","seyg",47);
//			int result=bookMapper.insert(book);
//			sqlSession.commit();  //提交到数据库，否则数据库内容不变
//			assertEquals(1, result);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
		
	}
	
	@Test 
	public void testUpdatePriceByNo(){
		int result=bookMapper.updatePriceByNo(1002, 101);
		sqlSession.commit();  //提交更改到数据库
		assertEquals(1, result);
		
	}
	
	@Test
	public void testDeleteByNo(){
//		int result=bookMapper.deleteByNo(1003);
//		sqlSession.commit();
//		assertEquals(1, result);
	}
	
	private void printBookList(List<Book> books){
		for(Book book:books)
			System.out.printf("%-5d\t%-30s\t%-8s\t%-4d\n",
					book.getNo(),book.getBookName(),book.getAuthor(),book.getPrice());
		//System.out.println("\n");
	}

	@AfterClass
	public static void destory(){
		sqlSession.close();
	}

	
	
	
}
