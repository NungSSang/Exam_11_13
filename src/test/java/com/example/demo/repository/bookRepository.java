package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.VO.bookVO;
@Mapper
public interface bookRepository {

	@Delete("""
			TRUNCATE TABLE book;
			""")
	void truncateTable();

	@Insert("""
			INSERT INTO book
					SET title = #{title}
						,author = #{author}
						,storeId = #{storeId}
			""")
	void insertBook(String title, String author, int storeId);

	@Select("""
			SELECT title
				FROM book
			""")
	List<bookVO> selectBookName();

	@Select("""
			SELECT title
				FROM book as b
				INNER JOIN bookStore as bs
				ON b.storeId = bs.id
				WHERE b.storeId = 1
			""")
	List<bookVO> sellKoreaStore();

	@Delete("""
			DELETE FROM book
				WHERE title = #{author}
			""")
	void deleteBook(String author);
		
	

}
