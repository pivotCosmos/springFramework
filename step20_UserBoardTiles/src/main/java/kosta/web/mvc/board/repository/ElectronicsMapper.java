package kosta.web.mvc.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kosta.web.mvc.board.dto.ElectronicsDTO;

public interface ElectronicsMapper {

	/**
	 * ¸®½ºÆ®
	 * */
	@Select("select * from electronics")
	List<ElectronicsDTO> selectAll();
	
	@Select("select * from electronics where model_num=#{_parameter}")
	ElectronicsDTO selectByModelNum(String modelNum);
	
	@Delete("delete from electronics where model_num=#{modelNum} and password=#{password}")
	int delete(@Param("modelNum")String modelNum, @Param("password") String password);
}



