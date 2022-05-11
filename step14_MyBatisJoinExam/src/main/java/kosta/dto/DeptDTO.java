package kosta.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
//@ToString(exclude="empList")
public class DeptDTO {
	private int deptno;
	private String dname;
	private String loc;
	
	//1:다
	private List<EmpDTO> empList;
}
