package kosta.mvc.repository;

import java.util.List;

import kosta.mvc.dto.CustomerDTO;

public interface CustomerDAO {
	/**
	 * ���̵� �ߺ�üũ
	 *  select id from customer where id=?
	 * */
	String idCheck(String id);
	
	/**
	 * Customer ����ϱ�
	 * */
	int insert(CustomerDTO customerDTO);
	
	/**
	 * ��ü Customer �˻��ϱ�
	 * */
	List<CustomerDTO> selectAll();
	
	/**
	 * id�� �ش��ϴ� ���ڵ� �����ϱ�
	 * */
	int delete(String id);
	
	/**
	 * id�� �ش��ϴ� ���ڵ� �����ϱ�
	 * */
	int update(CustomerDTO customerDTO);

}
