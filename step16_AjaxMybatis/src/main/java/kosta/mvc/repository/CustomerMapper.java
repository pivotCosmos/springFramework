package kosta.mvc.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import kosta.mvc.dto.CustomerDTO;

public interface CustomerMapper {

	/**
	 * 수정하기
	 * */
	@Update("update customer set name = #{name}, age = #{age}, tel = #{tel},addr = #{addr} where id = #{id}")
	int update(CustomerDTO customerDTO);
	
	/**
	 * 삭제하기
	 * */
	@Delete("delete from customer where id = #{_parameter}")
	int delete(String id);
}
