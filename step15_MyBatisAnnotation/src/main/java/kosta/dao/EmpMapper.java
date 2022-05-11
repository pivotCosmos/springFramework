package kosta.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import kosta.dto.EmpDTO;

/**
 * xml기반의 mapper를 대신해주는 interface
 *  : 모든 맴버필드는 public static final 상수이다.
 *  : 모든 메소드는 public abstract 추상메소드이다.
 * */
public interface EmpMapper {
	
	//공통쿼리는 상수로 빼둔다.
	String empSelectSQL="select empno, ename as empname, job, sal, hiredate from emp";
	
	String DELETE_SQL="delete from emp where empno=#{_parameter}";
	
	/**
	 * 전체검색
	 * */
	@Select(empSelectSQL)
	List<EmpDTO> selectAll();
	
	/**
	 * 사원번호에 해당하는 레코드 검색
	 * */
	 @Select(empSelectSQL+" where empno=#{_parameter}") //한칸 띄어야 한다.
	 EmpDTO selectByEmpno(int empno);
	 
	 /**
	  * 등록하기
	  * */
	 @Insert("insert into emp(empno, ename, job, sal, hiredate) "
	 		+ "values(#{empno},#{empName},#{job},#{sal},sysdate)")
	 int insert(EmpDTO empDTO);
	 
	 /**
	  * 삭제하기
	  * */
	 @Delete(DELETE_SQL)
	 int delete(int empno);
	 
	 /**
	  * 수정하기
	  * */
	 @Update("update emp set ename=#{empName}, job=#{job}, sal=#{sal} where empno=#{empno}")
	 int update(EmpDTO empDTO);
	 
	 /**
	  * 동적쿼리 : 태그들이 안에 있기 때문에 <script> </script>태그 안에 작성한다.
	  * */
	 @Select("<script>"+ empSelectSQL +" <trim prefix=\"where\" prefixOverrides=\"and|or\">\r\n"
	 		+ "			<if test=\"empName!=null\">\r\n"
	 		+ "				ename = #{empName} \r\n"
	 		+ "			</if>\r\n"
	 		+ "			<if test=\"job!=null\">\r\n"
	 		+ "				and upper(job)=upper(#{job})\r\n"
	 		+ "			</if>\r\n"
	 		+ "		</trim></script>")
	 List<EmpDTO> ifSelect(EmpDTO empDTO);
	 
}
