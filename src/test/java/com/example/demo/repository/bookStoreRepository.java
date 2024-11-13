package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.VO.bookStoreVO;
@Mapper
public interface bookStoreRepository {

	@Delete("""
			TRUNCATE TABLE bookStore;
			""")
	void truncateTable();
	
	@Insert("""
			INSERT INTO bookStore
					SET `name` = #{storeName}
			""")
	void insertStore(String storeName);

	@Select("""
			SELECT `name`
					FROM bookStore
			""")
	List<bookStoreVO> selectStore();

	
	@Update("""
			UPDATE bookStore
				SET `name` = #{storeName}
				WHERE id = #{id}
			""")
	void modifyName(int id, String storeName);
}
