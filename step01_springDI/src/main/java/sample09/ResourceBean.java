package sample09;

import javax.annotation.Resource;

public class ResourceBean {
	
	//@Resource를 사용하기 위해서 javax.annotation lib 추가
	@Resource(name="dto")
	private EmpDTO emp1;
	
	@Resource(name="dto2")
	private EmpDTO emp2;
	
	@Resource(name="service")
	private EmpService service;
	
	@Resource(name="controller")
	private EmpController controller;
	
	
	public void test() {
		System.out.println("emp1 = " + emp1 + " , emp1.getEmpno() = " + emp1.getEmpno());
		System.out.println("emp2 = " + emp2 + " , emp2.getEmpno() = " + emp2.getEmpno());
		
		System.out.println("service = " + service);
		System.out.println("controller = " + controller);
	}
}
