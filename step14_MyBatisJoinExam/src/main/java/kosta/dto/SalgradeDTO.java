package kosta.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@ToString(exclude="empList")
public class SalgradeDTO {
	private int grade;
	private int losal;
	private int hisal;
	
	//1:다
	private List<EmpDTO> empList;
}
