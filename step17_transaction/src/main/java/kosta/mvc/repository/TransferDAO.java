package kosta.mvc.repository;

import kosta.mvc.dto.TransferDTO;

public interface TransferDAO {
	/**
	 * ����ϱ�
	 * */
	int withDraw(TransferDTO transferDTO);
	
	/**
	 * �Ա��ϱ�
	 * */
	int deposit(TransferDTO transferDTO);
}
