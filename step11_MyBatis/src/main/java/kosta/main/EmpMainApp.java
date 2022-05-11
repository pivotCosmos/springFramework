package kosta.main;

import kosta.dao.EmpDAO;
import kosta.dto.EmpDTO;

public class EmpMainApp {

	public static void main(String[] args) {
		EmpDAO dao = new EmpDAO();
		
		System.out.println("1. 사원 이름 검색-----------------");
		//dao.selectByEname();
		
		System.out.println("\n2. 등록하기---------------------");
		//dao.insert(new EmpDTO(8001,"이효리","강사",2500,null));
		//dao.insert(new EmpDTO(8004, null,"강사",2500,null));
		
		System.out.println("\n3. 삭제하기---------------------");
		//dao.delete(8000);
		
		System.out.println("\n4. 수정하기---------------------");
		//dao.update(new EmpDTO(8001,"김효리","변호사",1000,null));
		
		System.out.println("\n5. 전체검색하기-----------------");
		//dao.selectAll();
		
		System.out.println("\n6. 사원번호에 해당하는 사원정보검색-----------------");
		//dao.selectByEmpno(8000);
		
		System.out.println("\n7. 인수로 전달된 급여보다 적게 받는 사원 검색-----------------");
		//dao.selectLessthanSal(2000);
		
		System.out.println("\n8. 인수로 전달된 최소 ~ 최대 범위안에 급여를 받는 사원 검색-----------------");
		//dao.selectMinMax(1000, 2000);
		
		System.out.println("\n9. 정렬대상 컬럼명을 인수로 전달받아 정렬하기-----------------");
		//dao.selectOrder("sal");
		
		System.out.println("\n10. 검색필드와 검색단어 또는 사원번호 또는 급여에 해당하는 레코드 검색-----------------");
		//dao.selectWhereMix("ename", "a", 8000, 3500);
		
		System.out.println("\n11. job에 해당하는 레코드 검색-----------------");
		//dao.selectByJob("manager");
		
		System.out.println("\n11. Member테이블의 모든레코드 검색하기-----------------");
		//dao.memberSelectAll();
	}

}
