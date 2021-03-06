package kosta.main;

import kosta.repository.EmpDAO;

public class EmpMainApp {

	public static void main(String[] args) {
		/**
			문제1)
			사원번호가 전달되면 사원번호에 해당하는 
			"사원번호, 사원이름 , 부서명, 부서지역" 검색하고
			사원번호가 없으면 모든 사원의 
			"사원번호, 사원이름 , 부서명, 부서지역" 검색 한다.
			
			=> 사원별 사원정보와 부서정보 ( 1 : 1)
		 */
		//EmpDAO.selectOne(0);//전체검색
		//EmpDAO.selectOne(7902);
		
		/**
		 * 문제1-1) 각 부서별 사원이름검색( 1 대 다)
    		(deptno,dname, loc, empno,ename)
		 */
		//EmpDAO.selectTwo();
		
		/**
		 * 문제2)
			 사원번호, 사원이름,직업, 급여, 급여등급, losal, hisal검색
			  
			  SELECT empno, ename, job, sal, grade, losal, hisal
			  FROM emp e JOIN salgrade s
			  ON e.sal BETWEEN s.losal AND s.hisal
			
			
			    1)  사원의 급여 등급 ( 1 : 1) 
			
			    2) 각 등급별 사원의 정보 검색( 1 : 다)
			
			  --쿼리 공유, java에서 다르게 출력
		 * */
		//EmpDAO.selectThree();
		//EmpDAO.selectFour();
	}
	
}
