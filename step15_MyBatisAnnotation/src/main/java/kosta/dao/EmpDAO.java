package kosta.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kosta.dto.EmpDTO;
import kosta.util.DbUtil;

public class EmpDAO {

	/**
	 * 전체검색
	 * */
	public static void selectAll() {
		SqlSession session=null;
		try {
			session=DbUtil.getSession();
			//java기반의 쿼리를 호출할때 Mapper interface를 구한다.
			//////////이하 두줄이 바뀐부분/////////////
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			List<EmpDTO> list = mapper.selectAll();
			/////////////////////
			for(EmpDTO emp: list) {
				System.out.println(emp);
			}
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 사원번호 검색
	 * */
	public static void selectByEmpno(int empno) {
		SqlSession session=null;
		try {
			session=DbUtil.getSession();
			//java기반의 쿼리를 호출할때 Mapper interface를 구한다.
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			EmpDTO emp = mapper.selectByEmpno(empno);
			System.out.println("emp = " + emp);
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 사원등록하기
	 * */
	public static void insert(EmpDTO empDTO) {
		SqlSession session=null;
		boolean state = false;
		try{
			session = DbUtil.getSession();
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			state = mapper.insert(empDTO) > 0 ? true : false;
			
			System.out.println("결과 state : " + state);
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	/**
	 * 삭제하기
	 * */
	public static void delete(int empno) {
		SqlSession session=null;
		boolean state = false;
		try{
			session = DbUtil.getSession();
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			state = mapper.delete(empno) > 0 ? true : false;
			
			System.out.println("결과 state : " + state);
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	/**
	 * 수정하기
	 * */
	public static void update(EmpDTO empDTO) {
		SqlSession session=null;
		boolean state = false;
		try{
			session = DbUtil.getSession();
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			state = mapper.update(empDTO) > 0 ? true : false;
			
			System.out.println("결과 state : " + state);
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	/**
	 * 동적쿼리 - if, where, trim
	 * */
	public static void ifTest(EmpDTO empDTO) {
		SqlSession session=null;
		try {
			session = DbUtil.getSession();
			EmpMapper mapper = session.getMapper(EmpMapper.class);
			List<EmpDTO> list = mapper.ifSelect(empDTO);
			
			for(EmpDTO e:list) {
				System.out.println(e);
			}
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
}
