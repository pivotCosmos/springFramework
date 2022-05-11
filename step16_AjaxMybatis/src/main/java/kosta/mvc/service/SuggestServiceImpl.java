package kosta.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kosta.mvc.repository.SuggestDAO;
import lombok.RequiredArgsConstructor;

@Service //id="suggestServiceImpl"
@RequiredArgsConstructor //생성자를 통한 final필드(상수) 초기화 해준다
public class SuggestServiceImpl implements SuggestService {

	/*@Autowired
	private SuggestDAO suggestDAO;*/
	
	private final SuggestDAO suggestDAO; //상수, 반드시 초기화 (생성되는 시점에 or 생성자로)
	
	@Override
	public List<String> selectSuggest(String word) {
		//dao호출!!!
		List<String> list = suggestDAO.selectSuggest(word);
		
		return list;
	}

}
