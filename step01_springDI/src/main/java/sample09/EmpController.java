package sample09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class EmpController {
	
	@Autowired //byType주입 -> byName 찾기 (이 프로젝트안에서 찾아서 주입)
	@Qualifier("aa")
	private EmpDTO empDTO;
	
	@Autowired
	private EmpDTO dto;
	
	@Autowired
	private EmpService service;
	
	
	
	public void test() {
		System.out.println("service = " + service);
		
		System.out.println("empDTO = " + empDTO + " , empDTO.getEmpno() = "+ empDTO.getEmpno());
		System.out.println("dto = " + dto + " , dto.getEmpno() = "+ dto.getEmpno());
		
		service.test();
	}
}
