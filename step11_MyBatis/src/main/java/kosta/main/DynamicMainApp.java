package kosta.main;


import java.util.Arrays;

import kosta.dao.DynamicDAO;
import kosta.dto.EmpDTO;

public class DynamicMainApp {

	public static void main(String[] args) {
		
		System.out.println("1.if문 동적 쿼리 --------------");
		//DynamicDAO.ifTest(null);//전체검색
		//DynamicDAO.ifTest(new EmpDTO(0,"이수정",null,0,null));//이름
		//DynamicDAO.ifTest(new EmpDTO(0,"김효리","변호사",0,null));//이름+job
		//DynamicDAO.ifTest(new EmpDTO(0,null,"강사",0,null));//job
		
		System.out.println("2.set 동적 쿼리 --------------");
		//DynamicDAO.setTest(new EmpDTO(8003,"김수한",null,0,null));
		//DynamicDAO.setTest(new EmpDTO(8004,"거북이",null,1000,null));
		//DynamicDAO.setTest(new EmpDTO(8002,null,"두루미",0,null));
		//DynamicDAO.setTest(new EmpDTO(8002,"삼천갑","동방삭",2000,null));
		
		System.out.println("3.forEach 동적 쿼리 --------------");
		DynamicDAO.forEachTest(Arrays.asList(8001,8002,8003,8004,8000,7369,7499));
	}

}
