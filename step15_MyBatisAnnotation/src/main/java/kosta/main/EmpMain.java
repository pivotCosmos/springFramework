package kosta.main;

import kosta.dao.EmpDAO;
import kosta.dto.EmpDTO;

public class EmpMain {

	public static void main(String[] args) {
		System.out.println("1.전체검색 -------------------------------------");
		EmpDAO.selectAll();
		
		System.out.println("\n2.사원번호 검색 -------------------------------------");
		//EmpDAO.selectByEmpno(7902);
		
		System.out.println("\n3.등록하기 -------------------------------------");
		//EmpDAO.insert(new EmpDTO(8003, "김추가","강사",2500,null));
		
		System.out.println("\n4. 삭제하기---------------------");
		//EmpDAO.delete(8003);
		
		System.out.println("\n5. 수정하기---------------------");
		//EmpDAO.update(new EmpDTO(8002,"테스트","간호사",1000,null));
		
		System.out.println("\n6.if문 동적 쿼리 --------------");
		//EmpDAO.ifTest(null);//전체검색
		//EmpDAO.ifTest(new EmpDTO(0,"이수정",null,0,null));//이름
		//EmpDAO.ifTest(new EmpDTO(0,"김효리","변호사",0,null));//이름+job
		//EmpDAO.ifTest(new EmpDTO(0,null,"강사",0,null));//job
	}

}
