package kosta.mvc.repository;

import java.util.List;

public interface SuggestDAO {

	/**
	 * �μ��� ���޵� �ܾ�� �����ϴ� ���ڵ� �˻�
	 * */
	List<String> selectSuggest(String word);
}
