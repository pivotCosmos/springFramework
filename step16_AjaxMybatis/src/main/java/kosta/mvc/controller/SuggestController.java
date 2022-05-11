package kosta.mvc.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.mvc.dto.TestDTO;
import kosta.mvc.service.SuggestService;
import lombok.RequiredArgsConstructor;

/**
 * suggest기능을 처리해줄 전용 ajax Controller
 * */
@RestController
@RequiredArgsConstructor
public class SuggestController {

	private final SuggestService suggestService;
	
	@Autowired
	private TestDTO testDTO;
	
	/**
	 * @PostConstruct는 객체 생성된 후 새성자 이후에 해야할 작업이 있을 경우
	 * 사용하는 annotation
	 * */
	@PostConstruct
	public void aa() {
		System.out.println("testDTO = " + testDTO);
		System.out.println("testDTO.getId = " + testDTO.getId());
		System.out.println("testDTO.getName = " + testDTO.getName());
	}
	
	@RequestMapping("/suggest")
	public List<String> test(String keyWord) { //인수 이름 똑같이
		System.out.println("SuggestController selectSuggest() 호출...");
		
		return suggestService.selectSuggest(keyWord);
	}
	
}
