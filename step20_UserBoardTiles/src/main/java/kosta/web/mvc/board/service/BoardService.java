package kosta.web.mvc.board.service;

import java.util.List;

import kosta.web.mvc.board.dto.ElectronicsDTO;

public interface BoardService {
	/**
	  * ���ڵ� ��ü �˻�
	  * */
	  List<ElectronicsDTO> selectAll() ;
	  
	  /**
		  * �𵨹�ȣ�� �ش��ϴ� ���ڵ� �˻�
		  * @param: state true�̸� ��ȸ������, false�̸� ��ȸ��������.
		  * */
	  ElectronicsDTO selectByModelNum(String modelNum , boolean state) ;
	  
	 
	  
	/**
	 * ���ڵ� ����
	 * */
	  int insert(ElectronicsDTO electronics);
	  
	  /**
	   * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	   * */
	   int delete(String modelNum, String password);
	  
	   /**
	    * �𵨹�ȣ�� �ش��ϴ� ���ڵ� ����
	    * */
	   int update(ElectronicsDTO electronics);
}
