package kosta.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kosta.mvc.dto.TransferDTO;
import kosta.mvc.exception.MyException;
import kosta.mvc.repository.TransferDAO;

@Service
@Transactional(rollbackFor = MyException.class)
public class TransferServiceImpl implements TransferService {

	@Autowired
	private TransferDAO transferDAO;
	
	//@Transactional(rollbackFor = MyException.class)
	@Override
	public int transfer(TransferDTO transferDTO) throws MyException{
		int re = transferDAO.withDraw(transferDTO); //출금
		int re2 = transferDAO.deposit(transferDTO); //입금
		
		if(re==0 || re2==0) {
			//throw new RuntimeException("계좌이체 실패했습니다.");
			throw new MyException("계좌오류로 이체 실패했습니다.");
		}
		
		return 0;
	}
	
	
	public void test() {
		
	}

}
