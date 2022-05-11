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
 * suggest����� ó������ ���� ajax Controller
 * */
@RestController
@RequiredArgsConstructor
public class SuggestController {

	private final SuggestService suggestService;
	
	@Autowired
	private TestDTO testDTO;
	
	/**
	 * @PostConstruct�� ��ü ������ �� ������ ���Ŀ� �ؾ��� �۾��� ���� ���
	 * ����ϴ� annotation
	 * */
	@PostConstruct
	public void aa() {
		System.out.println("testDTO = " + testDTO);
		System.out.println("testDTO.getId = " + testDTO.getId());
		System.out.println("testDTO.getName = " + testDTO.getName());
	}
	
	@RequestMapping("/suggest")
	public List<String> test(String keyWord) { //�μ� �̸� �Ȱ���
		System.out.println("SuggestController selectSuggest() ȣ��...");
		
		return suggestService.selectSuggest(keyWord);
	}
	
}
