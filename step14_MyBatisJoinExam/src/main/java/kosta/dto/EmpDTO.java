package kosta.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
//@ToString(exclude= {"deptDTO","salgradeDTO"})
public class EmpDTO {
	private int empno;
	private String ename;
	private String job;
	//안쓰는 것도 일단은 써준다..
	private int mgr;
	private String hireDate;
	private int sal;
	private int comm;
	private int deptno;
	
	//1:1
	private DeptDTO deptDTO;
	private SalgradeDTO salgradeDTO;
}
