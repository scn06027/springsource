package com.study.myapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.study.myapp.dto.BookDTO;
@Repository //객체생성
public class BookDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<BookDTO> select(){
		String sql = "select * from booktbl";
		
		
		//sql구문을 실행하고 , 그 쿼리 실행한걸 어디에다 넣어놓을까? 이 북 로우 매퍼에다 넣어두면됨
		//jdbcTemplate가 알아서 할거임
		return jdbcTemplate.query(sql, new BookRowMapper());
	}
	
	public int insert(BookDTO insertDto) {
		
	
		String sql = "insert into booktbl values(?,?,?,?)";
		
			int result=jdbcTemplate.update(sql, 
					insertDto.getCode(),
			insertDto.getTitle(),
			insertDto.getWriter(),
			insertDto.getPrice());
			
		
		return result;
	}
	
	public int update(int code, int price) {
		
		
		String sql = "update booktbl set price=? where code=?";
		
		int result=jdbcTemplate.update(sql,price,code);
			
		return result;
	}
	public int delete(int code) {
		
		
		String sql = "delete from booktbl where code=?";
		
		int result=jdbcTemplate.update(sql,code);
			
		return result;
	}	
}
