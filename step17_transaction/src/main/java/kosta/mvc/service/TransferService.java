package kosta.mvc.service;

import kosta.mvc.dto.TransferDTO;
import kosta.mvc.exception.MyException;

public interface TransferService {
	/**
	 * 이체하기
	 * */
	int transfer(TransferDTO transferDTO) throws MyException;
	
	void test();
}
