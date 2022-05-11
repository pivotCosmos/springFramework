package kosta.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kosta.dto.DeptDTO;
import kosta.dto.EmpDTO;
import kosta.dto.SalgradeDTO;

public class EmpDAO {
	
	public static void selectOne(int empno) {
		SqlSession session=null;
		try {
			session = DbUtil.getSession();
			List<EmpDTO> list = session.selectList("joinMapper.selectOne", empno);
			for(EmpDTO emp:list) {
				System.out.println(emp.getDeptDTO().getDname() + " | " + emp.getDeptDTO().getLoc() + " | " + 
								   emp.getEmpno() + " | " + emp.getEname());
			}
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	public static void selectTwo() {
		SqlSession session=null;
		try {
			session = DbUtil.getSession();
			List<DeptDTO> list = session.selectList("joinMapper.selectTwo");
			System.out.println("---총 부서 개수(" + list.size() + ")---------");
			for(DeptDTO dept:list) {
				System.out.println("-------------" + dept.getDname()+"부서정보-------------");
				System.out.println(dept.getDeptno() + " | " + dept.getDname() + " | " + dept.getLoc());
				System.out.println(dept.getDname()+"부서의 사원정보입니다.");
				
				for(EmpDTO emp: dept.getEmpList()) {
					System.out.println("  ▶" + emp.getEmpno() + " |" + emp.getEname());
				}
				System.out.println();
			}//for
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 사원을 기준으로 급여등급 검색하기
	 * */
	public static void selectThree() {
		SqlSession session=null;
		try {
			session = DbUtil.getSession();
			List<EmpDTO> list = session.selectList("joinMapper.selectThree");
			for(EmpDTO emp:list) {
				//empno, ename, job, sal, grade, losal, hisal
				System.out.println(emp.getEmpno() + " | " + emp.getEname() + " | " +
								   emp.getJob() + " | " + emp.getSal() + " | " +
								   emp.getSalgradeDTO().getGrade() + " | " +
								   emp.getSalgradeDTO().getLosal() + " | " +
								   emp.getSalgradeDTO().getHisal() + " | ");
			}
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 각 등급별 사원의 정보 검색
	 * */
	public static void selectFour() {
		SqlSession session=null;
		try {
			session = DbUtil.getSession();
			List<SalgradeDTO> list = session.selectList("joinMapper.selectFour");
			System.out.println("list.size() : " + list.size() + " 개");
			for(SalgradeDTO salgrade:list) {
				System.out.println("-------------급여 " + salgrade.getGrade()+"등급 정보-------------");
				System.out.println(salgrade.getGrade() + " : " + salgrade.getLosal() + " ~ "
									+ salgrade.getHisal());
				System.out.println(salgrade.getGrade()+"등급 급여를 받는 사원정보입니다.");
				
				for(EmpDTO emp: salgrade.getEmpList()) {
					System.out.println("  ▶" + emp.getEmpno() + " | " + emp.getEname() + " | " + 
										emp.getJob() + " | " + emp.getSal());
				}
				System.out.println();
			}
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
}
