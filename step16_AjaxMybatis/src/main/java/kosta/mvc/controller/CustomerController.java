package kosta.mvc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kosta.mvc.dto.CustomerDTO;
import kosta.mvc.service.CustomerService;
import lombok.RequiredArgsConstructor;

@RestController //�񵿱�ȭ���
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerService customerService;
	
	/**
	 * ������ ����
	 * */
	
	/**
	 * ��ü�˻�
	 * */
	@RequestMapping("/selectAll") //json���� �Ѿ�� �Ŷ� jackson�� �����ؼ� produces�ָ� �ȵȴ�.
	public List<CustomerDTO> selectAll(){
		List<CustomerDTO> list = customerService.selectAll();
		
		return list;
	}
	/**
	 * �ߺ�üũ
	 * */
	@RequestMapping(value = "/idCheck", produces="text/html;charset=UTF-8") //text�� �Ѿ�°Ŷ� ������.
	public String idCheck(String id) {
		//System.out.println("CustomerController idCheck() call....");
		return customerService.idCheck(id);
	}
	/**
	 * ���
	 * */
	@RequestMapping("/insert")
	public int insert(CustomerDTO customerDTO) {
		return customerService.insert(customerDTO);
	}
	
	/**
	 * ����
	 * */
	@RequestMapping("/update")
	public int update(CustomerDTO customerDTO) {
		return customerService.update(customerDTO);
	}
	
	/**
	 * ����
	 * */
	@RequestMapping("/delete")
	public int delete(String id) {
		System.out.println(id);
		return customerService.delete(id);
	}
	
}
