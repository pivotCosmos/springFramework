package kosta.web.mvc.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kosta.web.mvc.board.dto.ElectronicsDTO;
import kosta.web.mvc.board.repository.BoardDAO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class BoardServiceImpl implements BoardService {

	private final BoardDAO boardDAO;
	
	@Override
	public List<ElectronicsDTO> selectAll() {
		List<ElectronicsDTO> list = boardDAO.selectAll();
		return list;
	}

	@Override
	public ElectronicsDTO selectByModelNum(String modelNum, boolean state) {
		if(state) {//��ȸ��
			int result = boardDAO.readnumUpdate(modelNum);
			if(result==0)throw new RuntimeException("��ȸ�� ���� ������ �Խù� ��ȸ�� ����");
		}
		
		ElectronicsDTO dto = boardDAO.selectByModelNum(modelNum);
		if(dto==null)throw new RuntimeException("�Խù��� ��ȸ�� �� �����ϴ�.");
		
		return dto;
	}

	@Override
	public int insert(ElectronicsDTO electronics){
		int result = boardDAO.insert(electronics);
		if(result==0)throw new RuntimeException("��ϵ��� �ʾҽ��ϴ�.");
		
		return result;
	}

	@Override
	public int delete(String modelNum, String password) {
		//�������� ��й�ȣ ��ġ ���� Ȯ��
		ElectronicsDTO dbElec = boardDAO.selectByModelNum(modelNum);
		if(!dbElec.getPassword().equals(password)) {
			throw new RuntimeException("��й�ȣ ������ ������ �� �����ϴ�.");
		}
		
		int result = boardDAO.delete(modelNum, password);
		if(result==0) throw new RuntimeException("�������� �ʾҽ��ϴ�.");
		return result;
	}

	@Override
	public int update(ElectronicsDTO electronics){
		//�������� ��й�ȣ ��ġ ���� Ȯ��
		ElectronicsDTO dbElec = boardDAO.selectByModelNum(electronics.getModelNum());
		if(!dbElec.getPassword().equals(electronics.getPassword()) ) {
			throw new RuntimeException("��й�ȣ ������ ������ �� �����ϴ�.");
		}
		
		int result = boardDAO.update(electronics);
		
		if(result==0)throw new RuntimeException("�������� �ʾҽ��ϴ�.");
		
		return result;
	}

}
