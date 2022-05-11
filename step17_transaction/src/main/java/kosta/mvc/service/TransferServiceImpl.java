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
		int re = transferDAO.withDraw(transferDTO); //���
		int re2 = transferDAO.deposit(transferDTO); //�Ա�
		
		if(re==0 || re2==0) {
			//throw new RuntimeException("������ü �����߽��ϴ�.");
			throw new MyException("���¿����� ��ü �����߽��ϴ�.");
		}
		
		return 0;
	}
	
	
	public void test() {
		
	}

}
