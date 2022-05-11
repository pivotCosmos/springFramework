package kosta.mvc.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

import kosta.mvc.dto.CustomerDTO;

public interface CustomerMapper {

	/**
	 * �����ϱ�
	 * */
	@Update("update customer set name = #{name}, age = #{age}, tel = #{tel},addr = #{addr} where id = #{id}")
	int update(CustomerDTO customerDTO);
	
	/**
	 * �����ϱ�
	 * */
	@Delete("delete from customer where id = #{_parameter}")
	int delete(String id);
}
