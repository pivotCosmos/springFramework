package kosta.mvc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.mvc.dto.CustomerDTO;
import kosta.mvc.service.CustomerService;
import lombok.RequiredArgsConstructor;

@RestController //비동기화통신
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerService customerService;
	
	/**
	 * 페이지 띄우기
	 * */
	
	/**
	 * 전체검색
	 * */
	@RequestMapping("/selectAll") //json으로 넘어가는 거라 jackson이 동작해서 produces주면 안된다.
	public List<CustomerDTO> selectAll(){
		List<CustomerDTO> list = customerService.selectAll();
		
		return list;
	}
	/**
	 * 중복체크
	 * */
	@RequestMapping(value = "/idCheck", produces="text/html;charset=UTF-8") //text로 넘어가는거라 괜찮다.
	public String idCheck(String id) {
		//System.out.println("CustomerController idCheck() call....");
		return customerService.idCheck(id);
	}
	/**
	 * 등록
	 * */
	@RequestMapping("/insert")
	public int insert(CustomerDTO customerDTO) {
		return customerService.insert(customerDTO);
	}
	
	/**
	 * 수정
	 * */
	@RequestMapping("/update")
	public int update(CustomerDTO customerDTO) {
		return customerService.update(customerDTO);
	}
	
	/**
	 * 삭제
	 * */
	@RequestMapping("/delete")
	public int delete(String id) {
		System.out.println(id);
		return customerService.delete(id);
	}
	
}
