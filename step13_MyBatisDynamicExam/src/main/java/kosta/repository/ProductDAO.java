package kosta.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kosta.dto.ProductDTO;

public class ProductDAO {
	
	/**
	 * 상품 등록하기
	 */
	public static void insert(ProductDTO productDTO) {
		SqlSession session=null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			state = session.update("dynamicMapper.insert", productDTO) > 0 ? true : false;

		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	/**
	 * 상품 검색하기
	 * 
	 */
	public static void select(String keyField, String keyWord, String orderWord){
		SqlSession session = null;
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			session = DbUtil.getSession();
			
			map.put("keyField", keyField);
			map.put("keyWord", keyWord);
			map.put("orderWord", orderWord);
			
			//map.put("sort", 0);//내림차순
			map.put("sort", 1);//오름차순
			
			List<ProductDTO> list = session.selectList("dynamicMapper.select", map);
			for(ProductDTO productDTO:list) {
				System.out.println(productDTO);
			}
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 상품 수정하기
	 */
	public static void update(ProductDTO productDTO) {
		SqlSession session=null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			state = session.update("dynamicMapper.update", productDTO) > 0 ? true : false;
			
		}finally{
			DbUtil.sessionClose(session, state);
		}
	}
	
	/**
	 * 상품 삭제하기
	 */
	public static void delete(String code) {
		SqlSession session = null;
		boolean state = false;
		try {
			session = DbUtil.getSession();
			state = session.update("dynamicMapper.delete", code) >0 ? true: false;
			
		}finally {
			DbUtil.sessionClose(session, state);
		}
	}
	
	/**
	 * 모든상품의 qty의총합계
	 */
	public static void selectQtySum() {
		SqlSession session=null;
		try {
			session = DbUtil.getSession();
			int qtySum = session.selectOne("dynamicMapper.selectQtySum");
			System.out.println("등록된 상품의 총 수량 : " + qtySum);
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
	
	/**
	 * 상품코드로 상품 검색하기
	 * 
	 */
	public static void selectByCode(List<String> param){
		SqlSession session = null;
		List<ProductDTO> list = null;
		try {
			session = DbUtil.getSession();
			list = session.selectList("dynamicMapper.selectByCode", param);
			for(ProductDTO productDTO:list) {
				System.out.println(productDTO);
			}//for
			
		}finally {
			DbUtil.sessionClose(session);
		}
	}
}
