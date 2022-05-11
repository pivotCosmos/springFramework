package kosta.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.repository.SuggestDAO;
import lombok.RequiredArgsConstructor;

@Service //id="suggestServiceImpl"
@RequiredArgsConstructor //�����ڸ� ���� final�ʵ�(���) �ʱ�ȭ ���ش�
public class SuggestServiceImpl implements SuggestService {

	/*@Autowired
	private SuggestDAO suggestDAO;*/
	
	private final SuggestDAO suggestDAO; //���, �ݵ�� �ʱ�ȭ (�����Ǵ� ������ or �����ڷ�)
	
	@Override
	public List<String> selectSuggest(String word) {
		//daoȣ��!!!
		List<String> list = suggestDAO.selectSuggest(word);
		
		return list;
	}

}
