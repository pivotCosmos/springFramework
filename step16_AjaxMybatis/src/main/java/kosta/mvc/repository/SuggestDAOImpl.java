package kosta.mvc.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository //���� id="suggestDAOImpl"
@RequiredArgsConstructor
public class SuggestDAOImpl implements SuggestDAO {

	private final SqlSession session; //����
	
	@Override
	public List<String> selectSuggest(String word) {
		List<String> list = session.selectList("suggestMapper.selectByWord", word);
		
		return list;
	}

}
