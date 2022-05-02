package kosta.mvc.dao;

import java.util.List;

import kosta.mvc.dto.ProductDTO;
import kosta.mvc.exception.MyErrorException;

public interface ProductDAO {
   /**
    * �˻�
    * */
	List<ProductDTO> select();
	
	/**
	 * ���
	 * */
	int insert(ProductDTO productDTO)throws MyErrorException;
	
	/**
	 * ����
	 * */
	 int delete(String code)throws MyErrorException;

	/**
	 * �󼼺���
	 * */
	 ProductDTO read(String code);

}










