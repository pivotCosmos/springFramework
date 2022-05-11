package kosta.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kosta.dto.EmpDTO;
import kosta.dto.MemberDTO;
import kosta.util.DbUtil;

public class EmpDAO {
	/**
	 * 모든 사원의 이름 검색하기
	 * */
	public void selectByEname() {
		//로드 연결 실행 닫기
		SqlSession session=null;
		try{
			session = DbUtil.getSession();
			List<String> list = session.selectList("empMapper.selectByEname");
			System.out.println("개수 : " + list.size());
			System.out.println("list = " + list);
			
		}finally {
			//닫기
			DbUtil.sessionClose(session);
			
		}
	}//selectByEname끝

	/**
	 * 사원등록하기
	 * */
	public void insert(EmpDTO empDTO) {
		SqlSession session=null;
		boolean state = false;
		try{
			session = DbUtil.getSession();
			state = session.insert("empMapper.insert", empDTO) > 0 ? true : false;
			
			System.out.println("결과 state : " + state);
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	/**
	 * 삭제하기
	 * */
	public void delete(int empno) {
		SqlSession session=null;
		boolean state = false;
		try{
			session = DbUtil.getSession();
			state = session.delete("empMapper.delete", empno) > 0 ? true : false;
			
			System.out.println("결과 state : " + state);
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	/**
	 * 수정하기
	 * */
	public void update(EmpDTO empDTO) {
		SqlSession session=null;
		boolean state = false;
		try{
			session = DbUtil.getSession();
			state = session.update("empMapper.update", empDTO) > 0 ? true : false;
			
			System.out.println("결과 state : " + state);
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	///////////////////////////////////////////////////////////////
	
	/**
	 * 전체검색
	 * */
	public void selectAll() {
		SqlSession session=null;
		try {
			session = DbUtil.getSession();
			//List<EmpDTO> list = session.selectList("empSelectMapper.selectAll");
			
			List<EmpDTO> list = 
					session.selectList("empSelectMapper.selectAll", null, new RowBounds(15, 5));
			
			for(EmpDTO emp:list) {
				System.out.println(emp);
			}
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/////////////////////////////////////////////////////////
	/**
	 * 사원번호에 해당하는 사원정보검색
	 * */
	public void selectByEmpno(int empno) {
		SqlSession session=null;
		try {
			session = DbUtil.getSession();
			EmpDTO emp = session.selectOne("empSelectMapper.selectByEmpno", empno);
			System.out.println("emp = " + emp);
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 인수로 전달된 급여보다 적게 받는 사원 검색
	 * */
	public void selectLessthanSal(int sal) {
		SqlSession session=null;
		try {
			session = DbUtil.getSession();
			List<EmpDTO> list= session.selectList("empSelectMapper.selectLessthanSal", sal);
			
			for(EmpDTO emp:list) {
				System.out.println(emp);
			}
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 인수로 전달된 최소 ~ 최대 범위안에 급여를 받는 사원 검색
	 * */
	public void selectMinMax(int min, int max) {
		SqlSession session=null;
		try {
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("min", min);
			map.put("max", max);
			
			session = DbUtil.getSession();
			List<EmpDTO> list = session.selectList("empSelectMapper.selectMinMax", map);
			
			for(EmpDTO emp:list) {
				System.out.println(emp);
			}
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 정렬대상 컬럼명을 인수로 전달받아 정렬하기
	 * */
	public void selectOrder(String columnName) {
		SqlSession session=null;
		try {
			session = DbUtil.getSession();
			List<EmpDTO> list = session.selectList("empSelectMapper.selectOrder", columnName);
			
			for(EmpDTO emp:list) {
				System.out.println(emp);
			}
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 검색필드와 검색단어 또는 사원번호 또는 급여에 해당하는 레코드 검색
	 * */
	public void selectWhereMix(String keyField, String keyWord, int empno, int sal) {
		SqlSession session=null;
		try {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("keyField", keyField);
			map.put("keyWord", keyWord);
			map.put("dto", new EmpDTO(empno,null,null,sal,null));
			
			session = DbUtil.getSession();
			List<EmpDTO> list = session.selectList("empSelectMapper.selectWhereMix", map);
			
			for(EmpDTO emp:list) {
				System.out.println(emp);
			}
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * job에 해당하는 레코드 검색
	 */
	public void selectByJob(String job) {
		SqlSession session=null;
		try {
			session = DbUtil.getSession();
			List<EmpDTO> list = session.selectList("empMapper.selectByJob", job);
			
			for(EmpDTO emp:list) {
				System.out.println(emp);
			}
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * Member테이블의 모든레코드 검색하기
	 */
	public void memberSelectAll() {
		SqlSession session=null;
		try {
			session = DbUtil.getSession();
			List<MemberDTO> list = session.selectList("empMapper.memberSelectAll");
			
			for(MemberDTO member:list) {
				System.out.println(member);
			}
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
}//class끝
