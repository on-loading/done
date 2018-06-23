package mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import models.Book;
public interface BookMapper_annotation {
	
	@Select({"select * from books"})
	public List<Book> selectAll();
	
	@Select({"select * from books where price>#{price}"})
	public List<Book> selectByPrice(int price);
	
	@Insert({"insert into books(no,bookName,author,price) values(#{no},#{bookName},#{author},#{price})"})
	public int insert(Book book);
	
	@Delete({"delete from books where no=#{no} "})
	public int delectByNo(int no);
	
	@Update({"update books set price=#{1} where no=#{0}"})
	public int updatePriceByNo(int no,int price);
	

}
