package kosta.web.mvc.board.repository;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kosta.web.mvc.board.dto.ElectronicsDTO;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession session;
	
	private ElectronicsMapper mapper;
	
	@PostConstruct
	public void init() {
		mapper = session.getMapper(ElectronicsMapper.class);
	}
	
	@Override
	public List<ElectronicsDTO> selectAll() {

		return mapper.selectAll();
	}

	@Override
	public ElectronicsDTO selectByModelNum(String modelNum) {

		return mapper.selectByModelNum(modelNum);
	}

	@Override
	public int readnumUpdate(String modelNum) {
		return session.update("boardMapper.readnumUpdate", modelNum);
	}

	@Override
	public int insert(ElectronicsDTO electronics) {
		return session.update("boardMapper.insert", electronics);
	}

	@Override
	public int delete(String modelNum, String password) {
		int result = mapper.delete(modelNum, password);
		return result;
	}

	@Override
	public int update(ElectronicsDTO electronics) {
		//비밀번호체크도
		
		return session.update("boardMapper.update", electronics);
	}

}
