package kosta.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kosta.dto.EmpDTO;
import kosta.util.DbUtil;

public class DynamicDAO {

	/**
	 * 동적쿼리 - if, where, trim
	 * */
	public static void ifTest(EmpDTO empDTO) {
		SqlSession session=null;
		try {
			session = DbUtil.getSession();
			List<EmpDTO> list = session.selectList("dynamicMapper.ifSelect", empDTO);
			
			for(EmpDTO e:list) {
				System.out.println(e);
			}
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 수정하기(동적쿼리 - set)
	 * */
	public static void setTest(EmpDTO empDTO) {
		SqlSession session=null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			state = session.update("dynamicMapper.setTest", empDTO) > 0 ? true : false;
			System.out.println("결과 : " + state);
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	/**
	 * forEach test
	 * */
	public static void forEachTest(List<Integer> empList) {
		SqlSession session=null;
		try {
			session = DbUtil.getSession();
			List<EmpDTO> list = session.selectList("dynamicMapper.forEachTest", empList);
			
			for(EmpDTO emp:list) {
				System.out.println(emp);
			}
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	
}
