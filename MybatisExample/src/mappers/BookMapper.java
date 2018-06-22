package mappers;

import java.util.List;


import models.Book;;
public interface BookMapper {
	//查询全部内容
	public List<Book> selectAll();
	//按no查询
	public Book selectByNo(int no);
	//按作者名称查询
	public List<Book> selectByAuthor(String author);
	
    
	/**
	 * 插入
	 * @return 返回值表示受影响的行
	 * */
	public int insert(Book book);
	
	/**
	 * 更新
	 * @param no 
	 * @param newPrice 要更新的值
	 * @return 返回值表示受影响的行
	 * */
	public int updatePriceByNo(int no,int newPrice);
	
	/**
	 * 删除
	 * @return 返回值表示受影响的行
	 * */
	public int deleteByNo(int no);
	

}
